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
        } catch (FileNotFoundException e){e.printStackTrace();}

        byte[] bytelist = null;

        try { //filling the list with bytes from file
            bytelist = m.reader();
        } catch (IOException e){e.printStackTrace();}

        System.out.println(m.printBytes(bytelist)); // checking bytes

        BitSet bitList = m.byteToBit(bytelist);// gets bit list


        //TODO
        //instruction_t instruction[] = {
        //  { "ADD", 0b10001011000 },
        //  { "ADDI", 0b1001000100  },
        //  { "ADDIS",   ADDIS_inst,  0b1011000100  },
        //  { "ADDS",    ADDS_inst,   0b10101011000 },
        //  { "AND",     AND_inst,    0b10001010000 },
        //  { "ANDI",    ANDI_inst,   0b1001001000  },
        //  { "ANDIS",   ANDIS_inst,  0b1111001000  },
        //  { "ANDS",    ANDS_inst,   0b1110101000  },
        //  { "B",       B_inst,      0b000101      },
        //  { "BL",      BL_inst,     0b100101      },
        //  { "BR",      BR_inst,     0b11010110000 },
        //  { "CBNZ",    CBNZ_inst,   0b10110101    },
        //  { "CBZ",     CBZ_inst,    0b10110100    },
        //  { "DUMP",    DUMP_inst,   0b11111111110 },
        //  { "EOR",     EOR_inst,    0b11001010000 },
        //  { "EORI",    EORI_inst,   0b1101001000  },
        //  { "FADDD",   FADDD_inst,  0b00011110011 },
        //  { "FADDS",   FADDS_inst,  0b00011110001 },
        //  { "FCMPD",   FCMPD_inst,  0b00011110011 },
        //  { "FCMPS",   FCMPS_inst,  0b00011110001 },
        //  { "FDIVD",   FDIVD_inst,  0b00011110011 },
        //  { "FDIVS",   FDIVS_inst,  0b00011110001 },
        //  { "FMULD",   FMULD_inst,  0b00011110011 },
        //  { "FMULS",   FMULS_inst,  0b00011110001 },
        //  { "FSUBD",   FSUBD_inst,  0b00011110011 },
        //  { "FSUBS",   FSUBS_inst,  0b00011110001 },
        //  { "HALT",    HALT_inst,   0b11111111111 },
        //  { "LDUR",    LDUR_inst,   0b11111000010 },
        //  { "LDURB",   LDURB_inst,  0b00111000010 },
        //  { "LDURD",   LDURD_inst,  0b11111100010 },
        //  { "LDURH",   LDURH_inst,  0b01111000010 },
        //  { "LDURS",   LDURS_inst,  0b10111100010 },
        //  { "LDURSW",  LDURSW_inst, 0b10111000100 },
        //  { "LSL",     LSL_inst,    0b11010011011 },
        //  { "LSR",     LSR_inst,    0b11010011010 },
        //  { "MUL",     MUL_inst,    0b10011011000 },
        //  { "ORR",     ORR_inst,    0b10101010000 },
        //  { "ORRI",    ORRI_inst,   0b1011001000  },
        //  { "PRNL",    PRNL_inst,   0b11111111100 },
        //  { "PRNT",    PRNT_inst,   0b11111111101 },
        //  { "SDIV",    SDIV_inst,   0b10011010110 },
        //  { "SMULH",   SMULH_inst,  0b10011011010 },
        //  { "STUR",    STUR_inst,   0b11111000000 },
        //  { "STURB",   STURB_inst,  0b00111000000 },
        //  { "STURD",   STURD_inst,  0b11111100000 },
        //  { "STURH",   STURH_inst,  0b01111000000 },
        //  { "STURS",   STURS_inst,  0b10111100000 },
        //  { "STURSW",  STURW_inst,  0b10111000000 },
        //  { "SUB",     SUB_inst,    0b11001011000 },
        //  { "SUBI",    SUBI_inst,   0b1101000100  },
        //  { "SUBIS",   SUBIS_inst,  0b1111000100  },
        //  { "SUBS",    SUBS_inst,   0b11101011000 },
        //  { "UDIV",    UDIV_inst,   0b10011010110 },
        //  { "UMULH",   UMULH_inst,  0b10011011110 }
        //};

    }
}