package cn.fastword.word.enums;

public enum FastDocument {

    WORD(1, "Word文档", ".docx"),
    PDF(2, "Pdf文档", ".pdf");

    public int code;
    public String name;
    public String suffix;

    FastDocument(int code, String name, String suffix) {
        this.code = code;
        this.name = name;
        this.suffix = suffix;
    }

    public int getCode() {
        return code;
    }

    public FastDocument setCode(int code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public FastDocument setName(String name) {
        this.name = name;
        return this;
    }

    public String getSuffix() {
        return suffix;
    }

    public FastDocument setSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    public static String getDocumentPix(FastDocument document) {
        return document.getSuffix();
    }
}
