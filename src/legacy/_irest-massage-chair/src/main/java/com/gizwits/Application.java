package com.gizwits;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.gizwits.domain.Device;
import com.gizwits.domain.DeviceType;
import com.gizwits.domain.Member;
import com.gizwits.domain.User;
import com.gizwits.service.DeviceManagement;
import com.gizwits.service.DeviceTypeManagement;
import com.gizwits.service.MemberManagement;
import com.gizwits.service.UserManagement;

/**
 * @author Marvel
 * 
 * 项目启动程序
 */
@EnableJpaAuditing
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	private UserManagement userManagement;
	
	@Autowired
    private MemberManagement memberManagement;
	
	@Autowired
    private DeviceManagement deviceManagement;
	
	@Autowired
    private DeviceTypeManagement deviceTypeManagement;
	
	@PostConstruct
    public void init() {
	    User user = userManagement.findByPhoneNumber("10086");
	    if (user == null) {
	        user = userManagement.register("10086", "10086");
	    }
	    List<Member> members = memberManagement.findByUser(user);
	    if (members.isEmpty()) {
	        Member member = memberManagement.edit(user, null, "妈妈", "女", new Date(), "172", "56");
	        memberManagement.create(member);
	        
	        member = memberManagement.edit(user, null, "爸爸", "男", new Date(), "182", "75");
            memberManagement.create(member);
	    }
	    
	    initDeviceType();
	    initDevice();
	}
	
	private void initDeviceType() {
	    List<DeviceType> deviceTypes = deviceTypeManagement.findAll();
	    if (deviceTypes.isEmpty()) {
	        deviceTypeManagement.create("按摩椅");
	        deviceTypeManagement.create("体温计");
	        deviceTypeManagement.create("体重仪");
	    }
	}
	
	private void initDevice() {
	    String mac = "123.123.123.123";
	    String deviceTypeName = "按摩椅";
	    String phoneNumber = "10086";
        Device device = deviceManagement.findByMac(mac);
        if (device == null) {
            DeviceType deviceType = deviceTypeManagement.findByName(deviceTypeName);
            device = deviceManagement.create(mac, deviceType);
            User user = userManagement.findByPhoneNumber(phoneNumber);
            deviceManagement.createUserDevice("我的第一张按摩椅", user, device);
        }
    }
}
