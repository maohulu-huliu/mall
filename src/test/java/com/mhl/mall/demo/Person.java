package com.mhl.mall.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huLiu
 * @date 2021/11/17 17:14
 */
@Data
public class Person {
    /**
     * 层级 1，2，3，4，5
     */
    private String id;

    /**
     * 层级名字
     */
    private String Name;

    /**
     * 父级
     */
    private String pid;

    /**
     * 下属
     */
    private List<Person> childList = new ArrayList<>();

    public Person(String id, String pid, String name) {
        this.id = id;
        this.pid = pid;
        Name = name;
    }
}
