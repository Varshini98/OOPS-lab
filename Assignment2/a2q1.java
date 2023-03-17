import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


class Sponsor{
    public String name;
    public double amount;

    public void input(){
        System.out.println("Enter sponsorship details (Name of sponsor and amount)");
        Scanner input = new Scanner(System.in);
        String data = input.nextLine();
        String dataArray[] = data.split(" ") ;
        name = dataArray[0];
        amount = Double.parseDouble(dataArray[1]);
    }
}

class AmateurRunner{
    public int number;
    public int hh, mm, ss;
    private ArrayList<Sponsor> sponsors;

    public void input(){
        
        Scanner inp = new Scanner(System.in);
        String data = inp.nextLine();
        String dataArray[] = data.split(" ");
        number = Integer.parseInt(dataArray[0]);
        String time[] = dataArray[1].split(":");
        hh = Integer.parseInt(time[0]);
        mm = Integer.parseInt(time[1]);
        ss = Integer.parseInt(time[2]);

        int noOfSponsors;
        
        System.out.println();

        System.out.print("Enter no. of Sponsors: ");
        Scanner newScanner = new Scanner(System.in);
        noOfSponsors = newScanner.nextInt();
        sponsors = new ArrayList<>();
        for(int c=1; c<=noOfSponsors; c++){
            Sponsor sponsor = new Sponsor();
            sponsor.input();
            sponsors.add(sponsor);
        }
    }

    public void display(){
        System.out.print("Runner "+number+" ");
        System.out.print("Sponsors ");
        Double total = 0.0;
	    int c=0;
        for(c=0; c<this.sponsors.size()-1; c++){
            Sponsor loopSponsor = this.sponsors.get(c);
            total+=loopSponsor.amount;
            System.out.print(loopSponsor.name+" - "+loopSponsor.amount+", ");
        }
        Sponsor lSponsor = this.sponsors.get(c);
        total+=lSponsor.amount;
        System.out.print(lSponsor.name+" - "+lSponsor.amount+" total: "+total.toString());

        if(hh==0&&mm==0&&ss==0){
            System.out.println(" Finished in "+hh+":"+mm+":"+ss);
        }
    }

}

class ProfessionalRunner extends AmateurRunner{
    public int ranking;
    
    public void input(){

        Scanner inp = new Scanner(System.in);
        String data = inp.nextLine();
        String dataArray[] = data.split(" ");
        String time[] = dataArray[2].split(":");
	if(Integer.parseInt(time[ss])>59 || Integer.parseInt(time[1])>59){
		System.out.println("WRONG TIME (Minutes and Seconds should be less than or equal to 59)..!!!");
		return;	
	}
        number = Integer.parseInt(dataArray[0]);
        ranking = Integer.parseInt(dataArray[1]);

        hh = Integer.parseInt(time[0]);
        mm = Integer.parseInt(time[1]);
        ss = Integer.parseInt(time[2]);
    }

    public void display(){
        System.out.print("Runner "+number+" (Ranking "+ranking+")");
        if(hh==0 && mm==0 && ss==0){
            System.out.print(" Finished in "+hh+":"+mm+":"+ss);
        }else{
            System.out.println(" Not Finished ");            
        }
    }
}



class FancyDressRunner extends AmateurRunner{
    public String costume;
    public ArrayList<Sponsor> sponsors;
    
    public void input(){

        Scanner inp = new Scanner(System.in);
        String data = inp.nextLine();
        String dataArray[] = data.split(" ");
        number = Integer.parseInt(dataArray[0]);
        costume = dataArray[1];
        String time[] = dataArray[2].split(":");
        hh = Integer.parseInt(time[0]);
        mm = Integer.parseInt(time[1]);
        ss = Integer.parseInt(time[2]);

        int noOfSponsors;
        
        System.out.println();

        System.out.print("Enter no. of Sponsors: ");
        Scanner newScanner = new Scanner(System.in);
        noOfSponsors = newScanner.nextInt();
        sponsors = new ArrayList<>();
        for(int c=1; c<=noOfSponsors; c++){
            Sponsor sponsor = new Sponsor();
            sponsor.input();
            sponsors.add(sponsor);
        }
    }

    public void display(){
        System.out.print("Runner "+number+" ("+costume+") ");
        System.out.print("Sponsors ");
        double total = 0.0;
	    int c=0;
        for(c=0; c<this.sponsors.size()-1; c++){
            Sponsor loopSponsor = this.sponsors.get(c);
            total+=loopSponsor.amount;
            System.out.print(loopSponsor.name+" - "+loopSponsor.amount+", ");
        }
        if(c<this.sponsors.size()){
            Sponsor lSponsor = this.sponsors.get(c);
            total+=lSponsor.amount;
            System.out.print(lSponsor.name+" - "+lSponsor.amount+" total: "+total);
        }

        if(hh==0&&mm==0&&ss==0){
            System.out.println(" Not Finished");
        }else{
            System.out.println(" Finished in "+hh+":"+mm+":"+ss);
        }
    }
}

public class a2q1{
    public static void main(String args[]){
        ArrayList<ProfessionalRunner> pro_dataList = new ArrayList<>();
        ArrayList<AmateurRunner> ama_dataList = new ArrayList<>();
        ArrayList<FancyDressRunner> fancy_dataList = new ArrayList<>();

        do{
            int option1, option2;
            System.out.println("1. Add Runner Details.");
            System.out.println("2. Display runner details.");
            System.out.println("3. Exit.");
            System.out.print("Enter Choice: ");

            Scanner inp = new Scanner(System.in);
            option1 = inp.nextInt();

            switch(option1){
                case 1:
                        System.out.println("Types of Runner");
                        System.out.println("1. Professional");
                        System.out.println("2. Amateur");
                        System.out.println("3. Fancy Dress Runner.");
                        System.out.print("Enter option: ");

                        Scanner option = new Scanner(System.in);
                        option2 = option.nextInt();
                        if(option2==1){
                            ProfessionalRunner professionalRunner = new ProfessionalRunner();
                            System.out.println("Enter runner details(Number, ranking and finish time in hh:mm:ss format)");
                            professionalRunner.input();
                            pro_dataList.add(professionalRunner);
                        }
                        else if(option2==2){
                            AmateurRunner amateurRunner = new AmateurRunner();
                            System.out.println("Enter runner details(Number, finish time in hh:mm:ss format)");
                            amateurRunner.input();
                            ama_dataList.add(amateurRunner);
                        }
                        else if(option2==3){
                            FancyDressRunner fancyDressRunner = new FancyDressRunner();
                            System.out.println("Enter runner details(Number, costume and finish time in hh:mm:ss format)");
                            fancyDressRunner.input();
                            fancy_dataList.add(fancyDressRunner);
                        }
                        else{
                            System.out.println("Invalid Option !!!...Option(s) (1/2/3) only.");
                        }
                        break;
                case 2:
                        //First displaying Profrssional runner details
                        for(int i=0; i<pro_dataList.size(); i++){
                            ProfessionalRunner pro = pro_dataList.get(i);
                            pro.display();
                        }
                        for(int j=0; j<ama_dataList.size(); j++){
                            AmateurRunner ama = ama_dataList.get(j);
                            ama.display();
                        }
                        System.out.println();
                        for(int k=0; k<fancy_dataList.size(); k++){
                            FancyDressRunner fan = fancy_dataList.get(k);
                            fan.display();
                        }
                        break;

                case 3: 
                        return;
            }
            System.out.println();
        }while(true);
    }
}
