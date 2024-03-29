package com.fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.controller.dto.LoginDto;
import com.fr.adaming.converters.EmployeeConverter;
import com.fr.adaming.dto.RegisterDto;
import com.fr.adaming.entity.Employee;
import com.fr.adaming.service.EmployeeService;

@RestController
@RequestMapping(path = "api/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@RequestMapping(path = "/ajouter", method = RequestMethod.POST)
	public String ajouter(@RequestBody Employee employee) {
		if (service.ajouter(employee) != null) {
			return "Ajouter SUCCES";
		} else {
			return "Ajouter FAIL";
		}
	}

	@RequestMapping(path = "/modifier", method = RequestMethod.POST)
	public String modifier(@RequestBody Employee employee) {
		if (service.modifier(employee)) {
			return "Modifier SUCCES";
		} else {
			return "Modifier FAIL";
		}
	}

	@PostMapping(path="/supprimer")
	public boolean supprimer(@RequestBody Employee employee) {
		return service.supprimer(employee);
	}

	@RequestMapping(path="/vraimentsupprimer", method = RequestMethod.DELETE)
	public void vraimentSupprimer(@RequestBody Employee employee) {
		service.vraimentSupprimer(employee);
	}

	@PostMapping(path = "/restaurer")
	public void restaurer(@RequestBody Employee employee) {
		service.restaurer(employee);
	}

	@GetMapping(path = "/afficher")
	public List<Employee> afficher() {
		return service.afficher();
	}

	@GetMapping(path = "/affichertout")
	public List<Employee> afficherVraimentTout() {
		return service.afficherVraimentTout();
	}

	@GetMapping(path = "/{id}/chercherid")
	public Employee chercherParId(@PathVariable(name = "id") Integer id) {
		return service.chercherParId(id);
	}

	@GetMapping(path = "/{id}/cherchertoutid")
	public Employee chercherToutId(@PathVariable(name = "id") Integer id) {
		return service.chercherToutId(id);
	}

	@GetMapping(path = "/{nom}/cherchernom")
	public List<Employee> chercherParNom(@PathVariable(name = "nom") String nom) {
		return service.chercherParNom(nom);
	}

	@PostMapping(path = "/login")
	public String login(@RequestBody LoginDto dto) {
		System.out.println(dto.getEmail());
		if (service.login(dto.getEmail(), dto.getPwd()) != null) {
			return "SUCCES";
		} else {
			return "FAIL";
		}
	}
	
	@PostMapping(path = "/register")
	public String register(@RequestBody RegisterDto dto) {
		if (service.save(EmployeeConverter.convert(dto)) != null) {
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}
}
