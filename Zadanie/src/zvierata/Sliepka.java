package zvierata;
import java.lang.Math;



public class Sliepka extends Zviera {

		private static int pocet;
		private int pocetvajec;
		
		
		public Sliepka(String druh, String meno, boolean dospelost, String pohlavie )
		{
			this.pohlavie = pohlavie;
			this.druh = druh;
			this.meno = meno;
			this.dospelost = dospelost;
			pocetvajec = 0;
			nakrmene = false;
			++pocet;
		}
		
		public static int getPocet()
		{
			return pocet;
		}
		
		public boolean isNakrmene() {
			if(nakrmene)
			{
				System.out.println("Slepka "+this.getMeno()+" je nakrmena a pripravena zniest vajcia");
			}
			return nakrmene;
		}
		
		public void vytvorTovar()
		{
			//lacna vyliahne menej ako normalna atd.
			if(dospelost && nakrmene)
			{
				if(druh == "draha")
				{
					pocetvajec = (int)(Math.random() * ((1 - 4) + 1)) + 1;
					nakrmene=false;
				}
				else if(druh == "normalna")
				{
					pocetvajec = (int)(Math.random() * ((0 - 3) + 1)) + 0;
					nakrmene=false;
				}
				else if(druh == "lacna")
				{
					pocetvajec = (int)(Math.random() * ((0 - 2) + 1)) + 0;
					nakrmene=false;
				}
			}
		}
		
		public int getPocetVajec(){
			return pocetvajec;
		}
		public void setpocetvajec(int pocetvajec){
			this.pocetvajec=pocetvajec;
		}
		
		public void setNakrmene(boolean nakrmene) {
			this.nakrmene = nakrmene;
			if(this.nakrmene)
				System.out.println("Sliepka " + this.meno + " je nakrmena");
		}
		
		
}
