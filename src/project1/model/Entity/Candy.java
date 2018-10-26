package project1.model.Entity;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.Objects;

public abstract class Candy implements Comparable {
    private String type;
    private int price;
    private int sugarWeight;
    private int totalWeight;

    public Candy(int price, int sugarWeight, int totalWeight) {

        if (sugarWeight > totalWeight) {
            throw new InvalidDnDOperationException();
        }

        this.type = this.getClass().getSimpleName();
        this.price = price;
        this.sugarWeight = sugarWeight;
        this.totalWeight = totalWeight;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getSugarWeight() {
        return sugarWeight;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    @Override
    public int compareTo(Object o) {
        return (this.totalWeight - ((Candy) o).getPrice()) +
                (this.totalWeight - ((Candy) o).getTotalWeight()) +
                (this.sugarWeight - ((Candy) o).getSugarWeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return price == candy.price &&
                sugarWeight == candy.sugarWeight &&
                totalWeight == candy.totalWeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price, sugarWeight, totalWeight);
    }

    @Override
    public String toString() {
        return type + "{" +
                " price= " + price + " $ " +
                ", sugarWeight= " + sugarWeight + " g " +
                ", totalWeight= " + totalWeight + " g " +
                '}';
    }
}
