package ex01;

import java.util.ArrayList;
import java.util.List;

public class NoticiaFutbol extends Noticia{
	//ATRIBUTS
	private String competicio;
	private String club;
	private String jugador;
	//CONSTANTS
	private final ArrayList<String> COMPETICIONS=new ArrayList<String>(List.of("Lliga de Campions","lliga"));
	private final ArrayList<String> CLUBS= new ArrayList<String>(List.of("Barça","madrid"));
	private final ArrayList<String> JUGADORS= new ArrayList<String>(List.of("Fernando Torres","Benzema"));
	private final int LLIGACAMPS=0;
	private final int LLIGA=1;
	//CONSTRUCTOR
	public  NoticiaFutbol (String titular,String competicio,String club,String jugador) {
		super.titular=titular;
		this.competicio=competicio;
		this.club=club;
		this.jugador=jugador;
	}
	//MÈTODES CÀLCUL PREU I PUNTS
	@Override
	public void calcularPreuNoticia(){

		 preu=300;
		
		if (competicio.equalsIgnoreCase(COMPETICIONS.get(LLIGACAMPS))) {
			preu+=100;
		}
		if (Operacions.buscaString(club,CLUBS)) {
			preu+=100;
		}
		if(Operacions.buscaString(jugador,JUGADORS))
		{
			preu+=50;
		}
	}
		
		@Override
		
		public void calcularPuntsNoticia() {
			puntuacio=5;
			
			switch(COMPETICIONS.indexOf(competicio)) {
				case LLIGACAMPS:
					puntuacio+=3;
					break;
				case LLIGA:
					puntuacio+=2;
					break;
				default:
					System.out.println("Competició inexistent");
			}
			if (Operacions.buscaString(club,CLUBS)) {
				puntuacio+=1;
			}
			if(Operacions.buscaString(jugador,JUGADORS))
			{
				puntuacio+=1;
			}
			
		}
		
		

	

}
