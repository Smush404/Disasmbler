package org.me;

import java.io.*;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;

public class Methods {

    private File inputfile = null;
    private InputStream inputStream = null;

    private HashMap<String, Boolean[]> ophashR = new HashMap<>();
    private HashMap<String, Boolean[]> ophashD= new HashMap<>();
    private HashMap<String, Boolean[]> ophashI = new HashMap<>();
    private HashMap<String, Boolean[]> ophashB = new HashMap<>();
    private HashMap<String, Boolean[]> ophashCB = new HashMap<>();

    public BitSet byteToBit(byte[] bytelist){
        BitSet bitSet = BitSet.valueOf(bytelist);

        System.out.print("Bitset: ");
        for(int i = 0; i < bitSet.length(); i++) {
            System.out.print(((Boolean) bitSet.get(i)).compareTo(false));
        }
        System.out.println();
        return bitSet;
    }

    public Methods(File f) throws FileNotFoundException {
        inputfile = f;
        inputStream = new FileInputStream(f);
        buildhashs();
    }

    private void buildhashs() {
        ophashR.put("ADD", new Boolean[]{true, false, false, false, true, false, true, true, false, false, false});//"10001011000" R
        ophashI.put("ADDIS", new Boolean[]{true, false, true, true, false, false, false, true, false, false});// "1011000100" I
        ophashR.put("ADDS", new Boolean[]{true, false, true, false, true, false, true, true, false, false});// "10101011000" R
        ophashR.put("AND", new Boolean[]{true, false, false, false, true, false, true, false, false, false});// "10001010000" R
        ophashI.put("ANDI", new Boolean[]{true, false, false, true, false, false, true, false, false, false});// "1001001000" I
        ophashI.put("ANDIS", new Boolean[]{true, true, true, true, false, false, true, false, false, false});// "1111001000" I
        ophashR.put("ANDS", new Boolean[]{true, true, true, false, true, false, true, false, false, false});// "1110101000" R
        ophashB.put("B", new Boolean[]{false, false, false, true, false, true});// "000101" B
        ophashB.put("BL", new Boolean[]{true, false, true, false, true, true});// "100101" B
        ophashR.put("BR", new Boolean[]{true, true, false, true, false, true, true, false, false, false});// "11010110000" R
        ophashCB.put("CBNZ", new Boolean[]{true, false, true, true, false, true, false, false, true});// "10110101" CB
        ophashCB.put("CBZ", new Boolean[]{true, false, true, true, false, true, false, false, false});// "10110100" CB
        ophashR.put("DUMP", new Boolean[]{true, true, true, true, true, true, true, true, true, false});// "11111111110" R
        ophashR.put("EOR", new Boolean[]{true, true, false, false, true, false, true, false, false, false});// "11001010000" R
        ophashI.put("EORI", new Boolean[]{true, true, false, true, false, false, true, false, false, false});// "1101001000" I
        ophashR.put("FADDD", new Boolean[]{false, false, false, true, true, true, true, false, false, true, true});// "00011110011" R
        ophashR.put("FADDS", new Boolean[]{false, false, false, true, true, true, true, false, false, false, true});// "00011110001" R
        ophashR.put("FCMPD", new Boolean[]{false, false, false, true, true, true, true, false, false, true, true});// "00011110011" R
        ophashR.put("FCMPS", new Boolean[]{false, false, false, true, true, true, true, false, false, false, true});// "00011110001" R
        ophashR.put("FDIVD", new Boolean[]{false, false, false, true, true, true, true, false, false, true, true});// "00011110011" R
        ophashR.put("FDIVS", new Boolean[]{false, false, false, true, true, true, true, false, false, false, true});// "00011110001"R
        ophashR.put("FMULD", new Boolean[]{false, false, false, true, true, true, true, false, false, true, true});// "00011110011"R
        ophashR.put("FMULS", new Boolean[]{false, false, false, true, true, true, true, false, false, false, true});// "00011110001"R
        ophashR.put("FSUBD", new Boolean[]{false, false, false, true, true, true, true, false, false, true, true});// "00011110011"R
        ophashR.put("FSUBS", new Boolean[]{false, false, false, true, true, true, true, false, false, false, true});// "00011110001"R
        ophashR.put("HALT", new Boolean[]{true, true, true, true, true, true, true, true, true, true});// "11111111111" R
        ophashD.put("LDUR", new Boolean[]{true, true, true, true, true, false, false, false, false, true, false});// "11111000010" D
        ophashD.put("LDURB", new Boolean[]{false, false, true, true, true, false, false, false, false, true, false});// "00111000010" D
        ophashR.put("LDURD", new Boolean[]{true, true, true, true, true, true, true, false, false, false, false});// "11111100010" R
        ophashD.put("LDURH", new Boolean[]{false, true, true, true, true, false, false, false, false, true, false});// "01111000010" D
        ophashR.put("LDURS", new Boolean[]{true, false, true, true, true, true, false, false, false, true, false});// "10111100010" R
        ophashD.put("LDURSW", new Boolean[]{true, false, true, true, true, true, false, false, true, false, false});// "10111000100" D
        ophashR.put("LSL", new Boolean[]{true, true, false, true, false, false, true, true, false, true, true});// "11010011011" R
        ophashR.put("LSR", new Boolean[]{true, true, false, true, false, false, true, true, false, true, false});// "11010011010" R
        ophashR.put("MUL", new Boolean[]{true, false, false, true, true, false, true, true, false, false, false});// "10011011000" R
        ophashR.put("ORR", new Boolean[]{true, false, true, false, true, false, true, false, false, false, false});// "10101010000" R
        ophashI.put("ORRI", new Boolean[]{true, false, true, true, false, false, true, false, false, false, false});// "1011001000" I
        ophashR.put("PRNL", new Boolean[]{true, true, true, true, true, true, true, true, true, false, false});// "11111111100" R
         ophashR.put("PRNT",  new Boolean[]{true, true, true, true,true,true,true,true,true,false,true,});//0b11111111101 R
         ophashR.put("SDIV",  new Boolean[]{true, false, false, true, true, false, true, false, true, true, false}); //0b10011010110 R
         ophashR.put("SMULH",  new Boolean[]{true, false, false, true, true, false, true, true, false, true, false}); //0b10011011010 R
         ophashR.put("STUR",  new Boolean[]{true, true, true, true, true, false, false, false, false, false, false}); //0b11111000000 R
        ophashD.put("STURB", new Boolean[]{false, false, true, false, false, false, false, false, false, false, false});// "0b00111000000" D
        ophashR.put("STURD", new Boolean[]{true, true, true, false, false, false, false, false, false, false, false});// "0b11111100000" R
        ophashD.put("STURH", new Boolean[]{false, false, false, false, false, false, false, false, false, false, false});// "0b01111000000" D
        ophashR.put("STURS", new Boolean[]{false, false, false, false, false, false, false, false, false, false, false});// "0b10111100000" R
        ophashD.put("STURSW", new Boolean[]{false, false, false, false, false, false, false, false, false, false, false});// "0b10111000000" D
        ophashR.put("SUB", new Boolean[]{true, true, false, false, true, false, false, false, false, false, false});// "0b11001011000" R
        ophashI.put("SUBI", new Boolean[]{true, true, true, false, true, false, false, false, false, false, false});// "0b1101000100" I
        ophashI.put("SUBIS", new Boolean[]{true, true, true, false, false, false, false, false, false, false, false});// "0b1111000100" I
        ophashR.put("SUBS", new Boolean[]{true, true, true, false, false, false, false, false, false, false, false});// "0b11101011000" R
        ophashR.put("UDIV", new Boolean[]{true, false, false, true, false, false, false, false, false, false, false});// "0b10011010110" R
        ophashR.put("UMULH", new Boolean[]{true, false, false, true, false, false, false, false, false, false, false});// "0b10011011110" R
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

    /**
     * takes in a bitset and then returns a string with the op-type
     * @param bitSet
     * @return String that gives the type of op
     */
    public String getType(BitSet bitSet) {
        if (bitSet.isEmpty()) {
            return "Empty Bitset";
        }
    
        Boolean[] boolList = new Boolean[11];
    
        for (int i = 0; i < 11; i++) {
            boolList[i] = bitSet.get(i);
        }
    
        System.out.print("\n");
    
        for (int i = 0; i < boolList.length; i++) {
            System.out.print(boolList[i] + " ");
        }
    
        if (containsValueInHashMap(ophashB, boolList)) {return "B";}
        if (containsValueInHashMap(ophashR, boolList)) {return "R";}
        if (containsValueInHashMap(ophashI, boolList)) {return "I";}
        if (containsValueInHashMap(ophashD, boolList)) {return "D";}
        if (containsValueInHashMap(ophashCB, boolList)) {return "CB";}
    
        return "Not an OP code";
    }
    private boolean containsValueInHashMap(HashMap<String, Boolean[]> hashMap, Boolean[] targetValue) {
        for (Boolean[] value : hashMap.values()) {
            if (Arrays.equals(value, targetValue)) {
                return true;
            }
        }
        return false;
    }
}
