package project1.controller;

import project1.Utility.InputUtility;
import project1.model.CandyPresent;
import project1.model.Data;
import project1.model.Entity.*;
import project1.view.View;
import java.util.Comparator;

/**
 * The type Menu.
 */
class Menu {

    private CandyPresent model;
    private View view = new View();
    private InputUtility inputUtility = new InputUtility();
    private Data data = new Data();
    private Service service = new Service();

    /**
     * User interface.
     */
    void userInterface() {
        View.printMessage(View.CREATING_PRESENT);
        model = new CandyPresent(inputUtility.inputInt());
        menu();
    }

    private void menu() {
        while (true) {
            View.printMessage(View.PRESENT_INFO);
            View.printMessage(model.toString());
            View.printMessage(View.MENU);

            switch (inputUtility.inputIntBetween(8)) {
                case 1:
                    view.printCandies(model.getCandies());
                    View.printMessage("Candy total price: " + model.getCandyTotalPrice());
                    View.printMessage("Candy total sugar weight: " + model.getCandyTotalSugarWeight());
                    View.printMessage("Candy total weight: " + model.getCandyTotalWight());
                    break;
                case 2:
                    Object fields;
                    do {
                        View.printMessage(View.PRESENT_INFO);
                        View.printMessage("curWeight " + model.getCurWeight() + " maxWeight " + model.getMaxWeight());
                        do {
                            fields = enterItemType();
                        } while (fields == null);
                        if (model.addCandy(service.initItem(fields))) {
                            View.printMessage(View.SUCCESS);
                        } else View.printMessage(View.UNSUCCESS);
                    } while (inputUtility.checkRepeat("y"));
                    break;
                case 3:
                    model.setCandies(data.fillPresentWithRandomParams(model.getCurWeight(), model.getMaxWeight()));
                    view.printCandies(model.getCandies());
                    break;
                case 4:
                    model.sortBy(Comparator.comparing(Candy::getPrice));
                    view.printCandies(model.getCandies());
                    break;
                case 5:
                    model.sortBy(Comparator.comparing(Candy::getTotalWeight));
                    view.printCandies(model.getCandies());
                    break;
                case 6:
                    model.sortBy(Comparator.comparing(Candy::getSugarWeight));
                    view.printCandies(model.getCandies());
                    break;
                case 7:
                    view.printCandies(model.getCandiesBetweenSugarWeight(inputUtility.inputIntBetween(1000),
                            inputUtility.inputIntBetween(1000)));
                    break;
                case 8:
                    View.printMessage(View.PRESENT_INFO);
                    View.printMessage("curWeight " + model.getCurWeight() + " maxWeight " + model.getMaxWeight());
                    do {
                        fields = enterItemType();
                    } while (fields == null);
                    model.addCandy(service.initItem(fields));
                    break;
                case 9:
                    do {
                        View.printMessage("Enter index of candy");
                        model.deleteCandy(inputUtility.inputIntBetween(model.getCandies().size()));
                    } while (inputUtility.checkRepeat("y"));
                    view.printCandies(model.getCandies());
                    break;
                case 0:
                    System.exit(0);
                default:
                    View.printMessage(View.WRONG_INPUT);
            }
        }
    }

    private Object enterItemType() {
        View.printMessage(View.CANDIES_LIST);
        switch (inputUtility.inputString()) {
            case "Caramel":
                return Caramel.class;
            case "Chocolate":
                return Chocolate.class;
            case "Iris":
                return Iris.class;
            case "Jelly":
                return Jelly.class;
            case "Marshmallow":
                return Marshmallow.class;
            default:
                View.printMessage("no such type");
                return null;
        }
    }
}
