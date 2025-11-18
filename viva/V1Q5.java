package viva;

import java.util.Scanner;

public class V1Q5 {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
        System.out.print("Enter Original Message: ");
        String message = input.nextLine();

        System.out.println("Encoded Message:");

        for (int i = 0; i < message.length(); i++) {
            char a = message.charAt(i);

            int ascii = (int) a;
            //System.out.println(ascii);

            String binary8bit = String.format("%8s", Integer.toBinaryString(ascii)).replace(' ', '0');
            //System.out.println(binary8bit); 

            StringBuilder inverted = new StringBuilder();
            for (int j = 0; j < binary8bit.length(); j++) {
                char bit = binary8bit.charAt(j);
                inverted.append(bit == '0' ? '1' : '0');
            }
            //System.out.println(inverted);
            
            int encodedDecimal = Integer.parseInt(inverted.toString(), 2);
            System.out.print(encodedDecimal + " ");
        }

        input.close();
    }
}
