import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> shoppList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию: ");
            System.out.println("1. Добавить");
            System.out.println("2. Показать");
            System.out.println("3. Удалить");
            System.out.println("4. Найти");

            String input = scanner.nextLine();

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    String productName = scanner.nextLine();
                    shoppList.add(productName); //добавляем продукт в список
                    System.out.println("Итого в списке покупок: " + shoppList.size()); //итоговое кол-во покупок
                    break;
                case 2:
                    getShoppList(shoppList);
                    break;
                case 3:
                    getShoppList(shoppList);
                    System.out.println("Какую хотите удалить? Введите номер или название: ");
                    if (scanner.hasNextInt()) {
                        int numbDel = scanner.nextInt();
                        System.out.println("Покупка " + shoppList.get(numbDel - 1) + " удалена.");
                        shoppList.remove(numbDel - 1);
                        getShoppList(shoppList);
                    } else {
                        String textDel = scanner.nextLine();
                        System.out.println("Покупка " + textDel + " удалена.");
                        shoppList.remove(textDel);
                        getShoppList(shoppList);
                    }
                    break;
                case 4:
                    System.out.println("Введите текст для поиска: ");
                    String queryLower = scanner.nextLine().toLowerCase();
                    System.out.println("Найдено: ");
                    int match = 0;

                    for (int i = 0; i < shoppList.size(); i++) {
                        String itemLower = shoppList.get(i).toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            match++;
                            System.out.println((i + 1) + ". "  + shoppList.get(i));
                        }
                    }
                    if (match == 0) {
                        System.out.println("Совпадений не найдено!");
                    }
                    break;
            }
        }

    }

    static void getShoppList(ArrayList<String> shoppList) {
        System.out.println("Список покупок: ");
        for (int i = 0; i < shoppList.size(); i++) {
            System.out.println((i + 1) + ". " + shoppList.get(i));
        }
    }
}
