package com.hz.example.langproblem;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/** java中获取类加载路径和项目根路径的5种方法
 *
 * Created by hezhao on 2018-06-22 16:52
 */
public class GetClassPath {
    public static void main(String[] args) {
        GetClassPath getProjectPath = new GetClassPath();
        try {
            getProjectPath.showURL();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showURL() throws IOException {

        // 第一种：获取类加载的根路径   F:\git\java_example\target\classes
        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f);
        // 获取当前类的所在工程路径; 如果不加“/”  获取当前类的加载目录  F:\git\java_example\target\classes\com\hz\example\langproblem
        File f2 = new File(this.getClass().getResource("").getPath());
        System.out.println(f2);


        // 第二种：获取项目路径    F:\git\java_example
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);


        // 第三种：  获取类加载的根路径   file:/F:/git/java_example/target/classes/
        URL xmlpath = this.getClass().getClassLoader().getResource("");
        System.out.println(xmlpath);


        // 第四种： 获取当前工程路径    F:\git\java_example
        System.out.println(System.getProperty("user.dir"));


        // 第五种：  获取所有的类路径 包括jar包的路径
        // C:\Program Files\Java\jdk1.8.0_25\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_25\jre\lib\rt.jar;F:\git\java_example\target\classes;C:\Users\Administrator\.m2\repository\commons-logging\commons-logging\1.2\commons-logging-1.2.jar;C:\Users\Administrator\.m2\repository\commons-io\commons-io\2.6\commons-io-2.6.jar;C:\Users\Administrator\.m2\repository\commons-fileupload\commons-fileupload\1.3.3\commons-fileupload-1.3.3.jar;C:\Users\Administrator\.m2\repository\org\apache\commons\commons-lang3\3.7\commons-lang3-3.7.jar;C:\Users\Administrator\.m2\repository\commons-lang\commons-lang\2.6\commons-lang-2.6.jar;C:\Users\Administrator\.m2\repository\commons-codec\commons-codec\1.11\commons-codec-1.11.jar;C:\Users\Administrator\.m2\repository\commons-beanutils\commons-beanutils\1.9.3\commons-beanutils-1.9.3.jar;C:\Users\Administrator\.m2\repository\commons-collections\commons-collections\3.2.2\commons-collections-3.2.2.jar;C:\Users\Administrator\.m2\repository\org\apache\commons\commons-collections4\4.1\commons-collections4-4.1.jar;C:\Users\Administrator\.m2\repository\commons-cli\commons-cli\1.4\commons-cli-1.4.jar;C:\Users\Administrator\.m2\repository\org\apache\commons\commons-math3\3.6.1\commons-math3-3.6.1.jar;C:\Users\Administrator\.m2\repository\org\apache\commons\commons-math\2.2\commons-math-2.2.jar;C:\Users\Administrator\.m2\repository\commons-net\commons-net\3.6\commons-net-3.6.jar;C:\Users\Administrator\.m2\repository\org\apache\commons\commons-email\1.5\commons-email-1.5.jar;C:\Users\Administrator\.m2\repository\com\sun\mail\javax.mail\1.5.6\javax.mail-1.5.6.jar;C:\Users\Administrator\.m2\repository\javax\activation\activation\1.1\activation-1.1.jar;C:\Users\Administrator\.m2\repository\commons-attributes\commons-attributes-api\2.2\commons-attributes-api-2.2.jar;C:\Users\Administrator\.m2\repository\ant\ant\1.5\ant-1.5.jar;C:\Users\Administrator\.m2\repository\qdox\qdox\1.5\qdox-1.5.jar;C:\Users\Administrator\.m2\repository\commons-attributes\commons-attributes-compiler\2.2\commons-attributes-compiler-2.2.jar;C:\Users\Administrator\.m2\repository\org\apache\httpcomponents\httpclient\4.5.5\httpclient-4.5.5.jar;C:\Users\Administrator\.m2\repository\org\apache\httpcomponents\httpcore\4.4.9\httpcore-4.4.9.jar;C:\Users\Administrator\.m2\repository\org\apache\httpcomponents\httpasyncclient\4.1.3\httpasyncclient-4.1.3.jar;C:\Users\Administrator\.m2\repository\org\apache\httpcomponents\httpclient-cache\4.5.5\httpclient-cache-4.5.5.jar;C:\Users\Administrator\.m2\repository\org\apache\httpcomponents\httpcore-nio\4.4.9\httpcore-nio-4.4.9.jar;C:\Users\Administrator\.m2\repository\org\apache\httpcomponents\httpmime\4.5.5\httpmime-4.5.5.jar;C:\Users\Administrator\.m2\repository\commons-httpclient\commons-httpclient\3.1\commons-httpclient-3.1.jar;C:\Users\Administrator\.m2\repository\com\alibaba\fastjson\1.2.6\fastjson-1.2.6.jar;C:\Users\Administrator\.m2\repository\com\google\code\gson\gson\2.8.2\gson-2.8.2.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\core\jackson-databind\2.9.5\jackson-databind-2.9.5.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\core\jackson-core\2.9.5\jackson-core-2.9.5.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\core\jackson-annotations\2.9.5\jackson-annotations-2.9.5.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\dataformat\jackson-dataformat-yaml\2.9.5\jackson-dataformat-yaml-2.9.5.jar;C:\Users\Administrator\.m2\repository\org\yaml\snakeyaml\1.18\snakeyaml-1.18.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\module\jackson-module-jaxb-annotations\2.9.5\jackson-module-jaxb-annotations-2.9.5.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\jackson\dataformat\jackson-dataformat-xml\2.9.5\jackson-dataformat-xml-2.9.5.jar;C:\Users\Administrator\.m2\repository\org\codehaus\woodstox\stax2-api\3.1.4\stax2-api-3.1.4.jar;C:\Users\Administrator\.m2\repository\com\fasterxml\woodstox\woodstox-core\5.0.3\woodstox-core-5.0.3.jar;C:\Users\Administrator\.m2\repository\org\codehaus\jackson\jackson-core-asl\1.9.13\jackson-core-asl-1.9.13.jar;C:\Users\Administrator\.m2\repository\org\codehaus\jackson\jackson-mapper-asl\1.9.13\jackson-mapper-asl-1.9.13.jar;C:\Users\Administrator\.m2\repository\org\codehaus\jackson\jackson-jaxrs\1.9.13\jackson-jaxrs-1.9.13.jar;C:\Users\Administrator\.m2\repository\org\codehaus\jackson\jackson-xc\1.9.13\jackson-xc-1.9.13.jar;C:\Users\Administrator\.m2\repository\org\json\json\20180130\json-20180130.jar;C:\Users\Administrator\.m2\repository\de\odysseus\staxon\staxon\1.3\staxon-1.3.jar;C:\Users\Administrator\.m2\repository\net\sf\ezmorph\ezmorph\1.0.6\ezmorph-1.0.6.jar;C:\Users\Administrator\.m2\repository\com\google\guava\guava\23.0\guava-23.0.jar;C:\Users\Administrator\.m2\repository\com\google\code\findbugs\jsr305\1.3.9\jsr305-1.3.9.jar;C:\Users\Administrator\.m2\repository\com\google\errorprone\error_prone_annotations\2.0.18\error_prone_annotations-2.0.18.jar;C:\Users\Administrator\.m2\repository\com\google\j2objc\j2objc-annotations\1.1\j2objc-annotations-1.1.jar;C:\Users\Administrator\.m2\repository\org\codehaus\mojo\animal-sniffer-annotations\1.14\animal-sniffer-annotations-1.14.jar;C:\Users\Administrator\.m2\repository\org\im4java\im4java\1.4.0\im4java-1.4.0.jar;C:\Users\Administrator\.m2\repository\com\belerweb\pinyin4j\2.5.0\pinyin4j-2.5.0.jar;C:\Users\Administrator\.m2\repository\com\lmax\disruptor\3.3.6\disruptor-3.3.6.jar;C:\Users\Administrator\.m2\repository\joda-time\joda-time\2.8.1\joda-time-2.8.1.jar;C:\Users\Administrator\.m2\repository\junit\junit\4.12\junit-4.12.jar;C:\Users\Administrator\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\Program Files\JetBrains\IntelliJ IDEA 2018.1\lib\idea_rt.jar
        System.out.println(System.getProperty("java.class.path"));

    }
}