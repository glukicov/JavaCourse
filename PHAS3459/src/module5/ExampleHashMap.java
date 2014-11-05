/*package module5;

public class ExampleHashMap {

	HashMap<String, GregorianCalendar> myDates =
			new HashMap<String, GregorianCalendar>();
			// Insert using put(<KEY>,<VALUE>) :
			myDates.put("christmas",
			new GregorianCalendar(2007,Calendar.DECEMBER,25));
			myDates.put("birthday-john",
			new GregorianCalendar(2006,Calendar.AUGUST,22));
			myDates.put("birthday-jane",
			new GregorianCalendar(2006,Calendar.AUGUST,22));
			myDates.put("birthday-john",
			new GregorianCalendar(2006,Calendar.AUGUST,24));
			// DUPLICATE KEYS ARE NOT ALLOWED
			// Therefore in this example only 3 items remain since the same
			// key "birthday-john" was used twice:
			System.out.println(myDates.size());
			// The last pair to use the duplicate key is the only one that
			// remains in the HashMap.
	
	for (String event : myDates.keySet()) {
GregorianCalendar date = myDates.get(event);
System.out.println(event+" date : "+
date.get(Calendar.DAY_OF_MONTH)+"/"+
date.get(Calendar.MONTH)+"/"+
date.get(Calendar.YEAR));
}
}
*/