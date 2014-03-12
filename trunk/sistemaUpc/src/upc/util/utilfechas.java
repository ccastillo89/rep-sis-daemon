package upc.util;
import java.util.Calendar;
import java.sql.Date;
public class utilfechas {
	
	public static Date getFecha(int dia, int mes, int anio) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH,dia);
        cal.set(Calendar.MONTH,mes);
        cal.set(Calendar.YEAR,anio);
        Date d = (Date) cal.getTime();
        return d;        
    }  

}
