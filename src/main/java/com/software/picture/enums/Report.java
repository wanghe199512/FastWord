package com.software.picture.enums;

public enum Report {
    基础日报(1, "基础日报"),
    基础周报(2, "基础周报"),
    基础月报(3, "基础月报"),
    基础年报(4, "基础年报");

    public int code;
    public String name;

    Report(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public Report setCode(int code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Report setName(String name) {
        this.name = name;
        return this;
    }
}
