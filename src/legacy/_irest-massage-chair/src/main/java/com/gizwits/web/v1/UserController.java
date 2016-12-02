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
import com.gizwits.domain.Member;
import com.gizwits.domain.User;
import com.gizwits.service.DeviceManagement;
import com.gizwits.service.MemberManagement;
import com.gizwits.service.UserManagement;
import com.gizwits.util.FormatDate;
import com.gizwits.util.FormattedPage;
import com.gizwits.util.FormattedResult;
import com.gizwits.util.RetMsg;

/**
 * @author Marvel
 * 
 * 用户模块接口
 */
@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserManagement userManagement;
    
    @Autowired
    private MemberManagement memberManagement;
    
    @Autowired
    private DeviceManagement deviceManagement;
    
    // 用户登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    FormattedResult login(@RequestParam String phoneNumber,
            @RequestParam String password) {
        if (userManagement.findByPhoneNumber(phoneNumber) == null) {
            return new FormattedResult(RetMsg.FAILURE_PHONENUMBER_NOT_FOUND);
        }
        User user = userManagement.login(phoneNumber, password);
        if (user == null) {
            return new FormattedResult(RetMsg.FAILURE_INCORRECT_PASSWORD);
        }
        return new FormattedResult(user, RetMsg.SUCCESS_LOGIN);
    }
    
    // 用户注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    FormattedResult register(@RequestParam String phoneNumber, 
            @RequestParam String password,
            @RequestParam String code) {
        if (!userManagement.validateCode(code)) {
            return new FormattedResult(RetMsg.FAILURE_INCORRECT_CODE);
        }
        if (userManagement.findByPhoneNumber(phoneNumber) != null) {
            return new FormattedResult(RetMsg.FAILURE_PHONENUMBER_ALREADY_EXISTS);
        }
        User user = userManagement.register(phoneNumber, password);
        if (user == null) {
            return new FormattedResult(RetMsg.FAILURE_REGISTER);
        }
        return new FormattedResult(user, RetMsg.SUCCESS_REGISTER);
    }

//    @RequestMapping(value = "/users", method = RequestMethod.POST)
//    public ResponseEntity<User> create(@RequestBody User user) {
//        user = userManagement.create(user);
//        if (user == null) {
//            return new ResponseEntity<User>(HttpStatus.CONFLICT);
//        }
//        return new ResponseEntity<User>(user, HttpStatus.CREATED);
//    }
    
    // TODO 获取短信验证码
    @RequestMapping(value = "/validatedCode", method = RequestMethod.POST)
    FormattedResult validatedCode(@RequestParam String phoneNumber) {
        return new FormattedResult(RetMsg.SUCCESS);
    }
    
    // TODO 忘记用户密码
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
    FormattedResult forgetPassword(@RequestParam String phoneNumber) {
        return new FormattedResult(RetMsg.SUCCESS);
    }
    
    // TODO 修改用户密码
//    @RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
//    FormattedResult updatePassword(@RequestParam String phoneNumber,
//            @RequestParam String oldPassword,
//            @RequestParam String newPassword) {
//        User user = userManagement.findByPhoneNumber(phoneNumber);
//        if (user == null) {
//            return new FormattedResult(RetMsg.FAILURE_PHONENUMBER_NOT_FOUND);
//        }
//        if (oldPassword == null || !oldPassword.equals(user.getPassword())) {
//            return new FormattedResult(RetMsg.FAILURE_INCORRECT_PASSWORD);
//        }
//        user = userManagement.updatePassword(user, newPassword);
//        return new FormattedResult(user, RetMsg.SUCCESS_UPDATED_PASSWORD);
//    }
    
    // TODO 修改用户密码
    @RequestMapping(value = "/updatePassword", method = RequestMethod.PUT)
    FormattedResult updatePassword(@RequestParam String phoneNumber,
            @RequestParam String password,
            @RequestParam String code) {
        User user = userManagement.findByPhoneNumber(phoneNumber);
        if (user == null) {
            return new FormattedResult(RetMsg.FAILURE_PHONENUMBER_NOT_FOUND);
        }
        if (!userManagement.validateCode(code)) {
            return new FormattedResult(RetMsg.FAILURE_INCORRECT_CODE);
        }
        user = userManagement.updatePassword(user, password);
        return new FormattedResult(user, RetMsg.SUCCESS_UPDATED_PASSWORD);
    }
    
    // 获取用户列表
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    FormattedPage listAll(@RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer size) {
        Page<User> users = userManagement.findAll(page, size);
        if (users == null) {
            return new FormattedPage(page, size, RetMsg.FAILURE);
        }
        if (users.getNumberOfElements() == 0) {
            return new FormattedPage(users, RetMsg.SUCCESS_NO_CONTENT);
        }
        return new FormattedPage(users, RetMsg.SUCCESS);
    }
    
    // 获取用户信息
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    FormattedResult show(@PathVariable("id") Long id) {
        User user = userManagement.findById(id);
        if (user == null) {
            return new FormattedResult(RetMsg.FAILURE_USER_NOT_FOUND);
        }
        return new FormattedResult(user, RetMsg.SUCCESS);
    }
    
    // 修改用户基本信息
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    FormattedResult update(@PathVariable("id") Long id,
            @RequestParam(required = false) String name) {
        User user = userManagement.findById(id);
        if (user == null) {
            return new FormattedResult(RetMsg.FAILURE_USER_NOT_FOUND);
        }
        user = userManagement.update(user, name);
        if (user == null) {
            return new FormattedResult(RetMsg.FAILURE_UPDATED);
        }
        return new FormattedResult(user, RetMsg.SUCCESS_UPDATED);
    }
    
    // 删除用户
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    FormattedResult delete(@PathVariable("id") Long id) {
        if (userManagement.exists(id) != true) {
            return new FormattedResult(RetMsg.FAILURE_USER_NOT_FOUND);
        }
        userManagement.delete(id);
        return new FormattedResult(RetMsg.SUCCESS_DELETED);
    }
    
    // 查找用户绑定的所有设备
    @RequestMapping(value = "/users/{id}/devices", method = RequestMethod.GET)
    FormattedResult listAllDevices(@PathVariable("id") Long id) {
        User user = userManagement.findById(id);
        if (user == null) {
            return new FormattedResult(RetMsg.FAILURE_USER_NOT_FOUND);
        }
        List<Device> devices = deviceManagement.findByUser(user);
        if (devices.isEmpty()) {
            return new FormattedResult(devices, RetMsg.SUCCESS_NO_CONTENT);
        }
        return new FormattedResult(devices, RetMsg.SUCCESS);
    }
    
    // 成员 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    // 创建用户成员
    @RequestMapping(value = "/users/{id}/members", method = RequestMethod.POST)
    FormattedResult createMember(@PathVariable("id") Long userId,
            @RequestParam String name,
            @RequestParam(required = false) String sex,
            @RequestParam(value = "birthday", required = false) String strBirthday,
            @RequestParam(required = false) String height,
            @RequestParam(required = false) String weight) {
        User user = userManagement.findById(userId);
        if (user == null) {
            return new FormattedResult(RetMsg.FAILURE_USER_NOT_FOUND);
        }
        Date birthday = FormatDate.strToDate(strBirthday);
        Member member = memberManagement.edit(user, null, name, sex, birthday, height, weight);
        member = memberManagement.create(member);
        if (member == null) {
            return new FormattedResult(RetMsg.FAILURE_CREATED);
        }
        return new FormattedResult(member, RetMsg.SUCCESS_CREATED);
    }
    
    // 修改用户成员
    @RequestMapping(value = "/users/{id}/members/{memberId}", method = RequestMethod.PUT)
    FormattedResult updateMember(@PathVariable("id") Long userId,
            @PathVariable("memberId") Long memberId,
            @RequestParam String name,
            @RequestParam(required = false) String sex,
            @RequestParam(value = "birthday", required = false) String strBirthday,
            @RequestParam(required = false) String height,
            @RequestParam(required = false) String weight) {
        User user = userManagement.findById(userId);
        if (user == null) {
            return new FormattedResult(RetMsg.FAILURE_USER_NOT_FOUND);
        }
        Member member = memberManagement.findById(memberId);
        if (member == null) {
            return new FormattedResult(RetMsg.FAILURE_MEMBER_NOT_FOUND);
        }
        if (!isMemberBelongToUser(member, user)) {
            return new FormattedResult(RetMsg.FAILURE_MEMBER_NOT_BELONG_TO_USER);
        }
        Date birthday = FormatDate.strToDate(strBirthday);
        member = memberManagement.edit(user, member, name, sex, birthday, height, weight);
        member = memberManagement.update(member);
        if (member == null) {
            return new FormattedResult(RetMsg.FAILURE_UPDATED);
        }
        return new FormattedResult(member, RetMsg.SUCCESS_UPDATED);
    }
    
    // 删除用户成员
    @RequestMapping(value = "/users/{id}/members/{memberId}", method = RequestMethod.DELETE)
    FormattedResult deleteMember(@PathVariable("id") Long userId,
            @PathVariable("memberId") Long memberId) {
        User user = userManagement.findById(userId);
        if (user == null) {
            return new FormattedResult(RetMsg.FAILURE_USER_NOT_FOUND);
        }
        Member member = memberManagement.findById(memberId);
        if (member == null) {
            return new FormattedResult(RetMsg.FAILURE_MEMBER_NOT_FOUND);
        }
        if (!isMemberBelongToUser(member, user)) {
            return new FormattedResult(RetMsg.FAILURE_MEMBER_NOT_BELONG_TO_USER);
        }
        memberManagement.delete(member);
        return new FormattedResult(RetMsg.SUCCESS_DELETED);
    }
    
    // 获取用户成员
    @RequestMapping(value = "/users/{id}/members/{memberId}", method = RequestMethod.GET)
    FormattedResult showMember(@PathVariable("id") Long userId,
            @PathVariable("memberId") Long memberId) {
        User user = userManagement.findById(userId);
        if (user == null) {
            return new FormattedResult(RetMsg.FAILURE_USER_NOT_FOUND);
        }
        Member member = memberManagement.findById(memberId);
        if (member == null) {
            return new FormattedResult(RetMsg.FAILURE_MEMBER_NOT_FOUND);
        }
        if (!isMemberBelongToUser(member, user)) {
            return new FormattedResult(RetMsg.FAILURE_MEMBER_NOT_BELONG_TO_USER);
        }
        return new FormattedResult(member, RetMsg.SUCCESS);
    }
    
    // 获取用户成员列表
    @RequestMapping(value = "/users/{id}/members", method = RequestMethod.GET)
    FormattedResult listAllMembers(@PathVariable("id") Long userId) {
        User user = userManagement.findById(userId);
        if (user == null) {
            return new FormattedResult(RetMsg.FAILURE_USER_NOT_FOUND);
        }
        List<Member> members = memberManagement.findByUser(user);
        if(members.isEmpty()){
            return new FormattedResult(members, RetMsg.SUCCESS_NO_CONTENT);
        }
        return new FormattedResult(members, RetMsg.SUCCESS);
    }
    
    private Boolean isMemberBelongToUser(Member member, User user) {
        return memberManagement.isBelongToUser(member, user);
    }
}
