package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll() {
		
		return userRepository.findAll();
		
	}
	
	public User findById (Long id) {
		
		Optional<User> obj = userRepository.findById(id); // findById() Entidade real já carregada
		return obj.get();
		
	}
	
	public User insert(User obj) {
		
		return userRepository.save(obj);
		
	}
	
	
	public void delete(Long id) {
		
		userRepository.deleteById(id);
		
 }
	
	public User update(Long id,User obj) {
		User entity = userRepository.getReferenceById(id);// getReferenceById() Proxy (casca vazia com ID)
		updateData(entity,obj);
		
		return userRepository.save(entity);
		
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());;
		
	}
}

