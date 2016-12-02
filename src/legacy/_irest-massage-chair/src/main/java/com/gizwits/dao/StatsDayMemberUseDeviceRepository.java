package com.gizwits.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gizwits.domain.Device;
import com.gizwits.domain.Member;
import com.gizwits.domain.StatsDayMemberUseDevice;

/**
 * @author Marvel
 */
public interface StatsDayMemberUseDeviceRepository extends JpaRepository<StatsDayMemberUseDevice, Long> {

    StatsDayMemberUseDevice findByDateAndMemberAndDevice(Date date, Member member, Device device);
}
