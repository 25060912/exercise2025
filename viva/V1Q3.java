package viva;
import java.util.Scanner;

public class V1Q3 { 
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);

        String user = "";
        String pass = "";

        System.out.print("Enter username: ");
        user = k.nextLine();
        System.out.print("Enter password: ");
        pass = k.nextLine();
        if (user.length() >= 5 && user.length() <= 15) {
            if (user.charAt(0) >= 'a' && user.charAt(0) <= 'z') {
                boolean checkValidCharsUser = user.chars().allMatch(ch ->
                (ch >= 'a' && ch <= 'z') ||
                (ch >= '0' && ch <= '9') ||
                (ch == '_')
                );
                if (checkValidCharsUser) {
                    int passStrength = 0;
                    if (pass.length() >= 8) passStrength++;
                    if (pass.chars().anyMatch(ch -> ch >= 'A' && ch <= 'Z')) passStrength++;
                    if (pass.chars().anyMatch(ch -> ch >= 'a' && ch <= 'z')) passStrength++;
                    if (pass.chars().anyMatch(ch -> ch >= '0' && ch <= '9')) passStrength++;
                    if (pass.chars().anyMatch(ch -> ch == '!' || ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*')) passStrength++;
                    if (pass.chars().noneMatch(ch -> ch == ' ')) passStrength++;
                    if (!pass.toLowerCase().contains(user.toLowerCase())) passStrength++;

                    if (passStrength > 6)
                        System.out.println("Password Strength: Very Strong");
                    else if (passStrength > 5)
                        System.out.println("Password Strength: Strong");
                    else if (passStrength > 3)
                        System.out.println("Password Strength: Moderate");
                    else
                        System.out.println("Password Strength: Weak");
                }
            }
        }
        else System.out.println("Invalid username, try again");

    }
}
