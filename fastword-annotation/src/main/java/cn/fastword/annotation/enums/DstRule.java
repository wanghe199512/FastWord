package cn.fastword.annotation.enums;

import cn.hutool.core.util.DesensitizedUtil;

/**
 * 数据脱敏枚举
 *
 * @author wanghe
 */
public enum DstRule implements IDstRuleInterface {

    NONE() {
        @Override
        public Object result(Object content) {
            return content;
        }
    },
    ID_CARD() {
        @Override
        public Object result(Object content) {
            return DesensitizedUtil.idCardNum((String) content, 3, 2);
        }
    },
    MOBILE_PHONE() {
        @Override
        public Object result(Object content) {
            return DesensitizedUtil.mobilePhone((String) content);
        }
    },
    ADDRESS() {
        @Override
        public Object result(Object content) {
            return DesensitizedUtil.address((String) content, 1);
        }
    },
    EMAIL() {
        @Override
        public Object result(Object content) {
            return DesensitizedUtil.email((String) content);
        }
    },
    PASSWORD() {
        @Override
        public Object result(Object content) {
            return DesensitizedUtil.password((String) content);
        }
    },
    CAR_CARD() {
        @Override
        public Object result(Object content) {
            return DesensitizedUtil.carLicense((String) content);
        }
    },
    BANK_CARD() {
        @Override
        public Object result(Object content) {
            return DesensitizedUtil.bankCard((String) content);
        }
    };

    DstRule() {
    }

}
