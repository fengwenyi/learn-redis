package com.fengwenyi.example.springbootredis.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Wenyi Feng
 * @since 2018-12-04
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -8579995238558768823L;
    private String name;
    private Integer age;
}
