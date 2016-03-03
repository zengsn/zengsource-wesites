package com.gizwits.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gizwits.domain.Member;
import com.gizwits.domain.User;

/**
 * @author Marvel
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByUser(User user);
}
