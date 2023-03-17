import java.util.Scanner;

enum BusType
{
 	O,E,L;
}

class Bus
{
	public int Busno;
	public String From;
	public String To;
	public int Distance;
	BusType Type;
	public int Fare;
	
	public Bus(int b,String fr,String to,int d)
	{
		Busno = b;
		From = fr;
		To = to;
		Distance = d;
		Type = BusType.O;
		
	}
	
	public Bus(int b,String fr,String to,int d,String ty)
	{
		Busno = b;
		From = fr;
		To = to;
		Distance = d;
		if(ty.charAt(1) == 'O')
		{		
			Type = BusType.O;
		}
		if(ty.charAt(1) == 'E')
		{		
			Type = BusType.E;
		}
		if(ty.charAt(1) == 'L')
		{		
			Type = BusType.L;
		}
	}
	
	public void CalcFare()
	{
		if(Type == BusType.O)
		{
			Fare = 10*Distance;
		}
		if(Type == BusType.E)
		{
			Fare = 20*Distance;
		}
		if(Type == BusType.L)
		{
			Fare = 24*Distance;
		}
	}
	
	public void Show()
	{
		System.out.println(Busno+" "+From+" "+To+" "+Distance+" "+Type+" "+Fare);
	}
}

class a2q2
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Bus[] bus = new Bus[100000];
		int ch,i=0,j;
		while(true)
		{
			System.out.println("\n1-Add details");
			System.out.println("2-Show details");
			System.out.println("3-Exit");
			System.out.print("\nEnter choice ");
			ch = sc.nextInt();
			switch(ch)
			{
				case 1:
						System.out.println("Enter bus details(Busno,from,to,distance,type)\n");
						int busno = sc.nextInt();
						String from = sc.next();
						String to = sc.next();
						int distance = sc.nextInt();
						String type = sc.nextLine();
						//bus[i] = new Bus(sc.nextInt(),sc.next(),sc.next(),sc.nextInt(),sc.nextLine());
						if(type.equals(""))
						{
							bus[i] = new Bus(busno,from,to,distance);
						}
						else
						{
							bus[i] = new Bus(busno,from,to,distance,type);
						} 
						bus[i].CalcFare();
						i++;
						break;
				case 2:
						for(j=0;j<i;j++)
						{
							bus[j].Show();
						}
						break;
				case 3:
						return;
				default:
			}
		}
	}
}
