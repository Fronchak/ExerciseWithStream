package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			
			String aux = br.readLine();
			
			while(aux != null) {
				System.out.println(aux);
				aux = br.readLine();
			}
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
