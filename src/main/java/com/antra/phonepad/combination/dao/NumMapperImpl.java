package com.antra.phonepad.combination.dao;

import java.util.*;
import org.springframework.stereotype.Repository;


@Repository("ToNumMapper")
public class NumMapperImpl implements ToNumMapper{

    String normal = "";

    @Override
    public String toNumMapper(String digits) {
        return toNormalPhoneNumber(digits);
    }

    public String toNormalPhoneNumber(String digits) {
        normal = "";
        for (char c : digits.toCharArray()) {
            if (Character.isDigit(c))
                normal += c;
            else {
                switch (c) {
                    case 'A' : case 'B' : case 'C' : normal += '2'; continue;
                    case 'D' : case 'E' : case 'F' : normal += '3'; continue;
                    case 'G' : case 'H' : case 'I' : normal += '4'; continue;
                    case 'J' : case 'K' : case 'L' : normal += '5'; continue;
                    case 'M' : case 'N' : case 'O' : normal += '6'; continue;
                    case 'P' : case 'Q' : case 'R' : case 'S' : normal += '7'; continue;
                    case 'T' : case 'U' : case 'V' : normal += '8'; break;
                    case 'W' : case 'X' : case 'Y' : case 'Z' : normal += '9'; continue;
                }
            }
        }

        return normal;
    }
}
