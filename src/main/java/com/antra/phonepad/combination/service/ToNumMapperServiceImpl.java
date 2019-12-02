package com.antra.phonepad.combination.service;
import com.antra.phonepad.combination.dao.ToNumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("ToNumMapperService")
public class ToNumMapperServiceImpl implements ToNumMapperService {
    @Autowired
    private ToNumMapper toNumMapper;

    @Override
    public String ToNumMapper(String num) {
        return toNumMapper.toNumMapper(num);
    }
}
