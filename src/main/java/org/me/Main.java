package org.me;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.BitSet;

public class Main {
    public static void main(String[] args) {

        File f;
        Methods m = null;

        //Setup
        try { //puting file into methods
            f = new File("src/main/java/org/me/test.txt.machine");
            m = new Methods(f);
        } catch (FileNotFoundException e){System.out.println("No file found");}

        byte[] bytelist = null;

        try { //filling the list with bytes from file
            bytelist = m.reader();
        } catch (IOException | NullPointerException e){e.printStackTrace();}

        System.out.println(m.printBytes(bytelist)); // checking bytes

        BitSet bitList = m.byteToBit(bytelist);// gets bit list

        for(int i = 0; i < bitList.length(); i = i + 32){
            BitSet temp = bitList.get(i, i + 32);
            String op = m.getType(temp.get(0, 11));
            System.out.println(op);
        }

    }
}