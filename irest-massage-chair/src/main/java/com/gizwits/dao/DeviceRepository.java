package com.gizwits.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gizwits.domain.Device;

/**
 * @author Marvel
 */
public interface DeviceRepository extends JpaRepository<Device, Long> {

    Device findByMac(String mac);
    
    List<Device> findByTypeName(String name);
    
}
