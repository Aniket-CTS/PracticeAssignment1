package EventEsae;

public class Attendee extends ParticipantInfo {
    private double walletBalance;

//-----------------------------------------------------------------------
public void setwalletBalance(double walletBalance){
    this.walletBalance=walletBalance;
}

public double getwalletBalance(){
    return walletBalance;
}
//-------------------------------------------------------------------------
   public Attendee( String participantId,String name,String email,long phoneNumber,double walletBalance){
        super(participantId, name, email, phoneNumber);
  
  this.walletBalance=walletBalance;
   }
//----------------------------------------------------------------------------
double calculateBuyingCost(int ticketsToBuy, double pricePerTicket){
    double cost=ticketsToBuy * pricePerTicket;
    if (cost>walletBalance) {
        return -1;
        
    }
    else{
        return cost;
    }
}
    
}
