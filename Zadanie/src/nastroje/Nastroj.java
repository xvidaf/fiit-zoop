package nastroje;

public class Nastroj {
	protected String nazov;
	int stav = 100;
	
	public static final void skontrolujStroj(Nastroj stroj)
	{
		System.out.println("Nazov tohto nastroju je " + stroj.getNazov());
		if(stroj instanceof Traktor )
		{
			System.out.println("Je to traktor");
		}
		else if(stroj instanceof Traktor)
		{
			System.out.println("Je to kombajn");
		}
		System.out.println("Nazov tohto nastroju je " + stroj.getNazov());
		stroj.getStav();
		
	}
	
	public final void getStav()
	{
		System.out.println("Jeho stav je "+ this.stav + "%");
	}
	
	public final void setStav()
	{
		this.stav -= 1;
	}
	
	String getNazov()
	{
		return nazov;
	}

}
