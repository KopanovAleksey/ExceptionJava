public class Task2 {

    public static void main(String[] args) {
/* Before
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;   // Переменная intArray не проинициализирована и может быть null
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {           // Не обработана ошибка выхода за пределы массива
            System.out.println("Catching exception: " + e);
        }
*/
// After
        try {
            int d = 0;
            int[] intArray = {1,2,1,1,1,1,1,1,1};
            double catchedRes1 =  intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
