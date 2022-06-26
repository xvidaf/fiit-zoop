package zvierata;

public abstract class Zviera {
	protected String meno;
	protected String pohlavie;
	protected boolean dospelost;
	protected boolean nakrmene;
	protected String druh; //lacna, normalna, draha
	
	public String getMeno() {
		return meno;
	}
	
	public String getPohlavie() {
		return pohlavie;
	}


	public boolean isDospelost() {
		return dospelost;
	}
	
	public boolean isNakrmene() {
		return nakrmene;
	}
	
	public abstract void setNakrmene(boolean nakrmene);
		
	public abstract void vytvorTovar();

	
}
