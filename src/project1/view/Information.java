package project1.view;

/**
 * The interface Information.
 */
public interface Information {

    /**
     * The constant CANDIES_LIST.
     */
    String CANDIES_LIST = "\nTypes of candies\n" +
            "\nCaramel\n" +
            "\nChocolate\n" +
            "\nIris\n" +
            "\nJelly\n" +
            "\nMarshmallow\n";

    /**
     * The constant SUCCESS.
     */
    String SUCCESS = "Inserted!\n";

    /**
     * The constant UNSUCCESS.
     */
    String UNSUCCESS = "Not inserted.\n";

    /**
     * The constant CREATING_PRESENT.
     */
    String CREATING_PRESENT = "Enter max weight of present(not less then 150 gram): \n";

    /**
     * The constant WRONG_INPUT.
     */
    String WRONG_INPUT = "Wrong input! Try again.\n";

    /**
     * The constant INPUT_VALUE.
     */
    String INPUT_VALUE = "\nEnter value: \n";

    /**
     * The constant PRESENT_INFO.
     */
    String PRESENT_INFO = "Present: \n";

    /**
     * The constant EMPTY_LIST.
     */
    String EMPTY_LIST = "List is empty, try to fill it\n";

    /**
     * The constant MENU.
     */
    String MENU = "\nMain menu (select option):\n" +
            "1 show all candies;\n" +
            "2 fill present by keyboard;\n" +
            "3 fill present automatic;\n" +
            "4 sort candies by price;\n" +
            "5 sort candies by total weight;\n" +
            "6 sort candies by sugar weight;\n" +
            "7 show candies with sugar consist from ? to ?: \n" +
            "8 add candy;\n" +
            "9 delete candy;\n" +
            "0 exit program.";
}
