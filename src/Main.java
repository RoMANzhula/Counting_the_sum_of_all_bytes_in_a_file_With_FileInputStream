import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String fileName = "pathToFile"; //створюємо змінну для шляху до файлу
        File file = new File("pathToFile2"); //створюємо новий файл, вказуючи шлях до нього
    
        sumOfAllBytesInFile(fileName);
        searchMaximumByte(fileName);
        searchMinimumByte(fileName);
        sortBytesAscending(fileName);
    
        writeDataToFile(file);
        writeDataToFileWithoutDeleteOldData(file);
        readDataAndPrintToTheConsole(file);
        readDataAndPrintToTheConsoleWithBufferedInputStream(file);
    }
    
    public static void sumOfAllBytesInFile(String pathToFile) { //метод для підрахунку всіх байтів в зазначеному файлі
    
        long containerForBytes = 0; //створюємо 64-бітний контейнер для підрахунку байтів
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { //створюємо потік для послідовного введення даних з файлу
            while (fileInputStream.available() > 0) { //поки в потоці є байти
                int dataForRead = fileInputStream.read(); //читаємо наступний байт
                containerForBytes += dataForRead; //додаємо байт до нашого контейнера
            }
    
        } catch (IOException ioException) { //ловимо виняток для потоку вводу/виводу
            ioException.printStackTrace(); //виводимо виняток у стек
        }
        System.out.println("The sum of all bytes in your file: " + containerForBytes); //виводимо суму всіх байтів у консоль
    }
    
    public static void searchMaximumByte(String pathToFile) { //метод для пошуку максимального байта в зазначеному файлі
        ArrayList<Long> arrayListForReadBytes = new ArrayList<>(); //створюємо колекцію для збереження байтів, прочитаних з файлу
    
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { //створюємо потік для вводу з файлу
            while (fileInputStream.available() > 0) { //запускаємо цикл поки є непрочитані байти
                long containerForBytes = fileInputStream.read(); //читаємо черговий байт
                arrayListForReadBytes.add(containerForBytes); //додаємо байт у список
            }
            System.out.println("This is the maximum byte in your file: " + Collections.max(arrayListForReadBytes)); //виводимо максимальний байт
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void searchMinimumByte(String pathToFile) { //метод для пошуку мінімального байта в зазначеному файлі
        ArrayList<Long> arrayListForReadBytes = new ArrayList<>(); //створюємо колекцію для збереження байтів, прочитаних з файлу
    
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { //створюємо потік для вводу з файлу
            while (fileInputStream.available() > 0) { //поки є непрочитані байти
                long containerForBytes = fileInputStream.read(); //читаємо черговий байт
                arrayListForReadBytes.add(containerForBytes); //додаємо байт у список
            }
            System.out.println("This is the minimum byte in your file: " + Collections.min(arrayListForReadBytes)); //виводимо мінімальний байт
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortBytesAscending(String pathToFile) { // метод для пошуку мінімального байта у вказаному файлі
        ArrayList<Long> arrayListForReadBytes = new ArrayList<>(); // створюємо колекцію типу ArrayList<Long> для зберігання байтів,
        // прочитаних з вказаного файлу
    
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { // створюємо потік для послідовного введення даних
            // з вказаного файлу в блоці try-with-resource (який автоматично звільняє ресурси, закриваючи потоки)
            while (fileInputStream.available() > 0) { // запускаємо цикл, поки (є ще непрочитані байти)
                long containerForBytes = fileInputStream.read(); // створюємо контейнер для байтів у вигляді змінної і читаємо
                // черговий байт у цю змінну
                arrayListForReadBytes.add(containerForBytes); // заповнюємо список байтами
            }
    
            Collections.sort(arrayListForReadBytes); // використовуємо метод sort() з класу Collections для сортування списку
            // в порядку зростання
            Set<Long> sortBytesForSet = new HashSet<>(arrayListForReadBytes); // створюємо Set, який забезпечить унікальність нашого списку байтів
            // тобто позбавить нас від повторюваних елементів
            arrayListForReadBytes.clear(); // очищаємо список всіх байтів
            arrayListForReadBytes.addAll(sortBytesForSet); // заповнюємо список байтами з Set
            System.out.print("Для вашої уваги, відсортовані байти з вашого файлу: "); // виводимо в консоль повідомлення
            for (long elementOfArray : arrayListForReadBytes) { // використовуємо for-each для виведення кожного елемента з нашого списку
                // вже відсортованих байтів
                System.out.print(elementOfArray + " "); // кожен елемент виводимо через пробіл
            }
    
        } catch (IOException e) { // ловимо виключення введення/виведення
            e.printStackTrace(); // виводимо стек для пойманого виключення
        }
    }
    
    public static void writeDataToFile(File pathToFile) { // метод, який записуватиме дані у вказаний файл
        try (FileOutputStream fileToOutputStream = new FileOutputStream(pathToFile)) { // в блоці try-with-resource створюємо потік
            // для запису даних у вказаний файл
            String dataForWriting = "Доброго ранку, мій друже!"; // створюємо рядок, який запишемо у файл
    
            fileToOutputStream.write(dataForWriting.getBytes()); // записуємо в файл рядок, перетворений на байти
    
        } catch (IOException e) { // ловимо виключення потоку введення/виведення
            e.printStackTrace(); // виводимо виключення в стек
        }
    }
    
    public static void writeDataToFileWithoutDeleteOldData(File pathToFile) { // метод, який дописуватиме дані у вказаний
        // файл, не стираючи вже існуючі дані
        try (FileOutputStream fileToOutputStream = new FileOutputStream(pathToFile, true)) { // в блоці try-with-resource створюємо потік
            // для запису даних у вказаний файл і вказуємо для boolean append значення true (за замовчуванням false),
            // що дозволить дописувати дані у файл, не стираючи вже існуючі дані
            String dataForWriting = "\n Добрий день, мій друже!\r\n"; // створюємо рядок, який допишемо в файл (з переносами
            // на нову стрічку)
    
            fileToOutputStream.write(dataForWriting.getBytes()); // записуємо в файл рядок, перетворений на байти
    
        } catch (IOException e) { // ловимо виключення потоку введення/виведення
            e.printStackTrace(); // виводимо виключення в стек
        }
        // закриття потоків в блоці try-with-resource виконується автоматично
    }
    
    public static void readDataAndPrintToTheConsole(File pathToFile) { // метод, який буде зчитувати дані з вказаного
        // файлу і виводити ці дані на консоль
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { // відкриваємо потік для введення (зчитування) даних
            // з вказаного файлу
            int containerForOneByte; // створюємо змінну-контейнер для побайтового зчитування
            while ((containerForOneByte = fileInputStream.read()) != -1) { // зчитуємо по одному байту в тимчасовий контейнер для одного
                // байта
                System.out.println((char) containerForOneByte); // виконуємо приведення типу до символу і виводимо кожен символ на консоль
            }
        } catch (IOException e) { // ловимо виключення потоку введення/виведення
            e.printStackTrace(); // виводимо виключення в стек
        }
        // закриття потоків в блоці try-with-resource виконується автоматично
    }
    
    public static void readDataAndPrintToTheConsoleWithBufferedInputStream(File pathToFile) { // метод, який буде зчитувати дані з вказаного
        // файлу і виводити ці дані на консоль швидше попереднього методу завдяки буферизації даних
        try (FileInputStream fileInputStream = new FileInputStream(pathToFile)) { // відкриваємо потік для введення (зчитування) даних
            // з вказаного файлу
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream); // розширюємо наш вхідний потік
            // до буферизованого потоку, в якому метод read() працює значно швидше
            int containerForOneByte; // створюємо змінну-контейнер для побайтового зчитування
            while ((containerForOneByte = bufferedInputStream.read()) != -1) { // зчитуємо по одному байту в тимчасовий контейнер для одного
                // байта
                System.out.println((char) containerForOneByte); // виконуємо приведення типу до символу і виводимо кожен символ на консоль
            }
        } catch (IOException e) { // ловимо виключення потоку введення/виведення
            e.printStackTrace(); // виводимо виключення в стек
        }
        // закриття потоків в блоці try-with-resource виконується автоматично
    }

}
