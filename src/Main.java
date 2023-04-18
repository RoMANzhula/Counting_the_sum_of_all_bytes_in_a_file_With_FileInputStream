import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileName = "pathToFile"; //создаем строковую переменную и инициализируем ее адресом(путем к) нашего файла, в
        //котором мы хотим посчитать байты
        long containerForBites = 0; //создаем 64-битный контейнер для подсчета байтов
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {//создаем поток для последовательного ввода данных
            //из указанного файла в блоке try-with-resource(который в свою очередь автоматически освобождает ресурсы, закрывая потоки)

            while (fileInputStream.available() > 0) { //будет выполнять цикл, пока в потоке для чтения есть еще байты
                int dataForRead = fileInputStream.read(); //считываем следующий байт
                containerForBites += dataForRead; //добавляем считанный байт в наш контейнер байтов
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println("The sum of all bytes in file: " + fileName + " = " + containerForBites);

    }
}