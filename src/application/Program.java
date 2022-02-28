package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import model.service.InstantiateEmployee;
import model.service.InstantiateEmployeeComma;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		InstantiateEmployee instantiate = new InstantiateEmployeeComma();
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			
			String aux = br.readLine();
			Set<String> set = new HashSet<>();
			
			while(aux != null) {
				//System.out.println(aux);
				set.add(aux);
				System.out.println(instantiate.createEmployee(aux));
				aux = br.readLine();
			}
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
