package upc.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	public  Date ObtnerFecha() throws ParseException {
		
		//int hora,minutos,segundos;
		//String fecha;
		Date fechaCreacion=null;
		 //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		  Calendar cal = Calendar.getInstance();
		 // fecha=dateFormat.format(cal.getTime());
		 // fecha=DateFormat.getDateInstance();
		 // fechaCreacion= dateFormat.parse(fecha);
		  
		  /*
		  hora =cal.get(Calendar.HOUR_OF_DAY);
		  minutos = cal.get(Calendar.MINUTE);
		  segundos = cal.get(Calendar.SECOND);
		  
		 */
		  //Date fechaCreacion = cal.getTime();
		  
		  
		   fechaCreacion = cal.getTime();
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
