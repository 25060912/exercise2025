package viva;
import java.util.Scanner;

public class V1Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Entering the price for multiple items
        double price, subtotal = 0;
        int itemCount = 0;
        
        while (true){
            System.out.print("Enter item price (0 to finish):  ");
            price = input.nextDouble();
            
            if (price == 0){
                if (itemCount == 0){
                    System.out.println("You must enter at least ONE item!");
                    continue;
                }
                break;
            }
            
            if (price < 0){
                System.out.println("Invalid amount. Price cannot be negative. Please re-enter.");
                continue;
            }
            
            subtotal += price;
            itemCount++;
        }
        
        //Calculate SST based on subtotal
        double sstRate;
        
        if (subtotal <= 30){
            sstRate = 0.06;
        } else if (subtotal > 30 && subtotal <= 100){
            sstRate = 0.08;
        } else {
           sstRate = 0.10; 
        }
        
        double sst = subtotal * sstRate;
        double totalAfterTax = subtotal + sst;
        
        //Enter day and hour
        input.nextLine(); // clear newline buffer
        String day;
        
         while (true) {
            System.out.print("Enter day of week: ");
            day = input.nextLine().trim();

            if (day.matches("Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday")) {
                break;
            } else {
                System.out.println("Invalid day. Try again.");
            }
        }
                     
        int hour;
        
        while (true){
            System.out.print("Enter hour (24-hour format): ");
            hour = input.nextInt();
            
            if (hour >= 0 && hour <= 23){
                break;
            }
        
            System.out.println("Invalid hour. Try again.");
        }
        
        //Applying discounts
        
        double discStudent = 0, discHappyHour = 0, discWeekend = 0;
        double totalBeforeDisc = totalAfterTax;
                
        //Student Saver Discount
        if (day.matches("Monday|Tuesday|Wednesday|Thursday|Friday")){
            if (totalBeforeDisc > 25){
                discStudent = totalBeforeDisc * 0.10;
            }
        }
        
        double totalAfterStudent = totalBeforeDisc - discStudent;
        
        // Happy Hour  Discount
        if (day.matches("(?i)Monday|Tuesday|Wednesday|Thursday|Friday")) {
            if (hour >= 15 && hour <= 16) {
                discHappyHour = totalAfterStudent * 0.05;
             }
        }
        
        double totalAfterHappy = totalAfterStudent - discHappyHour;
        
        //Weekend Combo Discount
        if (day.matches("Saturday|Sunday")){
            if (subtotal >= 50){
                discWeekend = totalAfterHappy * 0.05;
            }
        }
        
        //Total discount applied
        double totalDisc = discStudent + discHappyHour + discWeekend;
        double finalAmount = totalBeforeDisc - totalDisc;
        
        //Membership cashback
        System.out.print("Is customer a member (Y/N)? ");
        char membership = input.next().charAt(0);
        
        double cashback = 0;
        
        if (membership == 'Y' || membership == 'y'){
            cashback = finalAmount * 0.02;
        }
        
        //Print receipt
        
        System.out.println("\n---- Kopi-Satu Receipt -----------");
        System.out.printf("Subtotal:%22sRM %.2f\n", "", subtotal);
        System.out.printf("Service Tax (%.0f%%):%13sRM %.2f\n", sstRate * 100, "", sst);
        System.out.printf("Total before discount:%9sRM %.2f\n", "", totalBeforeDisc);

        if (discStudent > 0)
            System.out.printf("Student Discount (10%%):%10sRM %.2f\n", "", discStudent);

        if (discHappyHour > 0)
            System.out.printf("Happy Hour Discount (5%%):%7sRM %.2f\n", "", discHappyHour);

        if (discWeekend > 0)
            System.out.printf("Weekend Combo Discount (5%%):%6sRM %.2f\n", "", discWeekend);

        System.out.println("----------------------------------");
        System.out.printf("Total Payable:%15sRM %.2f\n", "", finalAmount);

        if (cashback > 0)
            System.out.printf("Loyalty Cashback (2%%):%9sRM %.2f\n", "", cashback);

        System.out.println("----------------------------------");
        System.out.printf("Final Amount to Collect:%5sRM %.2f\n", "", finalAmount);
    }
}

