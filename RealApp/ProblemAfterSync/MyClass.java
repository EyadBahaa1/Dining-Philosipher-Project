public class MyClass {
    public static void main(String args[])
    {
       RoomBooking obj=new RoomBooking();
           
           Thread thread1=new Thread(obj,"Client1 ");
           Thread thread2=new Thread(obj,"Client2 ");
           
           thread1.start();
           thread2.start();
           
    }
 
}






class RoomBooking implements Runnable{
    int RoomsAvailable=1;
    
    public void run(){
           
           System.out.println("Waiting to book Room for : "+Thread.currentThread().getName());
           synchronized (this) {
                  if(RoomsAvailable>0){
                        System.out.println("Booking Room for : "+Thread.currentThread().getName());
                        
                        //Let's say system takes some time in booking Room (here we have taken 1 second time)
                        try{
                               Thread.sleep(1000); 
                        }catch(Exception e){}
                          
                        RoomsAvailable--;
                        System.out.println("Room BOOKED for : "+ Thread.currentThread().getName());
                        System.out.println("currently RoomsAvailable = "+RoomsAvailable);
                  }
                  else{
                        System.out.println("Room NOT BOOKED for : "+ 
                                  Thread.currentThread().getName());
                  }
                  
           }//End synchronization block
           
           
    }
    
}