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
        buildhash();

    }

    private void buildhash() {
        ophash.put("ADD", new Boolean[]{true, false, false, false, true, false, true, true, false, false, false});//"10001011000" R
        ophash.put("ADDIS", new Boolean[]{true, false, true, true, false, false, false, true, false, false});// "1011000100" I
        ophash.put("ADDS", new Boolean[]{true, false, true, false, true, false, true, true, false, false});// "10101011000" R
        ophash.put("AND", new Boolean[]{true, false, false, false, true, false, true, false, false, false});// "10001010000" R
        ophash.put("ANDI", new Boolean[]{true, false, false, true, false, false, true, false, false, false});// "1001001000" I
        ophash.put("ANDIS", new Boolean[]{true, true, true, true, false, false, true, false, false, false});// "1111001000" I
        ophash.put("ANDS", new Boolean[]{true, true, true, false, true, false, true, false, false, false});// "1110101000" R
        ophash.put("B", new Boolean[]{false, false, false, true, false, true});// "000101" B
        ophash.put("BL", new Boolean[]{true, false, true, false, true, true});// "100101" B
        ophash.put("BR", new Boolean[]{true, true, false, true, false, true, true, false, false, false});// "11010110000" R
        ophash.put("CBNZ", new Boolean[]{true, false, true, true, false, true, false, false, true});// "10110101" CB
        ophash.put("CBZ", new Boolean[]{true, false, true, true, false, true, false, false, false});// "10110100" CB
        ophash.put("DUMP", new Boolean[]{true, true, true, true, true, true, true, true, true, false});// "11111111110" R
        ophash.put("EOR", new Boolean[]{true, true, false, false, true, false, true, false, false, false});// "11001010000" R
        ophash.put("EORI", new Boolean[]{true, true, false, true, false, false, true, false, false, false});// "1101001000" I
        ophash.put("FADDD", new Boolean[]{false, false, false, true, true, true, true, false, false, true, true});// "00011110011" R
        ophash.put("FADDS", new Boolean[]{false, false, false, true, true, true, true, false, false, false, true});// "00011110001" R
        ophash.put("FCMPD", new Boolean[]{false, false, false, true, true, true, true, false, false, true, true});// "00011110011" R
        ophash.put("FCMPS", new Boolean[]{false, false, false, true, true, true, true, false, false, false, true});// "00011110001" R
        ophash.put("FDIVD", new Boolean[]{false, false, false, true, true, true, true, false, false, true, true});// "00011110011" R
        ophash.put("FDIVS", new Boolean[]{false, false, false, true, true, true, true, false, false, false, true});// "00011110001"R
        ophash.put("FMULD", new Boolean[]{false, false, false, true, true, true, true, false, false, true, true});// "00011110011"R
        ophash.put("FMULS", new Boolean[]{false, false, false, true, true, true, true, false, false, false, true});// "00011110001"R
        ophash.put("FSUBD", new Boolean[]{false, false, false, true, true, true, true, false, false, true, true});// "00011110011"R
        ophash.put("FSUBS", new Boolean[]{false, false, false, true, true, true, true, false, false, false, true});// "00011110001"R
        ophash.put("HALT", new Boolean[]{true, true, true, true, true, true, true, true, true, true});// "11111111111" R
        ophash.put("LDUR", new Boolean[]{true, true, true, true, true, false, false, false, false, true, false});// "11111000010" D
        ophash.put("LDURB", new Boolean[]{false, false, true, true, true, false, false, false, false, true, false});// "00111000010" D
        ophash.put("LDURD", new Boolean[]{true, true, true, true, true, true, true, false, false, false, false});// "11111100010" R
        ophash.put("LDURH", new Boolean[]{false, true, true, true, true, false, false, false, false, true, false});// "01111000010" D
        ophash.put("LDURS", new Boolean[]{true, false, true, true, true, true, false, false, false, true, false});// "10111100010" R
        ophash.put("LDURSW", new Boolean[]{true, false, true, true, true, true, false, false, true, false, false});// "10111000100" D
        ophash.put("LSL", new Boolean[]{true, true, false, true, false, false, true, true, false, true, true});// "11010011011" R
        ophash.put("LSR", new Boolean[]{true, true, false, true, false, false, true, true, false, true, false});// "11010011010" R
        ophash.put("MUL", new Boolean[]{true, false, false, true, true, false, true, true, false, false, false});// "10011011000" R
        ophash.put("ORR", new Boolean[]{true, false, true, false, true, false, true, false, false, false, false});// "10101010000" R
        ophash.put("ORRI", new Boolean[]{true, false, true, true, false, false, true, false, false, false, false});// "1011001000" I
        ophash.put("PRNL", new Boolean[]{true, true, true, true, true, true, true, true, true, false, false});// "11111111100" R
         ophash.put("PRNT",  new Boolean[]{true, true, true, true,true,true,true,true,true,false,true,});//0b11111111101 R
         ophash.put("SDIV",  new Boolean[]{true, false, false, true, true, false, true, false, true, true, false}); //0b10011010110 R
         ophash.put("SMULH",  new Boolean[]{true, false, false, true, true, false, true, true, false, true, false}); //0b10011011010 R
         ophash.put("STUR",  new Boolean[]{true, true, true, true, true, false, false, false, false, false, false}); //0b11111000000 R
        ophash.put("STURB", new Boolean[]{false, false, true, false, false, false, false, false, false, false, false});// "0b00111000000" D
        ophash.put("STURD", new Boolean[]{true, true, true, false, false, false, false, false, false, false, false});// "0b11111100000" R
        ophash.put("STURH", new Boolean[]{false, false, false, false, false, false, false, false, false, false, false});// "0b01111000000" D
        ophash.put("STURS", new Boolean[]{false, false, false, false, false, false, false, false, false, false, false});// "0b10111100000" R
        ophash.put("STURSW", new Boolean[]{false, false, false, false, false, false, false, false, false, false, false});// "0b10111000000" D
        ophash.put("SUB", new Boolean[]{true, true, false, false, true, false, false, false, false, false, false});// "0b11001011000" R
        ophash.put("SUBI", new Boolean[]{true, true, true, false, true, false, false, false, false, false, false});// "0b1101000100" I
        ophash.put("SUBIS", new Boolean[]{true, true, true, false, false, false, false, false, false, false, false});// "0b1111000100" I
        ophash.put("SUBS", new Boolean[]{true, true, true, false, false, false, false, false, false, false, false});// "0b11101011000" R
        ophash.put("UDIV", new Boolean[]{true, false, false, true, false, false, false, false, false, false, false});// "0b10011010110" R
        ophash.put("UMULH", new Boolean[]{true, false, false, true, false, false, false, false, false, false, false});// "0b10011011110" R
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
