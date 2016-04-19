package com.gizwits.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gizwits.domain.DeviceType;

/**
 * @author Marvel
 */
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {

    DeviceType findByName(String name);
}
