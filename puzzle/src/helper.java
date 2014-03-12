
import java.util.Scanner;
public class helper {

	/**
	 * @param args
	 */
	
	int input(mainpuzzle p1)
	{ System.out.println("you wanna travel or move?");
		@SuppressWarnings("resource")
		Scanner s=new Scanner(System.in);
    	String n=s.nextLine();
    	
    	int response=0;
    	if (n.equals("travel"))
    		response= -1;
    	else if (n.equals("s1"))
    		response=0;
    	else if (n.equals("s2"))
    		response=1;
    	else if (n.equals("s3"))
    		response=2;
    	else if (n.equals("c1"))
    		response=3;
    	else if (n.equals("c2"))
    		response=4;
    	else if (n.equals("c3"))
    		response=5;
    	if ((response==-1)||(p1.boat1.state(p1.lands[0],p1.lands[1]).content.contains(p1.humanex[response]))||p1.boat1.passengers.contains(p1.humanex[response]))
    	return response;
    	else 
    		System.out.println ("he is in the other land");
    		return input(p1);
	}

}
