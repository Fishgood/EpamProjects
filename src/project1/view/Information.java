package project1.view;

public interface Information {

    String CANDIES_LIST = "\nTypes of candies\n" +
            "\nCaramel\n" +
            "\nChocolate\n" +
            "\nIris\n" +
            "\nJelly\n" +
            "\nMarshmallow\n";

    String SUCCESS = "Inserted!\n";

    String UNSUCCESS = "Not inserted.\n";

    String CREATING_PRESENT = "Enter max weight of present(not less then 150 gram): \n";

    String WRONG_INPUT = "Wrong input! Try again.\n";

    String INPUT_VALUE = "\nEnter value: \n";

    String PRESENT_INFO = "Present: \n";

    String EMPTY_LIST = "List is empty, try to fill it\n";

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
