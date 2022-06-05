package cn.fastword.word.enums;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 文件归档规则(日，天，周，年)
 *
 * @author wanghe
 */
public enum FastArchive implements IFastArchiveInterfaces {
    DAY() {
        @Override
        public String archive() {
            return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }
    },
    WEEK() {
        @Override
        public String archive() {
            return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM-dd"));
        }
    },
    MONTH() {
        @Override
        public String archive() {
            return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM"));
        }
    },
    YEAR() {
        @Override
        public String archive() {
            return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy"));
        }
    },

}

