package Farma;

import zvierata.Krava;
import zvierata.Sliepka;
import zvierata.Zviera;
import Farma.Sklad;
import nastroje.Kombajn;
import nastroje.Traktor;

public class Farmar {
	
	private Traktor traktor;
	private Kombajn kombajn;
	
	private double peniaze;
	private String meno;
	private String priezvisko;
	private boolean kupenyTraktor;
	private static int pocetDni;
	private boolean kupenyKombajn;
	
	
	
	
	public Farmar(int peniaze, String meno, String priezvisko)
	{
		this.peniaze = peniaze;
		this.meno = meno;
		this.priezvisko = priezvisko;
		kupenyTraktor = false;
	}
	
	public double getPeniaze() {
		return peniaze;
	}
	public void setPeniaze(double peniaze) {
		this.peniaze += peniaze;
		System.out.println("Nova hodnota penazi je " + this.peniaze);
	}
	public String getMeno() {
		return meno;
	}
	
	public String getPriezvisko() {
		return priezvisko;
	}
	
	//////////////////////
	//Praca so sliepkami//
	//////////////////////
	
	public void kupSliepku(String druh, String meno, boolean dospelost, String pohlavie, Sliepka sliepky[] )
	{
		System.out.println("Kupujem sliepku druhu "+ druh+" s menom " + meno);
		if(druh == "lacna")
		{
			if(this.peniaze >= 5)
			{
				this.setPeniaze(-5);
				//sliepka novaslieka = new sliepka(druh , meno, dospelost, pohlavie);
				sliepky[Sliepka.getPocet()] = new Sliepka("lacna",meno,true,"zena");
				
			}
			else
			{
				System.out.println("Nedostatok penazi");
			}
		}
		else if(druh == "normalna")
		{
			if(this.peniaze >= 10)
			{
				this.setPeniaze(-10);
				//sliepka novaslieka = new sliepka(druh , meno, dospelost, pohlavie);
				sliepky[Sliepka.getPocet()] = new Sliepka("normalna",meno,true,"zena");
				
			}
			else
			{
				System.out.println("Nedostatok penazi");
			}
		}
		else if(druh == "draha")
		{
			if(this.peniaze >= 15)
			{
				this.setPeniaze(-15);
				//sliepka novaslieka = new sliepka(druh , meno, dospelost, pohlavie);
				sliepky[Sliepka.getPocet()] = new Sliepka("draha",meno,true,"zena");
				
			}
			else
			{
				System.out.println("Nedostatok penazi");
			}
		}
	}
	
	
	public void nakrm(Zviera zver[], Sklad skladisko)
	{	
		if(zver[0] instanceof Sliepka)
		{
			Sliepka sliepocka = null;
			System.out.println("Na nakrmenie sliepok potrebujeme " + Sliepka.getPocet() + " kukurice");
			if(Sliepka.getPocet()<=skladisko.getKukurica())
			{
				for (int i = 0; i < Sliepka.getPocet(); i++) 
				{
					sliepocka = (Sliepka) zver[i];
					sliepocka.setNakrmene(true);
				}
			}
			else
			{
				System.out.println("Nemame dost kukurice v sklade(V sklade je "+skladisko.getKukurica()+")");
			}
		}
		else if(zver[0] instanceof Krava)
		{
			Krava kravicka = null;
			System.out.println("Na nakrmenie krav potrebujeme " + Krava.getPocet() + " psenice");
			//System.out.println(Krava.getPocet());
			if(Krava.getPocet()<=skladisko.getPsenica())
			{
				for (int i = 0; i < Krava.getPocet(); i++) 
				{
					kravicka = (Krava) zver[i];
					kravicka.setNakrmene(true);
				}
			}
			else
			{
				System.out.println("Nemame dost psenice v sklade(V sklade je "+skladisko.getPsenica()+")");
			}
		}
		  
	}
	//Vajcia ihned predame
	public void pozbierajVajcia(Sliepka sliepky[])
	{
		for (int i = 0; i < Sliepka.getPocet(); i++) 
		{
			if(sliepky[i].getPocetVajec()>0)
			{
				System.out.println("Sliepka " + sliepky[i].getMeno() + " zniesla " + sliepky[i].getPocetVajec() + " vajec");
				this.setPeniaze(sliepky[i].getPocetVajec()*2);
				sliepky[i].setpocetvajec(0);
			}
			else
			{
				System.out.println("Sliepka " + sliepky[i].getMeno() + " nezniesla ziadne vajcia");
			}
		}
	}
	//dame ich do skladu
	public void pozbierajVajcia(Sliepka sliepky[], Sklad skladisko)
	{
		for (int i = 0; i < Sliepka.getPocet(); i++) 
		{
			if(sliepky[i].getPocetVajec()>0)
			{
				System.out.println("Sliepka " + sliepky[i].getMeno() + " zniesla " + sliepky[i].getPocetVajec() + " vajec");
				skladisko.setVajcia(sliepky[i].getPocetVajec());
				sliepky[i].setpocetvajec(0);
			}
			else
			{
				System.out.println("Sliepka " + sliepky[i].getMeno() + " nezniesla ziadne vajcia");
			}
		}
	}
	
	
	
	
	/////////////////////////////
	//Koniec prace so sliepkami//
	/////////////////////////////
	
	
	//////////////////////////////////
	//Ukoncenie dna(farmar ide spat)//
	//////////////////////////////////
	public void skonciDen(Sliepka sliepky[], Pole polia[], Krava kravy[])
	{
		pocetDni++;
		for (int i = 0; i < Sliepka.getPocet(); i++) 
		{
			
			if(sliepky[i].isNakrmene())
			{
				sliepky[i].vytvorTovar();
				System.out.println("Sliepka " + sliepky[i].getMeno() + " vyliahla " + sliepky[i].getPocetVajec() + " vajec");
			}
			else
			{
				System.out.println("Sliepka " + sliepky[i].getMeno() + " nieje nakrmena");
			}
		}
		for (int i = 0; i < Pole.getPocet(); i++) 
		{
			
			if(polia[i].isZasadene())
			{
				polia[i].dozrej();
				System.out.println("Pole velkosti " + polia[i].getVelkost() + " je uz zasadene " + polia[i].getDni() + " dni");
			}
		}
		for (int i = 0; i < Krava.getPocet(); i++)
		{
			if(kravy[i].isNakrmene())
				kravy[i].setDniOdDojenia();
			kravy[i].vytvorTovar();
		}
	}

	//////////////////
	//Praca s polami//
	//////////////////
	
	public void kupPole(int velkost,Pole polia[])
	{
		if(this.peniaze < (velkost*2))
		{
			System.out.println("Nemame dost penazi na kupu pole velkosti "+ velkost +" za cenu " + (velkost*2));
		}
		else
		{
			polia[Pole.getPocet()] = new Pole(velkost);
			System.out.println("Kupil som pole velkosti " + velkost + " za cenu " + (velkost*2));
			this.setPeniaze(-(velkost*2));
		}
	}
	
	public void poOrPolia(Pole polia[])
	{
		if(kupenyTraktor == true)
		{
			for (int i = 0; i < Pole.getPocet(); i++) 
			{
				traktor.poOrPole(polia[i]);
			}
		}
		else
		{
			System.out.println("Nevieme poorat pole kedze nemame traktor");
		}
	}
	
	public void zasadPole(Pole polia[],Sklad sklad,String typ)
	{
		if(typ=="psenica"||typ=="kukurica")
		{
		for (int i = 0; i < Pole.getPocet(); i++) 
		{
			if(polia[i].isZasadene()== false)
			{
				if(typ == "psenica" && sklad.getPsenica() >= polia[i].getVelkost())
				{
					polia[i].zasad(typ);
					sklad.setPsenica(-polia[i].getVelkost());
				}
				else if(typ == "kukurica" && sklad.getKukurica() >= polia[i].getVelkost())
				{
					polia[i].zasad(typ);
					sklad.setKukurica(-polia[i].getVelkost());
				}
				break;
			}
			else
			{
				System.out.println("Na poli velkosti"+polia[i].getVelkost()+"uz je zasadene, ideme na dalsie");
			}
		}
		}
		else
		{
			System.out.println("Nerozpoznany typ obilniny");
		}
	}
	
	public void vykonajZatvu(Pole polia[],Sklad skladisko)
	{
		for (int i = 0; i < Pole.getPocet(); i++) 
		{
			if(polia[i].isReady())
			{
				if(kupenyKombajn)
				{
					System.out.println("Pozbierali sme produkt pomocou kombajnu z pola velkosti"+ polia[i].getVelkost());
					if(polia[i].getZasadeneDruh()=="psenica")
					{
						skladisko.setPsenica(4*polia[i].getVelkost());
					}
					else
					{
						skladisko.setKukurica(4*polia[i].getVelkost());
					}
					
					polia[i].zatva();
				}
				else
				{
					System.out.println("Pozbierali sme produkt z pola velkosti"+ polia[i].getVelkost());
					if(polia[i].getZasadeneDruh()=="psenica")
					{
						skladisko.setPsenica(2*polia[i].getVelkost());
					}
					else
					{
						skladisko.setKukurica(2*polia[i].getVelkost());
					}
					polia[i].zatva();
				}
				
			}
			else
			{
				System.out.println("Pole velkosti"+ polia[i].getVelkost()+ " nieje pripravene na zatvu");
			}
			
		}
	}
	
	/////////////////////////
	//Koniec prace s polami//
	////////////////////////
	
	//////////////////
	//Kupa nastrojov//
	/////////////////
	
	public void kupTraktor()
	{
		if(this.kupenyTraktor)
		{
			System.out.println("Traktor uz vlastnime");
		}
		else if(this.peniaze>=100)
		{
			this.setPeniaze(-100);
			traktor = new Traktor();
			kupenyTraktor = true;
			System.out.println("Kupili sme traktor");
		}
		else
		{
			System.out.println("Nedostatok penazi, mame "+ this.peniaze + " Potrebujeme 100" );
		}
		
	}
	
	public void kupKombajn()
	{
		if(this.kupenyKombajn)
		{
			System.out.println("Kombajn uz vlastnime");
		}
		else if(this.peniaze>=100)
		{
			this.setPeniaze(-100);
			kombajn = new Kombajn();
			kupenyKombajn = true;
			System.out.println("Kupili sme Kombajn");
		}
		else
		{
			System.out.println("Nedostatok penazi, mame "+ this.peniaze + " Potrebujeme 100" );
		}
		
	}
	
	public Traktor getTraktor()
	{
		return traktor;
	}
	public Traktor getKombajn()
	{
		return traktor;
	}
	//////////////////////////
	//Koniec kupy nastrojov //
	//////////////////////////
	
	/////////////////////
	//Praca s kravami///
	///////////////////
	
	
	public void kupKravu(String druh, String meno,Krava kravy[] )
	{
		System.out.println("Kupujem kravu druhu "+ druh+" s menom " + meno);
		if(druh == "lacna")
		{
			if(this.peniaze >= 10)
			{
				this.setPeniaze(-10);
				kravy[Krava.getPocet()] = new Krava("lacna",meno);
				
			}
			else
			{
				System.out.println("Nedostatok penazi");
			}
		}
		else if(druh == "normalna")
		{
			if(this.peniaze >= 20)
			{
				this.setPeniaze(-20);
				kravy[Krava.getPocet()] = new Krava("normalna",meno);
				
			}
			else
			{
				System.out.println("Nedostatok penazi");
			}
		}
		else if(druh == "draha")
		{
			if(this.peniaze >= 30)
			{
				this.setPeniaze(-30);
				kravy[Krava.getPocet()] = new Krava("draha",meno);
				
			}
			else
			{
				System.out.println("Nedostatok penazi");
			}
		}
	}
	//Mlieko ihned predame
	public void ziskajMlieko(Krava kravy[])
	{
		for (int i = 0; i < Krava.getPocet(); i++) 
		{
			if(kravy[i].isDojenie())
			{
				this.setPeniaze(kravy[i].getMlieko()*4);
				kravy[i].podojeni();
			}
			else
			{
				System.out.println("Krava " + kravy[i].getMeno() + " nieje pripravena na dojenie");
			}
		}
	}
		//dame ho do skladu
	public void ziskajMlieko(Krava kravy[], Sklad skladisko)
	{
		for (int i = 0; i < Sliepka.getPocet(); i++) 
		{
			if(kravy[i].isDojenie())
			{
				skladisko.setMlieko(kravy[i].getMlieko());
				kravy[i].podojeni();
			}
			else
			{
				System.out.println("Krava " + kravy[i].getMeno() + " nieje pripravena na dojenie");
			}
		}
	}
}
