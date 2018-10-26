package project1.Utility;

import project1.model.Entity.Candy;
import project1.view.View;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class InputUtility {

    private static Scanner sc = new Scanner(System.in);

    public int inputInt(){
        View.printMessage(View.INPUT_VALUE);
        while (!sc.hasNextInt()) {
            View.printMessage(View.WRONG_INPUT);

            sc.next();
        }
        return sc.nextInt();
    }

    public int inputIntBetween(int end){
        View.printMessage(View.INPUT_VALUE);
        while (!sc.hasNextInt() && !(sc.nextInt() >= 0) && !(sc.nextInt() <= end)) {
            View.printMessage(View.WRONG_INPUT);

            sc.next();
        }
        return sc.nextInt();
    }

    public String inputString(){
        return sc.next().trim();
    }

    public boolean checkRepeat(String ch){
        System.out.println("If want to add ome more - press " + ch);
        return sc.next().equals(ch);
    }

    public static ArrayList<String> inputParameter(Object fields) {
        View.printMessage("Enter next params: ");
        String line;
        ArrayList<String> inputsArray = new ArrayList<>();
        Field[] superClass = fields.getClass().getSuperclass().getDeclaredFields();
        Field[] subClass = fields.getClass().getDeclaredFields();
        //Field[] temp = Item.class.getDeclaredFields();

        do {
            if (inputsArray.size() < superClass.length) {
                View.printMessage("Enter " + superClass[inputsArray.size()].getName());
            } else
                View.printMessage("Enter " + subClass[inputsArray.size() - subClass.length].getName());

            line = sc.next();
            inputsArray.add(line.trim());

        } while (inputsArray.size() != (superClass.length + subClass.length));

        return inputsArray;
    }
}
