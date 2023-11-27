package org.me;

import java.io.*;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;


public class Methods {

    private File inputfile = null;
    private InputStream inputStream = null;

    private HashMap<String, BitSet> instruction = new HashMap<>();
//      { "ADD",   10001011000 },
//      { "ADDI",  1001000100  },
//      { "ADDIS", 1011000100  },
//      { "ADDS",  10101011000 },
//      { "AND",   10001010000 },
//      { "ANDI",  1001001000  },
//      { "ANDIS", 1111001000  },
//      { "ANDS",  1110101000  },
//      { "B",     000101      },
//      { "BL",    100101      },
//      { "BR",    11010110000 },
//      { "CBNZ",  10110101    },
//      { "CBZ",   10110100    },
//      { "DUMP",  11111111110 },
//      { "EOR",   11001010000 },
//      { "EORI",  1101001000  },
//      { "FADDD", 0b00011110011 },
//      { "FADDS", 00011110001 },
//      { "FCMPD", 00011110011 },
//      { "FCMPS", 00011110001 },
//      { "FDIVD", 00011110011 },
//      { "FDIVS", 00011110001 },
//      { "FMULD", 00011110011 },
//      { "FMULS", 00011110001 },
//      { "FSUBD", 00011110011 },
//      { "FSUBS", 00011110001 },
//      { "HALT",  11111111111 },
//      { "LDUR",  11111000010 },
//      { "LDURB", 00111000010 },
//      { "LDURD", 11111100010 },
//      { "LDURH", 01111000010 },
//      { "LDURS", 10111100010 },
//      { "LDURSW",10111000100 },
//      { "LSL",   11010011011 },
//      { "LSR",   11010011010 },
//      { "MUL",   10011011000 },
//      { "ORR",   10101010000 },
//      { "ORRI",  1011001000  },
//      { "PRNL",  11111111100 },
//      { "PRNT",  11111111101 },
//      { "SDIV",  10011010110 },
//      { "SMULH", 10011011010 },
//      { "STUR",  11111000000 },
//      { "STURB", 00111000000 },
//      { "STURD", 11111100000 },
//      { "STURH", 01111000000 },
//      { "STURS", 10111100000 },
//      { "STURSW",10111000000 },
//      { "SUB",   11001011000 },
//      { "SUBI",  1101000100  },
//      { "SUBIS", 1111000100  },
//      { "SUBS",  11101011000 },
//      { "UDIV",  10011010110 },
//      { "UMULH", 10011011110 }

    public BitSet byteToBit(byte[] bytelist){
        BitSet bitSet = BitSet.valueOf(bytelist);

        System.out.print("Bitset: ");
        for(int i = 0; i < bitSet.length(); i++) {
            System.out.print(((Boolean) bitSet.get(i)).compareTo(false));
        }

        return bitSet;
    }

    public Methods(File f) throws FileNotFoundException {
        inputfile = f;
        inputStream = new FileInputStream(f);
        buildHash();
    }

    private void buildHash() {
          BitSet b = new BitSet();
          for(int i = 0; i < "10001011000".length(); i++){}
          instruction.put("ADD", 10001011000);
    }

    protected byte[] reader() throws IOException {


        if(!inputfile.exists()){return null;}

        return inputStream.readAllBytes();
    }

    public String printBytes(byte[] bytelist){
        StringBuilder sb = new StringBuilder();
        sb.append(">> [ ");
        for (byte b : bytelist) {
            sb.append(String.format("0x%02X ", b));
        }
        sb.append("]");
        return sb.toString();
    }

    //Getter + Setter

    protected File getInputfile() {
        return inputfile;
    }

    /**
     * takes in a bitset and then returns a string with the op-type
     * @param bitSet
     * @return String that gives the type of op
     */
    public String getType(BitSet bitSet) {
        return "R - ADDI";
    }
}
