package com.gizwits.web.v1;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gizwits.domain.DeviceType;
import com.gizwits.service.DeviceTypeManagement;
import com.gizwits.util.FormattedResult;
import com.gizwits.util.RetMsg;

/**
 * @author Marvel
 * 
 * 设备类型接口
 */
@RestController
@RequestMapping("/v1/deviceTypes")
public class DeviceTypeController {

    @Autowired
    private DeviceTypeManagement deviceTypeManagement;
    
    // 创建设备类型
    @RequestMapping(method = RequestMethod.POST)
    FormattedResult create(@RequestParam String name) {
        // 检验名称格式
        if (StringUtils.isBlank(name)) {
            return new FormattedResult(RetMsg.FAILURE_NAME_FORMAT);
        }
        // 查找是否重名
        if (deviceTypeManagement.findByName(name) != null) {
            return new FormattedResult(RetMsg.FAILURE_NAME_ALREADY_EXISTS);
        }
        DeviceType deviceType = deviceTypeManagement.create(name);
        if (deviceType == null) {
            return new FormattedResult(RetMsg.FAILURE_CREATED);
        }
        return new FormattedResult(deviceType, RetMsg.SUCCESS_CREATED);
    }
    
    // 获取所有设备类型
    @RequestMapping(method = RequestMethod.GET)
    FormattedResult listAll() {
        List<DeviceType> deviceTypes = deviceTypeManagement.findAll();
        if (deviceTypes.isEmpty()) {
            return new FormattedResult(deviceTypes, RetMsg.SUCCESS_NO_CONTENT);
        }
        return new FormattedResult(deviceTypes, RetMsg.SUCCESS);
    }
    
    // 修改设备类型
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    FormattedResult update(@PathVariable("id") Long id,
            @RequestParam String name) {
        DeviceType deviceType = deviceTypeManagement.findById(id);
        if (deviceType == null) {
            return new FormattedResult(RetMsg.FAILURE_DEVICETYPE_NOT_FOUND);
        }
        deviceType = deviceTypeManagement.update(deviceType, name);
        if (deviceType == null) {
            return new FormattedResult(RetMsg.FAILURE_UPDATED);
        }
        return new FormattedResult(deviceType, RetMsg.SUCCESS_UPDATED);
    }
    
    // 删除设备类型
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    FormattedResult delete(@PathVariable("id") Long id) {
        DeviceType deviceType = deviceTypeManagement.findById(id);
        if (deviceType == null) {
            return new FormattedResult(RetMsg.FAILURE_DEVICETYPE_NOT_FOUND);
        }
        if (!deviceTypeManagement.delete(deviceType)) {
            return new FormattedResult(RetMsg.FAILURE_DELETED);
        }
        return new FormattedResult(RetMsg.SUCCESS_DELETED);
    }
    
    // 获取设备类型
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    FormattedResult show(@PathVariable("id") Long id) {
        DeviceType deviceType = deviceTypeManagement.findById(id);
        if (deviceType == null) {
            return new FormattedResult(RetMsg.FAILURE_DEVICETYPE_NOT_FOUND);
        }
        return new FormattedResult(deviceType, RetMsg.SUCCESS);
    }
}
