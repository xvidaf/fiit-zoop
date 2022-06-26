package zvierata;

public class Krava extends Zviera{
	private boolean pripravenaNaDojenie;
	private int dniOdDojenia;
	private int mlieko =0;
	private static int pocet;
	
	public Krava(String druh, String meno)
	{
		this.druh=druh;
		this.meno = meno;
		nakrmene = false;
		pripravenaNaDojenie = false;
		++pocet;
	}
	
	public void setDniOdDojenia()
	{
		dniOdDojenia += 1;
	}
	
	public static int getPocet()
	{
		return pocet;
	}
	
	public boolean isDojenie()
	{
		return pripravenaNaDojenie;
	}
	public int getMlieko()
	{
		return mlieko;
	}
	public void podojeni()
	{
		mlieko = 0;
		pripravenaNaDojenie = false;
		dniOdDojenia = 0;
	}
	
	public void vytvorTovar()
	{
		if(nakrmene && dniOdDojenia>=2 && mlieko == 0)
		{
			if(druh == "draha")
			{
				mlieko = 4;
				nakrmene=false;
				pripravenaNaDojenie = true;
			}
			else if(druh == "normalna")
			{
				mlieko = 3;
				nakrmene=false;
				pripravenaNaDojenie = true;
			}
			else if(druh == "lacna")
			{
				mlieko = 2;
				nakrmene=false;
				pripravenaNaDojenie = true;
			}
			System.out.println("Krava " + this.meno + " je pripravena na dojenie");
		}
	}
	
	public void setNakrmene(boolean nakrmene) {
		this.nakrmene = nakrmene;
		if(this.nakrmene)
			System.out.println("Krava " + this.meno + " je nakrmena");
	}
}
