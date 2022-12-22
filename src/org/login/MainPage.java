package org.login;

import java.util.Scanner;
import java.util.TreeMap;

public class MainPage extends MethodPage {
	 int i;
	
	 static TreeMap<String, Details> value;
		
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		MainPage m = new MainPage();
		do {
			System.out.print("Enter 1 for New User Creation and 0 for existing user and greater than 1 for exit: ");
			m.i = s.nextInt();
			if(m.i == 1) {
			    value = m.addNewUser();
			    //m.displayDetails(value);
			}
			else if(m.i == 0) {
				m.checkUserInput(value);	
			}
		} while (m.i == 1 || m.i == 0);
			
		
		
	}

}
