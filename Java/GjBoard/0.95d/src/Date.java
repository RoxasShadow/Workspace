/* Mette a disposizione i metodi per la gestione delle date tramite GregorianCalendar. */
import java.util.GregorianCalendar;
import java.util.Calendar;
public class Date {
	private Calendar calendar;
	
	Date() {
		calendar = new GregorianCalendar();
	}
	
	public int getGiorno() {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getMese() {
		return (calendar.get(Calendar.MONTH) + 1);
	}
	
	public int getAnno() {
		return calendar.get(Calendar.YEAR);
	}
	
	public int getOra() {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	public int getMinuto() {
		return calendar.get(Calendar.MINUTE);
	}
}
