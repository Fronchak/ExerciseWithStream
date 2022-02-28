package model.service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import model.entities.Employee;

public class PrintService {

	public static void printEmployee(List<Employee> list, 
									 Predicate<Employee> predicate, 
									 Function<Employee, String> function, 
									 Comparator<Employee> comparator) {
		list.stream().filter(predicate).sorted(comparator).map(function).forEach(System.out::println);
	}
	
	public static void printStartWith(List<Employee> list,
			Predicate<Employee> predicate) {
		Double sum = list.stream().filter(predicate).mapToDouble(p -> p.getSalary()).sum();
		
		System.out.println("Sum : " + sum);
	}
	
}
