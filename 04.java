class Ticket{
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    Ticket(int ticketNumber, String customerName, int seatNumber){
        this.ticketNumber=ticketNumber;
        this.customerName=customerName;
        this.seatNumber=seatNumber;
    }

    public void setTicketNumber(int ticketNumber){
        this.ticketNumber=ticketNumber;
    }
    public void setCustomerName(String customerName){
        this.customerName=customerName;
    }
    public void setSeatNumber(int seatNumber){
        this.seatNumber=seatNumber;
    }

    public int getTicketNumber(){
        return ticketNumber;
    }
    public String getCustomerName(){
        return customerName;
    }
    public int getSeatNumber(){
        return seatNumber;
    }
}

class CinemaHall{
    int seatIndex=0;
    Ticket[] ticketArray=new Ticket[10];

    public void bookTicket(Ticket ticket){
        if(ticketArray[ticket.getSeatNumber()]==null){
            ticketArray[ticket.getSeatNumber()]=ticket;
        } 
		else{
            System.out.println("Not available");
        }
    }

    public void cancelTicket(int ticketNumber){
        boolean isFound=false;
        for(int i=0; i<10; i++){
            if(ticketArray[i]!= null){
                if(ticketArray[i].getTicketNumber()==ticketNumber){
                    ticketArray[i]=null;
                    isFound = true;
                }
            }
        }
        if(!isFound){
            System.out.println("Not found");
        }
    }

    public void displayDetails(){
        for(Ticket ticket:ticketArray){
            if(ticket!=null){
                System.out.println("Ticket Number: "+ticket.getTicketNumber()+" Customer Name: "+ticket.getCustomerName()+" Seat Number : "+ticket.getSeatNumber());
            }
        }
    }
}

class Main{

    public static void main(String[] args) {

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.bookTicket(new Ticket(1, "Saman", 1));
        cinemaHall.bookTicket(new Ticket(2, "Amara", 2));
        cinemaHall.bookTicket(new Ticket(3, "Wimal", 3));

        cinemaHall.cancelTicket(2);

        cinemaHall.bookTicket(new Ticket(4, "Sumana", 2));

        cinemaHall.displayDetails();
    }
}