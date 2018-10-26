package project1.controller;

import project1.Utility.InputUtility;
import project1.model.Entity.*;

import java.util.ArrayList;

class Service<T extends Candy> {

    T initItem(Object fields) {

        ArrayList<String> params = InputUtility.inputParameter(fields);

        switch (fields.getClass().getSimpleName()) {
            case "Caramel":
                return (T)new Caramel(Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1)),
                        Integer.parseInt(params.get(2)));
            case "Chocolate":
                return(T)new Chocolate(Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1)),
                        Integer.parseInt(params.get(2)));
            case "Iris":
                return(T)new Iris(Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1)),
                        Integer.parseInt(params.get(2)));
            case "Jelly":
                return(T)new Jelly(Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1)),
                        Integer.parseInt(params.get(2)));
            case "Marshmallow":
                return(T)new Marshmallow(Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1)),
                        Integer.parseInt(params.get(2)));
        }

        return null;
    }



}
