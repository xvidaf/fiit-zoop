package Farma;

public class Sypka {
	private int psenica;
	private int kukurica;
	
	Sypka()
	{
		this.psenica = 100;
		this.kukurica = 60;
	}
	public int getPsenica() {
		return psenica;
	}

	public void setPsenica(int psenica) {
		this.psenica += psenica;
	}

	public int getKukurica() {
		return kukurica;
	}

	public void setKukurica(int kukurica) {
		this.kukurica += kukurica;
	}
}
