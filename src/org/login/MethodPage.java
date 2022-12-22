package org.login;

import java.util.Map.Entry;


import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public abstract class MethodPage implements CheckExistingUser,NewUserCreation{
	
	static int count = 1;
	static int j = 0;
	int i=1;
	int value = 1;
	
	TreeMap<String,Details> map = new TreeMap<>();
	TreeSet<String> mail = new TreeSet<>();
	TreeSet<String> password = new TreeSet<>();
	TreeSet<String> name = new TreeSet<>();
	
	Details[] d = null;
	Scanner s = new Scanner(System.in);
		
	@Override
	public TreeMap<String, Details> addNewUser() {
		while(i == 1) {
			while ( j >= 0 ) {
				if( j == count) {
					count++;
					break;
				}
				else {
					d = new Details[j+1];
					d[j] = new Details();
					System.out.print("Enter name: ");
					d[j].setName(s.nextLine());
					name.add(d[j].getName());
					while (true) {
						System.out.print("Enter emailId: ");
						d[j].setEmail(s.nextLine());
						if(!map.isEmpty() && !mail.isEmpty() && mail.contains(d[j].getEmail())) {
							System.out.println();
							System.out.println("Please add unique emailid...");
							continue;
						}
						else {
							mail.add(d[j].getEmail());
							break;
						}		
					}
					while(true) {
						System.out.print("Enter password: ");
						d[j].setPassword(s.next());
						if(!map.isEmpty() && !password.isEmpty() && password.contains(d[j].getPassword())) {
							System.out.println();
							System.out.println("Please add unique password...");
							continue;
						}
						else {
							password.add(d[j].getPassword());
							break;
						}
					}
					map.put(d[j].getEmail(),d[j]);
					System.out.println();
					System.out.println();
					System.out.println("New userid has been created for you....");
					System.out.println();
					System.out.println();
					//System.out.println("Created one object");
					j++;
				}
			}
			System.out.print("Enter 1 to continue to create new user or 0 to exit: ");
			i = s.nextInt();
			s.nextLine();
		}	
		return map;
	}
	
	public void displayDetails(TreeMap<String,Details> m) {
		Set<Entry<String,Details>> set = m.entrySet();
		for(Entry<String,Details> e : set) {
			System.out.println(e.getKey());
		}
	}
	
	public void checkUserInput(TreeMap<String,Details> m) {
		int count = 0;
		while(value == 1) {
			System.out.print("Enter name: ");
			String user = s.nextLine();
			System.out.print("Enter password: ");
			String pwd = s.next();
			System.out.println();
			System.out.println();
			try {
				
					Set<Entry<String,Details>> set = m.entrySet();
					for(Entry<String,Details> e : set) {
						//System.out.println(m.get(e.getKey()).getName());
						//System.out.println(m.get(e.getKey()).getPassword());
						if(m.get(e.getKey()).getName().equals(user) && m.get(e.getKey()).getPassword().equals(pwd)) {
							System.out.println("The user exits and logging in....");
							count++;
							break;
						}
						else if(name.contains(user) && m.get(e.getKey()).getName().equals(user) && !m.get(e.getKey()).getPassword().equals(pwd) && !password.contains(pwd)) {
							System.out.println("Incorrect password...Please enter crt password..");
							count++;
							break;
						}
						else if(password.contains(pwd) && m.get(e.getKey()).getPassword().equals(pwd) && !m.get(e.getKey()).getName().equals(user) && !name.contains(user)) {
							System.out.println("Incorrect Name..Please enter valid name...");
							count++;
							break;
						}
						else if(name.contains(user) && password.contains(pwd) && (m.get(e.getKey()).getName().equals(user) || m.get(e.getKey()).getPassword().equals(pwd))) {
							System.out.println("Invalid username and password...Please check both username and password matches...");
							count++;
							break;
						}
					}
					if(count == 0) {
						System.out.println("The user does not exits...");
					}
				}
			catch(Exception e) {
				System.out.println("There are no data entered in..empty...Please exit from this program.");
			}
			System.out.println();
			count = 0;
			System.out.print("Enter 1 to continue or 0 to return to main menu: ");
			value = s.nextInt();
			s.nextLine();
		}
	}
}
