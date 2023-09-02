import java.io.FileNotFoundException;

public class Task3 {
    public static void main(String[] args) throws Exception {
        /*
            try {
                int a = 90;
                int b = 3;
                System.out.println(a / b);                 // Не обработано возможное деление на 0
                printSum(23, 234);
                int[] abc = { 1, 2 };
                abc[3] = 9;
            } catch (Throwable ex) {                        //Родительский класс исключения использован перед дочерними
                System.out.println("Что-то пошло не так...");
            } catch (NullPointerException ex) {
                System.out.println("Указатель не может указывать на null!");
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Массив выходит за пределы своего размера!");
            }

        public static void printSum(Integer a, Integer b) throws FileNotFoundException { // Исключение никогда не будет проброшено
            System.out.println(a + b);
        }
        */
        try {
            int a = 90;
            int b = 3; // Можно передать 0 - отработает ArithmeticException
            System.out.println(a / b);
            printSum(23, 234); // Можно передать null - отработает NullPointerException
            int[] abc = { 1, 2 };
            abc[3] = 9; // отработает IndexOutOfBoundsException
        }
        catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }catch (ArithmeticException ex){
            System.out.println("Деление на ноль!");
        }
    }
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

}
