package org.me;


import java.io.*;
import java.util.HashMap;

public class Main{
    public static HashMap<Integer, String> opHash = new HashMap<>();
    private static void buildHash() {
        opHash.put(0b10001011000, "ADD");
        opHash.put(0b1001000100, "ADDI");
        opHash.put(0b10001010000, "AND");
        opHash.put(0b1001001000, "ANDI");
        opHash.put(0b000101, "B");
        opHash.put(0b01010100, "B.");
        opHash.put(0b100101, "BL");
        opHash.put(0b11010110000, "BR");
        opHash.put(0b10110101, "CBNZ");
        opHash.put(0b10110100, "CBZ");
        opHash.put(0b11001010000, "EOR");
        opHash.put(0b1101001000, "EORI");
        opHash.put(0b11111000010, "LDUR");
        opHash.put(0b11010011011, "LSL");
        opHash.put(0b11010011010, "LSR");
        opHash.put(0b10101010000, "ORR");
        opHash.put(0b1011001000, "ORRI");
        opHash.put(0b11111000000, "STUR");
        opHash.put(0b11001011000, "SUB");
        opHash.put(0b1101000100, "SUBI");
        opHash.put(0b1111000100, "SUBIS");
        opHash.put(0b11101011000, "SUBS");
        opHash.put(0b10011011000, "MUL");
        opHash.put(0b11111111101, "PRNT");
        opHash.put(0b11111111100, "PRNL");
        opHash.put(0b11111111110, "DUMP");
        opHash.put(0b11111111111, "HALT");

    }
    
    public static HashMap<Integer, String> conditions = new HashMap<>();
    private static void buildCondition() {
        conditions.put(0x0, "EQ");
        conditions.put(0x1, "NE");
        conditions.put(0x2, "HS");
        conditions.put(0x3, "LO");
        conditions.put(0x4, "MI");
        conditions.put(0x5, "PL");
        conditions.put(0x6, "VS");
        conditions.put(0x7, "VC");
        conditions.put(0x8, "HI");
        conditions.put(0x9, "LS");
        conditions.put(0xa, "GE");
        conditions.put(0xb, "LT");
        conditions.put(0xc, "GT");
        conditions.put(0xd, "LE");
    }

    public static int totalCount = 1;
    
    public static void main(String[] args) {
        
        buildHash();
        buildCondition();

        try {
            File f = new File(args[0]);
            DataInputStream instruction = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));
            StringBuilder codeLineString = new StringBuilder();
            while(instruction.available() >= 4){
                
                byte byte1 = instruction.readByte();
                int byte1Int = (byte1 & 0xFF) << 24;
                
                byte byte2 = instruction.readByte();
                int byte2Int = (byte2 & 0xFF) << 16;
                
                byte byte3 = instruction.readByte();
                int byte3Int = (byte3 & 0xFF) << 8;
                
                byte byte4 = instruction.readByte();
                int byte4Int = byte4 & 0xFF;

                int codeLine = byte1Int + byte2Int + byte3Int + byte4Int;

                runner(codeLine, codeLineString);
                codeLineString.append("\n");
            }

            //final print
            System.out.println(codeLineString.toString());
        }
        catch (IOException e){
            System.out.println("ERROR: File Not Found");
            e.printStackTrace();
        }
    }
    

    private static void runner(int instruction, StringBuilder codeLineString){

        int RDop = (instruction >> 21) & 0x7FF;
        int Iop = (instruction >> 22) & 0x3FF;
        int CBop = (instruction >> 24) & 0xFF;
        int Bop = (instruction >> 26) & 0x3F;
        
        //R/D - type
        if(opHash.containsKey(RDop)){
            codeLineString.append(opHash.get(RDop));

            if((RDop == 0b10001011000) || (RDop == 0b10001010000) || (RDop == 0b11001010000) || (RDop == 0b10101010000) || (RDop == 0b11001011000) || (RDop == 0b11101011000) || (RDop == 0b10011011000)){

                int rd = instruction & 0x1F;
                String rdString = "X" + rd;

                int rn = instruction >> 5 & 0x1F;
                String rnString = "X" + rn;
                
                int rm = instruction >> 16 & 0x1F;
                String rmString = "X" + rm;
              

                codeLineString.append(" " + rdString + ", " + rnString + ", " + rmString);
            }

            else if(RDop == 0b11010110000){

                int rn = instruction >> 5 & 0x1F;

                codeLineString.append(" X" + rn);
            }

            else if((RDop == 0b11010011011) || (RDop == 0b11010011010)) {

                int rd = instruction & 0x1F;
                String rdString = "X" + rd;
                
                int rn = instruction >> 5 & 0x1F;
                String rnString = "X" + rn;


                int shamt = instruction >> 10 & 0x3F;
                if(shamt >= 32){
                    shamt -= 64;
                }

                codeLineString.append(" " + rdString + ", " + rnString + ", #" + shamt);
            }

            else if(RDop == 0b11111111101){

                int rd = instruction & 0x1F;
                String rdString = "X" + rd;

                codeLineString.append(" " + rdString);
            }

            else if((RDop == 0b11111000010) || (RDop == 0b11111000000)){

                int Rt = instruction & 0x1F;
                String RtString = "X" + Rt;


                int rn = instruction >> 5 & 0x1F;
                String rnString = "X" + rn;
                
                int DTAddr = instruction >> 12 & 0x1FF;
                if(DTAddr >= 256){
                    DTAddr -= 512;
                }

                codeLineString.append(" " + RtString + ", [" + rnString + ", #" + DTAddr + "]");
            }
            
        }

        //Type I
        else if(opHash.containsKey(Iop)){
            codeLineString.append(opHash.get(Iop));

            int rd = instruction & 0x1F;
            String rdString = "X" + rd;

            int rn = instruction >> 5 & 0x1F;
            String rnString = "X" + rn;

            int ALUImm = instruction >> 10 & 0xFFF;

            if(ALUImm >= 2048){
                ALUImm -= 4096;
            }

            codeLineString.append(" " + rdString + ", " + rnString + ", #" + ALUImm);
        }
        
        //CB/B -  type
        else if(opHash.containsKey(CBop)){
            codeLineString.append(opHash.get(CBop));

            if(CBop == 0b01010100){
                int cond = instruction & 0x1F;
                String condString = conditions.get(cond);
                codeLineString.append(condString);
            }

            int Address = instruction >> 5 & 0x7FFFF;

            if(Address >= 262144){
                Address -= 524288;
            }

            codeLineString.append(" Label" + (totalCount + Address));
        }

        
        //attempt at Branch labels lol
        else if(opHash.containsKey(Bop)){
            int Address = instruction & 0x3FFFFFF;

            if(Address >= 33554432){
                Address -= 67108864;
            }

            codeLineString.append(opHash.get(Bop) + " Label" + (totalCount + Address));
        }
        
        else{
            System.out.println("Opcode not found --> Error with program");
        }
        totalCount++;

    }
}