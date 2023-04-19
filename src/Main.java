import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String fileName = "pathToFile"; //создаем строковую переменную и инициализируем
        // ее адресом(путем к) нашего файла
        File file = new File("pathToFile2"); //создаем новый файл (указываем путь к нему)

        sumOfAllBytesInFile(fileName);
        searchMaximumByte(fileName);
        searchMinimumByte(fileName);
        sortBytesAscending(fileName);

        writeDataToFile(file);
        writeDataToFileWithoutDeleteOldData(file);
        readDataAndPrintToTheConsole(file);
        readDataAndPrintToTheConsoleWithBufferedInputStream(file);
    }

    public static void sumOfAllBytesInFile(String pathToFile) { //метод для подсчета всех байтов в указанном файле

        long containerForBytes = 0; //создаем 64-битный контейнер для подсчета байтов
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) {//создаем поток для последовательного ввода данных
            //из указанного файла в блоке try-with-resource(который в свою очередь автоматически освобождает ресурсы, закрывая потоки)

            while (fileInputStream.available() > 0) { //будет выполнять цикл, пока в потоке для чтения есть еще байты
                int dataForRead = fileInputStream.read(); //считываем следующий байт
                containerForBytes += dataForRead; //добавляем считанный байт в наш контейнер байтов
            }

        } catch (IOException ioException) { //ловим исключение для входного/выходного потока
            ioException.printStackTrace(); //выводим исключение в стек
        }
        System.out.println("The sum of all bytes in your file: " + containerForBytes); //выводим в консоль данные
    }

    public static void searchMaximumByte(String pathToFile) { //метод для поиска максимального байта в указанном файле
        ArrayList<Long> arrayListForReadBytes = new ArrayList<>(); //создаем коллекцию типа интерфейса ArrayList<Long> для хранения байтов,
        //прочитанных из указанного файла

        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { //создаем поток для последовательного ввода данных
            //из указанного файла в блоке try-with-resource(который в свою очередь автоматически освобождает ресурсы, закрывая потоки)
            while (fileInputStream.available() > 0) { //запускаем цикл пока(есть еще непрочитанные байты)
                long containerForBytes = fileInputStream.read();//создаем контейнер для байтов в виде переменной и читаем
                // очередной байт в данную переменную
                arrayListForReadBytes.add(containerForBytes);//заполняем список байтами
            }
            System.out.println("This is the maximum byte in your file: " + Collections.max(arrayListForReadBytes));//выводим в консоль -
            // функция super-класс Коллекции - вывести максимальное число(из коллекции)

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchMinimumByte(String pathToFile) { //метод для поиска минимального байта в указанном файле
        ArrayList<Long> arrayListForReadBytes = new ArrayList<>(); //создаем коллекцию типа интерфейса ArrayList<Long> для хранения байтов,
        //прочитанных из указанного файла

        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { //создаем поток для последовательного ввода данных
            //из указанного файла в блоке try-with-resource(который в свою очередь автоматически освобождает ресурсы, закрывая потоки)
            while (fileInputStream.available() > 0) { //запускаем цикл пока(есть еще непрочитанные байты)
                long containerForBytes = fileInputStream.read();//создаем контейнер для байтов в виде переменной и читаем
                // очередной байт в данную переменную
                arrayListForReadBytes.add(containerForBytes);//заполняем список байтами
            }
            System.out.println("This is the minimum byte in your file: " + Collections.min(arrayListForReadBytes));//выводим в консоль -
            // функция super-класс Коллекции - вывести минимальное число(из коллекции)

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void sortBytesAscending(String pathToFile) { //метод для поиска минимального байта в указанном файле
        ArrayList<Long> arrayListForReadBytes = new ArrayList<>(); //создаем коллекцию типа интерфейса ArrayList<Long> для хранения байтов,
        //прочитанных из указанного файла

        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { //создаем поток для последовательного ввода данных
            //из указанного файла в блоке try-with-resource(который в свою очередь автоматически освобождает ресурсы, закрывая потоки)
            while (fileInputStream.available() > 0) { //запускаем цикл пока(есть еще непрочитанные байты)
                long containerForBytes = fileInputStream.read();//создаем контейнер для байтов в виде переменной и читаем
                // очередной байт в данную переменную
                arrayListForReadBytes.add(containerForBytes);//заполняем список байтами
            }

            Collections.sort(arrayListForReadBytes); //используем супер-класса Collections метод sort() сортировки указанного
            // списка в порядке возрастания
            Set<Long> sortBytesForSet = new HashSet<>(arrayListForReadBytes); //создаем Сэт, который обеспечит нашему списку байтов
            //уникальность, т.е. избавит нас то повторяющихся экземпляров
            arrayListForReadBytes.clear(); //очищаем наш список всех байтов
            arrayListForReadBytes.addAll(sortBytesForSet); //заполняем наш список всех байтов значениями из Сэта
            System.out.print("For your attention sorted bytes from your file: "); //в консоль выводим литерал
            for (long elementOfArray : arrayListForReadBytes) { //используем or-each для вывода каждого элемента из нашего списка
                //уже отсортированных байтов
                System.out.print(elementOfArray + " "); //каждый элемент выводим их через пробел
            }

        } catch (IOException e) { //ловим исключения входного/выходного потока
            e.printStackTrace(); //выводим стек для пойманного исключения
        }
    }

    public static void writeDataToFile(File pathToFile) { //метод, который будет писать данные в указанный файл
        try (FileOutputStream fileToOutputStream = new FileOutputStream(pathToFile)) { //в блоке try-with-resource мы создаем поток
            //для записи(вывода) данных в указанный файл
            String dataForWriting = "Good morning my friend!"; //создаем строку, которую мы запишем в файл

            fileToOutputStream.write(dataForWriting.getBytes()); //пишем в файл строку, преобразованную в баты

        } catch (IOException e) { //ловим исключения входящего/исходящего потока
            e.printStackTrace(); //выводим исключение в стек
        }
    }

    public static void writeDataToFileWithoutDeleteOldData(File pathToFile) { //метод, который будет дописывать данные в указанный
        //файл, при этом не стирая уже существующие данные
        try (FileOutputStream fileToOutputStream = new FileOutputStream(pathToFile, true)) { //в блоке try-with-resource мы создаем поток
            //для записи(вывода) данных в указанный файл и указываем для boolean append значение = true (по умолчанию false),
            //что позволит дописать данные в файл, при этом не стирая уже существующие данные в файле
            String dataForWriting = "\n Good afternoon my friend!\r\n"; //создаем строку, которую мы допишем в файл (с переносами
            //на новую строку)

            fileToOutputStream.write(dataForWriting.getBytes()); //пишем в файл строку, преобразованную в баты

        } catch (IOException e) { //ловим исключения входящего/исходящего потока
            e.printStackTrace(); //выводим исключение в стек
        }
        //закрытие потоков в блоке try-with-resource выполняется автоматически
    }

    public static void readDataAndPrintToTheConsole(File pathToFile) { //метод, который будет считывать данные из указанного
        //файла и выводить эти данные на консоль
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { //открываем поток для ввода(считывания) данных
            //из указанного файла
            int containerForOneByte; //создаем переменную-контейнер для побайтового считывания
            while ((containerForOneByte = fileInputStream.read()) != -1) { //считываем по одному байту во временный контейнер для одного
                //байта
                System.out.println((char) containerForOneByte); //выполняем приведение типа к символу и выводим каждый символ в консоль
            }
        } catch (IOException e) { //ловим исключения входящего/исходящего потока
            e.printStackTrace(); //выводим исключение в стек
        }
        //закрытие потоков в блоке try-with-resource выполняется автоматически
    }

    public static void readDataAndPrintToTheConsoleWithBufferedInputStream(File pathToFile) { //метод, который будет считывать данные из указанного
        //файла и выводить эти данные на консоль быстрее предидущего метода за счет буферизации данных
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { //открываем поток для ввода(считывания) данных
            //из указанного файла
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream); //расширяем наш входной поток
            //до буферизированного потока, в котором метод read() работает в разы быстрее
            int containerForOneByte; //создаем переменную-контейнер для побайтового считывания
            while ((containerForOneByte = bufferedInputStream.read()) != -1) { //считываем по одному байту во временный контейнер для одного
                //байта
                System.out.println((char) containerForOneByte); //выполняем приведение типа к символу и выводим каждый символ в консоль
            }
        } catch (IOException e) { //ловим исключения входящего/исходящего потока
            e.printStackTrace(); //выводим исключение в стек
        }
        //закрытие потоков в блоке try-with-resource выполняется автоматически
    }
}