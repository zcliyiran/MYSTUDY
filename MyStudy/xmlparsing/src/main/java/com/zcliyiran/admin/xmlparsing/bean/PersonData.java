package com.zcliyiran.admin.xmlparsing.bean;

/**
 * @author 甘罗
 * @date 2018/9/16.
 */
public class PersonData {


    private Integer id;
    private String name;
    private Short age;

    public PersonData() {
    }

    public PersonData(Integer id, String name, Short age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", id=" + id + ", name=" + name + "]";
    }


}
