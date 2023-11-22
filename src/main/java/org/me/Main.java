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

        for(int i = 0; i < bitList.length() - 32; i = i + 32){
            BitSet temp = bitList.get(i, i + 32);
            String op = m.getType(temp.get(0, 11));

        }


        //TODO
        //instruction_t instruction[] = {
        //  { "ADD",   10001011000 },
        //  { "ADDI",  1001000100  },
        //  { "ADDIS", 1011000100  },
        //  { "ADDS",  10101011000 },
        //  { "AND",   10001010000 },
        //  { "ANDI",  1001001000  },
        //  { "ANDIS", 1111001000  },
        //  { "ANDS",  1110101000  },
        //  { "B",     000101  },
        //  { "BL",    100101      },
        //  { "BR",    11010110000 },
        //  { "CBNZ",  10110101    },
        //  { "CBZ",   10110100    },
        //  { "DUMP",  11111111110 },
        //  { "EOR",   11001010000 },
        //  { "EORI",  1101001000  },
        //  { "FADDD", 0b00011110011 },
        //  { "FADDS", 00011110001 },
        //  { "FCMPD", 00011110011 },
        //  { "FCMPS", 00011110001 },
        //  { "FDIVD", 00011110011 },
        //  { "FDIVS", 00011110001 },
        //  { "FMULD", 00011110011 },
        //  { "FMULS", 00011110001 },
        //  { "FSUBD", 00011110011 },
        //  { "FSUBS", 00011110001 },
        //  { "HALT",  11111111111 },
        //  { "LDUR",  11111000010 },
        //  { "LDURB", 00111000010 },
        //  { "LDURD", 11111100010 },
        //  { "LDURH", 01111000010 },
        //  { "LDURS", 10111100010 },
        //  { "LDURSW",10111000100 },
        //  { "LSL",   11010011011 },
        //  { "LSR",   11010011010 },
        //  { "MUL",   10011011000 },
        //  { "ORR",   10101010000 },
        //  { "ORRI",  1011001000  },
        //  { "PRNL",  11111111100 },
        //  { "PRNT",  11111111101 },
        //  { "SDIV",  10011010110 },
        //  { "SMULH", 10011011010 },
        //  { "STUR",  11111000000 },
        //  { "STURB", 00111000000 },
        //  { "STURD", 11111100000 },
        //  { "STURH", 01111000000 },
        //  { "STURS", 10111100000 },
        //  { "STURSW",10111000000 },
        //  { "SUB",   11001011000 },
        //  { "SUBI",  1101000100  },
        //  { "SUBIS", 1111000100  },
        //  { "SUBS",  11101011000 },
        //  { "UDIV",  10011010110 },
        //  { "UMULH", 10011011110 }
        //};

    }
}