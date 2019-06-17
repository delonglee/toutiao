package com.nowCoder.toutiao.moder;

import org.springframework.web.bind.annotation.Mapping;

@Mapping
public class News {

    private int userId;

    public int getUserId(){
        return userId;
    }
}
