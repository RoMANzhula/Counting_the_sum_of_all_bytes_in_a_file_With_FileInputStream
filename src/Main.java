import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Admin\\Desktop\\Diploma\\Technologies.txt"; //создаем строковую переменную и инициализируем ее адресом(путем к) нашего файла, в
        //котором мы хотим посчитать байты
        sumOfAllBytesInFile(fileName);
        searchMaximumByte(fileName);
        searchMinimumByte(fileName);
    }

    public static void sumOfAllBytesInFile(String pathToFile) { //метод для подсчета всех байтов в указанном файле

        long containerForBites = 0; //создаем 64-битный контейнер для подсчета байтов
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) {//создаем поток для последовательного ввода данных
            //из указанного файла в блоке try-with-resource(который в свою очередь автоматически освобождает ресурсы, закрывая потоки)

            while (fileInputStream.available() > 0) { //будет выполнять цикл, пока в потоке для чтения есть еще байты
                int dataForRead = fileInputStream.read(); //считываем следующий байт
                containerForBites += dataForRead; //добавляем считанный байт в наш контейнер байтов
            }

        } catch (IOException ioException) { //ловим исключение для входного/выходного потока
            ioException.printStackTrace(); //выводим исключение в стек
        }
        System.out.println("The sum of all bytes in your file: " + containerForBites); //выводим в консоль данные
    }

    public static void searchMaximumByte(String pathToFile) { //метод для поиска максимального байта в указанном файле
        ArrayList<Long> arrayList = new ArrayList<>(); //создаем коллекцию типа интерфейса ArrayList<Long> для хранения байтов,
        //прочитанных из указанного файла

        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { //создаем поток для последовательного ввода данных
            //из указанного файла в блоке try-with-resource(который в свою очередь автоматически освобождает ресурсы, закрывая потоки)
            while (fileInputStream.available() > 0) { //запускаем цикл пока(есть еще непрочитанные байты)
                long containerForBytes = fileInputStream.read();//создаем контейнер для байтов в виде переменной и читаем
                // очередной байт в данную переменную
                arrayList.add(containerForBytes);//заполняем список байтами
            }
            System.out.println("This is the maximum byte in your file: " + Collections.max(arrayList));//выводим в консоль -
            // функция super-класс Коллекции - вывести максимальное число(из коллекции)

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchMinimumByte(String pathToFile) { //метод для поиска минимального байта в указанном файле
        ArrayList<Long> arrayList = new ArrayList<>(); //создаем коллекцию типа интерфейса ArrayList<Long> для хранения байтов,
        //прочитанных из указанного файла

        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { //создаем поток для последовательного ввода данных
            //из указанного файла в блоке try-with-resource(который в свою очередь автоматически освобождает ресурсы, закрывая потоки)
            while (fileInputStream.available() > 0) { //запускаем цикл пока(есть еще непрочитанные байты)
                long containerForBytes = fileInputStream.read();//создаем контейнер для байтов в виде переменной и читаем
                // очередной байт в данную переменную
                arrayList.add(containerForBytes);//заполняем список байтами
            }
            System.out.println("This is the minimum byte in your file: " + Collections.min(arrayList));//выводим в консоль -
            // функция super-класс Коллекции - вывести минимальное число(из коллекции)

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}