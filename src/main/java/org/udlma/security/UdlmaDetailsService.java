package org.udlma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.udlma.persistence.MemberRepository;

import lombok.extern.java.Log;

@Service
@Log
public class UdlmaDetailsService implements UserDetailsService {

	@Autowired
	MemberRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return  
			repo.findById(username)
			.filter(m -> m != null)
			.map(m -> new UdlmaSecurityUser(m)).get();
		
	}

}
