package com.numeral_system_converter;

import java.util.Scanner;

public class Converter {
    private Scanner scan = new Scanner(System.in);



    public void goConvert() {
        long decimal = Long.parseLong(scan.nextLine());
        int radix = Integer.parseInt(scan.nextLine());
        String result = Long.toString(decimal, radix);

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
    }
}

