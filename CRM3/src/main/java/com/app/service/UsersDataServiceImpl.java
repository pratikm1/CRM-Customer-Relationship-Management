package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.UsersDataRepository;
import com.app.pojos.UserData;

@Service
@Transactional
public class UsersDataServiceImpl implements IUsersDataService {

	@Autowired
	private UsersDataRepository userDataRepo;

	@Override
	public List<UserData> listAllUserDatas() {
		return userDataRepo.findAll();
	}

	@Override
	public UserData addUserData(UserData newUserData) {
		// TODO Auto-generated method stub
		return userDataRepo.save(newUserData);
	}

	@Override
	public String deleteUserData(int id) {
		// TODO Auto-generated method stub
		UserData u = userDataRepo.findByUserId(id);
		try {
			userDataRepo.delete(u);
		} catch (Exception e) {
			System.out.println("Error in deleting user " + e);
		}
		return "User details deleted Successfully";
	}
	@Override
	public UserData getUserData(String email, String password) {
		// TODO Auto-generated method stub
//		return Optional.ofNullable(repo.findByEmailAndPassword(em, pass));
		return userDataRepo.findByEmailAndPassword(email, password);
	}
	@Override
	public UserData updateUserData(UserData updatedUserData) {
		
		return userDataRepo.save(updatedUserData);
	}
	public UserData getUserDataById(int id) {
		
		return userDataRepo.findByUserId(id);
	}
	
	public int getNumberOfUsers() {
		// TODO Auto-generated method stub
		return userDataRepo.getNumberOfUsers();
	}
	
	public List<String> getPhoneNumberOfUsers() {
		return userDataRepo.getPhoneNumbersOfUsers();
	}
}
