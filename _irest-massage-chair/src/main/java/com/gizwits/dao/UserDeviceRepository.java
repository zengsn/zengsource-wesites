package com.gizwits.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gizwits.domain.Device;
import com.gizwits.domain.User;
import com.gizwits.domain.UserDevice;

/**
 * @author Marvel
 */
public interface UserDeviceRepository extends JpaRepository<UserDevice, Long> {

    List<UserDevice> findByUser(User user);
    
    List<UserDevice> findByDevice(Device device);
    
    UserDevice findByUserAndDevice(User user, Device device);
}
