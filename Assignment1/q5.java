

import java.util.Scanner;

 class person

{   String name;
    int age;
    Scanner bucky = new Scanner(System.in);
   
}

class emp extends person
{ 
  String emp_id;
  double salary; 
}

class manager extends emp
{ 
  String mdept;
  int under; 

  


    void show1() 
	{
	 System.out.println(name+" "+age+" "+emp_id+" "+salary+" "+mdept+" "+under);
	}

}
     
public class q5
{
    public static void main(String[] args)
    {  
        int n,i;
        Scanner bucky = new Scanner(System.in);

        System.out.println("Enter number of managers "); 
        n=bucky.nextInt();

                String enter=bucky.nextLine();
		String mdept;
		String name;
                int age;
                int under;
                String emp_id;
                double salary;

		

            manager obj[] = new manager[n];





        System.out.println("Enter Details"); 

      

        for(i=0;i<n;i++)
        {          obj[i]=new manager();

                   obj[i].name=bucky.nextLine(); 
		   obj[i].age=bucky.nextInt();	
                   obj[i].emp_id=bucky.next();  //next.line
		   obj[i].salary=bucky.nextDouble();	
                   obj[i].mdept=bucky.next(); 
		   obj[i].under=bucky.nextInt();

                   enter=bucky.nextLine();; 

        }
      
        for(i=0;i<n;i++)
        { obj[i].show1(); }
      
        
        
}
}

        
        
     
      
