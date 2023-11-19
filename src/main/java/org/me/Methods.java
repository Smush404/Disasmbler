package org.me;

import java.io.*;
import java.util.BitSet;


public class Methods {

    private File inputfile = null;
    private InputStream inputStream = null;


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
}
