
public class EventNotifier {

    private InterestingEvent ie;
    private boolean somethingHappened; 
    public EventNotifier (InterestingEvent event, boolean somethingHappened)
    {
    // Save the event object for later use.
    ie = event; 
    // Nothing to report yet.
    this.somethingHappened = somethingHappened;
    doWork();
    } 
    //...  
    public void doWork ()
    {
    // Check the predicate, which is set elsewhere.
    if (somethingHappened)
        {
        // Signal the even by invoking the interface's method.
        ie.interestingEvent ();
        }
    //...
    } 
   
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterestingEvent ie = new CallMe();
		//EventNotifier en = new EventNotifier(ie,true);

	}
    
}
