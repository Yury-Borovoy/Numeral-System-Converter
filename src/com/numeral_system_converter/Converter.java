package com.numeral_system_converter;

import java.util.Scanner;

public class Converter {

    private int sourceRadix;
    private String sourceNumber;
    private int targetRadix;
    private final Scanner scan = new Scanner(System.in);

    public void goConvert() {
        boolean ok = enterValues();
        if (!ok) {
            return;
        }
        double decimalNumber = 0.0;
        //translate the sourceRadix to decimalRadix (work with sourceNumber)
        if (sourceRadix == 10) {
            decimalNumber = Double.parseDouble(sourceNumber);
        } else if (sourceRadix == 1) {
            for (int i = 0; i < sourceNumber.length(); i++) {
                decimalNumber += 1;
            }
        } else {
            decimalNumber = translateToDecimalRadix();
        }
        //translate the decimalRadix to targetRadix
        System.out.println(translateToTargetRadix(decimalNumber));
    }

    public boolean enterValues() {
        //enter and check sourceRadix
        String sRadix = scan.nextLine();
        if (sRadix.matches("[0-9]+") && Integer.parseInt(sRadix) < 37 && Integer.parseInt(sRadix) > 0) {
            sourceRadix = Integer.parseInt(sRadix);
        } else {
            System.out.println("error");
            return false;
        }
        //enter and check sourceNumber
        sourceNumber = scan.nextLine().toLowerCase();
        if (!sourceNumber.matches("[0-9a-z]+\\.?[0-9a-z]*")) {
            System.out.println("error");
            return false;
        }
        for (int i = 0; i < sourceNumber.length(); i++) {
            if (sourceNumber.charAt(i) <= '9' && !String.valueOf(sourceNumber.charAt(i)).matches("\\.")) {
                if (Integer.parseInt(String.valueOf(sourceNumber.charAt(i))) > sourceRadix) {
                    System.out.println("error");
                    return false;
                }
            }else if (sourceNumber.charAt(i) > '9' && !String.valueOf(sourceNumber.charAt(i)).matches("\\.")) {
                if (Integer.parseInt(String.valueOf(sourceNumber.charAt(i) - 87)) >= sourceRadix) {
                    System.out.println("error");
                    return false;
                }
            }
        }
        String tRadix = scan.nextLine();
        if (tRadix.matches("[0-9]+") && Integer.parseInt(tRadix) > 0 && Integer.parseInt(tRadix) < 37) {
            targetRadix = Integer.parseInt(tRadix);
        } else {
            System.out.println("error");
            return false;
        }
        return true;
    }
    public double translateToDecimalRadix() {
        if (sourceNumber.matches("[0-9a-z]*\\.[0-9a-z]*")) {
            String[] wholeAndFraction = sourceNumber.toLowerCase().split("\\.");
            int wholePart = Integer.parseInt(wholeAndFraction[0], sourceRadix);//translate wholePart to decimalWholePart
            StringBuilder fractionPart = new StringBuilder();
            fractionPart.append((wholeAndFraction[1]).toLowerCase());
            double decimalFractionPart = 0.0;
            int countPow = 1;
            //divide each unit of the fractionPart by the sourceRadix^countPow
            for (int i = 0; i < fractionPart.length(); i++) {
                if (fractionPart.charAt(i) >= 'a' && fractionPart.charAt(i) <= 'z') {
                    decimalFractionPart += Integer.parseInt(String.valueOf(fractionPart.charAt(i) - 87)) / Math.pow(sourceRadix, countPow);
                } else {
                    decimalFractionPart += Integer.parseInt(String.valueOf(fractionPart.charAt(i))) / Math.pow(sourceRadix, countPow);
                }
                countPow++;
            }
            return wholePart + decimalFractionPart;
        } else {
            return Integer.parseInt(sourceNumber, sourceRadix);
        }
    }
        public String translateToTargetRadix(double decimalNumber){
            int wholePart = (int) decimalNumber;
            if (sourceNumber.matches("[0-9a-z]*\\.[0-9a-z]*")) {
                double fractionPart = decimalNumber - wholePart;
                StringBuilder fractionTargetPart = new StringBuilder();
                //Multiply the fractional part by the new base.
                //The integer part of the result is the first digit
                // (or letter if the integer part is greater than 9)
                // in the fractional part of a number in the new base.
                for (int i = 0; i < 5; i++) {
                    fractionPart = fractionPart * targetRadix;
                    if ((int) fractionPart > 9) {
                        fractionTargetPart.append((char) (87 + (int) fractionPart));
                    } else {
                        fractionTargetPart.append((int) fractionPart);
                    }
                    fractionPart -= (int) fractionPart;
                }
                if (targetRadix != 1) {
                    return Integer.toString(wholePart, targetRadix) + "." + fractionTargetPart.toString();
                } else {
                    return "1".repeat(Math.max(0, wholePart));
                }
            } else {
                if (targetRadix != 1) {
                    return Integer.toString(wholePart, targetRadix);
                } else {

                    return "1".repeat(Math.max(0, wholePart));
                }
            }
        }
    }

