import java.util.Scanner;

class engine
{
  int engine_no;
  int cc;
}

class carQ7
{

	public static void main(String args[]) 
	{

	Scanner input=new Scanner(System.in);
	engine eng=new engine();
	String color;
	
	int price;

	System.out.println("Enter car details");
	eng.engine_no=input.nextInt();
	eng.cc=input.nextInt();
	color=input.next();
	price=input.nextInt();

	System.out.println(eng.engine_no+" "+eng.cc+" "+color+" "+price);

	}
}





