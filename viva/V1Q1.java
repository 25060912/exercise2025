package viva;
import java.util.Scanner;

public class V1Q1 {
    public static void main(String[] args) {
        //Input test case
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the number of test cases: ");
        int testCases = input.nextInt();
        
        //Loop through all test cases
        
        for (int i = 1; i <= testCases; i++){
            System.out.println("\nEnter details for Case " + i);
            
            System.out.print("Enter days overdue: ");
            int days = input.nextInt();
            
            System.out.print("Enter book type (R/G/M/C/T): ");
            char type = input.next().charAt(0);
            
            System.out.print("Enter borrower type (S = Student, T = Staff): ");
            char borrower = input.next().charAt(0);
            
            System.out.print("Enter number of previous late returns (if any): ");
            int prevLate = input.nextInt();
            
            System.out.println("--- Case " + i + " ---");
            
            double fine = 0;
            
            //Base fine calculation
            
            switch (type){
                case 'R': //Reference books
                    fine = 100.00;
                    break;
                          
                case 'G': //General books
                    if (days >= 1 && days <= 7){
                        fine = days * 0.50;
                    } else if (days >= 8 && days <= 30){
                        fine = (7 * 0.50) + ((days  - 7) * 1.00); 
                    } else {
                        fine = (7 * 0.50) + (23 * 1.00) + ((days - 30) * 2.00);
                    }
                    break;
                    
                case 'M': //Magazine
                    fine = days * 0.20;
                    break;
                    
                case 'C': //CDs or DVDs
                    if (days <= 10){
                        fine = days * 2.00;
                    } else{
                        fine = (10 * 2.00) + ((days - 10) * 5.00);
                    }
                    break;
                    
                case 'T': //Thesis
                    fine = days * 10.00;
                    if (days > 15){
                        fine += 200.00;
                    }
                    break;
                    
                default:
                    System.out.println("Invalid book type.");
                   
            }
            
            //Additional penalties
            
            if (days > 60){
                fine += 25.00;
            }
            
            if (prevLate >= 3){
                fine += 10.00;
            }
            
            //Discounts (mutually exclusive)
            
            if (borrower == 'T'){
                fine *= 0.80;    //Staff gets 20% discount on final fine
            } else if (prevLate == 0 && days <= 3){
                fine *= 0.50; //Good borrower reward of 50% fine reduction
            }
            
            //Output
            System.out.printf("Total Fine: RM %.2f\n", fine);
        }
        
    }
    
}
