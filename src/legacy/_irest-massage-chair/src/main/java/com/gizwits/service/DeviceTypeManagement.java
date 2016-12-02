package com.gizwits.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gizwits.dao.DeviceTypeRepository;
import com.gizwits.domain.Device;
import com.gizwits.domain.DeviceType;

/**
 * @author Marvel
 * 
 * 设备类型
 */
@Service
public class DeviceTypeManagement {

    @Autowired
    private DeviceTypeRepository deviceTypeRepository;
    
    @Autowired
    private DeviceManagement deviceManagement;
    
    /**
     * 创建设备类型
     * @param name 唯一，不能为空白
     * @return 返回创建成功后的设备类型，创建失败或参数不符合条件则返回null
     */
    public DeviceType create(String name) {
        if (StringUtils.isBlank(name) || findByName(name) != null) {
            return null;
        }
        return deviceTypeRepository.save(new DeviceType(name));
    }
    
    /**
     * 更新设备类型
     * @param deviceType 必须存在于数据库
     * @param name 唯一，不能为空白
     * @return 返回更新成功后的设备类型，更新失败或参数不符合条件则返回null
     */
    public DeviceType update(DeviceType deviceType, String name) {
        if (!isExists(deviceType) || StringUtils.isBlank(name) || findByName(name) != null) {
            return null;
        }
        deviceType.setName(name);
        return deviceTypeRepository.save(deviceType);
    }
    
    /**
     * 删除设备类型，设备类型没有被任何设备引用才允许删除
     * @param deviceType 必须存在于数据库
     * @return 删除成功返回true，不符合条件则返回false
     */
    public Boolean delete(DeviceType deviceType) {
        if (!isExists(deviceType)) {
            return false;
        }
        List<Device> devices = deviceManagement.findByDeviceType(deviceType);
        if (devices != null && !devices.isEmpty()) {
            return false;
        }
        deviceTypeRepository.delete(deviceType);
        return true;
    }
    
    /**
     * 通过id找到设备类型
     * @param id 不能为null
     * @return 返回设备类型，找不到设备类型或参数不符合条件则返回null
     */
    public DeviceType findById(Long id) {
        if (id == null) {
            return null;
        }
        return deviceTypeRepository.findOne(id);
    }
    
    /**
     * 通过名称找到设备类型
     * @param name 不能为空白
     * @return 返回设备类型，找不到设备类型或参数不符合条件则返回null
     */
    public DeviceType findByName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        return deviceTypeRepository.findByName(name);
    }
    
    /**
     * 找到所有设备类型
     */
    public List<DeviceType> findAll() {
        return deviceTypeRepository.findAll();
    }
    
    /**
     * 检测id是否存在于数据库
     * @param id 不能为null
     * @return 存在于数据库返回true，不存在于数据库或参数不符合条件则返回false
     */
    public Boolean isExists(Long id) {
        if (id == null) {
            return false;
        }
        return deviceTypeRepository.exists(id);
    }
    
    /**
     * 检测设备类型是否存在于数据库
     * @param deviceType 不能为null
     * @return 存在于数据库返回true，不存在于数据库或参数不符合条件则返回false
     */
    public Boolean isExists(DeviceType deviceType) {
        if (deviceType == null) {
            return false;
        }
        return isExists(deviceType.getId());
    }
}
