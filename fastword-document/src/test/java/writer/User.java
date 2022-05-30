package writer;

import cn.fastword.annotation.FastWordTabled;

public class User {
    @FastWordTabled(title = "姓名", sort = 0)
    private String name;

    @FastWordTabled(title = "地址", sort = 0)
    private String address;

    private String age;

    private String telPhone;

    @FastWordTabled(title = "大学名称", sort = 0)
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
