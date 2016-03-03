package com.gizwits.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Marvel
 * 
 * 用户绑定的设备，用户与设备多对多关系
 */
@Entity
@Table(name = "UserDevices")
public class UserDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // 用户设定的设备名
    @Column(nullable = false)
    private String name;
    
    // 用户
    @ManyToOne(optional = false)
    private User user;
    
    // 设备
    @ManyToOne(optional = false)
    private Device device;
    
    public UserDevice() {
    }

    public UserDevice(String name, User user, Device device) {
        super();
        this.name = name;
        this.user = user;
        this.device = device;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
    
}
