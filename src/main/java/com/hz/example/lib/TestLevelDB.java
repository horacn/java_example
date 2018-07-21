package com.hz.example.lib;

import org.iq80.leveldb.*;
import org.iq80.leveldb.impl.Iq80DBFactory;

import java.io.File;
import java.io.IOException;

import static org.iq80.leveldb.impl.Iq80DBFactory.asString;
import static org.iq80.leveldb.impl.Iq80DBFactory.bytes;

/**
 * LevelDB是一个基于本地文件的存储引擎，非分布式存储引擎，原理基于BigTable（LSM文件树），无索引机制，存储条目为Key-value。
 * 适用于保存数据缓存、日志存储、高速缓存等应用，主要是避免RPC请求带来的延迟问题。
 * 在存取模型上，顺序读取性能极高，但是对于随机读取的情况延迟较大（但性能也不是特别低），比较适合顺序写入（key），随机的key写入也不会带来问题。数据存量通常为物理内存的3~5倍，不建议存储过大的数据，在这个数据量级上，leveldb的性能比那些“分布式存储”要高（即本地磁盘存取延迟小于RPC网络延迟）。
 *
 * 原生leveldb是基于C++开发，java语言无法直接使用；iq80对leveldb使用JAVA语言进行了“逐句”重开发，经过很多大型项目的验证（比如ActiveMQ），iq80开发的JAVA版leveldb在性能上损失极少（10%）。对于JAVA开发人员来说，我们直接使用即可，无需额外的安装其他lib。
 *
 * https://blog.csdn.net/chary8088/article/details/54945303
 *
 * @Author hezhao
 * @Time 2018-07-21 21:01
 */
public class TestLevelDB {

    public static void main(String[] args) {

        String path = "files/leveldb";
        boolean cleanup = true;
        DB db = null;

        try {
            // init
            DBFactory factory = Iq80DBFactory.factory;
            File dir = new File(path);

            // 如果数据不需要reload，则每次重启，尝试清理磁盘中path下的旧数据。
            if(cleanup) {
                factory.destroy(dir,null); // 清除文件夹内的所有文件。
            }
            Options options = new Options().createIfMissing(true);

            // 重新open新的db
            db = factory.open(dir,options);

            // write
            db.put(bytes("key-01"), bytes("value-01"));

            // write后立即进行磁盘同步写
            WriteOptions writeOptions = new WriteOptions().sync(true); // 线程安全
            db.put(bytes("key-02"), bytes("value-02"), writeOptions);

            // batch write
            WriteBatch writeBatch = db.createWriteBatch();
            try {
                writeBatch.put(bytes("key-03"), bytes("value-03"));
                writeBatch.put(bytes("key-04"), bytes("value-04"));
                writeBatch.delete(bytes("key-01"));
                db.write(writeBatch);
            } finally {
                writeBatch.close();
            }

            // read
            String key02 = asString(db.get(bytes("key-02")));
            System.out.println(key02);

            // iterator，遍历，顺序读

            // 读取当前snapshot，快照，读取期间数据的变更，不会反应出来
            Snapshot snapshot = db.getSnapshot();

            // 读选项
            ReadOptions readOptions = new ReadOptions();
            readOptions.fillCache(false); // 遍历中swap出来的数据，不应该保存在memtable中。
            readOptions.snapshot(snapshot); // 默认snapshot为当前。
            DBIterator iterator = db.iterator(readOptions);
            try {
                for(iterator.seekToFirst(); iterator.hasNext(); iterator.next()) {
                    String key = asString(iterator.peekNext().getKey());
                    String value = asString(iterator.peekNext().getValue());
                    System.out.println(key + ":" + value);
                }
            } finally {
                // Make sure you close the iterator to avoid resource leaks.
                iterator.close();
            }

            // delete
            db.delete(bytes("key-01"));

            String key01 = asString(db.get(bytes("key-01")));
            System.out.println(key01);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                try {
                    // close
                    db.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
