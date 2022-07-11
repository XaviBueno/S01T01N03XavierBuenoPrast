package ex01;

import java.util.ArrayList;
import java.util.List;

public class NoticiaF1 extends Noticia{
	//ATRIBUTS
	private String escuderia;
	//CONSTANTS
	private final ArrayList<String> ESCUDERIES=new ArrayList<String>(List.of("ferrari","mercedes"));
	//CONSTRUCTOR
	public NoticiaF1(String titular, String escuderia) {
		super.titular=titular;
		this.escuderia=escuderia;
	}
	//MÈTODES CÀLCUL PREU I PUNTS
	@Override
	
	public void calcularPreuNoticia() {
		
		preu=100;
	if (Operacions.buscaString(escuderia,ESCUDERIES)) {
			preu+=50;
		}

	}
	
	@Override
	
	public void calcularPuntsNoticia() {
		puntuacio=4;
		if (Operacions.buscaString(escuderia,ESCUDERIES)) {
			puntuacio+=2;
			}
		
	}
	

}
