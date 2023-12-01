package org.me;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;


public class Methods {

    private File inputfile = null;
    private InputStream inputStream = null;

//    private ArrayList<String> opNames = new ArrayList<>();
//    private ArrayList<Boolean[]> opCodes = new ArrayList<>();
    private HashMap<String, Boolean[]> ophash = new HashMap<>();


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
        buildArrays();
    }

    private void buildArrays() {
        ophash.put("AND", new Boolean[]{true, false, false, false, true, false, true, true, false, false, false});
        ophash.put("ANDIS", new Boolean[]{true, false, false, true, false, false, false, true, false, false} ); //1001000100
        ophash.put("ANDS");
        ophash.put("B");
        ophash.put("BL");
        ophash.put("BR");
        ophash.put("CBNZ");
        ophash.put("CBZ");
        ophash.put("DUMP");
        ophash.put("EOR");
        ophash.put("EORI");
        ophash.put("FADDD");
        ophash.put("FADDS");
        ophash.put("FCMPD");
        ophash.put("FCMPS");
        ophash.put("ANDI");
        ophash.put("FDIVD");
        ophash.put("FDIVS");
        ophash.put("FMULD");
        ophash.put("FMULS");
        ophash.put("FSUBD");
        ophash.put("FSUBS");
        ophash.put("HALT");
        ophash.put("LDUR");
        ophash.put("LDURB");
        ophash.put("LDURD");
        ophash.put("LDURH");
        ophash.put("LDURS");
        ophash.put("LDURSW");
        ophash.put("LSL");
        ophash.put("LSR");
        ophash.put("MUL");
        ophash.put("ORR");
        ophash.put("ORRI");
        ophash.put("PRNL");
        ophash.put("PRNT");
        ophash.put("SDIV");
        ophash.put("SMULH");
        ophash.put("STUR");
        ophash.put("STURB");
        ophash.put("STURD");
        ophash.put("STURH");
        ophash.put("STURS");
        ophash.put("STURSW");
        ophash.put("SUB");
        ophash.put("SUBI");
        ophash.put("SUBIS");
        ophash.put("SUBS");
        ophash.put("UDIV");
        ophash.put("UMULH");

        Boolean[] b = new Boolean[]{true, false, false, false, true, false, true, true, false, false, false};
        opCodes.add(b);
        opCodes
//        opCodes.add(1001000100L);
//        opCodes.add(1011000100L);
//        opCodes.add(10101011000L);
//        opCodes.add(10001010000L);
//        opCodes.add(1001001000L);
//        opCodes.add(1111001000L);
//        opCodes.add(1110101000L);
//        opCodes.add(000101L);
//        opCodes.add(100101L);
//        opCodes.add(11010110000L);
//        opCodes.add(10110101L);
//        opCodes.add(10110100L);
//        opCodes.add(11111111110L);
//        opCodes.add(11001010000L);
//        opCodes.add(1101001000L);
//        opCodes.add(0b00011110011L);
//        opCodes.add(00011110001L);
//        opCodes.add(00011110011L);
//        opCodes.add(00011110001L);
//        opCodes.add(00011110011L);
//        opCodes.add(00011110001L);
//        opCodes.add(00011110011L);
//        opCodes.add(00011110001L);
//        opCodes.add(00011110011L);
//        opCodes.add(00011110001L);
//        opCodes.add(11111111111L);
//        opCodes.add(11111000010L);
//        opCodes.add(00111000010L);
//        opCodes.add(11111100010L);
//        opCodes.add(01111000010L);
//        opCodes.add(10111100010L);
//        opCodes.add(10111000100L);
//        opCodes.add(11010011011L);
//        opCodes.add(11010011010L);
//        opCodes.add(10011011000L);
//        opCodes.add(10101010000L);
//        opCodes.add(1011001000L);
//        opCodes.add(11111111100L);
//        opCodes.add(11111111101L);
//        opCodes.add(10011010110L);
//        opCodes.add(10011011010L);
//        opCodes.add(11111000000L);
//        opCodes.add(00111000000L);
//        opCodes.add(11111100000L);
//        opCodes.add(01111000000L);
//        opCodes.add(10111100000L);
//        opCodes.add(10111000000L);
//        opCodes.add(11001011000L);
//        opCodes.add(1101000100L);
//        opCodes.add(1111000100L);
//        opCodes.add(11101011000L);
//        opCodes.add(10011010110L);
//        opCodes.add(10011011110L);
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
