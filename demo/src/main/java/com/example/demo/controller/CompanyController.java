package com.example.demo.controller;

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
import com.example.demo.entity.Sector;
import com.example.demo.entity.StockExchange;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.IpoRepository;
import com.example.demo.repository.SectorRepository;
import com.example.demo.repository.StockExchangeRepository;
import com.example.demo.service.CompanyService;

import dto.CompanyResponse;
import dto.Companydto;
import dto.Companyupdatedto;
import dto.Perioddto;
import dto.StockPricedto;

@RestController
public class CompanyController {
	@Autowired
	CompanyRepository companyrepo;
	
	@Autowired
	StockExchangeRepository stockrepo;
	@Autowired
	IpoRepository iporepo;
	@Autowired 
	SectorRepository sectorrepo;
	@Autowired
	CompanyService companyservice;
	@Transactional
	@PostMapping("/addcompany")
	public void addcompany( @RequestBody Companydto companydto) {
		companyservice.addCompany(companydto);
		}
	@Transactional
	@PostMapping("/updatebasiccompany")
	public void updatecompany( @RequestBody Companyupdatedto companyupdto) {
	
		companyservice.updateBsicCompany(companyupdto);
	}
	@Transactional
	@GetMapping("/displayallcompany")
	public List<CompanyResponse> displayallcompany()
	{
		return companyservice.displayallCompanies();
	}
	
	@Transactional
	@GetMapping("/displayCompany/{name}")
	public  CompanyResponse displayCompany(@PathVariable("name") String name)
	{
		return companyservice.displayCompany(name);
	}
	@Transactional
	@GetMapping("/displayMatchingcompany/{name}")
	public List<String> displayMatchingcompany(@PathVariable("name") String name)
	{
		return companyservice.displayMatchingCompanies(name);
	}	
	@Transactional
	@PostMapping("/displayStockPrice")
	public List<StockPricedto> displayStockPrice(@RequestBody Perioddto perioddto)
	{
		return companyservice.displaystockprice(perioddto.getName(),perioddto.getSd(),perioddto.getSt(),
				perioddto.getEd(),perioddto.getEt());
	}	
}
