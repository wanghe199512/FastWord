package cn.fastword.annotation.enums;

/**
 * 数据脱敏枚举
 *
 * @author wanghe
 */
public enum DesensitizedRule {
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

    DesensitizedRule(int code, String name) {
        this.code = code;
        this.name = name;
    }

/*
    public String aa(String data) {
        switch (data) {
            case none:
                return data;
            case address:
                return DesensitizedUtil.address(data, 1);
            case email:
                return DesensitizedUtil.email(data);
            case idCard:
                return DesensitizedUtil.idCardNum(data, 3, 2);
            case carCard:
                return DesensitizedUtil.carLicense(data);
            case password:
                return DesensitizedUtil.password(data);
            case bankCard:
                return DesensitizedUtil.bankCard(data);
            case mobilePhone:
                return DesensitizedUtil.mobilePhone(data);
            default:
                return null;
        }
    }*/

    public int getCode() {
        return code;
    }

    public DesensitizedRule setCode(int code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public DesensitizedRule setName(String name) {
        this.name = name;
        return this;
    }
}
