package org.me;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.BitSet;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {

        File f;
        Methods m = null;

        /*
        testI = ADDI X0, X2, #15
        testB:
            B label1
            label1:
        testR = ADD X4, X2, X16
        testD:
            SUBI SP, SP, #8
            STUR X5, [SP, #0]
            LDUR X5, [SP, #0]
            ADDI SP, SP, #8
        testCB:
            CBZ X0, label1
            label1:
         */

        //Setup
        try { //puting file into methods
            f = new File("src/main/java/org/me/testI.txt.machine");
            m = new Methods(f);
        } catch (FileNotFoundException e){System.out.println("No file found");}

        byte[] bytelist = null;

        try { //filling the list with bytes from file
            bytelist = m.reader();
        } catch (IOException | NullPointerException e){e.printStackTrace();}

        System.out.println(m.printBytes(bytelist)); // checking bytes

        BitSet bitList = m.byteToBit(bytelist);// gets bit list

        StringBuilder sb = new StringBuilder();
        String op = null;

        for(int i = 0; i < bitList.length(); i = i + 33) {
            BitSet codeLine = bitList.get(i, i + 33);
            op = m.getType(codeLine.get(0, 12));
            System.out.println(op);

            try {
                op.equals(null);
            } catch (NullPointerException e) {
                System.out.println("ERROR: OP code not found");
                e.printStackTrace();
                System.exit(1);
            }

            switch (op) {
                case "R":
                     m.getOP(codeLine.get(0, 12), "R");
                     sb.append(m.bitToReg(codeLine.get(12, 17)));
                    break;
                case "B":
                    break;
                case "I":
                    sb.append(m.getOP(codeLine.get(0, 11), "I")); //op 11
                    sb.append(m.bitToReg(codeLine.get(23, 28)));// Rd 5
                    sb.append(m.bitToReg(codeLine.get(12, 17))); //Rn 5
                    sb.append(m.bitToImm(codeLine.get(28, 33))); // immm 12
                    break;
                case "CB":
                    break;
                case "D":
                    break;
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }
}