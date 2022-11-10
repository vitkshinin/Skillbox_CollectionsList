package practice;

import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        System.out.println("Введите команду LIST, ADD, EDIT или DELETE");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();
            if (input.equals("0")) {
                break;
            }
            int index = 0;

            String regex = "(.+?)(\\s+(\\d+)?(.+)?)?";
            String command = input.replaceAll(regex, "$1").trim();
            String indexStr = input.replaceAll(regex, "$3").trim();
            String todo = input.replaceAll(regex, "$4").trim();

            if (!indexStr.isEmpty()) {
                index = Integer.parseInt(indexStr);
            }
            switch (command) {
                case "ADD": {
                    if (index == 0) {
                        todoList.add(todo);
                        break;
                    } else {
                        todoList.add(index - 1, todo);
                        break;
                    }
                }
                case "EDIT":
                    todoList.edit(index - 1, todo);
                    break;
                case "DELETE":
                    todoList.delete(index - 1);
                    break;
                case "LIST":
                    todoList.getTodos();
                    break;
                default:
                    System.out.println("Введена неверная команда");
                    break;
            }
        }
    }
}
