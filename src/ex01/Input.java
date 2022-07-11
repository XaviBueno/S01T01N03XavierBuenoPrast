package ex01;

//A AQUESTA CLASE ESTAN ELS MÈTODES PER ENTRADA DE DADES

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	
	/*METODE PER ENTRAR UN INTEGER
	 * Torna un senseer entrat pel teclat
	 * Comprova que el string correspon a un número
	 * Es passa com argument el missatge que es volgui
	 */
	static int inputInteger(String missatge) {
		Scanner input=new Scanner(System.in);
		int num=0;
		boolean correcte=false;
		while(!correcte) {
			try {
				System.out.println(missatge);
				num=input.nextInt();
				
			}catch(InputMismatchException e) {
				System.out.println("Introduir un número" );
			}
			correcte=true;
		}
		
		return num;
	}
	/*METODE PER ENTRAR UN INTEGER
	 * Torna un double entrat pel teclat
	 * Comprova que el string correspon a un número double
	 * Es passa com argument el missatge que es volgui
	 */
	static double inputDouble(String missatge1,String missatge2) {
		
		boolean correcte=false;
		double valor=0.0;
		System.out.println(missatge1);
		Scanner input= new Scanner(System.in);
		while(!correcte) {
			try {
				valor=input.nextDouble();
				correcte=true;
			}catch(InputMismatchException e) {
				System.out.println(missatge2);
				
			}
			
		}
		
		return valor;
		
		
	}
	
	/* MÈTODE PER ENTRAR UN DNI 1
	 * a
	 * 
	 * Torna un string amb el dni entrat
	 */
	 
	static String inputDni (String missatge) {
		
		boolean sortir=false;
		String dni="0";
		while(!sortir) {
			dni=inputString( missatge);
			if(dni.equals("0")) {
				sortir=true;
			}else if(dni.length()==9) {
				
					int numDni=Integer.valueOf(dni.substring(0,dni.length()-1));
					dni.charAt(dni.length()-1);
					if(lletraDni(numDni)!=dni.toUpperCase().charAt(dni.length()-1)) {
						System.out.println("DNI Incorrecte");
					}else {
						sortir=true;
					}
				
			}else {
				System.out.println("DNI Incorrecte");
			}
		}
		return dni;
		
	}
	//CALCULA LA LLETRA DEL DNI
	static char lletraDni(int dni) {
		int resto =dni%23;
		String lletras="TRWAGMYFPDXBNJZSQVHLCKE";
		return lletras.charAt(resto);
	}
	
	/*MÈTODE PER INTRODUIR UN STRING
	 * Es passa un missatge com paràmetre
	 */
	static String inputString( String missatge1) {
			
			
			String valor;
			System.out.println(missatge1);
			Scanner input= new Scanner(System.in);
			valor=input.nextLine();
			return valor;
	}
	
	
}
