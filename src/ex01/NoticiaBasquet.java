package ex01;
/*
 * CLASSE NOTICIA DE BASQUET
 */
import java.util.ArrayList;
import java.util.List;

public class NoticiaBasquet extends Noticia {
	//ATRIBUTS
	private String competicio;
	private  String club;
	//CONSTANTS
	private final ArrayList<String> COMPETICIONS=new ArrayList<String>(List.of("eurolliga","acb"));
	private final ArrayList<String> EQUIPS=new ArrayList<String>(List.of("barça","madrid"));
	private final int EUROLLIGA=0;
	private final int ACB=1;
	
	//CONSTRUCTOR
	public NoticiaBasquet(String titular,String competicio,String club) {
		super.titular=titular;
		this.competicio=competicio;
		this.club=club;
	}
	
	//MÈTODES CÀLCUL PREU I PUNTS
	@Override
	public void  calcularPreuNoticia() {
		preu=250;
		
		if(Operacions.buscaString(competicio,COMPETICIONS)) {
			preu+=75;
		}
		if(Operacions.buscaString(club,EQUIPS)) {
			preu+=75;
		}
		
	}
	
	@Override
	public void  calcularPuntsNoticia() {
		puntuacio=4;
		int index;
		index=COMPETICIONS.indexOf(competicio);
		
		if(index>-1) {
			switch (index) {
				case EUROLLIGA:
					puntuacio+=3;
					break;
				case ACB:
					puntuacio+=2;
					break;
				default:
					System.out.println("Competició inexistent");
			}
		}
		if(Operacions.buscaString(club,EQUIPS)){
			puntuacio+=1;
		}
	}
		
			
			
		
		
		
		
		
	
	
}

	
