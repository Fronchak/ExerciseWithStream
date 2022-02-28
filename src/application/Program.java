package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import model.entities.Employee;
import model.exception.DomainException;
import model.service.GenerateList;
import model.service.InstantiateEmployeeComma;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		GenerateList generateList = new GenerateList(new InstantiateEmployeeComma());
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {		
			String aux = br.readLine();
			Set<String> set = new HashSet<>();	
			while(aux != null) {
				set.add(aux);
				aux = br.readLine();
			}
			List<Employee> list = generateList.createList(set);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(DomainException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
