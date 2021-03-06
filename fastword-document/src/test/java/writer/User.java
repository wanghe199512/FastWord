package writer;

import cn.fastword.annotation.FastWordTabled;
import cn.fastword.annotation.enums.DstRule;

public class User {
    @FastWordTabled(title = "姓名", sort = 1)
    private String name;

    @FastWordTabled(title = "地址", sort = 11)
    private String address;
    private String age;
    @FastWordTabled(title = "电话", sort = 5, dstRule = DstRule.MOBILE_PHONE)
    private String telPhone;
    @FastWordTabled(title = "编号", sort = 5)
    private Double number;

    @FastWordTabled(title = "大学名称", sort = 12)
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
