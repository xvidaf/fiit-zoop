package Farma;

public class Pole implements Zem {
	private boolean zasadene;
	protected static int pocet;
	private String zasadeneDruh;
	private int velkost;
	private int dniPoZasadeni;
	private boolean ready;
	private boolean poOrane;
	
	Pole(int velkost)
	{
		zasadene = false;
		this.velkost = velkost;
		++pocet;
		poOrane= false;
	}
	
	public boolean isZasadene() {
		return zasadene;
	}
	public static int getPocet() {
		return pocet;
	}
	public static void setPocet(int pocet) {
		Pole.pocet = pocet;
	}
	public String getZasadeneDruh() {
		return zasadeneDruh;
	}
	public int getVelkost() {
		return velkost;
	}
	public void setVelkost(int velkost) {
		this.velkost = velkost;
	}
	
	public int getDni() {
		return dniPoZasadeni;
	}
	
	public void setPoOrane()
	{
		this.poOrane= true;
		this.dniPoZasadeni += 2;
	}
	
	public boolean isPoOrane()
	{
		return poOrane;
	}
	public boolean isReady()
	{
		return ready;
	}
	
	public void zasad(String druh) {
		this.zasadene = true;
		this.zasadeneDruh=druh;
		this.dniPoZasadeni=0;
		ready=false;
		System.out.println("Na pole velkosti " + this.getVelkost() + "bolo zasadene " + druh);
	}
	
	public void dozrej()
	{
		this.dniPoZasadeni+=1;
		if(this.zasadeneDruh=="psenica"&&this.dniPoZasadeni==8)
		{
			System.out.println("Pole velkosti " + this.getVelkost() + " je uz pripravene na zozatie ");
			ready=true;
		}
		else if(this.zasadeneDruh=="kukurica"&&this.dniPoZasadeni==12)
		{
			ready=true;
		}
	}
	
	public void zatva()
	{
		this.ready=false;
		this.zasadeneDruh= "nic";
		this.dniPoZasadeni=0;
		this.zasadene = false;
		
	}
	
}
