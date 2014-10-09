package problems;

import common.BaseProblem;
import common.TreeNode;
import org.codehaus.plexus.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ge.lin
 * Date: 14-10-8
 * Time: 上午9:46
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeLevelOrderTraversal extends BaseProblem {
    @Override
    protected void execute() {
        String treeStr = "1,2,3,#,#,4,#,#,5";
        TreeNode head = initTree(treeStr);
        levelOrder(head);
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<TreeNode> currentLevelNodeList = new LinkedList<TreeNode>();
        currentLevelNodeList.add(root);
        int index = 0;
        int levelCount = 1;
        int levelIndex = 0;
        List<Integer> levelOne = new LinkedList<Integer>();
        result.add(levelOne);

        while (index < currentLevelNodeList.size()) {
            if (levelIndex == result.size()) {
                List<Integer> newLevel = new LinkedList<Integer>();
                result.add(newLevel);
            }
            List<Integer> currentLevel = result.get(levelIndex);
            TreeNode currentNode = currentLevelNodeList.get(index);
            currentLevel.add(currentNode.getVal());

            if (currentNode.getLeft() != null) {
                currentLevelNodeList.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                currentLevelNodeList.add(currentNode.getRight());
            }
            index++;
            if (index == levelCount) {
                levelCount = currentLevelNodeList.size();
                levelIndex++;
            }
        }
        return result;
    }

    private static TreeNode initTree(String treeStr) {
        TreeNode head = null;
        if (StringUtils.isBlank(treeStr)) {
            return head;
        }

        List<TreeNode> currentLevelNodeList = new LinkedList<TreeNode>();
        List<TreeNode> nextLevelNodeList = new LinkedList<TreeNode>();
        if (treeStr.indexOf(",") > 0) {
            head = new TreeNode(Integer.valueOf(treeStr.substring(0, treeStr.indexOf(","))));
        } else {
            head = new TreeNode(Integer.valueOf(treeStr));
        }
        currentLevelNodeList.add(head);

        int currentLevelIndex = 0;
        for (String treeNodeStr : treeStr.substring(treeStr.indexOf(",") + 1, treeStr.length()).split(",")) {
            if (!treeNodeStr.equals("#")) {
                TreeNode currentNode = new TreeNode(Integer.valueOf(treeNodeStr));
                nextLevelNodeList.add(currentNode);
                if ((currentLevelIndex + 1) % 2 == 1) {
                    currentLevelNodeList.get(currentLevelIndex / 2).setLeft(currentNode);
                } else {
                    currentLevelNodeList.get(currentLevelIndex / 2).setRight(currentNode);
                }
            }

            if (currentLevelIndex + 1 == currentLevelNodeList.size() * 2) {
                currentLevelIndex = 0;
                currentLevelNodeList.clear();
                currentLevelNodeList.addAll(nextLevelNodeList);
                nextLevelNodeList.clear();
                continue;
            }
            currentLevelIndex++;
        }
        return head;
    }

    public static void main(String[] args) {
        BaseProblem binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        binaryTreeLevelOrderTraversal.process();;
    }
}
