package EventEsae;

public class Organizer extends ParticipantInfo{
    private int ticketsAvailable;

//---------------------------------------------------------------------
  public void setticketsAvailable(int ticketsAvailable){
    this.ticketsAvailable=ticketsAvailable;
   }

   public int getticketsAvailable(){
    return ticketsAvailable;
   }
//--------------------------------------------------------------------
     public Organizer( String participantId,String name,String email,long phoneNumber,int ticketsAvailable){
        super(participantId, name, email, phoneNumber);
  
  this.ticketsAvailable=ticketsAvailable;
   }
//-------------------------------------------------------------------------
double calculateSellingRevenue(int ticketsToSell, double pricePerTicket){

double revenue =ticketsToSell * pricePerTicket;
    if (ticketsToSell>ticketsAvailable){
    return -1;
}
else{
return revenue;
}
}

}
