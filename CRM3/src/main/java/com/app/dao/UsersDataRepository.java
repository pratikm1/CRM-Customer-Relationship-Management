package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.UserData;

public interface UsersDataRepository extends JpaRepository<UserData, Integer> {

	UserData findByUserId(Integer id);
	UserData findByEmailAndPassword(String email, String password);
	@Query(value = "SELECT COUNT(u) FROM UserData u where role='CUSTOMER'")
	int getNumberOfUsers();
	@Query(value = "SELECT u.phoneNumber from UserData u")
	List<String> getPhoneNumbersOfUsers();
}
