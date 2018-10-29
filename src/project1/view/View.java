package project1.view;

import project1.model.Entity.Candy;

import java.util.List;

/**
 * The type View.
 *
 * @param <T> the type parameter
 */
public class View<T extends Candy> implements Information{

    /**
     * Print message.
     *
     * @param message the message
     */
    public static void printMessage(String message) {
        System.out.print(message);
    }

    /**
     * Print message and result.
     *
     * @param message the message
     * @param value   the value
     */
    public void printMessageAndResult(String message, String value) {
        System.out.println(message + value);
    }

    /**
     * Print candies.
     *
     * @param list the list
     */
    public void printCandies(List<T> list){
        if (list.size() == 0){
            System.out.println(View.EMPTY_LIST);
        } else list.forEach(item -> System.out.println(item + " ,index = " + list.indexOf(item)));
    }
}
