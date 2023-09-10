import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Program {

    public static void main(String[] args) {
        String data = getData();
        while (!validData(data)){
            data = getData();
        }
        writeData(data);

    }

    private static void writeData(String data) {
        String fileName = "C:\\Users\\User\\Desktop\\Exception\\FinalTask\\src\\main\\java\\" + data.split(" ")[0] + ".txt";
        try (Writer writer = new FileWriter(fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)){
            String newDataFormat = (Arrays.stream(data.split(" "))
                    .map(s -> {
                        return String.format("<%s>", s);
                    }).collect(Collectors.joining()));
            writer.write(newDataFormat + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getData(){
        System.out.println("Введите следующие данные, разделенные пробелом:\n" +
                "Фамилия Имя Отчество датарождения номертелефона пол");
        Scanner scanner= new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean validData(String data){
        boolean validData;
        try {
            String[] dataArray = data.split(" ");
            if (dataArray.length != 6){
                throw new IOException("Данные введены некорректно !");
            }
            String firstName = dataArray[0];
            String secondName = dataArray[1];
            String patronymicName = dataArray[2];
            String birthDate = validateBirthDate(dataArray[3]);
            Long phoneNumber = Long.parseLong(dataArray[4]);
            char sex = validateSex(dataArray[5]);
            validData = true;
        }catch (NumberFormatException | IOException | NullPointerException e){
            e.printStackTrace();
            validData = false;
        }
        return validData;
    }
    public static String validateBirthDate(String birthDate) throws NumberFormatException, IOException {
            List<String> date = List.of(birthDate.split("\\."));
            if(date.size() != 3){
                throw new IOException("Введена некорректная дата рождения!");
            }
            birthDate = Arrays.toString(date.stream()
                    .map(Integer::parseInt)
                    .toArray());
        return birthDate;
    }
    public static char validateSex(String sex) throws IOException {
        char[] chars = sex.toCharArray();
        if (chars.length > 1 ) {
            throw new IOException("Пол обозначается одной буквой ! (m/f)");
        }
        if (chars[0] == 'm' || chars[0] == 'f') {
            return chars[0];
        }
        else throw new IOException("Пол обозначается одной буквой ! (m/f)");
    }

}
