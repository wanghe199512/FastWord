package cn.fastword.word.document;

public interface IFastParagraph {

    void addParagraphRows(String... text);

    <A, B> void addParagraphRows(A ParagraphAlignment, B defaultFont, String... texts);

    void addBlankRow();


}
