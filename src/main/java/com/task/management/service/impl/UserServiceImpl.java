package com.task.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.management.config.security.AuthUser;
import com.task.management.model.Users;
import com.task.management.repository.UserRepository;
import com.task.management.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users createUser(Users user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
        }

    @Override
    public List<Users> getAllUser() {
       return userRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
    }

    @Override
    public Users updateUser(Long id, Users updateUser) {
        Users userById = getUserById(id);
        userById.setUsername(updateUser.getUsername());
        userById.setEmail(updateUser.getEmail());
        userById.setPassword(passwordEncoder.encode(updateUser.getPassword()));
        updateUser.setRole(updateUser.getRole());
        return userRepository.save(userById);
    }

    @Override
    public Users deleteUser(Long id) {
      Users userById = getUserById(id);
      userRepository.delete(userById);
      return userById;
    }
    @Override
	public Optional<AuthUser> findUserByUsername(String username) {
		Users user = userRepository.findUserByUsername(username)
			.orElseThrow(() -> new RuntimeException("Username Not Found"));
		
		AuthUser authUser = AuthUser.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.authorities(user.getRole().getAuthorities())
				.accountNonExpired(user.isAccountNonExpired())
				.accountNonLocked(user.isAccountNonLocked())
				.credentialsNonExpired(user.isCredentialsNonExpired())
				.enabled(user.isEnabled())
				.build();
		return Optional.ofNullable(authUser);
	}
    

  

    
}
