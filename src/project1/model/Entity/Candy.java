package project1.model.Entity;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.Objects;

/**
 * The type Candy.
 */
public abstract class Candy implements Comparable {

    /**
     * field - candy type
     */
    private String type;

    /**
     * field - candy price
     */
    private int price;

    /**
     * field - part of sugar weight in candy
     */
    private int sugarWeight;

    /**
     * field - total weight of candy
     */
    private int totalWeight;


    /**
     * Instantiates a new Candy.
     *
     * @param price       the price
     * @param sugarWeight the sugar weight
     * @param totalWeight the total weight
     */
    public Candy(int price, int sugarWeight, int totalWeight) {

        if (sugarWeight > totalWeight) {
            throw new InvalidDnDOperationException();
        }

        this.type = this.getClass().getSimpleName();
        this.price = price;
        this.sugarWeight = sugarWeight;
        this.totalWeight = totalWeight;
    }

    /**
     * Gets {@link #type}.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets {@link #price}.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets {@link #sugarWeight}.
     *
     * @return the sugar weight
     */
    public int getSugarWeight() {
        return sugarWeight;
    }

    /**
     * Gets {@link #totalWeight}.
     *
     * @return the total weight
     */
    public int getTotalWeight() {
        return totalWeight;
    }


    /**
     * Compare candies by {@link #price}, {@link #totalWeight} and {@link #sugarWeight}
     *
     * @param o - reference of other candy
     * @return the value {@code 0} if the other objects values is equal to
     * *          this objects value; a value less than {@code 0} if this objects values
     * *          is less than the other object values; and a
     * *          value greater than {@code 0} if this object values is
     * *          greater than the other objects values.
     */
    @Override
    public int compareTo(Object o) {
        return (this.price - ((Candy) o).getPrice()) +
                (this.totalWeight - ((Candy) o).getTotalWeight()) +
                (this.sugarWeight - ((Candy) o).getSugarWeight());
    }


    /**
     * Show if other candy os equal to this one
     *
     * @param o - reference of other candy
     * @return {@code true} if the given object
     * equivalent to this object, {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return price == candy.price &&
                sugarWeight == candy.sugarWeight &&
                totalWeight == candy.totalWeight;
    }


    /**
     * Returns a hash code value for the candy.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(type, price, sugarWeight, totalWeight);
    }

    /**
     * Returns a string representation of the candy.
     *
     * @return a string representation of the candy.
     */
    @Override
    public String toString() {
        return type + "{" +
                " price= " + price + " $ " +
                ", sugarWeight= " + sugarWeight + " g " +
                ", totalWeight= " + totalWeight + " g " +
                '}';
    }
}
