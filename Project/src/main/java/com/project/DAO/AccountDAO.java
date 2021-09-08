package com.project.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Entity.Account;

public interface AccountDAO extends JpaRepository<Account, String> {
	
	@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('DIRE','STAF')")
	List<Account> getAdministrators();
	
	@Query("SELECT a FROM Account a WHERE a.username LIKE ?1")
	List<Account> findByUsername(String username);

}
