import java.util.Scanner;

class Shape  
 {  

    double length,breadth,radius,area;
    Scanner input = new Scanner(System.in); 
	/*lenghth=input.nextDouble(); 
	breadth=input.nextDouble();
	radius=input.nextDouble();*/
 }  
   
 
   

   
class Rectangle extends Shape  
 {  
      void area()  
      {  
           System.out.println("Enter l and h of rectangle:"); 
           length=input.nextDouble(); 
	   breadth=input.nextDouble();	
           area = length * breadth;  
            
           //System.out.println("Area of rectangle : "+area);  
      } 
     void show2() 
	{
	 System.out.println("Area of rectangle : "+area);
	}
 }  
   
 class Circle extends Shape  
 {  
      void area()  
      {  
          System.out.println("Radius Of circle:"); 
	  radius=input.nextDouble(); 
          area = 3.14 * radius * radius;  
             
           //System.out.println("Area of circle : "+area);  
      }  

       void show3() 
	{
	 System.out.println("Area of circle : "+area);
	}
 }  
   
   
 class q2
 {  
      public static void main(String[] args)  
      {  
            
           double area;
           Rectangle rec = new Rectangle();  
           Circle cir = new Circle();  
            
           
           rec.area(); 
           cir.area(); 

		rec.show2();
		cir.show3();
		
      }  
 } 
