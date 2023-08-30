package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Child;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
	@Autowired
	ApiService apser;
	@PostMapping("post")
	public Child adding(@RequestBody Child b)
	{
		return apser.saveinfo(b);
	}
	@GetMapping("get")
	public List<Child> showing()
	{
		return apser.showinfo();
	}
	
	//show by id
	@GetMapping("getbyid/{id}")
	public Optional<Child> showid(@PathVariable int id)
	{
		return apser.showbyid(id);
	}
	@PutMapping("put")
	public Child modify(@RequestBody Child b)
	{
		return apser.changeinfo(b);
	}
	
	//put by id
	@PutMapping("putbyid/{id}")
	public String modifybyid(@PathVariable int id, @RequestBody Child b)
	{
		return apser.updateinfobyid(id, b);
	}
	
	@DeleteMapping("delid/{id}")
	public void deletemyid(@PathVariable int id)
	{
		apser.deleteid(id);
	}
	
	//Sorting
	@GetMapping("sort/{name}")
	public List<Child> getsortinfo(@PathVariable String name)
	{
		return apser.sortinfo(name);
	}
	
	@GetMapping("paging/{pageno}/{pagesize}")
	public List<Child> showpageinfo(@PathVariable int pageno, @PathVariable int pagesize)
	{
		return apser.getbypage(pageno, pagesize);
	}
	@GetMapping("paging2/{pageno}/{pagesize}/{name}")
	public List<Child> showpageinfo(@PathVariable int pageno, @PathVariable int pagesize, @PathVariable String name)
	{
		return apser.getbypage(pageno, pagesize, name);
	}
	
}
