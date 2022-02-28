package model.service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import model.entities.Employee;
import model.exception.DomainException;

public class GenerateList {

	InstantiateEmployee instantiateEmployee;
	
	public GenerateList(InstantiateEmployee instantiateEmployee) {
		this.instantiateEmployee = instantiateEmployee;
	}
	
	public List<Employee> createList(Set<String> set) {	
		if(set.isEmpty()) {
			throw new DomainException("List cannot be empty!");
		}
		return set.stream().map(instantiateEmployee::createEmployee).collect(Collectors.toList());
	}	
}
