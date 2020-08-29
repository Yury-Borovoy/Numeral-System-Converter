# Numeral-System-Converter
The program converts a number from the source base to the target base. The max base can be 36 because there are 26 Latin letters and 10 digits (26 + 10). For example:

![picture](https://github.com/Yury-Borovoy/Numeral-System-Converter/blob/master/1.jpg)

The program converts both integers and numbers with a fractional part. To convert a number from the source base to the target base, we do the next:

1. If the given number is not decimal, we convert it to a decimal using the method ***Integer.parseInt(number, sourceBase)*** that returns a decimal representation of a number.
2. After that, we use the method ***Integer.toString(decimalNumber, newBase)*** that takes a decimal number and converts it to the target base.
