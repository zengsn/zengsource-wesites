package com.gizwits.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gizwits.util.FormatDate;

/**
 * @author Marvel
 * 
 * 成员：一个用户账号里有多个成员
 */
@Entity
@Table(name = "Members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 昵称
    private String name;

    // 性别
    private String sex;

    // 出生日期
    @Temporal(TemporalType.DATE)
    private Date birthday;

    // 身高
    private String height;

    // 体重
    private String weight;

    // 头像
    // private String avatar;

    // 用户账号
    @JsonIgnore
    @ManyToOne
    private User user;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return FormatDate.dateToStr(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
