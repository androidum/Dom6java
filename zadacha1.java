// Урок 6. Хранение и обработка данных ч3: множество коллекций Set.
// 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// 2. Создать множество ноутбуков.
// 3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
// Критерии фильтрации можно хранить в Map. Например: “Введите цифру, соответствующую необходимому критерию:
// - ОЗУ
// - Объем ЖД
// - Операционная система
// - Цвет …
package domash6;

import java.util.HashMap; // импорт коллекций
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class zadacha1 { 
    public static void main(String[] args) {

        System.out.println("\nЭта программа ищет модели ноутбуков подходящие по критериям.\n");

        Notebooks note1 = new Notebooks(
            "Lenovo",
            "Синий глянцевый", 
            "Windows11", 
            32, 
            1024, 
            54000);
        Notebooks note2 = new Notebooks(
            "MacBook", 
            "Розоватый перламутр", 
            "MacOS", 
            16, 
            512, 
            99999);
        Notebooks note3 = new Notebooks(
            "Dexp", 
            "Серый асфальт", 
            "Windows10", 
            4, 
            256, 
            15000);
        Notebooks note4 = new Notebooks(
            "HP", 
            "Бронзовый с патиной", 
            "Linux (Ubuntu)", 
            16, 
            1024, 
            85000);
        Notebooks note5 = new Notebooks(
            "Xhing-Chang", 
            "Натуральный пластик", 
            "FreeBSD (ch) (OEM)", 
            32,
            512, 
            1325);
        Notebooks note6 = new Notebooks(
            "Samsung", 
            "Черный благородный", 
            "Windows11", 
            64, 
            2048, 
            95000);

        Map<Integer, Notebooks> noteDataBase = new HashMap<>(); // инициализация hash-map "noteDataBase" 
        noteDataBase.put(1, note1);
        noteDataBase.put(2, note2);
        noteDataBase.put(3, note3);
        noteDataBase.put(4, note4);
        noteDataBase.put(5, note5);
        noteDataBase.put(6, note6);

        System.out.println("Что ищем? :");
        System.out.println("1 - Оперативная память (МБ)");
        System.out.println("2 - Объем жесткого диска (ГБ)");
        System.out.println("3 - Операционная система (Windows/MacOS/Linux/FreeBSD)");
        System.out.println("4 - Цвет корпуса");

        zadacha1.choice((HashMap<Integer, Notebooks>) noteDataBase);
    }

    public static void choice(HashMap<Integer, Notebooks> noteDataBase) {  // метод Выбор
        Scanner sc = new Scanner(System.in);
        Integer count = sc.nextInt();
        switch (count) {
            case (1): {                                                    // случай 1. 
                Set<Integer> choice = new TreeSet<>();
                for (int i = 1; i <= noteDataBase.size(); i++) {
                    Notebooks current = (Notebooks) noteDataBase.get(i);
                    choice.add(current.getRam());
                }
                System.out.println("В наличии ноутбуки с оперативной памятью (МБ): ");
                System.out.println(choice);
                System.out.println("Введите объем оперативной памяти: ");
                Integer count1 = sc.nextInt();
                Boolean flag = false;
                for (int i = 1; i <= noteDataBase.size(); i++) {
                    Notebooks current = (Notebooks) noteDataBase.get(i);
                    if (count1.equals(current.getRam())) {
                        printNote(current);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("Таких ноутбуков нет.");
                }
                break;
            }
            case (2): {                                                    // случай 2. 
                Set<Integer> choice = new TreeSet<>();
                for (int i = 1; i <= noteDataBase.size(); i++) {
                    Notebooks current = (Notebooks) noteDataBase.get(i);
                    choice.add(current.getHdd());
                }
                System.out.println("В наличии ноутбуки жестким диском (ГБ): ");
                System.out.println(choice);
                System.out.println("Введите объём жесткого дистка: ");
                Integer count1 = sc.nextInt();
                Boolean flag = false;
                for (int i = 1; i <= noteDataBase.size(); i++) {
                    Notebooks current = (Notebooks) noteDataBase.get(i);
                    if (count1.equals(current.getHdd())) {
                        printNote(current);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("Таких ноутбуков нет.");
                }
                break;
            }
            case (3): {                                                    // случай 3. 
                Set<String> choice = new TreeSet<>();
                for (int i = 1; i <= noteDataBase.size(); i++) {
                    Notebooks current = (Notebooks) noteDataBase.get(i);
                    choice.add(current.getOS());
                }
                System.out.println("В наличии ноутбуки с операционными системами: ");
                System.out.println(choice);
                System.out.println("Введите желаемую операционную систему: ");
                String count1 = sc.next();
                Boolean flag = false;
                for (int i = 1; i <= noteDataBase.size(); i++) {
                    Notebooks current = (Notebooks) noteDataBase.get(i);
                    if (count1.equals(current.getOS())) {
                        printNote(current);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("Таких ноутбуков нет.");
                }
                break;
            }
            case (4): {                                                    // случай 4. 
                Set<String> choice = new TreeSet<>();
                for (int i = 1; i <= noteDataBase.size(); i++) {
                    Notebooks current = (Notebooks) noteDataBase.get(i);
                    choice.add(current.getColour());
                }
                System.out.println("В наличии ноутбуки цвета: ");
                System.out.println(choice);
                System.out.println("Введите цвет: ");
                String count1 = sc.next();
                Boolean flag = false;
                for (int i = 1; i <= noteDataBase.size(); i++) {
                    Notebooks current = (Notebooks) noteDataBase.get(i);
                    if (count1.equals(current.getColour())) {
                        printNote(current);
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("Таких ноутбуков нет.");
                }
                break;
            }
        }
        sc.close();
    }

    public static void printNote(Notebooks current) {     // метод final
        System.out.printf("\n марка: %s , \n цвет: %s , \n операционная система: %s , \n оперативная память (МБ): %d ,  \n жесткий диск (ГБ): %d , \n цена (руб): %d . \n ",
                current.getProduct(), 
                current.getColour(), 
                current.getOS(),
                current.getRam(), 
                current.getHdd(), 
                current.getPrice());
    }
}

class Notebooks {
    int ram;
    int hdd;
    String os;
    String colour;
    String product;
    Integer price;
    
    public Notebooks(
        String noteProd, 
        String noteCol, 
        String noteOS, 
        Integer noteRam,  
        Integer noteHdd, 
        Integer notePrice) 
        {
        this.product = noteProd;
        this.colour = noteCol;
        this.os = noteOS;
        this.ram = noteRam;
        this.hdd = noteHdd;
        this.price = notePrice;
    }

    public String getProduct() {  
        return this.product;
    }

    public String getColour() {
        return this.colour;
    }

    public String getOS() {
        return this.os;
    }

    public Integer getRam() {
        return this.ram;
    }

    public Integer getHdd() {
        return this.hdd;
    }

    public Integer getPrice() {
        return this.price;
    }
}