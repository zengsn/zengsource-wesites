package com.gizwits.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.gizwits.domain.Account;

/**
 * @author Marvel
 */
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

}
