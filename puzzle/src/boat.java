

import java.util.ArrayList;



public class boat {
	ArrayList<human> passengers=new ArrayList<human>();
	public boolean state;
	public void setstate(boolean state1)
	{
		state=state1;
	}
	
	public boolean add(human human1)
	{   if (this.passengers.size()==2)
	{
		System.out.println("NO THE boat is Full");
	return false;
	}
	else
	{
		passengers.add(human1);
	return true;
	}
	}
	public void remove(human human1)
	{
		passengers.remove(human1);
	}
	public void travel()
	{
		if (state==true)
			state=false;
		else
			state=true;
	}
	public land state(land land0,land land1)
	{
		if (state==true)
			return land0;
		else return land1;
	}

}
