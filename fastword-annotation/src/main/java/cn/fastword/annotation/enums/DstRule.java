package cn.fastword.annotation.enums;

import cn.hutool.core.util.DesensitizedUtil;

/**
 * 数据脱敏枚举
 *
 * @author wanghe
 */
public enum DstRule {
    NONE(0, ""),
    ID_CARD(2, "身份证"),
    MOBILE_PHONE(3, "电话号码"),
    ADDRESS(4, "地址"),
    EMAIL(5, "邮箱"),
    PASSWORD(6, "密码"),
    CAR_CARD(7, "车牌号"),
    BANK_CARD(8, "银行卡");

    private int code;
    private String name;

    DstRule(int code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * @param content 脱敏文本
     * @return
     */
    public static Object dstRuleFormat(DstRule dstRule, Object content) {
        switch (dstRule) {
            case ADDRESS:
                return DesensitizedUtil.address((String) content, 1);
            case EMAIL:
                return DesensitizedUtil.email((String) content);
            case ID_CARD:
                return DesensitizedUtil.idCardNum((String) content, 3, 2);
            case CAR_CARD:
                return DesensitizedUtil.carLicense((String) content);
            case PASSWORD:
                return DesensitizedUtil.password((String) content);
            case BANK_CARD:
                return DesensitizedUtil.bankCard((String) content);
            case MOBILE_PHONE:
                return DesensitizedUtil.mobilePhone((String) content);
            default:
                return content;
        }
    }

    public int getCode() {
        return code;
    }

    public DstRule setCode(int code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public DstRule setName(String name) {
        this.name = name;
        return this;
    }
}
