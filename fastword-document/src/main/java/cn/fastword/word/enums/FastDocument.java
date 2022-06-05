package cn.fastword.word.enums;

public enum FastDocument {

    WORD(1, "Word文档"),
    PDF(2, "Pdf文档");

    public int code;
    public String name;

    FastDocument(int code, String name) {
        this.code = code;
        this.name = name;
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

    public static String getDocumentPix(FastDocument document) {
        final String WORD_PIX = ".docx", PDF_PIX = ".pdf";
        switch (document) {
            case PDF:
                return PDF_PIX;
            case WORD:
                return WORD_PIX;
            default:
                return null;
        }
    }
}
