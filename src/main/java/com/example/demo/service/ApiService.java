package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Child;
import com.example.demo.repository.ChildRepo;


@Service
public class ApiService {
	@Autowired
	ChildRepo r;
	public Child saveinfo(Child b)
	{
		return r.save(b);
	}
	public List<Child> savedetails(List<Child> b)
	{
		return (List<Child>) r.saveAll(b);
	}
	public List<Child> showinfo()
	{
		return r.findAll();
	}
	
	//get by id
	public Optional<Child> showbyid(int id)
	{
		return r.findById(id);
	}
	public Child changeinfo(Child b)
	{
		return r.saveAndFlush(b);
	}
	
	//put by id
	public String updateinfobyid(int id, Child b)
	{
		r.saveAndFlush(b);
		if(r.existsById(id))
		{
			return "Updated";
		}
		else
		{
			return "Enter valid id";
		}
	}
	//delete by id
	public void deleteid(int id)
	{
		r.deleteById(id);
	}
	public List<Child> sortinfo(String b)
	{
		return r.findAll(Sort.by(Sort.DEFAULT_DIRECTION, b));
	}
	public List<Child> getbypage(int pgno, int pgsize)
	{
		Page<Child> p=r.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();
	}
	//unh
	public List<Child> getbypage(int pgno, int pgsize,String s)
	{
		Page<Child> p=r.findAll(PageRequest.of(pgno, pgsize, (Sort.by(Sort.Direction.ASC))));
		return p.getContent();
	}
	
	
	
	
	//public List<Child> getDetails(int s, String b)
	//{
		//return r.getChildInfo(s, b);
	//}
	
	
}
