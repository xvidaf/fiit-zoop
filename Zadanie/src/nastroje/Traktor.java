package nastroje;

import Farma.Pole;

public class Traktor extends Nastroj {
	
	public Traktor()
	{
		nazov = "Zetor";
	}
	
	public void poOrPole(Pole pole)
	{
		if(pole.isZasadene() && pole.isPoOrane() ==  false)
		{
			pole.setPoOrane();
			System.out.println("Pole velkosti "+pole.getVelkost()+" je teraz poorane, obilnina vyrastie rychlejsie");
			this.setStav();
		}
		else if(pole.isPoOrane())
		{
			System.out.println("Pole je uz poorane");
		}
		else
		{
			System.out.println("Nieje co poorat");
		}
	}
}
