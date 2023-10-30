import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CarCompany carCompany = new CarCompany();
        carCompany.read();
        while (true){
            menu();
            int choice = input.nextInt();
            if (choice == 1){
                int index = carCompany.getACar();
                if (index == -1){
                    System.out.println("There is no Available car, Sorry");
                }
                else {
                    System.out.print("Enter name: ");
                    String name = input.next();
                    System.out.print("Enter address: ");
                    String address = input.next();
                    System.out.print("For how many days you want to keep this Car? ");
                    int days = input.nextInt();
                    carCompany.bookACar(index, new Customer(name, address), days);
                    System.out.println("Car has been booked");
                }
            }
            else if (choice == 2){
                System.out.println("Enter car id ");
                int id = input.nextInt();
                carCompany.returnACar(id);
            }
            else if (choice == 3)
                carCompany.availableCars();
            else if (choice == 4)
                carCompany.bookedCars();
            else if (choice == 5){
                carCompany.availableCars();
                carCompany.bookedCars();
            }
            else if (choice == 6)
                break;
            else
                System.out.println("Wrong choice");
        }
    }
    public static void menu(){
        System.out.println("1. Book a car");
        System.out.println("2. return a car");
        System.out.println("3. List all available cars");
        System.out.println("4. list all booked cars");
        System.out.println("5. list all cars");
        System.out.println("6. save and exit");
    }
}
