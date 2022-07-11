package ex01;
//CLASSE AMB ELS MÈTODES NECESSARIS PER FER LES OPERACIONS DEL MENÚ PRINCIPAL
import java.util.ArrayList;
import java.util.Scanner;


public class Operacions {
	
	/*
	 * CREA UN REDACTOR I EL DESA EN UN ARRAY DE OBJECTES REDACTOR
	 *  es passa com a paràmetre l'Array, al ser un pas per rferència el valor del array
	 *  quedarà modificat
	 */
	 static void crearRedactor(ArrayList <Redactor> redactors,double sou, Redactor redactor) {
			
			//Comproba si el redactor existeix
					
			if(buscaRedactor( redactor.getDni(),  redactors)<0) {
				redactors.add(redactor);
			}
			else {
				System.out.println("El redactor ja existeix");
			}
		}
	 
	 	/*
		 * ELIMINA  UN REDACTOR DE UN ARRAY DE OBJECTES REDACTOR
		 *  es passa com a paràmetre l'Array, al ser un pas per referència el valor del array
		 *  quedarà modificat
		 */

		static void eliminarRedactor( ArrayList<Redactor> redactors,String dni) {
			
			int index=buscaRedactor( dni,  redactors);
			if(index>-1) {
				redactors.remove(index);
			}
		}
		/*
		 * CREA UNA NOTÍCIA PER A UN REDACTOR
		 */
		static void introNoticia(ArrayList<Redactor> redactors,String dni) {
			int index=0;
			
			if((index=buscaRedactor(dni,redactors))>-1){
				
				redactors.get(index).setNoticia(dadesNoticia());
				
			}
			
		}
		/*
		 * ELIMINA UNA NOTÍCIA
		 * A partir d'un redactor i titular d'una notícia
		 */
		static void eliminaNoticia(ArrayList<Redactor> redactors, String dni,String titular) {
		
			//busca redactor
			int index=buscaRedactor(dni,redactors);
			if(index>=0) {
				
				int index2=buscaNoticia(titular,redactors.get(index));
				if (index2>=0) {
					redactors.get(index).getNoticies().remove(index2);
					System.out.println("La Notícia s'ha eliminat");
				}
				else {
					System.out.println("Notícia no trobada");
				}
			}

		}
		/*
		 * MOSTRA PER CONSOLA LES NOTÍCIES DE TOTS ELS REDACTORS
		 */
	
		static void mostraNoticies(ArrayList<Redactor> redactors) {
			
			for(Redactor s: redactors) {
				displayNoticiesRedactor(s);
			}
		}
		/*
		 * CALCULA ELS PUNTS D'UNA NOTÍCIA D'UN REDACTOR EN CONCRET
		 */
		static void calculaPuntuacio(ArrayList<Redactor> redactors,String dni, String titular) {
			Noticia noticia=retornaNoticia( redactors,dni,titular);
			noticia.calcularPuntsNoticia();
			System.out.println("Punts noticia: "+noticia.getPuntuacio());
		}
		/*
		 * CALCULA EL PREU D'UNA NOTÍCIA D'UN REDACTOR EN CONCRET
		 */
		static void calculaPreu(ArrayList<Redactor> redactors,String dni, String titular) {
			Noticia noticia=retornaNoticia( redactors,dni,titular);
			noticia.calcularPreuNoticia();
			System.out.println("Punts noticia: "+noticia.getPreu());
			
			
			}
		/*
		 * BUSCA UN REDACTOR DINS D'UN ARRAY DE OBLJECTES REDACTORS A PARTIR DEL SEU DNI
		 * Retorna la posició del Objecte redactor dins de l'Atrray de redactors,
		 * si el troba retorna -1
		 */
		static int buscaRedactor( String dni, ArrayList<Redactor> redactors) {
			int valor=-1;
			
			 valor =redactors.stream().filter(s-> s.getDni()
					.equalsIgnoreCase(dni)).findFirst().
					map(s->s.getDni().toUpperCase().indexOf(dni.toUpperCase())).orElse(-1);
	
			return valor;
		}
		/*
		 * BUSCA UNA NOTÍCIA D'UN REDACTOR EN CONCRET A PARTIR FEL DEU TITULAR
		 * Retorna l'índex corresponent a la notícia dins de l'array de notícies del
		 * redactor. Si no la troba retorna -1
		 */
		static int buscaNoticia( String titular,Redactor redactor) {
			return redactor.getNoticies().stream().filter(s->s.getTitular()
					.equalsIgnoreCase(titular)).findFirst().map(s->s.getTitular().toUpperCase()
					.indexOf(titular.toUpperCase())).orElse(-1);
			}
		/*
		 * MÈTODE PER INTRODUIR LES DADES D'UNA NOTICIA
		 * Titular, tipus, text
		 */
		static Noticia dadesNoticia() {
			
			boolean sortir=false;
			int opcio=0;
			Noticia noticia= new Noticia();
			Scanner input= new Scanner(System.in);
			
			String titular=Input.inputString("Introdueix el titular de la noticia:");
			
			while(!sortir) {
				
				System.out.println("1.- Noticia fútbol.");
				System.out.println("2.-	Noticia basquet.");
				System.out.println("3.- Noticia tenis.");
				System.out.println("4.- Noticia F1");
				System.out.println("5.- Noticia motociclisme");
				
				
				opcio=Input.inputInteger("Escull opció(1-7)");
				switch (opcio) {
				
				case 1:
					noticia=new NoticiaFutbol(titular,Input.inputString("Competició?")
							,Input.inputString("Club?"),Input.inputString("Jugador?"));
					sortir=true;
					break;
				case 2:
					noticia=new NoticiaBasquet(titular,Input.inputString("Competició?")
							,Input.inputString("Club?"));
					sortir=true;
					break;

				case 3:
					noticia=new NoticiaTenis(titular,Input.inputString("Tenista?"));
					sortir=true;;
					break;
				case 4:
					noticia=new NoticiaF1(titular, Input.inputString("Escuderia?"));
					sortir=true;
					break;
				case 5:
					noticia=new NoticiaMotociclisme(titular, Input.inputString("Equip?"));
					sortir=true;
					break;
				default:
					System.out.println("Opció incorrecta");
				}

			}
			String text=Input.inputString("Introdueix el text de la noticia:");
			noticia.setText(text);
			return noticia;
		}
		
		/*
		 * CALCULA LA PUNTUACIÓ D'UNA NOTÍCIA
		 */
		static void calculaPunts(Noticia noticia) {
				noticia.calcularPuntsNoticia();
				
		}
		
		/*
		 * MOSTRA PER CONSOLA LES NOTÍCIES D'UN REDACTOR
		 */
		static void displayNoticiesRedactor(Redactor redactor) {
			
			System.out.println("Redactor: "+redactor.getnom());
			for(Noticia s:redactor.getNoticies()) {
				System.out.println("Titular: "+s.getTitular());
				System.out.println("Text: "+s.getText());
			}
		}
		
	
		/*
		 * TORNA UN OBJECTE NOTICIA D'UN REDACTOR
		 */
		static Noticia retornaNoticia(ArrayList<Redactor> redactors,String dni,String titular) {
			Noticia noticia=new Noticia();
			int index=buscaRedactor( dni,  redactors);
			if(index>=0) {
				int index2=buscaNoticia(titular,redactors.get(index));
				if (index2>=0) {
					noticia= redactors.get(index).getNoticies().get(index2);
				}
			}
			return noticia;
		}
		/*
		 * COMPROVA SI HI HA UN STRING DINS D'UN ARRAY DE STRINGS
		 */
		static boolean buscaString(String string,ArrayList<String>strings) {
			
			return strings.contains(string.toLowerCase());
			
		}
}
