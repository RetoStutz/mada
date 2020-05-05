package huffman;

public class Main{

    public static void main(String[] args) {
        huffman h1 = new huffman();

        byte[] text = h1.readFile();
        System.out.println(text);

    }
}

