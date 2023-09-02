import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(getFloat());
    }

    public static float getFloat(){
        boolean isValid = false;
        float result = 0;
        while (!isValid) {
            try(Scanner scanner = new Scanner(System.in);) {
                System.out.println("Введите дробное число: ");
                String input = scanner.nextLine();
                result = Float.parseFloat(input);
                isValid = true;
            } catch (NumberFormatException e){
                System.err.println("Invalid input ! Please try again !");
            }
        }
        return result;
    }
}
