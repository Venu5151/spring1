package com.venu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.venu.entity.User;
import com.venu.repository.UserRepository;

@Service
@EnableJpaRepositories(basePackages = {"com.venu.repository"})
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUsers(){
		return (List<User>) userRepository.findAll();
	}
	
	public List<User> getAllUsers(){
		List<String[]> lst = userRepository.getUsers();
		List<User> users = new ArrayList<User>();
		lst.stream().forEach(user ->{
			User usr =new User();
			usr.setUserName(user[0].toString());
			usr.setLastName(user[1].toString());
			users.add(usr);
		});
		return users;
	}

}
