import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            
            if (Character.isUpperCase(ch)) {
                char encryptedChar = (char) (((ch - 'A' + shift) % 26) + 'A');

                result.append(encryptedChar);
            } 
            else if (Character.isLowerCase(ch)) {
                char encryptedChar = (char) (((ch - 'a' + shift) % 26) + 'a');

                result.append(encryptedChar);
            }
            else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String decrypted = "";
        int shift = 1;
        
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();

        // Loop to attempt shift starting from 1
        while(!decrypted.equals("y")) {
            decrypt(text, shift);

            System.out.println("Shift: " + shift);
            System.out.println("Decrypted text: " + decrypt(text, shift));
            decrypted = scanner.nextLine();

            if(decrypted.equals("y")) {
                break;
            }
            else {
                shift = shift + 1;
            }
        }
        
        System.out.println("The final decrypted text is: " + text);
        
        scanner.close();
    }
}
