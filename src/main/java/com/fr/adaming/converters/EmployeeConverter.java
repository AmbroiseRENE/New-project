package com.fr.adaming.converters;

import java.util.ArrayList;
import java.util.List;

import com.fr.adaming.dto.RegisterDto;
import com.fr.adaming.entity.Employee;

public class EmployeeConverter {
	public static Employee convert(RegisterDto dto) {
		Employee user = new Employee();
		user.setNom(dto.getNom());
		user.setEmail(dto.getEmail());
		user.setPwd(dto.getPwd());
		return user;
	}
	
	public static RegisterDto convert (Employee user) {
		RegisterDto dto = new RegisterDto();
		dto.setNom(user.getNom());
		dto.setEmail(user.getEmail());
		dto.setPwd(user.getPwd());
		return dto;
	}

	public static List<Employee> convertt(List<RegisterDto> dtos) {
		List<Employee> listEmployees = new ArrayList<>();
		for(RegisterDto dto : dtos) {
			listEmployees.add(EmployeeConverter.convert(dto));
		}
		return listEmployees;
	}

	public static List<RegisterDto> convert(List<Employee> users) {
		List<RegisterDto> listDtos = new ArrayList<>();
		for(Employee user : users) {
			listDtos.add(EmployeeConverter.convert(user));
		}
		return listDtos;
	}
}
