package com.gizwits.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.gizwits.util.FormatDate;

/**
 * @author Marvel
 * 
 * 用户成员的设备每天使用情况统计
 */
@Entity
@Table(name = "StatsDayMemberUseDevices")
public class StatsDayMemberUseDevice implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    // 日期，统计一天的使用情况，同一个成员该字段不能重复
    @Temporal(TemporalType.DATE)
    private Date date;
    
    // 用户成员，单向多对一
    @ManyToOne
    private Member member;
    
    // 用户绑定的设备，单向多对一
    @ManyToOne
    private Device device;
    
    // 最高频率模式，单位：Hz
//    private String maxFrequencyMode;
  
    // 总使用时长， 单位：分钟
    private String totalUseTime;
    
    public StatsDayMemberUseDevice() {
    }

    public StatsDayMemberUseDevice(Date date, Member member, Device device, String totalUseTime) {
        super();
        this.date = date;
        this.member = member;
        this.device = device;
        this.totalUseTime = totalUseTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        if (date == null) {
            return null;
        }
        return FormatDate.dateToStr(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getTotalUseTime() {
        return totalUseTime;
    }

    public void setTotalUseTime(String totalUseTime) {
        this.totalUseTime = totalUseTime;
    }
    
}
