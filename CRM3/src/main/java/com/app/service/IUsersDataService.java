package com.app.service;

import java.util.List;

import com.app.pojos.UserData;

public interface IUsersDataService {

	List<UserData> listAllUserDatas();
	UserData addUserData(UserData newUserData);
	String deleteUserData(int userId);
	UserData getUserData(String em, String pass);
	UserData updateUserData(UserData updatedUserData);
	UserData getUserDataById(int id);
	int getNumberOfUsers();
	
}
