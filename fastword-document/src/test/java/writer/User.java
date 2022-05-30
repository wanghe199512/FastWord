package writer;

import cn.fastword.annotation.FastWordTabled;

public class User {
    @FastWordTabled(title = "姓名", sort = 1)
    private String name;

    @FastWordTabled(title = "地址", sort = 4)
    private String address;

    @FastWordTabled(title = "年龄", sort = 6)
    private String age;

    @FastWordTabled(title = "手机号码", sort = 5)
    private String telPhone;

    @FastWordTabled(title = "大学名称", sort = 2)
    private String collage;

    public User(String name, String address, String age, String telPhone, String collage) {
        this.name = name;
        this.address = address;
        this.age = age;
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
