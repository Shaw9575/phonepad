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
        List<String> res = toLetterMapper.toLetterMapper(num);
        return res;
    }
}

