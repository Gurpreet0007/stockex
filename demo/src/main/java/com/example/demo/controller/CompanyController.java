package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Company;
import com.example.demo.entity.Ipo;
import com.example.demo.entity.StockExchange;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.IpoRepository;
import com.example.demo.repository.StockExchangeRepository;

import dto.Companydto;

@RestController
public class CompanyController {
	@Autowired
	CompanyRepository companyrepo;
	
	@Autowired
	StockExchangeRepository stockrepo;
	@Autowired
	IpoRepository iporepo;
	
	
	@Transactional
	@PostMapping("/addcompany")
	public void addcompany( @RequestBody Companydto companydto) {
		Company company=new Company();
		company.setName(companydto.getName());
		company.setTurnover(companydto.getTurnover());
		company.setDirectors(companydto.getDirectors());
		company.setWriteup(companydto.getWriteup());
		
	Ipo ipo=new Ipo();
	ipo.setDate(companydto.getIpodate());
	ipo.setNumber(companydto.getNo());
		
	ipo.setTime(companydto.getTime());
	ipo.setPrice(companydto.getPrice());
	
	
	for(String se: companydto.getstockexchange())
	{
		StockExchange stockex=stockrepo.findBystockExchange(se);
stockex.addIpo(ipo)	;
ipo.addStockExchange(stockex);
company.addStockexchanges(stockex);
stockex.addcompany(company);
	
	}
	company.setipo(ipo);
	ipo.setcompany(company);
	companyrepo.save(company);
	iporepo.save(ipo);
	
	
	}
}
