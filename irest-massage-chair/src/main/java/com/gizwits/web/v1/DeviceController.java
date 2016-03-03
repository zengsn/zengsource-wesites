package com.gizwits.web.v1;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gizwits.domain.Device;
import com.gizwits.domain.DeviceType;
import com.gizwits.domain.Member;
import com.gizwits.domain.StatsDayMemberUseDevice;
import com.gizwits.domain.User;
import com.gizwits.domain.UserDevice;
import com.gizwits.service.DeviceManagement;
import com.gizwits.service.DeviceTypeManagement;
import com.gizwits.service.MemberManagement;
import com.gizwits.service.UserManagement;
import com.gizwits.util.FormatDate;
import com.gizwits.util.FormattedPage;
import com.gizwits.util.FormattedResult;
import com.gizwits.util.RetMsg;

/**
 * @author Marvel
 * 
 * 设备模块接口
 */
@RestController
@RequestMapping("/v1/devices")
public class DeviceController {

    @Autowired
    private UserManagement userManagement;
    
    @Autowired
    private MemberManagement memberManagement;
    
    @Autowired
    private DeviceManagement deviceManagement;
    
    @Autowired
    private DeviceTypeManagement deviceTypeManagement;
    
    // 注册设备
    @RequestMapping(method = RequestMethod.POST)
    FormattedResult register(@RequestParam String mac,
            @RequestParam String type,
            @RequestParam String name,
            @RequestParam Long userId) {
        User user = userManagement.findById(userId);
        if (user == null) {
            return new FormattedResult(RetMsg.FAILURE_USER_NOT_FOUND);
        }
        DeviceType deviceType = deviceTypeManagement.findByName(type);
        if (deviceType == null) {
            return new FormattedResult(RetMsg.FAILURE_DEVICETYPE_NOT_FOUND);
        }
        Device device = deviceManagement.findByMac(mac);
        // 不存在设备则创建设备
        if (device == null) {
            device = deviceManagement.create(mac, deviceType);
            if (device == null) {
                return new FormattedResult(RetMsg.FAILURE_CREATED);
            }
        }
        UserDevice userDevice = deviceManagement.createUserDevice(name, user, device);
        if (userDevice == null) {
            return new FormattedResult(RetMsg.FAILURE_CREATED);
        }
        // TODO 注册设备成功后的返回结果需要讨论
        return new FormattedResult(device, RetMsg.SUCCESS_CREATED);
    }
    
    // 列出所有设备
    @RequestMapping(method = RequestMethod.GET)
    FormattedPage listAll(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size) {
        Page<Device> devices = deviceManagement.findAll(page, size);
        if (devices.getNumberOfElements() == 0) {
            return new FormattedPage(devices, RetMsg.SUCCESS_NO_CONTENT);
        }
        return new FormattedPage(devices, RetMsg.SUCCESS);
    }
    
    // 获取设备信息
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    FormattedResult show(@PathVariable("id") Long id) {
        Device device = deviceManagement.findById(id);
        if (device == null) {
            return new FormattedResult(RetMsg.FAILURE_DEVICE_NOT_FOUND);
        }
        return new FormattedResult(device, RetMsg.SUCCESS);
    }
    
    // 累计用户成员设备使用时间
    @RequestMapping(value = "/{id}/statsDayMemberUseTime", method = RequestMethod.POST)
    FormattedResult addStatsDayMemberUseTime(@PathVariable("id") Long id,
            @RequestParam(value = "date") String strDate,
            @RequestParam Long memberId,
            @RequestParam Integer useTime) {
        Device device = deviceManagement.findById(id);
        if (device == null) {
            return new FormattedResult(RetMsg.FAILURE_DEVICE_NOT_FOUND);
        }
        Member member = memberManagement.findById(memberId);
        if (member == null) {
            return new FormattedResult(RetMsg.FAILURE_MEMBER_NOT_FOUND);
        }
        UserDevice userDevice = deviceManagement.findUserDeviceByUserAndDevice(member.getUser(), device);
        if (userDevice == null) {
            return new FormattedResult(RetMsg.FAILURE_USER_DEVICE_NOT_FOUND);
        }
        Date date = FormatDate.strToDate(strDate);
        if (date == null) {
            return new FormattedResult(RetMsg.ERROR_DATE_FORMAT);
        }
        if (useTime < 0) {
            return new FormattedResult(RetMsg.ERROR_PARAM_FORMAT);
        }
        StatsDayMemberUseDevice stats = deviceManagement.AddStatsDayMemberUseTime(date, member, device, useTime);
        if (stats == null) {
            return new FormattedResult(RetMsg.FAILURE);
        }
        return new FormattedResult(stats, RetMsg.SUCCESS);
    }
    
    // 获取用户成员设备使用时间列表
    @RequestMapping(value = "/{id}/statsDayMemberUseTime", method = RequestMethod.GET)
    FormattedResult getStatsDayMemberUseTime(@PathVariable("id") Long id,
            @RequestParam(value = "date") String strDate,
            @RequestParam Long memberId,
            @RequestParam Integer beforeDay) {
        Device device = deviceManagement.findById(id);
        if (device == null) {
            return new FormattedResult(RetMsg.FAILURE_DEVICE_NOT_FOUND);
        }
        Member member = memberManagement.findById(memberId);
        if (member == null) {
            return new FormattedResult(RetMsg.FAILURE_MEMBER_NOT_FOUND);
        }
        UserDevice userDevice = deviceManagement.findUserDeviceByUserAndDevice(member.getUser(), device);
        if (userDevice == null) {
            return new FormattedResult(RetMsg.FAILURE_USER_DEVICE_NOT_FOUND);
        }
        Date date = FormatDate.strToDate(strDate);
        if (date == null) {
            return new FormattedResult(RetMsg.ERROR_DATE_FORMAT);
        }
        if (beforeDay < 0) {
            return new FormattedResult(RetMsg.ERROR_PARAM_FORMAT);
        }
        List<StatsDayMemberUseDevice> statsList = deviceManagement.getStatsDayMemberUseTime(date, member, device, beforeDay);
        if (statsList.isEmpty()) {
            return new FormattedResult(RetMsg.SUCCESS_NO_CONTENT);
        }
        return new FormattedResult(statsList, RetMsg.SUCCESS);
    }
}
