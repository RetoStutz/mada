package huffman;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Huffman {

    //Filename
    private static final String FILE_NAME = "C:/Users/RetoStutz/Documents/FHNW/mada_2iCbb/Übungen/Programmieraufgabe-Huffman/TextdateiAscII.txt";

    String inputStream;
    Map<Character, Leaf> dataMap = new HashMap<>();


    public Huffman () {
        try {
            File myObj = new File(FILE_NAME);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                inputStream = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[] dataArray = inputStream.split(" ");

        for (String s: dataArray){
            Character c = (char)Integer.parseInt(s);
            if (dataMap.containsKey(c)) {
                dataMap.get(c).incrementFrequency();
            }
            else {
                dataMap.put(c, new Leaf(c));
            }
        }

        sortData();

        while (dataMap.size() > 1) {
            createTree();
            sortData();
        }

        Leaf main = dataMap.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .findFirst().orElse(null);
        printCode (main, "");

    }

    public void sortData(){
        dataMap = dataMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public void createTree(){


        Leaf leftLeaf;
        Leaf rightLeaf;

        //get first element in list
        leftLeaf = dataMap.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .findFirst().orElse(null);

        dataMap.remove(leftLeaf.getCharacter());

        rightLeaf = dataMap.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .findFirst().orElse(null);

        dataMap.remove(rightLeaf.getCharacter());

        dataMap.put(leftLeaf.getCharacter(), new Leaf(leftLeaf, rightLeaf, leftLeaf.getCharacter(), (leftLeaf.getFrequency()+rightLeaf.getFrequency())));

    }

    public void printCode(Leaf leaf,String s){
        if (leaf.getLeftLeaf()
                == null
                && leaf.getRightLeaf()
                == null
                && Character.isLetter(leaf.getCharacter())) {


            System.out.println(leaf.getCharacter() + ":" + s);

            return;
        }

        if (leaf.getLeftLeaf() != null){
            printCode(leaf.getLeftLeaf(), s + "0");
        }
        if (leaf.getRightLeaf() != null) {
            printCode(leaf.getRightLeaf(), s + "1");
        }
    }

}
