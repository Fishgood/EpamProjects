package project1.view;

import project1.model.Entity.Candy;

import java.util.List;

public class View<T extends Candy> implements Information{

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessageAndResult(String message, String value) {
        System.out.println(message + value);
    }

    public void printCandies(List<T> list){
        if (list.size() == 0){
            System.out.println(View.EMPTY_LIST);
        } else list.forEach(item -> System.out.println(item + " ,index = " + list.indexOf(item)));
    }
}
