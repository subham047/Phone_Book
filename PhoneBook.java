package creatingPhonebook;

import java.util.Scanner;

public class PhoneBook implements Comparable {
	private String name;
	private String gender;
	private long mob_no;
	private String email_id;
	private String group;
	public static int cp;
	public static int famp;
	public static int frndp;
	public static PhoneBook[] phoneBookArr = new PhoneBook[5];
	public static PhoneBook[] family = new PhoneBook[3];
	public static PhoneBook[] friends = new PhoneBook[3];

	public PhoneBook(String name, String gender, long mob, String group) {

		this.name = name;
		this.gender = gender;
		this.mob_no = mob;
		this.group=group;

	}

	public PhoneBook(String name, String gender, long mob, String group,String email) {

		this(name,gender,mob,group);
		this.email_id = email;

	}

	// Adding contact to phone book by checking validation
	public static boolean addContact() {
		Scanner t = new Scanner(System.in);

		if (cp <= phoneBookArr.length - 1) {
			System.out.println("Welcome to My Phonebook\n"+ "----------------------------");

			System.out.print("enter Phone Number: ");
			long mob = t.nextLong();
			if (!mob_no_Validation(mob)) {

				System.out.println("!!! Invalid number or number already exists !!! ");
				return false;

			} else {
				System.out.print("enter name: ");
				String n = t.next();
				if (!name_Validation(n)) {
					System.out.println("!!! Invalid name !!!");
					return false;
				} else {
					System.out.print("enter gender: (male/female)");
					String g = t.next();
					if (!gender_Validation(g)) {
						System.out.println("!!! Ivalid gender !!!");
						return false;
					} else {
						System.out.println("Do you want to register you email_id ? : yes/no");
						String response = t.next();

						if (response.equals("yes")) {
							System.out.print("enter Mail id : ");
							String mail = t.next();

							System.out.println("Do you want to add this contact in family or friends group?(yes/no)");

							String ch = t.next();

							switch (ch) {

							case "yes": {
								System.out.println("Which group you want to add?");
								System.out.println("1 : Family\n" + "2 : Friends");
								int gp = t.nextInt();
								if (gp == 1) {
									PhoneBook p = new PhoneBook(n, g, mob,"family", mail);
									family[famp++] = p;
									phoneBookArr[cp++] = p;
									System.out.println(" Contact registered in Family");

								} else if (gp == 2) {
									PhoneBook p = new PhoneBook(n, g, mob,"friend", mail);
									family[frndp++] = p;
									phoneBookArr[cp++] = p;
									System.out.println(" Contact registered in Friends");
								}
							}
								break;

							case "no":

							{
								PhoneBook p = new PhoneBook(n, g, mob, mail);
								phoneBookArr[cp++] = p;
								System.out.println(" Contact registered");
							}

								break;

							}

						} else {

							System.out.println("Do you want to add this contact in family or friends group?(yes/no)");

							String ch = t.next();

							switch (ch) {

							case "yes": {
								System.out.println("Which group you want to add?");
								System.out.println("1 : Family\n" + "2 : Friends");
								int gp = t.nextInt();
								if (gp == 1) {
									PhoneBook p = new PhoneBook(n, g, mob, "family");
									
									phoneBookArr[cp++] = p;
									System.out.println(" Contact registered in Family");

								} else if (gp == 2) {
									PhoneBook p = new PhoneBook(n, g, mob, "friend");
									
									phoneBookArr[cp++] = p;
									System.out.println(" Contact registered in Friends");
								}
							}
								break;

							case "no":

							{
								PhoneBook p = new PhoneBook(n, g, mob, "family");
								phoneBookArr[cp++] = p;
								System.out.println(" Contact registered");
							}
								break;
							}
						}
					}

				}

			}

			return true;
		} else
			return false;
	}
	
	
	// validation of mobile number length
	private static boolean mob_no_Validation(long n) {
		int len = 0;
		long temp = n;
		while (n != 0) {
			n /= 10;
			len++;
			
		}
		if (len == 10) {

			return unique_mob_num_validation(temp);
		} else
			return false;
	}

	// validation of unique mobile number
	private static boolean unique_mob_num_validation(long n) {
		if (cp > 0) {
			for (int i = 0; i < cp; i++) {
				if (n == phoneBookArr[i].mob_no) {
					return false;
				}
			}

		}
		return true;
	}

	// Name validation
	private static boolean name_Validation(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (((s.charAt(i) < 'z' && s.charAt(i) > 'a') || (s.charAt(i) < 'Z' && s.charAt(i) > 'A'))) {
				return true;
			}
		}
		return false;
	}

	// Gender validation
	private static boolean gender_Validation(String s) {
		if (s.equals("male") || s.equals("female")) {
			return true;
		}
		return false;
	}

	// Searching contact by name
	public static PhoneBook find() {
		Scanner t = new Scanner(System.in);
		System.out.println("Enter name you want to search");
		String nam = t.next();
		for (PhoneBook p : phoneBookArr) {
			if ((p.name).equals(nam)) {
				return p;
			}
		}
		return null;
	}
	
	public static  PhoneBook[] searchGroup(String gpname) {
		 PhoneBook[] phArr=new PhoneBook[5];
		
		for(int i=0;i<phoneBookArr.length;i++)
		{
			if((gpname).equals(phoneBookArr[i].group))
			{
				 phArr[i]=phoneBookArr[i];
				 
			}
		}
		return phArr;
		
		
		
	}
	
	// sorting array in alphabetical order
	public static void sort() {
		String temp;
		for (int i = 0; i < cp - 1; i++) {
			for (int j = i + 1; j < cp; j++) {
				if ((phoneBookArr[i].name).compareTo((phoneBookArr[j].name)) > 0) {
					temp = phoneBookArr[i].name;
					phoneBookArr[i].name = phoneBookArr[j].name;
					phoneBookArr[j].name = temp;
				}
			}

		}
	}

	// overriding toString
	@Override
	public String toString() {

		return "---------------------------------------\n" + "|| Name : " + this.name + "|| Gender : " + this.gender
				+ "\n---------------------------------\n|| Email: " + this.email_id + "|| Mobile  : " + this.mob_no
				+ "\n----------------------------------------------------";
	}

	// overriding compareTo()
	@Override
	public int compareTo(Object arg) {
		PhoneBook p = (PhoneBook) arg;
		return name.compareToIgnoreCase(p.name);
	}

}