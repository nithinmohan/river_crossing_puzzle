

import java.util.ArrayList;


public class land {

	ArrayList<human> content=new ArrayList<human>();
	 land(human human1,human human2,human human3)
	{
		add(human1);
		add(human2);
		add(human3);
	}
	public void add(human human1)
	{
		content.add(human1);
	}
	public void remove(human human1)
	{
		content.remove(human1);
	}
	public boolean safe(boat boat2,land land0,land land1)
	{
		int saint=0;
		int chattan=0;
		int boatsaint=0;
		int boatchattan=0;
		for(human human1: content)
		{
			if(human1.getstate())
				saint++;
			else
		        chattan++;
		}
		
		for(human human1:boat2.passengers)
		{
			if(human1.getstate())
				boatsaint++;
			else
		        boatchattan++;
		}
		if((boat2.state&this.equals(land0))|(!boat2.state&this.equals(land1)))
		{
		saint=saint+boatsaint;
		chattan=chattan+boatchattan;
		}
		
		if(saint==0|saint>=chattan)
		return true;
		else
		return false;
	}
			
		      
			
}
