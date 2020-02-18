package SiebDesEratostenes;

import java.util.*;

public class SiebDesEratostenes {
    ArrayList<Integer> numbers = new ArrayList<>();

    SiebDesEratostenes(){
        for (int i = 2; i<=10; i++ ){
            numbers.add(i);
        }
    }

    public void start(){
        while (numbers.size()>0) {
            int checkNumber = numbers.get(0);
            System.out.println(checkNumber + "new Primzahl");
            for (int i = 0; i <= numbers.size() - 1; i++) {
                if ((numbers.get(i) % checkNumber) == 0) {
                    System.out.println(numbers.get(i) + "removed");
                    numbers.set(i, null);
                } else {
                    System.out.println(numbers.get(i) + " not removed");
                }
            }
            numbers.remove(null);
        }
    }
}
