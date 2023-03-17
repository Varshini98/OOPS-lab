
import java.util.Scanner;
class Menu
{ 

	int job,hl;

  public int add (int x,int y)
   {
	job=x+y;
	return job; 
   } 

   public int  add (int x,int y,int z)
   {
	hl=x+y+z;
	return hl; 
   } 
    
}



public class q4
{
    public static void main(String[] args)
    {
        int a, b, c, opt, add, sub, mul;
        Scanner input = new Scanner(System.in);
        Menu rec = new Menu();


        while(true)
        {
            System.out.println("1- add 2 numbers");
            System.out.println("2- add 3 numbers");
            System.out.println("3- -1*number");
            System.out.println("4- Exit");
            System.out.println("Enter option : ");
            opt = input.nextInt();
            switch(opt)
            {
                case 1:
                    System.out.print("Enter two numbers ");
                    a = input.nextInt();
                    b = input.nextInt();


                add = rec.add(a,b);
                System.out.println("SUM : "+add);
                break;

                case 2:
                     System.out.print("Enter three numbers ");
                    a = input.nextInt();
                    b = input.nextInt();
                    c = input.nextInt();



                sub = rec.add(a,b,c);
                System.out.println("SUM :  "+sub);
                break;

                case 3:

                    System.out.print("Enter number ");
                    a = input.nextInt();
                mul = a * -1;
                System.out.println("(-1*number): "+mul);
                break;


                case 4:
                System.exit(0);
            }
        }
    }
}
