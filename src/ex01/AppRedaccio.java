package ex01;

import java.util.Scanner;
import java.util.ArrayList;


public class AppRedaccio {
	static final double sou=1500;//Sou fix
	//A AQUEST ARRAY S'AMAGATZEMEN ELS REDACTORS
	static ArrayList<Redactor> redactors=new ArrayList<Redactor>();
	public static void main(String[] args) {
		 
	redaccio();	  

	}
	/*
	 * MÈTODE EN QUE ESTÀ EL MENÚ PRINCIPAL Y ES CRIDEN LES DIFERENTS OPERACIONS1
	 */
	static void  redaccio(){
		
		boolean sortir=false;
		int opcio=0;
		String dni="";
		
		Scanner input= new Scanner(System.in);
		while(!sortir) {
			System.out.println("1.- Introduir redactor.");
			System.out.println("2.- Eliminar redactor.");
			System.out.println("3.- Introduir notícia a un redactor.");
			System.out.println("4.- Eliminar notícia (ha de demanar redactor i titular de la notícia).");
			System.out.println("5.- Mostrar totes les notícies per redactor.");
			System.out.println("6.- Calcular puntuació de la notícia.");
			System.out.println("7.- Calcular preu-notícia.");
			System.out.println("8.- Sortir.");
			
			opcio=Input.inputInteger("Escull opció(1-8)");
			switch (opcio) {
			
			case 1:
				Redactor redactor=new Redactor(Input.inputString("Introdueix el nom:")
						 ,Input.inputDni("Introdueix DNI del redactor(0 per sortir):"), sou);
				if(!redactor.getDni().equals("0")) {
					Operacions.crearRedactor(redactors,sou,redactor);
					System.out.println("Redactor creat");
				}
				else {
					System.out.println("Operació no realitzada");
				}
					
				
				break;
			case 2:
				dni=Input.inputDni("Introdueix DNI del redactor(0 per sortir):");
				Operacions.eliminarRedactor(redactors,dni);
				break;
			case 3:
				dni=Input.inputDni("Introdueix DNI del redactor(0 per sortir):");
				Operacions.introNoticia( redactors,dni);
				break;
			case 4:
				Operacions.eliminaNoticia( redactors
						,Input.inputDni("Introdueix DNI del redactor(0 per sortir):")
						,Input.inputString("Introdueix el titular de la noticia"));
				break;
			case 5:
				Operacions.mostraNoticies(redactors);
				break;
			case 6:
				Operacions.calculaPuntuacio(redactors,Input.inputDni("Introdueix DNI del redactor(0 per sortir):")
						,Input.inputString("Introdueix el titular de la noticia"));
				
				break;
			case 7:
				Operacions.calculaPreu(redactors,Input.inputDni("Introdueix DNI del redactor(0 per sortir):")
						,Input.inputString("Introdueix el titular de la noticia"));
				break;
			case 8:
				sortir=true;
				System.out.println("Fi del programa");
				break;
			default:
				System.out.println("Opció incorrecte");
				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
