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


//    public String readBinary(){
//        System.out.println("Reading binary file into byte array example");
//        String s ="";
//        try{
//            //Instantiate the file object
//            File file = new File(FILE_NAME);
//            //Instantiate the input stread
//            InputStream insputStream = new FileInputStream(file);
//            long length = file.length();
//            byte[] bytes = new byte[(int) length];
//
//            insputStream.read(bytes);
//            insputStream.close();
//
//            s = new String(bytes);
//            //Print the byte data into string format
//            System.out.println(s);
//        }catch(Exception e){
//            System.out.println("Error is:" + e.getMessage());
//        }
//
//        return s;
//    }

}
