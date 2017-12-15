package com.pc.myapp.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by pc on 2017/12/15.
 */

@Entity
public class Person {
    private String img;
    private String name;
    @Generated(hash = 2053737966)
    public Person(String img, String name) {
        this.img = img;
        this.name = name;
    }
    @Generated(hash = 1024547259)
    public Person() {
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
