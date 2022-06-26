package main;

import zvierata.Sliepka;
import zvierata.Krava;
import Farma.Farmar;
import Farma.Sklad;
import nastroje.Nastroj;
import Farma.Pole;

public class Main1 {

	public static void main(String[] args) {
     //inicializacia
	 Sliepka[] sliepky = new Sliepka[60];
	 Krava[] kravy = new Krava[60];
	 Farmar filip = new Farmar(500,"Filip","Vida");
	 Sklad skladisko = new Sklad();
	 Pole[] polia = new Pole[30];
	 //koniec inicializacie
	 
	 
	 filip.kupSliepku("lacna", "Kacer", true, "muz", sliepky);
	 filip.kupSliepku("lacna", "Kocner", true, "muz", sliepky);
	 filip.kupSliepku("draha", "Donald", true, "muz", sliepky);
	 filip.kupSliepku("lacna", "D", true, "muz", sliepky);
	 filip.kupKravu("draha", "Dorka", kravy);
	 filip.kupPole(10, polia);
	 filip.kupPole(5, polia);
	 filip.nakrm(sliepky, skladisko);
	 filip.nakrm(kravy, skladisko);
	 filip.kupTraktor();
	 filip.skonciDen(sliepky,polia,kravy);
	 filip.pozbierajVajcia(sliepky, skladisko);
	 filip.zasadPole(polia, skladisko, "psenica");
	 filip.poOrPolia(polia);
	 filip.skonciDen(sliepky,polia,kravy);
	 filip.nakrm(sliepky, skladisko);
	 filip.skonciDen(sliepky,polia,kravy);
	 filip.skonciDen(sliepky,polia,kravy);
	 filip.nakrm(sliepky, skladisko);
	 filip.pozbierajVajcia(sliepky);
	 filip.skonciDen(sliepky,polia,kravy);
	 filip.skonciDen(sliepky,polia,kravy);
	 filip.skonciDen(sliepky,polia,kravy);
	 Nastroj.skontrolujStroj(filip.getTraktor());
	 filip.vykonajZatvu(polia, skladisko);
	 filip.kupKombajn();
	 filip.vykonajZatvu(polia, skladisko);
	 filip.ziskajMlieko(kravy);
	 filip.skonciDen(sliepky,polia,kravy);
	 filip.skonciDen(sliepky,polia,kravy);
	}

}
