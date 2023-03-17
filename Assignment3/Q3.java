
import java.util.*;
import java.util.regex.*;

public class Q3 {
 String name,rollno;
 float intmark,extmark,assmark;
 Student(String a,String r,float sub1,float sub2,float sub3){
	 name=a;
	 rollno=r;
	 intmark=sub1;
	 extmark=sub2;
	 assmark=sub3;
 }
 public static void main(String[] args) {
	 System.out.println("Enter the student detail : ");
	 Scanner s=new Scanner(System.in);
	 try {
		 float x,y,z;
		 String a,r;
		 a=s.next();
		 r=s.next();
		 if(Pattern.matches("[a-zA-z][a-zA-z0-9]*", a)) {
			 if(Pattern.matches("[a-zA-z][a-zA-z0-9]*", r)) {
				 x=s.nextFloat();
				 y=s.nextFloat();
				 z=s.nextFloat();
				 Student st=new Student(a,r,x,y,z);
				 if(st.intmark<0 || st.extmark<0 || st.assmark<0) {
					 throw new NegativeException("negative marks cannot be entered");
				 }
				 else if(st.intmark>15 || st.extmark>50 || st.assmark>25) {
					 throw new BoundaryException("Marks out of scope");
				 }
			 }
			 else {
				 throw new TypeMismatchException("String has to be entered");
			 }
			
		 }
		 else {
			 throw new TypeMismatchException("String has to be entered");
		 } 		 
	 }
	 catch(BoundaryException e) {
		 System.out.println(e);
	 }
	
	 catch(NegativeException e) {
		 System.out.println(e);
	 }
	 catch(TypeMismatchException e) {
		System.out.println(e);
	 }
	 catch(IllegalFormatException e) {
		 System.out.println("Illegal format exception");
	 }
 }
}
class TypeMismatchException extends Exception {
	public TypeMismatchException(String x) {
		super(x);
	}
}
class NegativeException extends Exception {
	public NegativeException(String x) {
		super(x);
	}
}
class BoundaryException extends Exception {
	public BoundaryException(String x) {
		super(x);
	}
}
