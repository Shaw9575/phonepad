package com.antra.phonepad.combination.service;
import java.util.List;

public interface ToLetterMapperService {
    List<String> ToLetterMapper(String num);

    String ToNumMapper (String num);
}
