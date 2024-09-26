package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class Converter {
    // This function returns
    // value of a Roman symbol
    int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    // Finds decimal value of a
    // given roman numeral
    int romanToDecimal(String str)  {


        if (str==null){
            throw new IllegalArgumentException("Roman can not be null");
        }

        if (str.isEmpty()){
            throw new IllegalArgumentException("Roman can not be Empty");
        }

        if (str.contains(" ")){
            throw new IllegalArgumentException("Roman can not have spaces");
        }

        if (!str.matches("[A-Z]+")){
            throw new IllegalArgumentException("Roman should consist only of latin upper case letters");
        }

        if(!ValidationOfRomanNumerals(str))
        {
            throw new IllegalArgumentException("Invalid roman numeral");
        }

        // Initialize result
        int res = 0;

        for (int i = 0; i < str.length(); i++)
        {
            // Getting value of symbol s[i]
            int s1 = value(str.charAt(i));

            // Getting value of symbol s[i+1]
            if (i + 1 < str.length())
            {
                int s2 = value(str.charAt(i + 1));

                // Comparing both values
                if (s1 >= s2)
                {
                    // Value of current symbol
                    // is greater or equalto
                    // the next symbol
                    res = res + s1;
                }
                else
                {
                    // Value of current symbol is
                    // less than the next symbol
                    res = res + s2 - s1;
                    i++;
                }
            }
            else
            {
                res = res + s1;
            }
        }

        return res;
    }

    private static boolean
    ValidationOfRomanNumerals(String str)
    {

        // Regex to check Roman numeral
        String regex
                = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the str
        // is empty return false
        if (str == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given
        // ROMAN NUMERAL regular expression.
        Matcher m = p.matcher(str);

        // Return if the str
        // matched the ReGex
        return m.matches();
    }

}
