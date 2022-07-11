package ex01;
import java.util.ArrayList;

/*
 * CLASSE NOTICIA
 */
public  class Noticia {
	//ATRIBUTS
	protected String titular;
	protected String text;
	protected int puntuacio;
	protected double preu;
	
	//CONSTRUCTOR
	public Noticia() {}
	
	//GETTERS & SETTERS
	public String getTitular() {
		return titular;
	}
	public int getPuntuacio() {
		return puntuacio;
	}
	
	public String getText() {
		return text;
	}
	
	public double getPreu() {
		return preu;
	}
	
	public void setText(String text) {
		
		this.text=text;
		
	}
	
	//METODE PER CALCULAR UN PREU DE UNA NOTICIA
	
	public  void calcularPreuNoticia() {
		
	}
	//METODE PER CALCULAR UN PREU DE UNA NOTICIA
	
	public  void calcularPuntsNoticia() {
		
	}
	
}
	
		
		
	
	
	

