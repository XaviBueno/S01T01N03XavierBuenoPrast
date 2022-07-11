package ex01;

import java.util.ArrayList;
public class Redactor {
	private String nom;
	private String dni;
	private double sou;
	private ArrayList<Noticia> noticies;
	
	public Redactor(String nom,String dni,double sou) {
		this.nom=nom;
		this.dni=dni;
		this.sou=sou;
		noticies= new ArrayList<Noticia>();
	}
	
	public Redactor(String nom,String dni) {
		this.nom=nom;
		this.dni=dni;
		
		
	}
	
	public void setNoticia(Noticia noticia) {
		noticies.add(noticia);
	}
	
	public String getnom() {
		return nom;
	}
	
	public ArrayList<Noticia> getNoticies(){
		return noticies;
	}
	public String getDni() {
		return dni;
	}
	
	
	
	
	
}
