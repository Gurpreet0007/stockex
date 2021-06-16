package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Company;
import com.example.demo.entity.Ipo;
import com.example.demo.entity.StockExchange;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.IpoRepository;
import com.example.demo.repository.SectorRepository;
import com.example.demo.repository.StockExchangeRepository;
import com.example.demo.service.IpoService;

import dto.CompanyResponse;
import dto.Ipodto;

@RestController
public class IpoController {
	@Autowired
	CompanyRepository companyrepo;
	
	@Autowired
	StockExchangeRepository stockrepo;
	@Autowired
	IpoRepository iporepo;
	@Autowired
	IpoService iposervice;
	
	
	@Transactional
	@PostMapping("/updateipo")
	public void addupdateipo( @RequestBody Ipodto ipodto) {
	iposervice.updateipodetails(ipodto);
		}
	
@Transactional
@GetMapping("/displayCompanyIpo/{name}")
public Ipodto displayCompanyIpo(@PathVariable("name") String name)
{
	return iposervice.displayCompanyIpo(name);
}
@Transactional
@GetMapping("/displayUpcomingIpo")
public List<Ipodto> displayUpcomingIpo()
{
	return iposervice.displayUpcomingIpo();
}
}