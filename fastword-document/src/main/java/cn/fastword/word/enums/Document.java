package cn.fastword.word.enums;

public enum Document {

    WORD(1, "Word文档"),
    PDF(2, "Pdf文档");

    public int code;
    public String name;

    Document(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public Document setCode(int code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Document setName(String name) {
        this.name = name;
        return this;
    }
}
