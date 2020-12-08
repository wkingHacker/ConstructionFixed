package com.hunau.bean;

/**
 * @author Wking
 * @create 2020-12-05 15:46
 */
public class Token {
    String name;
    String value;

    public Token() {
    }

    public Token(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
