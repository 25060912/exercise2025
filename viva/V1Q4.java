 package viva;
import java.util.Scanner;

public class V1Q4 {
 
    public static void main (String[] args){
        /*Get Birth Date: Read the IC's YYMMDD part and print it as D/M/YYYY. (Remember 00-25 means 2000-2025 and 26-99 means 1926-1999).
Find Gender: Check the last digit. (Odd = Male, Even = Female).
Check Month Type: See if the birth month is "Long" (31 days) or "Short" (30 or 28/29 days).
Sum Digits: Add up all 12 digits of the IC number.
Find Lucky Winner:
If Male: He's lucky only if the sum is divisible by 5 AND he was born in a Short Month.
If Female: She's lucky only if the sum is divisible by 7 AND she was born in a Long Month.
Otherwise, the person is "Not Lucky.*/
Scanner obj = new Scanner(System.in);
        System.out.println("Enter IC number (YYMMDD-##-####) :");
        String ic = obj.nextLine();
        /// we need to change the format (YYMMDD-##-####) to (YYMMDD######) so we can read it as 
                                                            //01234567891011
        String noDash = ic.replace("-", "");
        
        //now we need to extract the year, month, day
        String ys = noDash.substring(0,2);
        String ms = noDash.substring(2,4);
        String ds = noDash.substring(4,6);
        
        //now we need to change the string to Int so we can compute it properly
        int year = Integer.parseInt(ys);
        int month = Integer.parseInt(ms);
        int day = Integer.parseInt(ds);
        
        //we want to display Remember 00-25 means 2000-2025 and 26-99 means 1926-1999).
        if(year<=25){
        year = 2000+year;
        }else{
        year = 1900 + year;
        }        //Find Gender: Check the last digit. (Odd = Male, Even = Female).
        String last = noDash.substring(noDash.length()-1); //noDash.length counts theres 12 but because string starts from 0.
            //the last digit is actualy 11 so we need to -1 
        int lastDigit = Integer.parseInt(last);
        
        //condition if male or female
        String gender;
        if (lastDigit%2==0){
        gender = "Female";
        }else{
        gender = "Male";
        }
        
        //Month Type: See if the birth month is "Long" (31 days) or "Short" (30 or 28/29 days).
        //long month, 1,3,5,7,8,10,12 short month, 2,4,6,9,11
        String monthType;
        
     
if ( month==2||month==4||month==6||month==9||month==11){
        monthType = "Short";
        }else{

        monthType = "Long";
        }
        
        //Sum Digits: Add up all 12 digits of the IC number.
        int total = 0;
        for(int i=0; i<noDash.length(); i++){
        char c = noDash.charAt(i);
        int digit = Integer.parseInt(String.valueOf(c));
        total += digit;
        }
        
        /*Find Lucky Winner:
        If Male: He's lucky only if the sum is divisible by 5 AND he was born in a Short Month.
        If Female: She's lucky only if the sum is divisible by 7 AND she was born in a Long Month.
        Otherwise, the person is "Not Lucky.*/
        
        String luck;
        
if ( gender.equals("Male")&& monthType.equals("Short")&& total % 5 == 0){
            luck = "Yes";
        }
        
else if (gender.equals("Female")&&monthType.equals("Long")&& total%7 == 0){
            luck = "Yes";
        }
        else{
            luck = "No";
        }
        
       
System.out.println("Birth Date: "+day+"/"+month+"/"+year);
        System.out.println("Gender: "+gender);
        System.out.println("Sum of Digits: "+total);
        System.out.println("Lucky Winner: "+luck);
    }
    
}
