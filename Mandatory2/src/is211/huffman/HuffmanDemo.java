package is211.huffman;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;


/**
 * Write a description of class HuffmanDemo here.
 *
 * @author Even Åby Larsen
 * @version 1.0
 */
public class HuffmanDemo
{
    public static void main(String[] args) throws IOException {
        runFileDemo("terjevigen.txt");

        // runStringDemo("Der bodde en underlig gråsprængt en på den yderste nøgne ø;-");
    }

    public static void runFileDemo(String filename) throws IOException {
        File infile = new File(filename); // the original text file
        File outfile = new File(filename + "-out.txt"); // decoded text
        File binfile = new File(filename + "-huffman.bin"); // encoded file

        // create huffman tree and encoding table, based on infile
        HuffmanTree tree = new HuffmanTree(infile);
        //FileBitSink binOut = new FileBitSink(binfile);
        //binOut.close();

        // decode the encoded file back to text
        //FileBitSource binIn = new FileBitSource(binfile);
        //FileWriter textOut = new FileWriter(outfile);
        //huff.decode(binIn, textOut);
        //textOut.close();
        // finished - compare the contents of infile and outfile
        // they should be identical
        // you can use diff (on mac/linux/unix). There is a similar
        // command on windows, comp or compare???
    }

}
