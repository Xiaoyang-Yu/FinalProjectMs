package com.management.sys.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class v_Recommend implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer uid;
    private Integer height;
    private Integer weight;
    private Integer bfp;
    private Integer bmi;
    private Integer age;
    private Integer sex;
    private String recipe;
    private Integer workType;
    private Integer isVegetarian;
    private Integer allergens;
    private Integer disease;
    private Integer goalType;
    private Integer score;
    private String username;
}
