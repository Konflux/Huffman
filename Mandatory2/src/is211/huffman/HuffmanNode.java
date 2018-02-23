package is211.huffman;

import java.util.ArrayList;

public class HuffmanNode implements Comparable<HuffmanNode> {

    private int Count;
    private int HuffmanCode;
    private char Character;
    private HuffmanNode Parent;
    private HuffmanNode Left;
    private HuffmanNode Right;


    public HuffmanNode(int Count, char Character){
        this.Count = Count;
        this.Character = Character;
        this.Parent = null;
        this.Left = null;
        this.Right = null;
    }

    public HuffmanNode(int Count){
        this.Count = Count;
        this.Parent = null;
        this.Left = null;
        this.Right = null;
    }
    public HuffmanNode(HuffmanNode Parent, HuffmanNode Left, HuffmanNode Right){
        this.Parent = Parent;
        this.Left = Left;
        this.Right = Right;
    }

    public boolean isLeafNode(){
        HuffmanNode right = this.Right;
        HuffmanNode left = this.Left;

        if(right == null & left == null){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public int compareTo(HuffmanNode that) {
        return -(that.Count - this.Count);
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public int getHuffmanCode() {
        return HuffmanCode;
    }

    public void setHuffmanCode(int huffmanCode) {
        this.HuffmanCode = huffmanCode;
    }

    public char getCharacter() {
        return Character;
    }

    public void setCharacter(char character) {
        Character = character;
    }

    public HuffmanNode getParent() {
        return Parent;
    }

    public void setParent(HuffmanNode parent) {
        Parent = parent;
    }

    public HuffmanNode getLeft() {
        return Left;
    }

    public void setLeft(HuffmanNode left) {
        Left = left;
    }

    public HuffmanNode getRight() {
        return Right;
    }

    public void setRight(HuffmanNode right) {
        Right = right;
    }


}
