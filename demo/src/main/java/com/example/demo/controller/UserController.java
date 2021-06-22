package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import dto.Perioddto;
import dto.StockPricedto;
import dto.Userdto;
@RestController
public class UserController {
	@Autowired
	UserRepository userrepo;
	@Autowired
	UserService userservice;
	@CrossOrigin(origins ="http://localhost:3000")
	@Transactional
	@PostMapping("/setuserapi2")
	public Userdto adduser(@RequestBody Userdto userdto)
	{System.out.print(userdto.getRole());
		userservice.addUser(userdto);
		return userdto;
	}	
}
