package com.example.beijing.domain;

import lombok.Data;

@Data
public class Param {

    private int id;

    private String paramKey;

    private String paramCn;

    private int itemId;

    private String itemValue;

    private int seqOrder;

    public Param(){}


}
