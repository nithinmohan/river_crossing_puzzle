

import java.util.ArrayList;

public class mainpuzzle {

	/**
	 * @param args
	 */
	
	human[] humanex=new human[6];
	land[] lands=new land[2];
	boat boat1=new boat();
	mainpuzzle()
	{
	humanex[0]=new human(true);
	humanex[1]=new human(true);
	humanex[2]=new human(true);
	humanex[3]=new human(false);
	humanex[4]=new human(false);
	humanex[5]=new human(false);
	lands[0]=new land(humanex[0],humanex[1],humanex[2]);
	lands[1]=new land(humanex[3],humanex[4],humanex[5]);
	boat1.setstate(false);
	}
	public boolean win(land la,land lb)
	{
		if((la.content.size()==3)&(lb.content.size()==3))
		{
   if(!la.content.get(0).getstate()&!la.content.get(1).getstate()&!la.content.get(2).getstate()&lb.content.get(0).getstate()&lb.content.get(1).getstate()&lb.content.get(2).getstate())
		return true;
   else 
	   return false;
    }
		else 
			return false;
					}
	
	public static void main(String[] args)
	{
		mainpuzzle p1= new mainpuzzle();
        p1.game(p1);
	}

	
void game(mainpuzzle p1)
{
	helper helper1=new helper();
    Boolean y=true;
	System.out.println("GAME STARTS");
	System.out.println("C means Saitans and S means Saints.");
	System.out.println("Help them to cross the river.");
	System.out.println("Dont let the number of Saitans Exceed Saints in any coast.");
	System.out.println("To get the person into the boat or vice-versa type the ID(s1,c1 etc).Hit ENTER.");
	System.out.println("To move the boat type 'travel'. Hit ENTER.");
	int counter=0;
	while (y)
	{   currentpos();
		if (p1.lands[0].safe(boat1,lands[0],lands[1])&p1.lands[1].safe(boat1,lands[0],lands[1]))
		{
		int j=helper1.input(p1);
		counter++;
		if (j==-1)
		{
			boat1.travel();
			
		}
		else if (p1.boat1.state(p1.lands[0],p1.lands[1]).content.contains(p1.humanex[j]))
		{
			boolean possible=boat1.add(humanex[j]);
			if(possible)
			boat1.state(lands[0],lands[1]).remove(humanex[j]);
			
		}
		else if (boat1.passengers.contains(p1.humanex[j]))
		{
			boat1.state(lands[0],lands[1]).add(humanex[j]);
			boat1.remove(humanex[j]);
		}
		
		else
		{
			System.out.println(boat1.state);
			continue;
		}
		y=!win(lands[0],lands[1]);
		//System.out.println(boat1.state);
		//System.out.println(boat1.state);
		
		//Scanner s=new Scanner(System.in);
    	//String n=s.nextLine();
		/*lands[0].remove(humanex[0]);
		lands[0].remove(humanex[1]);
		boat1.add(humanex[0]);
		boat1.add(humanex[1]);
	    boat1.travel();
		System.out.println(1);
		boat1.remove(humanex[0]);
		boat1.remove(humanex[1]);
		lands[1].add(humanex[0]);	
		lands[1].add(humanex[1]);
		boat1.add(humanex[4]);
		boat1.add(humanex[5]);
		lands[1].remove(humanex[4]);
		lands[1].remove(humanex[5]);
		boat1.travel();
		boat1.remove(humanex[5]);
		boat1.add(humanex[2]);
		lands[0].remove(humanex[2]);
		lands[0].add(humanex[5]);	
		boat1.travel();
		boat1.remove(humanex[2]);
		boat1.add(humanex[3]);
		lands[1].remove(humanex[3]);
		lands[1].add(humanex[2]);	
		boat1.travel();
		boat1.remove(humanex[3]);
		boat1.remove(humanex[4]);
		lands[0].add(humanex[3]);
		lands[0].add(humanex[4]);*/
		
		
		}
		else
		{
			System.out.println("You lost");
			break;
		}

	}
	if(y==false)
	{
		System.out.println("You Won!!");
		System.out.println("You took "+counter+" movements");
		if (counter==17)
		System.out.println("BEST!!!!");
		else
		System.out.println("You could do better");
		
	}
System.out.println("GAME ENDS");
}

String getstring(human human1)
{
	if(human1.equals(humanex[0]))
		return "s1";
	else if(human1.equals(humanex[1]))
		return "s2";
	else if(human1.equals(humanex[2]))
		return "s3";
	else if(human1.equals(humanex[3]))
		return "c1";
	else if(human1.equals(humanex[4]))
		return "c2";
	else if(human1.equals(humanex[5]))
		return "c3";
	else 
		return "error";
}
void currentpos()
{
	System.out.print("boat is in ");
	if (boat1.state(lands[0],lands[1]).equals(lands[0]))
		System.out.println("land1.");
	else
		System.out.println("land2.");
	System.out.print("boat has ");
	printlist(boat1.passengers);
	System.out.println();
	System.out.print("land1 has ");
	printlist(lands[0].content);
	System.out.println();
	System.out.print("land2 has ");
	printlist(lands[1].content);
	System.out.println();
}
void printlist(ArrayList<human> human1)
{
	if(human1.isEmpty())
		System.out.print("no one.");
	else
	{
	for(human human2:human1)
	{
		System.out.print(getstring(human2)+",");
	}
	}
}
}

