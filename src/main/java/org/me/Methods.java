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

    private ArrayList<String> opNames = new ArrayList<>();
    private ArrayList<Long> opCodes = new ArrayList<>();


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
        opNames.add("AND");
        opNames.add("ANDIS");
        opNames.add("ANDS");
        opNames.add("B");
        opNames.add("BL");
        opNames.add("BR");
        opNames.add("CBNZ");
        opNames.add("CBZ");
        opNames.add("DUMP");
        opNames.add("EOR");
        opNames.add("EORI");
        opNames.add("FADDD");
        opNames.add("FADDS");
        opNames.add("FCMPD");
        opNames.add("FCMPS");
        opNames.add("ANDI");
        opNames.add("FDIVD");
        opNames.add("FDIVS");
        opNames.add("FMULD");
        opNames.add("FMULS");
        opNames.add("FSUBD");
        opNames.add("FSUBS");
        opNames.add("HALT");
        opNames.add("LDUR");
        opNames.add("LDURB");
        opNames.add("LDURD");
        opNames.add("LDURH");
        opNames.add("LDURS");
        opNames.add("LDURSW");
        opNames.add("LSL");
        opNames.add("LSR");
        opNames.add("MUL");
        opNames.add("ORR");
        opNames.add("ORRI");
        opNames.add("PRNL");
        opNames.add("PRNT");
        opNames.add("SDIV");
        opNames.add("SMULH");
        opNames.add("STUR");
        opNames.add("STURB");
        opNames.add("STURD");
        opNames.add("STURH");
        opNames.add("STURS");
        opNames.add("STURSW");
        opNames.add("SUB");
        opNames.add("SUBI");
        opNames.add("SUBIS");
        opNames.add("SUBS");
        opNames.add("UDIV");
        opNames.add("UMULH");

        opCodes.add(10001011000L);
        opCodes.add(1001000100L);
        opCodes.add(1011000100L);
        opCodes.add(10101011000L);
        opCodes.add(10001010000L);
        opCodes.add(1001001000L);
        opCodes.add(1111001000L);
        opCodes.add(1110101000L);
        opCodes.add(000101L);
        opCodes.add(100101L);
        opCodes.add(11010110000L);
        opCodes.add(10110101L);
        opCodes.add(10110100L);
        opCodes.add(11111111110L);
        opCodes.add(11001010000L);
        opCodes.add(1101001000L);
        opCodes.add(0b00011110011L);
        opCodes.add(00011110001L);
        opCodes.add(00011110011L);
        opCodes.add(00011110001L);
        opCodes.add(00011110011L);
        opCodes.add(00011110001L);
        opCodes.add(00011110011L);
        opCodes.add(00011110001L);
        opCodes.add(00011110011L);
        opCodes.add(00011110001L);
        opCodes.add(11111111111L);
        opCodes.add(11111000010L);
        opCodes.add(00111000010L);
        opCodes.add(11111100010L);
        opCodes.add(01111000010L);
        opCodes.add(10111100010L);
        opCodes.add(10111000100L);
        opCodes.add(11010011011L);
        opCodes.add(11010011010L);
        opCodes.add(10011011000L);
        opCodes.add(10101010000L);
        opCodes.add(1011001000L);
        opCodes.add(11111111100L);
        opCodes.add(11111111101L);
        opCodes.add(10011010110L);
        opCodes.add(10011011010L);
        opCodes.add(11111000000L);
        opCodes.add(00111000000L);
        opCodes.add(11111100000L);
        opCodes.add(01111000000L);
        opCodes.add(10111100000L);
        opCodes.add(10111000000L);
        opCodes.add(11001011000L);
        opCodes.add(1101000100L);
        opCodes.add(1111000100L);
        opCodes.add(11101011000L);
        opCodes.add(10011010110L);
        opCodes.add(10011011110L);
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
