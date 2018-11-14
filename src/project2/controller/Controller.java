package project2.controller;

import project2.model.TextParser;

public class Controller {

    TextParser tp = new TextParser("One two three, bullet throws (crown) you bloody.Transform crown in the sky? " +
            "  Nope. No one will escape Tarkov.");

    public void run(){
        System.out.println("Original text: ");
        System.out.println(tp.toString());
        System.out.println("Sorted text: ");
        tp.sortByWords();
        System.out.println(tp.toString());
    }

}
