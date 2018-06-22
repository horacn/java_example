package com.hz.example.algorithm;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 二叉排序树
 * @author hezhao
 * @Time   2016年3月17日 下午5:58:30
 * @Description 无
 * @version V 1.0
 */
public class TreeSearch {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(50, 30, 70, 10, 40, 90, 80);

        //创建二叉遍历树
        BSTree bsTree = createBST(list);

        System.out.print("中序遍历的原始数据：");

        //中序遍历
        ldr_BST(bsTree);

        System.out.println("\n---------------------------------------------------------------------------\n");

        //查找一个节点
        System.out.println("\n10在二叉树中是否包含：" + SearchBST(bsTree, 10));

        System.out.println("\n---------------------------------------------------------------------------\n");

        boolean isExcute = false;

        //插入一个节点
        isExcute = insertBST(bsTree, 20, isExcute);

        System.out.println("\n20插入到二叉树，中序遍历后：");

        //中序遍历
        ldr_BST(bsTree);

        System.out.println("\n---------------------------------------------------------------------------\n");

        System.out.print("删除叶子节点 20， \n中序遍历后：");

        //删除一个节点(叶子节点)
        deleteBST(bsTree, 20);

        //再次中序遍历
        ldr_BST(bsTree);

        System.out.println("\n****************************************************************************\n");

        System.out.println("删除单孩子节点 90， \n中序遍历后：");

        //删除单孩子节点
        deleteBST(bsTree, 90);

        //再次中序遍历
        ldr_BST(bsTree);

        System.out.println("\n****************************************************************************\n");

        System.out.println("删除根节点 50， \n中序遍历后：");
        //删除根节点
        deleteBST(bsTree, 50);

        ldr_BST(bsTree);
    }

    /**
     * 二叉排序树的插入操作
     * @param bsTree 排序树
     * @param key 插入数
     * @param isExcute 是否执行了if语句
     * @return
     */
    public static boolean insertBST(BSTree bsTree,int key,boolean isExcute){
        if(bsTree == null)	return false;
        //如果父节点大于key，则遍历左子树
        if(bsTree.data > key)
            isExcute = insertBST(bsTree.left, key, isExcute);
        else
            isExcute = insertBST(bsTree.right, key, isExcute);
        if(!isExcute){
            //构建当前节点
            BSTree current = new BSTree();
            current.data = key;
            current.left = null;
            current.right = null;
            //插入到父节点的当前元素
            if (bsTree.data > key)
                bsTree.left = current;
            else
                bsTree.right = current;
            isExcute = true;
        }
        return isExcute;
    }

    public static BSTree createBST(List<Integer> list){
        //构建BST中的根节点
        BSTree bsTree = new BSTree();
        bsTree.data = list.get(0);
        bsTree.left = null;
        bsTree.right = null;

        for (int i = 1; i < list.size(); i++){
            boolean isExcute = false;
            isExcute = insertBST(bsTree, list.get(i), isExcute);
        }
        return bsTree;
    }

    /**
     * 在排序二叉树中搜索指定节点
     * @param bsTree
     * @param key
     * @return
     */
    public static boolean SearchBST(BSTree bsTree, int key){
        //如果bsTree为空，说明已经遍历到头了
        if (bsTree == null)
            return false;

        if (bsTree.data == key)
            return true;

        if (bsTree.data > key)
            return SearchBST(bsTree.left, key);
        else
            return SearchBST(bsTree.right, key);
    }

    /**
     * 中序遍历二叉排序树
     * @param bsTree
     */
    public static void ldr_BST(BSTree bsTree){
        if (bsTree != null){
            //遍历左子树
            ldr_BST(bsTree.left);
            //输入节点数据
            System.out.print(bsTree.data + " ");
            //遍历右子树
            ldr_BST(bsTree.right);
        }
    }

    public static void deleteBST(BSTree bsTree, int key){
        if (bsTree == null)
            return;

        if (bsTree.data == key){
            //第一种情况：叶子节点
            if (bsTree.left == null && bsTree.right == null){
                bsTree = null;
                return;
            }
            //第二种情况：左子树不为空
            if (bsTree.left != null && bsTree.right == null){
                bsTree = bsTree.left;
                return;
            }
            //第三种情况，右子树不为空
            if (bsTree.left == null && bsTree.right != null){
                bsTree = bsTree.right;
                return;
            }
            //第四种情况，左右子树都不为空
            if (bsTree.left != null && bsTree.right != null){
                BSTree node = bsTree.right;

                //找到右子树中的最左节点
                while (node.left != null){
                    //遍历它的左子树
                    node = node.left;
                }

                //交换左右孩子
                node.left = bsTree.left;

                //判断是真正的叶子节点还是空左孩子的父节点
                if (node.right == null){
                    //删除掉右子树最左节点
                    deleteBST(bsTree, node.data);

                    node.right = bsTree.right;
                }
                //重新赋值一下
                bsTree = node;
            }
        }

        if (bsTree.data > key){
            deleteBST(bsTree.left, key);
        }else{
            deleteBST(bsTree.right, key);
        }
    }
}

/**
 * 定义一个二叉排序树结构
 * @author hezhao
 * @Time   2016年3月18日 上午9:13:25
 * @Description 无
 * @version V 1.0
 */
class BSTree{
    public int data;
    public BSTree left;
    public BSTree right;
}