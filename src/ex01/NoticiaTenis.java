package ex01;

import java.util.ArrayList;
import java.util.List;

public class NoticiaTenis extends Noticia {
	
	//ATRIBUTS
	private String tenista;
	//CONSTANTS
	private final ArrayList<String> TENISTES=new ArrayList<String>(List.of("federer","nadal", "djocovic"));
	
	//CONSTRUCTOR
	public NoticiaTenis(String titular,String tenista) {
		super.titular=titular;
		this.tenista=tenista;
		
	}
	
	//METODES CALCUL PREU I PUNTS
	@Override
	
	public void calcularPreuNoticia() {
		preu=150;
		if(Operacions.buscaString(tenista,TENISTES)) {
			preu+=100;
		}
		
		
	

	}
	//MÈTODES CÀLCUL PREU I PUNTS
	@Override
	public void calcularPuntsNoticia() {
		puntuacio=4;
		
		if(Operacions.buscaString(tenista,TENISTES)) {
			puntuacio+=3;
		}
			
	}
	
}
