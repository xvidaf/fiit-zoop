package Farma;

public class Sklad {
	
	private Sypka sypka ;
	
	private int vajcia;
	private int vlna;
	private int mlieko;
	
	public Sklad()
	{
		sypka = new Sypka();
		this.vajcia = 0;
		this.vlna = 0;
	}
	
	public int getPsenica() {
		return sypka.getPsenica();
	}

	public void setPsenica(int psenica) {
		sypka.setPsenica(psenica);
	}

	public int getKukurica() {
		return sypka.getKukurica();
	}

	public void setKukurica(int kukurica) {
		sypka.setKukurica(kukurica);
	}

	public int getVajcia() {
		return vajcia;
	}

	public void setVajcia(int vajcia) {
		this.vajcia += vajcia;
		System.out.println("Teraz mame v sklade "+ this.vajcia + " vajec");
	}
	
	public void setMlieko(int mlieko) {
		this.mlieko += mlieko;
		System.out.println("Teraz mame v sklade "+ this.mlieko + " l mlieka");
	}
	
	public int getMlieko() {
		return mlieko;
	}

	public int getVlna() {
		return vlna;
	}

	public void setVlna(int vlna) {
		this.vlna += vlna;
	}
	
}
