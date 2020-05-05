package huffman;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class huffman {

    //Filename
    private static final String FILE_NAME ="C:/Users/RetoStutz/Documents/FHNW/mada_2iCbb/Übungen/Programmieraufgabe-Huffman/dec_tab-mada.txt";

    public String readFile(){
        String data = "";
        try {
            File myObj = new File(FILE_NAME);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;

    }
}
