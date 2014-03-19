package upc.util;

import java.util.Calendar;
import java.util.Date;

import upc.modelo.Publicacion;

public class Utilitarios {
	
	public static Date ingresarFecha(int dia, int mes, int anio) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,dia);
        cal.set(Calendar.MONTH,mes);
        cal.set(Calendar.YEAR,anio);
        Date d = cal.getTime();
        return d;        
    }  
	
	public  Date ObtnerFecha() {
		 
		  Calendar cal = Calendar.getInstance();
		  Date fechaCreacion = cal.getTime();
		  return fechaCreacion;
		  		  
		 } 

	public boolean validarDatosIncompletos(Publicacion pub){
        boolean estadovalido=true ;
        if (pub.getTitulo().isEmpty()  ){
        	estadovalido =false;          
       }
        if (pub.getDescripcion().isEmpty() ){
        	estadovalido =false;          
         }
        if (pub.getArchivo().isEmpty() ){
        	estadovalido =false;          
         }
        if (pub.getUsuario() == null ){
        	estadovalido =false;          
         }
        if (pub.getPalabraClave().isEmpty() ){
        	estadovalido =false;          
         }
       
        return estadovalido;
        
    }  
	/*	
	public boolean validarPalabras(Publicacion pub){
        boolean estadovalido=true ;
      
        if (pub.getPalabraClave().isEmpty() ){
        	estadovalido =false;          
         }
       return estadovalido;
        
    }  
	*/
}
