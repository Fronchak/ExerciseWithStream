package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;

import model.entities.Employee;
import model.exception.DomainException;
import model.service.GenerateList;
import model.service.InstantiateEmployeeComma;
import model.service.PrintService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		GenerateList generateList = new GenerateList(new InstantiateEmployeeComma());
		
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {		
			String aux = br.readLine();
			Set<String> set = new HashSet<>();	
			
			while(aux != null) {
				set.add(aux);
				aux = br.readLine();
			}
			
			List<Employee> list = generateList.createList(set);

			System.out.print("Enter the minimum salary: ");
			Double minimum = sc.nextDouble();
			
			PrintService.printEmployee(list, 
					p -> p.getSalary() > minimum,
					p -> p.getEmail(),
					(p1, p2) -> p1.getEmail().toUpperCase().compareTo(p2.getEmail().toUpperCase()));
			
			System.out.println("Enter the first letter to filter data");
			char c = sc.next().charAt(0);
			PrintService.printStartWith(list, p -> p.getName().charAt(0) == c);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
		finally {
			sc.close();
		}
	}
	
}
