package com.example.Webflux;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author elviswang
 * @date 2017/10/18
 * @time 17:20
 * Desc TODO
 */
public class Person {
    private final String name;

    private final int age;

    public Person(@JsonProperty("name") String name, @JsonProperty("age") int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
