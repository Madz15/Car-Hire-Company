import java.time.LocalDate;
public class Car {
    private int id;
    private Customer customer;
    private String status;
    private LocalDate bookDate;
    private LocalDate returnDate;

    public Car(int id, String status, LocalDate bookDate, LocalDate returnDate) {
        this.id = id;
        this.status = status;
        this.bookDate = bookDate;
        this.returnDate = returnDate;
        this.customer = new Customer("None", "None");
    }
    public void ownTo(Customer c){
        this.customer.setAddress(c.getAddress());
        this.customer.setName(c.getName());
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getBookDate() {
        return bookDate;
    }

    public void setBookDate(LocalDate bookDate) {
        this.bookDate = bookDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        if (status.equalsIgnoreCase("Available"))
            return id+","+status+","+bookDate+","+returnDate;
        else
            return id+","+status+","+bookDate+","+returnDate+","+customer.getName()+","+customer.getAddress();
    }
}
