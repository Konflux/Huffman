package is211.huffman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class HuffmanTree {
    private int treeSize;
    private HuffmanNode Root; //The root node of the tree

    public HuffmanTree(){

    }

    public HuffmanTree(File file) throws IOException {
        HashMap<Character, HuffmanNode> nodeMap = new HashMap<>();
        PriorityQueue<HuffmanNode> nodeQueue = new PriorityQueue<>();

        //Count frequencies
        countFrequencies(file, nodeMap);

        //Fill the queue
        fillQueue(nodeMap, nodeQueue);

        //Test it
        //testMap(nodeMap);

        //Build the tree and set codes
        HuffmanNode root = buildTree(nodeQueue);

        //Print the tree to test
        printTree(root);
    }

    private void countFrequencies(File file, HashMap<Character, HuffmanNode> nodeMap) throws FileNotFoundException {
        Scanner scanner = new Scanner(file, "UTF-8");
        while (scanner.hasNext()) {
            char[] chars = scanner.nextLine().toLowerCase().toCharArray();
            try {
                for (Character c : chars) {
                    if (!Character.isLetter(c)) {
                    } else if (nodeMap.containsKey(c)) {
                        HuffmanNode node = nodeMap.get(c);
                        node.setCount(node.getCount() + 1);
                        nodeMap.put(c, node);
                    } else {
                        HuffmanNode node = new HuffmanNode(1, c);
                        nodeMap.put(c, node);
                    }
                }
            } catch (NullPointerException nullp) {
                nullp.printStackTrace();
            }
        }
    }

    private void fillQueue(HashMap<Character, HuffmanNode> nodeMap, PriorityQueue<HuffmanNode> nodes){
        for (Map.Entry<Character, HuffmanNode> entry : nodeMap.entrySet()){
            HuffmanNode node = entry.getValue();
            nodes.add(node);
        }
    }

    private void testMap(HashMap<Character, HuffmanNode> map){
        for (Character c : map.keySet()) {
            HuffmanNode node = map.get(c);
            Character character = node.getCharacter();
            int count = node.getCount();
            System.out.println("Frequency for character " + character + " is " + count);
        }
    }

    private HuffmanNode buildTree(PriorityQueue<HuffmanNode> nodes){
        HuffmanNode root = null;

        while (nodes.size() > 1) {
            HuffmanNode least1 = nodes.poll();
            HuffmanNode least2 = nodes.poll();

            int combinedCount = least1.getCount() + least2.getCount();
            HuffmanNode combined = new HuffmanNode(combinedCount);

            combined.setRight(least1);
            combined.setLeft(least2);

            least1.setParent(combined);
            least2.setParent(combined);

            nodes.add(combined);
            root = combined;
            traverse(root,"");
        }
        return root;
    }

    private void traverse(HuffmanNode root, String code){
        if (root.getLeft() == null && root.getRight() == null) {
            root.setHuffmanCode(code);

        } else {
            traverse(root.getRight(),code + "1");
            traverse(root.getLeft(),code + "0");
        }
    }

    private void printTree(HuffmanNode rootNode) {
        if (rootNode.getRight() == null && rootNode.getLeft() == null) {
            System.out.println("Character " + rootNode.getCharacter() + " Has the code of " + rootNode.getHuffmanCode());
        }
        else if (rootNode.getRight() == null){
            printTree(rootNode.getLeft());
        }
        else if (rootNode.getLeft() == null){
            printTree(rootNode.getRight());
        }
        else if (rootNode.getLeft() != null && rootNode.getRight() != null){
            printTree(rootNode.getRight());
            printTree(rootNode.getLeft());
        }
    }
    
    private void setCode(HuffmanNode node, String code){
        node.setHuffmanCode(code);
    }

    public int getTreeSize() {
        return this.treeSize;
    }

    public void setTreeSize(int treeSize) {
        this.treeSize = treeSize;
    }

    public HuffmanNode getRootNode() {
        return Root;
    }

    public void setRootNode(HuffmanNode root) {
        Root = root;
    }
}
