package com.antra.phonepad.combination.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.antra.phonepad.combination.service.ToLetterMapperService;

@RestController
@RequestMapping()
public class CombinationController {

    @Autowired
    ToLetterMapperService toLetterMapperService;

    @RequestMapping(value = "/toNumbers/{num}", method = RequestMethod.GET)
    public String toNumbers(@PathVariable("num") String num) {
       if (num.length() != 10) {
            throw new ArithmeticException("Invalid telephone numbers. Must be 10 digits");
       } else {
            num = num.toUpperCase();
            return toLetterMapperService.ToNumMapper(num);
       }
    }

    @RequestMapping(value = "/toLetters/{num}", method = RequestMethod.GET)
    public List<String> toLetters(@PathVariable("num") String num) {
        if (num.length() != 10) {
            throw new ArithmeticException("Invalid telephone numbers. Must be 10 digits");
        } else {
            num = num.toUpperCase();
            return toLetterMapperService.ToLetterMapper(num);
        }
    }
}
