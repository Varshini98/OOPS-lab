import java.util.Scanner;

class student
{
	String rollno;
	float cgpa;
	String name;
	public double getpercentage()
	{
	double p=cgpa*10-5;
	return p;
	}
	
}

class q1
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		int n;
		System.out.println("Enter the number of students");
		n=input.nextInt();
		String enter=input.nextLine();
		String rollno;
		String name;
		float cgpa;
		student st[]=new student[n];
		System.out.println("Student details");
		for(int i=0;i<n;i++)
		{
			st[i]=new student();
			st[i].name=input.nextLine();
			st[i].rollno=input.nextLine();
			st[i].cgpa=input.nextFloat();
		 	enter=input.nextLine();
		}
		for(int i=0;i<n;i++)
		{
			
			System.out.println(st[i].name+ " " + st[i].rollno + " " + st[i].cgpa + " " + st[i].getpercentage());
			
		}
	}
}



