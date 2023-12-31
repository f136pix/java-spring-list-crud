package com.f136px.toDoList.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public String getLoggedUsername() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();

	}
}
