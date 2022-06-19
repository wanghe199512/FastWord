package cn.fastword.word.docx;

import cn.fastword.word.AbstractIBasicDocument;
import cn.fastword.word.common.DefaultTableThemes;
import cn.hutool.poi.word.Word07Writer;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.math.BigInteger;
import java.util.List;

/**
 * 表格样式设置
 *
 * @author wanghe
 */
public abstract class AbstractWordFile07XWPFTable extends AbstractIBasicDocument {
    /**
     * word操作对象
     */
    protected final Word07Writer writer = new Word07Writer();

    public AbstractWordFile07XWPFTable() {
        super();
    }

    public AbstractWordFile07XWPFTable(DefaultTableThemes themes) {
        super(themes);
        this.addXWPFTableRowThemes();
    }
    public AbstractWordFile07XWPFTable(Class<?> beanCls) {
        super(beanCls);
        this.addXWPFTableRowThemes();
    }

    /**
     * 获取文档中所有表格
     *
     * @return List<XWPFTable>
     */
    public final List<XWPFTable> getXWPFTableList() {
        return this.writer.getDoc().getTables();
    }

    /**
     * 表格单元格样式居中
     *
     * @param XWPFTableCells XWPFTableCells
     */
    protected final void setXWPFTableCell(List<XWPFTableCell> XWPFTableCells) {
        for (int i = 0; i < XWPFTableCells.size(); i++) {
            if (this.themes.isShowZebra()) {
                this.setZebraLine(i, XWPFTableCells.get(i).getCTTc().addNewTcPr().addNewShd());
            }
            CTTc cttc = XWPFTableCells.get(i).getCTTc();
            this.setTableCellWidth(cttc).setTableCellValCenter(cttc);
            XWPFTableCells.get(i).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        }
    }

    /*
     * 表格斑马线
     *
     * @param index 下标
     * @param cell  XWPFTableCell
     */
    protected void setZebraLine(int index, CTShd ctShd) {
        ctShd.setColor("auto");
        ctShd.setVal(STShd.CLEAR);
        if (index % 2 == 0) {
            ctShd.setFill(this.themes.getZebraColor()[0]);
        } else {
            ctShd.setFill(this.themes.getZebraColor()[1]);
        }
    }

    /**
     * 表格单元格内容居中
     *
     * @param cttc CTTc
     * @return this
     */
    protected AbstractWordFile07XWPFTable setTableCellWidth(CTTc cttc) {
        cttc.addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);
        cttc.getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
        return this;
    }

    /**
     * 表格单元格宽度
     *
     * @param cttc CTTc
     */
    protected void setTableCellValCenter(CTTc cttc) {
        CTTblWidth ctTblWidth = cttc.addNewTcPr().addNewTcW();
        ctTblWidth.setType(this.themes.getCellWidth() == 0 ? STTblWidth.AUTO : STTblWidth.DXA);  // 设置指定宽度与自动宽度
        ctTblWidth.setW(BigInteger.valueOf(this.themes.getCellWidth() * 5));
    }

    /**
     * 表格单元格样式
     */
    protected final void addXWPFTableRowThemes() {
        XWPFTable table = this.getXWPFTableList().get(this.getXWPFTableList().size() - 1);
        List<XWPFTableRow> rows = this.getXWPFTableRowList(table);
        for (int row = 0; row < rows.size(); row++) {
            this.setXWPFTableCell(this.getXWPFTableCell(this.getXWPFTableRow(table, row)));
        }
        table.setTableAlignment(TableRowAlign.CENTER);
        table.setCellMargins(this.themes.getMargin()[0], this.themes.getMargin()[1], this.themes.getMargin()[2], this.themes.getMargin()[3]);
    }

    /**
     * 获取表格列
     *
     * @param row XWPFTableRow
     * @return List<XWPFTableCell>
     */
    public final List<XWPFTableCell> getXWPFTableCell(XWPFTableRow row) {
        return row.getTableCells();
    }

    /**
     * 使用下标获取单个表格行
     *
     * @param table XWPFTable
     * @param index 表格行下标
     * @return XWPFTableRow
     */
    public final XWPFTableRow getXWPFTableRow(XWPFTable table, int index) {
        return this.getXWPFTableRowList(table).get(index);
    }

    /**
     * 获取所有表格行
     *
     * @param table XWPFTable
     * @return List<XWPFTableRow>
     */
    public final List<XWPFTableRow> getXWPFTableRowList(XWPFTable table) {
        return table.getRows();
    }

}
