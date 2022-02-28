package model.service;

import model.entities.Employee;

public class InstantiateEmployeeComma implements InstantiateEmployee {
	
	@Override
	public Employee createEmployee (String data) {
		String[] infos = data.split(",");
		return new Employee(infos[0], infos[1], salary(infos[2]));
		
	}

	private Double salary(String value) {
		return Double.parseDouble(value);
	}
}
