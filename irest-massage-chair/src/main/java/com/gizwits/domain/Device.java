package com.gizwits.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gizwits.util.FormatDate;

/**
 * @author Marvel
 * 
 * 设备
 */
@Entity
@Table(name = "Devices")
@EntityListeners(AuditingEntityListener.class)
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // 名称，用于显示字段，不用写入数据库
    private String name;
    
    // mac地址
    @Column(unique = true, nullable = false)
    private String mac;
    
    // 关联账号
//    @ManyToMany
//    private List<User> users;
    
    // 用户绑定的设备列表
    @JsonIgnore
    @OneToMany(mappedBy = "device")
    private List<UserDevice> userDevices;
    
    // 设备类型
    @ManyToOne
    private DeviceType type;
    
    // TODO 需要讨论，绑定状态
    // private String bindingStatus;
    
    // 创建时间
    @CreatedDate
    private Date createdDate;
    
    // 最后修改时间
    @LastModifiedDate
    private Date lastModifiedDate;
    
    public Device() {
    }

    public Device(String mac, DeviceType type) {
        super();
        this.mac = mac;
        this.type = type;
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

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public List<UserDevice> getUserDevices() {
        return userDevices;
    }

    public void setUserDevices(List<UserDevice> userDevices) {
        this.userDevices = userDevices;
    }

    public String getType() {
        if (type == null) {
            return null;
        }
        return type.getName();
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public String getCreatedDate() {
        return FormatDate.timestampToStr(createdDate);
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedDate() {
        return FormatDate.timestampToStr(lastModifiedDate);
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}
