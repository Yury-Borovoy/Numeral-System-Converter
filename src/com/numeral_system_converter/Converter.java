package com.numeral_system_converter;

import java.util.Scanner;

public class Converter {
    private Scanner scan = new Scanner(System.in);

    public void goConvert() {
        int sourceRadix = Integer.parseInt(scan.nextLine());
        int sourceNumber = Integer.parseInt(scan.nextLine());
        int targetRadix = Integer.parseInt(scan.nextLine());
        //translate the sourceRadix to decimalRadix (work with sourceNumber)
        int decimalNumber = translateToDecimalRadix(sourceRadix, sourceNumber);
        //translate the decimalRadix to targetRadix
        String result = translateToTargetRadix(decimalNumber, targetRadix);
        System.out.println(result);
        /*
        switch(radix) {
            case 16:
                System.out.println("0x" + result);
                break;
            case 8:
                System.out.println("0" + result);
                break;
            case 2:
                System.out.println("0b" + result);
                break;
            default:
                break;
        }

         */
    }

    public int translateToDecimalRadix (int sourceRadix, int sourceNumber) {
        if (sourceRadix != 1) {
            return Integer.parseInt(String.valueOf(sourceNumber), sourceRadix);
        } else {
            String[] massiveSource = String.valueOf(sourceNumber).split("");
            int result = 0;
            for (String s : massiveSource) {
                result += Integer.parseInt(s);
            }
            return result;
        }
    }
    public String translateToTargetRadix (int decimalNumber, int targetRadix) {
        if (targetRadix != 1) {
            return Integer.toString(decimalNumber, targetRadix);
        } else {

            return "1".repeat(Math.max(0, decimalNumber));
        }
    }


}

