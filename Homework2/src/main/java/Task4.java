import java.io.IOException;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                throw new IOException();
            }
        } catch (IOException e){
            System.out.println("Нельзя вводить пустую строку !");
        }

    }
}
