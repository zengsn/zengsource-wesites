package com.gizwits.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.gizwits.dao.DeviceRepository;
import com.gizwits.dao.StatsDayMemberUseDeviceRepository;
import com.gizwits.dao.UserDeviceRepository;
import com.gizwits.domain.Device;
import com.gizwits.domain.DeviceType;
import com.gizwits.domain.Member;
import com.gizwits.domain.StatsDayMemberUseDevice;
import com.gizwits.domain.User;
import com.gizwits.domain.UserDevice;

/**
 * @author Marvel
 */
@Service
public class DeviceManagement {

    @Autowired
    private DeviceRepository deviceRepository;
    
    @Autowired
    private UserDeviceRepository userDeviceRepository;
    
    @Autowired
    private StatsDayMemberUseDeviceRepository statsDayMemberUseDeviceRepository;
    
    /**
     * 创建设备
     * @param mac 唯一，不能为空白
     * @param deviceType 不能为null
     * @return 返回创建成功后的设备，创建失败或参数不符合条件则返回null
     */
    public Device create(String mac, DeviceType deviceType) {
        if (StringUtils.isBlank(mac) || findByMac(mac) != null || deviceType == null) {
            return null;
        }
        return deviceRepository.save(new Device(mac, deviceType));
    }
    
    /**
     * 用户绑定设备，不能重复绑定
     * @param name 不能为空白
     * @param user 不能为null
     * @param device 不能为null
     * @return
     */
    public UserDevice createUserDevice(String name, User user, Device device) {
        if (StringUtils.isBlank(name) || user == null || device == null) {
            return null;
        }
        if (userDeviceRepository.findByUserAndDevice(user, device) != null) {
            return null;
        }
        return userDeviceRepository.save(new UserDevice(name, user, device));
    }
    
    /**
     * 更新设备
     * @param device 设备不能为null，设备id不能为null
     * @return 返回在数据库更新后的设备
     */
    public Device update(Device device) {
        if (device == null || device.getId() == null) {
            return null;
        }
        return deviceRepository.save(device);
    }
    
    public List<Device> findByDeviceType(DeviceType deviceType) {
        return deviceRepository.findByTypeName(deviceType.getName());
    }
    
    /**
     * 通过id找到设备
     * @param id 不能为null
     * @return 返回设备，找不到设备或参数不符合条件则返回null
     */
    public Device findById(Long id) {
        if (id == null) {
            return null;
        }
        return deviceRepository.findOne(id);
    }
    
    /**
     * 通过mac地址找到设备
     * @param mac 不能为空白
     * @return 返回设备，找不到设备或参数不符合条件则返回null
     */
    public Device findByMac(String mac) {
        if (StringUtils.isBlank(mac)) {
            return null;
        }
        return deviceRepository.findByMac(mac);
    }
    
    public Page<Device> findAll(Integer page, Integer size) {
        return deviceRepository.findAll(new PageRequest(page, size));
    }
    
    /**
     * 查找用户绑定的设备列表
     */
    public List<Device> findByUser(User user) {
        List<UserDevice> userDevices = userDeviceRepository.findByUser(user);
        List<Device> devices = new ArrayList<Device>();
        if (!userDevices.isEmpty()) {
            Device device = null;
            for (UserDevice userDevice : userDevices) {
                device = userDevice.getDevice();
                device.setName(userDevice.getName());
                devices.add(device);
            }
        }
        return devices;
    }
    
    /**
     * 查找用户绑定的设备
     */
    public UserDevice findUserDeviceByUserAndDevice(User user, Device device) {
        return userDeviceRepository.findByUserAndDevice(user, device);
    }
    
    /**
     * 累计用户成员设备使用时间
     * @param date 不能为null
     * @param member 不能为null
     * @param device 不能为null
     * @param useTime 不能为null
     * @return 用户成员设备的累计使用时间
     */
    public StatsDayMemberUseDevice AddStatsDayMemberUseTime(Date date, Member member, Device device, Integer useTime) {
        StatsDayMemberUseDevice stats = statsDayMemberUseDeviceRepository.findByDateAndMemberAndDevice(date, member, device);
        if (stats == null) {
            stats = new StatsDayMemberUseDevice(date, member, device, String.valueOf(useTime));
        } else {
            Integer totalUseTime = Integer.valueOf(stats.getTotalUseTime());
            totalUseTime += useTime;
            stats.setTotalUseTime(String.valueOf(totalUseTime));
        }
        return statsDayMemberUseDeviceRepository.save(stats);
    }
    
    /**
     * 获取用户成员设备使用时间列表
     * @param date 不能为null
     * @param member 不能为null
     * @param device 不能为null
     * @param beforeDay 大于等于0
     * @return 用户成员设备的使用时间列表
     */
    public List<StatsDayMemberUseDevice> getStatsDayMemberUseTime(Date date, Member member, Device device, Integer beforeDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        StatsDayMemberUseDevice stats = null;
        List<StatsDayMemberUseDevice> statsList = new ArrayList<StatsDayMemberUseDevice>();
        while (beforeDay >= 0) {
            stats = statsDayMemberUseDeviceRepository.findByDateAndMemberAndDevice(calendar.getTime(), member, device);
            if (stats != null) {
                statsList.add(stats);
            }
            // 前移一天
            calendar.add(Calendar.DATE, -1);
            beforeDay -= 1;
        }
        return statsList;
    }
    
    /**
     * 编辑设备信息
     * @param device 不能为null
     * @param name 可选
     * @param mac 不能为null
     */
//    public Device edit(Device device, String name, String mac) {
//        if (device == null) {
//            return null;
//        }
////        if (name != null) {
////            device.setName(name);
////        }
//        if (mac != null) {
//            device.setMac(mac);
//        }
//        
//        return device;
//    }
}
