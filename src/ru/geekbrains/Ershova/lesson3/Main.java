package ru.geekbrains.Ershova.lesson3;

import java.util.Random;
import java.util.Scanner;


public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {
        //guessNumber();
        guessWord();
    }

    // 1. Написать программу, которая загадывает случайное число от 0 до 9,
    // и пользователю дается 3 попытки угадать это число.
    // При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное,
    // или меньше. После победы или проигрыша выводится запрос –
    // «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

    public static void guessNumber() {
        Scanner scanner = new Scanner(System.in);
        do {
            int number = random.nextInt(10);
            System.out.println("Угадай число от 0 до 9. У тебя 3 попытки");
            for (int count = 3; count > 0; count--) {
                System.out.println("Введи свой ответ: ");
                int userNumber = scanner.nextInt();
                if (userNumber == number) {
                    System.out.println("Ты угадал, молодец!");
                    break;
                }
                System.out.println(userNumber > number ? "Не угадал, твое число больше " : "Не угадал, твое число меньше");
                System.out.println((count - 1) > 0 ? "У тебя осталось " + (count - 1) + " попытки" : "Попытки закончились, ты проиграл. Загаданным числом было - " + number);
            }

            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        }

        while (scanner.nextInt() == 1);
        scanner.close();
    }

    // 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
    // "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
    // "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //Для сравнения двух слов посимвольно, можно пользоваться:
    //String str = "apple";
    //str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    //Играем до тех пор, пока игрок не отгадает слово.
    //Используем только маленькие буквы.

    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        int someWords = random.nextInt(words.length - 1);
        String word = words[someWords];
        System.out.println("Попробуй угадать слово");
        System.out.println(word);
        Scanner scaner = new Scanner(System.in);

        do {
            System.out.println("Введи свой ответ. Для выхода из игры нажми Enter");
            String answer = scaner.nextLine();
            if(answer.equals("")) break; // Выходим из игры, если надоест
            else if(word.equals(answer)){
                System.out.println("Ты угадал слово, молодец! Игра окончена");
                break;
            }

            char[] charAnswer = answer.toCharArray(); // Делаем подсказку для игрока
            for(int i = 0; i < word.length(); i++){
                if(i >= charAnswer.length) break;
                if(word.charAt(i) != charAnswer[i]) charAnswer[i] = "#";
            }
            StringBuilder comment = new StringBuilder(String.valueOf(charAnswer));
            for(int i = comment.length(); i < 15; i++) comment.append("#");
            System.out.println(comment);
        }
        while (true);
        scaner.close();

    }

}
