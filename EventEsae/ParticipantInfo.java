package EventEsae;

public class ParticipantInfo {
    
   protected String participantId;
   protected String name;
   protected String email;
   protected  long phoneNumber;
//---------------------------------------------------------
   public void setparticipantId(String participantId){
    this.participantId=participantId;
   }

   public String getparticipantId(){
    return participantId;
   }
//-----------------------------------------------------------
 public void setname(String name){
    this.name=name;
   }

   public String getname(){
    return name;
   }
//-----------------------------------------------------------------
 public void setemail(String email){
    this.email=email;
   }

   public String getemail(){
    return email;
   }
//--------------------------------------------------------------------
    public void setphoneNumber(long phoneNumber){
    this.phoneNumber=phoneNumber;
   }

   public long getphoneNumber(){
    return phoneNumber;
   }
//----------------------------------------------------------------------------


  public ParticipantInfo( String participantId,String name,String email,long phoneNumber ){
  this.participantId=participantId;
  this.name=name;
  this.email=email;
  this.phoneNumber=phoneNumber;
   }
}
