package writer;

import cn.fastword.annotation.FastWordColumn;
import cn.fastword.annotation.FastWordTabled;
import cn.fastword.annotation.enums.DstRule;
@FastWordTabled(rowHeight = 200,margin = {100,100,100,100},cellWidth = 300)
public class User {
    @FastWordColumn(title = "姓名", sort = 1)
    private String name;

    @FastWordColumn(title = "地址", sort = 11)
    private String address;
    private String age;
    @FastWordColumn(title = "电话", sort = 5, dstRule = DstRule.MOBILE_PHONE)
    private String telPhone;
    @FastWordColumn(title = "编号", sort = 5)
    private Double number;

    @FastWordColumn(title = "大学名称", sort = 12)
    private String collage;


    public User(String name, String address, String age, String telPhone, String collage,Double number) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.number = number;
        this.telPhone = telPhone;
        this.collage = collage;
    }

    public User(String name, String address, String telPhone, String collage) {
        this.name = name;
        this.address = address;
        this.telPhone = telPhone;
        this.collage = collage;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAge() {
        return age;
    }

    public User setAge(String age) {
        this.age = age;
        return this;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public User setTelPhone(String telPhone) {
        this.telPhone = telPhone;
        return this;
    }
}
