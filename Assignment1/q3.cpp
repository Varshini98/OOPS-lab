// multiple inheritance.cpp
#include<iostream>
using namespace std;
class Liquid // for specific gravity
{
 	public:
 	int x;
 	void getx()
    {
 	     cin >> x;
    }
};
class Fuel //for price
{
 	public:
 	int y;
 	void gety()
 	{
 	   cin >> y;
 	}
};

class Petrol : public Liquid, public Fuel   //Petrol is derived from class Luqid and class Fuel
{
 	public:
 	void output()
 	{
 	    cout << x <<" "  << y <<"\n";
 	}
};

int main()
{
	cout <<"Specific gravity and price of petrol:";
 	 Petrol obj1; //object of derived class Petrol
 	 obj1.getx();
 	 obj1.gety();
 	 obj1.output();
 	 return 0;
}   

