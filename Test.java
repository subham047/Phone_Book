package creatingPhonebook;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
	static int count;

	

	public static void main(String[] args) {
			// TODO Auto-generated method stub
		int choice;
			
		do{
				Scanner t=new Scanner(System.in);
				System.out.println("Enter the options :  ");
				System.out.println("1: Add contact\n"
						+ "2: View contacts \n"
						+ "3: Search contact \n"
						+ "4: search group\n"
						+ "7: Exit \n"
						+ "------------------------------------------");
				choice=t.nextInt();
				switch(choice) {
					case 1:
					{
						if (PhoneBook.addContact()) 
						{
							System.out.println("contact registered\n"
									+ "---------------------------------------------");
						}
						else 
						{
							System.out.println("Only 5 contacts can be saved...\n"
									+ "enter again....");
						}
						
					}break;
					
					case 2:
					{
						PhoneBook.sort();
						for(int i=0;i<PhoneBook.cp;i++) 
						{
							System.out.println(PhoneBook.phoneBookArr[i]);
						}
						
					}break;
					
					case 3:
					{
						PhoneBook p1=PhoneBook.find();
						System.out.println(p1);
					}
					case 4:
						PhoneBook[] p2=PhoneBook.searchGroup("family");
						System.out.println(p2);
					
				}
		}
		while(choice!=9);
		PhoneBook.searchGroup("family");
		
	}
}



