import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CarCompany {
    private ArrayList<Car> cars;

    public CarCompany() {
        cars = new ArrayList<>();
    }
    public void read(){
        try {
            FileReader reader = new FileReader("Cars.txt");
            Scanner scan = new Scanner(reader);
            while (scan.hasNext()){
                String[] line = scan.nextLine().split(",");
                Car c = new Car(Integer.parseInt(line[0]),
                        line[1], LocalDate.parse(line[2]), LocalDate.parse(line[3]));
                if (line.length == 4)
                    cars.add(c);
                else{
                    c.ownTo(new Customer(line[4], line[5]));
                    cars.add(c);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void write(int index, Car c){
        this.cars.get(index).setStatus(c.getStatus());
        try {
            PrintWriter pw = new PrintWriter("Cars.txt");
            for (Car updateCar : cars) {
                pw.println(updateCar.toString());
            }
            pw.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void bookACar(int index, Customer c, int days){
        cars.get(index).setStatus("Booked");
        cars.get(index).ownTo(c);
        cars.get(index).setBookDate(LocalDate.now());
        cars.get(index).setReturnDate(LocalDate.now().plusDays(days));
        write(index, cars.get(index));
    }
    public int getACar(){
        for (int i = 0; i < cars.size(); i++){
            if (cars.get(i).getStatus().equalsIgnoreCase("Available")){
                return i;
            }
        }
        return -1;
    }
    public void returnACar(int id){
        boolean done = false;
        int index = -1;
        for (Car c : cars){
            if (c.getStatus().equalsIgnoreCase("Booked") && c.getId() == id) {
                c.setStatus("Available");
                c.setReturnDate(LocalDate.parse("0001-01-01"));
                c.setBookDate(LocalDate.parse("0001-01-01"));
                index = c.getId();
                done = true;
                break;
            }
        }
        if (done){
            System.out.println("Done");
            write(index, cars.get(index));
        }
        else{
            System.out.println("Car is already Available");
        }
    }
    public void availableCars(){
        for (Car c : cars){
            if (c.getStatus().equalsIgnoreCase("Available"))
                System.out.println(c);
        }
    }
    public void bookedCars(){
        for (Car c : cars){
            if (c.getStatus().equalsIgnoreCase("Booked"))
                System.out.println(c);
        }
    }
}
