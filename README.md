# Numeral-System-Converter
The program converts a number from the source base to the target base. The max base can be 36 because there are 26 Latin letters and 10 digits (26 + 10). For example:

![picture](https://github.com/Yury-Borovoy/Numeral-System-Converter/blob/master/1.jpg)

The program converts both integers and numbers with a fractional part. To convert a number from the source base to the target base, we do the next:

1. Split the number into two parts: integer and fractional;
2. If the given number is not decimal, we convert it to a decimal using the method ***Integer.parseInt(number, sourceBase)*** that returns a decimal representation of a number.
3. After that, we use the method ***Integer.toString(decimalNumber, newBase)*** that takes a decimal number and converts it to the target base.
3. Convert the fractional part into decimal using the following formula:

![picture](https://github.com/Yury-Borovoy/Numeral-System-Converter/blob/master/fractional.jpg)

The more digits (literals) in the fractional part, the more addends in the formula. If the fractional part has letters, then use their number representation: ‘a’ – 10, ‘b’ – 11, c – ‘12’, and so on. To see the decimal representation of the source number, we can sum the decimal integer and the decimal fractional parts.

5. Split the decimal number into two parts: integer and fractional;
6. Convert the integer part into the new base;
7. Convert the fractional part from decimal to any other base.

## Converting the fractional part from a decimal bace to the target base
### Example: 0.5168 into base 19

Multiply the fractional part by the new base: 0.5168 * 19 = 9.81920.5168∗19=9.8192. The integer part of the result is the first digit (or letter if the integer part is greater than 9) in the fractional part of a number in the new base. In this case, the first digit in the fractional part is 9.

Take the fractional part from the result of the multiplication and multiply it by the new base again: 0.8192 * 19 = 15.56480.8192∗19=15.5648. For numbers greater than 9, we should use their literal representation: 10 – ‘a’, 11 – ‘b’, 12 – ‘c’, and so on. In this case, the second digit (literal) is f (15). To calculate the rest of the digits (literals), repeat this action.

![picture](https://github.com/Yury-Borovoy/Numeral-System-Converter/blob/master/toTarget.jpg)
