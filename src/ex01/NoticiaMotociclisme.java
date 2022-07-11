package ex01;

import java.util.ArrayList;
import java.util.List;

public class NoticiaMotociclisme extends Noticia {
	//ATRIBUTS
	private String equip;
	//CONSTANTS
	private final ArrayList<String> EQUIPS=new ArrayList<String>(List.of("honda","yamaha"));
	
	//CONSTRUCTOR
	public  NoticiaMotociclisme (String titular,String equip) {
		super.titular=titular;
		this.equip=equip;
	}
	
	//MÈTODES CÀLCUL PREU I PUNTS
	@Override
	
	public void calcularPreuNoticia() {
		preu=100;
		if(Operacions.buscaString(equip,EQUIPS)) {
			preu+=50;
		}
	}
	
	@Override
	
	public void calcularPuntsNoticia() {
		puntuacio=3;
		if(Operacions.buscaString(equip,EQUIPS)) {
			puntuacio+=3;
		}
	
	}

}
