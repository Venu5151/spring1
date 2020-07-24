package com.venu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.venu.config.UserDataSourceConfiguration;
import com.venu.entity.User;
import com.venu.service.UserService;


@Component
public class UserMain {
	
	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(UserDataSourceConfiguration.class);
		 
		UserMain user  = ctx.getBean(UserMain.class);
		List<User> usrList = user.getUser();
		usrList.parallelStream().forEach(usr->{
			System.out.println(usr.getFirstName() + "     "+usr.getLastName()+"     "+usr.getUserName());
		});
		ctx.close();
		
	}
	
	List<User> getUser(){
		
		return userService.getAllUsers();
		
	}

}
