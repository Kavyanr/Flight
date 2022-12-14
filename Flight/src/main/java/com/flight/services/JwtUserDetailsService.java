package com.flight.services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// find user from database where user = :username
		// userRepo.findByUsername(username);// username, password, roles
		
		//if ("admin".equals(username)) {
//			return new User("demo", "{noop}demo@123", new ArrayList<>());
//			return new User("demo", "{bcrypt}$2a$10$P/JrlUL1W0IQyjXaIBYvmu4OcjlpMbyeZS.VA5HmwYkkgdnvKGiKm", new ArrayList<>());
//			return new User("demo", "$2a$10$/KglearKkr45zuhlM98sVOhNYoa0Su8u3/1h0bw/yzgzVCkHldYBi", new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
		
		
		
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			if ("admin".equals(username)) {
				return new User("admin", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
						new ArrayList<>());
			} else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
		}
	}

