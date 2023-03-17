import java.util.*;
import java.text.NumberFormat;





 class Employe extends Person {
	String emp_id;
	int sal_per_day; //salary per day
	int sal; //total salary
	int days;
	Employe(String n,int a,String e,int spd,int d){
		super(n,a);
		emp_id=e;
		sal_per_day=spd;
		//sal=s;
		days=d;	
	}
}




class Hod extends Teacher implements salaryFinder {
	int teachers;
	int guide;
	Hod(String n,int a,String e,int spd,int d,String b,String spl,int teach,int guid){
		super(n,a,e,spd,d,b,spl);
		teachers=teach;
		guid=guide;
	}
	public int findSalary() {
		sal=sal_per_day*days;
		return sal;
	}
	public static final String[] units = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

	public static final String[] tens = { 
			"", 	
			"",		
			"Twenty", 	
			"Thirty", 	
			"Forty", 	
			"Fifty", 	
			"Sixty", 	
			"Seventy",	
			"Eighty", 	
			"Ninety" 	
	};
	public String convert( int n) {
		
		if (n < 20) {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		
		return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		

		//return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}
}





class Person {
	String name;
	int age;
	Person(String n,int a){
		name=n;
		age=a;
	}
}
	



 interface salaryFinder {
public int findSalary() ;
}




class Security extends Employe implements salaryFinder{
	public enum shift{Day,Night};
	shift st;
	Security(String n,int a,String e,int spd,int d,String sft){
		super(n,a,e,spd,d);
		if((shift.Day).equals(sft)) {
			st=shift.Day;
			
		}
		if((shift.Night).equals(sft)) {
			st=shift.Night;
		}
		
	}
	public int findSalary() {
		sal=sal_per_day*days;
		return sal;
	}
	public static final String[] units = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };

	public static final String[] tens = { 
			"", 	
			"",		
			"Twenty", 	
			"Thirty", 	
			"Forty", 	
			"Fifty", 	
			"Sixty", 	
			"Seventy",	
			"Eighty", 	
			"Ninety" 	
	};
	public String convert( int n) {
		
		if (n < 20) {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		
		return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		

		//return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}
}





class Teacher extends Employe {
		String branch;
		String special;
	Teacher(String n,int a,String e,int spd,int d,String b,String spl){
		super(n,a,e,spd,d);
		branch=b;
		special=spl;
	}
}





public class a2q3 {
	public static void main(String[] args) {
		ArrayList<Hod> hd=new ArrayList<Hod>();
		ArrayList<Security> sc=new ArrayList<Security>();
		while(true) {
		System.out.print("1- Insert HOD details\n2- Insert security details\n3- Display HOD details\n4- Display Security details\n5  Exit\nEnter choice ");
		Scanner s=new Scanner(System.in);
		int choice =s.nextInt();
		if(choice==1) {
			System.out.println("Enter details of HOD (name , age, emp_id, salary_per_day, No_of_days_present,  specialization , department, number_of_Teachers_working_under, number_of_guideship)");
			Scanner sr=new Scanner(System.in);
			Hod h=new Hod(sr.next(),sr.nextInt(),sr.next(),sr.nextInt(),sr.nextInt(),sr.next(),sr.next(),sr.nextInt(),sr.nextInt());
			hd.add(h);
			continue;
			}
		if(choice==2) {
			System.out.println("Enter details of Security (name , age, emp_id, salary_per_day, No_of_days_present,  shift)\r\n");
			Scanner sr=new Scanner(System.in);
			Security sec=new Security(sr.next(),sr.nextInt(),sr.next(),sr.nextInt(),sr.nextInt(),sr.next());
			sc.add(sec);
			continue;
		}
		if(choice==3) {
			Iterator ir=hd.iterator();
			while(ir.hasNext()) {
				Hod h1=(Hod)ir.next();
				int sal=h1.findSalary();
				System.out.println(h1.name+" "+sal+" "+h1.convert(sal));
			}
			continue;
		}
		if(choice==4) {
			Iterator ir=sc.iterator();
			while(ir.hasNext()) {
				Security sec1=(Security)ir.next();
				int sal=sec1.findSalary();
				System.out.println(sec1.name+" "+sal+" "+sec1.convert(sal));
			}
			continue;
		}
		if(choice==5) break;
		}
	}
}
