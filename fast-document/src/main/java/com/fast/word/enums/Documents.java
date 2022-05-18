package com.fast.word.enums;

public enum Documents {

    WORD(1, "Word文档"),
    PDF(2, "Pdf文档");

    public int code;
    public String name;

    Documents(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public Documents setCode(int code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Documents setName(String name) {
        this.name = name;
        return this;
    }
}
