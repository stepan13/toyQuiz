import model.Toy;
import model.ToyMachine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ToyMachine machine = new ToyMachine();
        fillRandom(machine);
        machine.printToys();
        runQuiz(machine);

    }

    private static void runQuiz(ToyMachine machine) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("quiz.txt", false);
            fileWriter.write(machine.getToysList());
            int i = 0;
            while (machine.getToysCount() > 0) {
                i++;
                Toy nextToy = machine.getNext();
                String str = "" + i + ": " + nextToy.toString() + "\n";
                fileWriter.write(str);
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Здесь заполняем автомат случайными игрушками.
     * Можно задать количество различных видов игрушек и максимально количество одного вида игрушки.
     * вероятность прописывается случайная
     * не стал писать какой-то интерфейс для работы с программой. программа просто выдает
     * файл с результатом розыгрыша. входные параметры можно задать в этой функции
     * @param machine
     */
    private static void fillRandom(ToyMachine machine) {
        int toysTypeCount = 3;
        int toysMaxCount = 50;
        int rate = 0;
        int count = 0;
        Random rnd = new Random();
        for (int i = 1; i <= toysTypeCount; i++) {
            rate = rnd.nextInt(101);
//            switch (i) {
//                case 1 -> {
//                    rate = 10;
//                }
//                case 2 -> {
//                    rate = 20;
//                }
//                default -> {
//                    rate = 70;
//                }
//            }
            Toy toy = new Toy(i, "Toy" + i, rate);
            count = 1 + rnd.nextInt(toysMaxCount);
            for (int c = 1; c <= count; c++) {
                machine.add(toy);
            }
        }
    }


}