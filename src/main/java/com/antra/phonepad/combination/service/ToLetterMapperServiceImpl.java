package com.antra.phonepad.combination.service;
import com.antra.phonepad.combination.dao.ToLetterMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ToLetterMapperService")
public class ToLetterMapperServiceImpl implements ToLetterMapperService {
    @Autowired
    private ToLetterMapper toLetterMapper;


    @Override
    public List<String> ToLetterMapper(String num) {
        if (num.matches("[0-9]+")) {
            List<String> res = toLetterMapper.toLetterMapper(num);
            return res;
        } else {
            throw new ArithmeticException("Invalid telephone numbers. Must be all digits");
        }
    }

    @Override
    public String ToNumMapper(String num) {
        return toLetterMapper.toNumMapper(num);
    }
}

