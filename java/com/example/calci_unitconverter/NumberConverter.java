package com.example.calci_unitconverter;

import androidx.fragment.app.Fragment;

import java.util.HashMap;
import java.util.Map;
public class NumberConverter {
    public String toRoman(int numberinput) {
        String returnstringvalue = " ";
        if (numberinput < 0 || numberinput > 1000000) {
            return "Out of given range";
        }
        while (numberinput >= 1000) {
            returnstringvalue += "M";
            numberinput -= 1000;
        }
        while (numberinput >= 900) {
            returnstringvalue += "CM";
            numberinput -= 900;
        }
        while (numberinput >= 500) {
            returnstringvalue += "D";
            numberinput -= 500;
        }
        while (numberinput >= 400) {
            returnstringvalue += "CD";
            numberinput -= 400;
        }
        while (numberinput >= 100) {
            returnstringvalue += "C";
            numberinput -= 100;
        }
        while (numberinput >= 90) {
            returnstringvalue += "XC";
            numberinput -= 90;
        }
        while (numberinput >= 50) {
            returnstringvalue += "L";
            numberinput -= 50;
        }
        while (numberinput >= 40) {
            returnstringvalue += "XL";
            numberinput -= 40;
        }
        while (numberinput >= 10) {
            returnstringvalue += "X";
            numberinput -= 10;
        }
        while (numberinput >= 9) {
            returnstringvalue += "IX";
            numberinput -= 9;
        }
        while (numberinput >= 5) {
            returnstringvalue += "V";
            numberinput -= 5;
        }
        while (numberinput >= 4) {
            returnstringvalue += "IV";
            numberinput -= 4;
        }
        while (numberinput >= 1) {
            returnstringvalue += "I";
            numberinput -= 1;
        }
        return returnstringvalue;
    }
    public int toNumber(String romaninput) {
        romaninput = romaninput.toUpperCase();
        if (romaninput == null || romaninput.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('I', 1);
        charMap.put('V', 5);
        charMap.put('X', 10);
        charMap.put('L', 50);
        charMap.put('C', 100);
        charMap.put('D', 500);
        charMap.put('M', 1000);
        int result = 0;
        for (int i = 0; i < (romaninput.length() - 1); i++) {
            if (charMap.get(romaninput.charAt(i)) >= charMap.get(romaninput.charAt(i + 1))) {
                result += charMap.get(romaninput.charAt(i));
            } else {
                result -= charMap.get(romaninput.charAt(i));
            }
        }
        result += charMap.get(romaninput.charAt(romaninput.length() - 1));
        return result;
    }
}