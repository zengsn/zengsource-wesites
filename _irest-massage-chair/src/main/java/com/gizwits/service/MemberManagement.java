package com.gizwits.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gizwits.dao.MemberRepository;
import com.gizwits.domain.Member;
import com.gizwits.domain.User;

/**
 * @author Marvel
 */
@Service
public class MemberManagement {

    @Autowired
    private MemberRepository memberRepository;

    // 创建成员
    public Member create(Member member) {
        // 成员id必须为空
        if (member == null || member.getId() != null) {
            return null;
        }
        return memberRepository.save(member);
    }
    
    // 更新成员
    public Member update(Member member) {
        // 成员id不能为空
        if (member == null || member.getId() == null) {
            return null;
        }
        return memberRepository.save(member);
    }

    // 编辑用户成员
    public Member edit(User user, Member member, String name, String sex, Date birthday, String height, String weight) {
        // 用户不能为空
        if (user == null) {
            return null;
        }
        // 成员不存在则新建成员
        if (member == null) {
            member = new Member();
            member.setUser(user);
        }
        
        // 设置成员各项值
        // 名称不能为空
        if (name == null) {
            return null;
        }
        member.setName(name);
        if (sex != null) {
            member.setSex(sex);
        }
        if (birthday != null) {
            member.setBirthday(birthday);
        }
        if (height != null) {
            member.setHeight(height);
        }
        if (weight != null) {
            member.setWeight(weight);
        }
        return member;
    }

    // 删除用户
    public void delete(Member member) {
        memberRepository.delete(member);
    }

    public Member findById(Long id) {
        if (id == null) {
            return null;
        }
        return memberRepository.findOne(id);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public List<Member> findByUser(User user) {
        if (user == null) {
            return null;
        }
        return memberRepository.findByUser(user);
    }

//    public Boolean exists(Long id) {
//        if (id == null) {
//            return null;
//        }
//        return memberRepository.exists(id);
//    }

    // 判断成员是否属于用户
    public Boolean isBelongToUser(Member member, User user) {
        if (member.getUser().getId() != user.getId()) {
            return false;
        }
        return true;
    }
    
}
