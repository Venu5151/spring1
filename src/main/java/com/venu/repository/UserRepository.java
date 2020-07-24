package com.venu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.venu.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

	@Query(value="SELECT FIRSTNAME, USERNAME FROM USER", nativeQuery=true)
	 public List<String[]> getUsers();
}
