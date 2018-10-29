package project1.model;

import project1.model.Entity.Candy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Candy present.
 *
 * @param <T> the type parameter
 */
public class CandyPresent<T extends Candy> {

    /**
     * field - current weight of present
     */
    private int curWeight;
    /**
     * field - maximum weight of present
     */
    private int maxWeight;

    /**
     * field - candies list
     */
    private List<T> candies;

    /**
     * Instantiates a new Candy present.
     *
     * @param maxWeight the max weight
     */
    public CandyPresent(int maxWeight) {
        this.curWeight = 0;
        this.maxWeight = maxWeight;
        this.candies = new ArrayList<>();
    }

    /**
     * Gets {@link #curWeight}.
     *
     * @return the cur weight
     */
    public int getCurWeight() {
        return curWeight;
    }

    /**
     * Gets {@link #maxWeight}.
     *
     * @return the max weight
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
     * Gets candies.
     *
     * @return the candies
     */
    public List<T> getCandies() {
        return candies;
    }

    /**
     * Sets candies.
     *
     * @param candies the candies
     */
    public void setCandies(List<T> candies) {
        this.candies.addAll(candies);
        setCurWeight();
    }

    /**
     * \
     * Sets current weight of present
     */
    private void setCurWeight() {
        curWeight = candies.stream()
                .map(Candy::getTotalWeight)
                .reduce(0, Integer::sum);
    }

    /**
     * Check if present can add this candy to present
     *
     * @param candy - candy object
     * @return the boolean
     */
    private boolean checkAdd(T candy) {
        if (candy != null &&
                (candy.getTotalWeight() + curWeight) <= maxWeight) {
            curWeight += candy.getTotalWeight();
            return true;
        } else return false;
    }

    /**
     * Get candy total price int.
     *
     * @return sum price of all candies in present
     */
    public int getCandyTotalPrice() {
        return candies.stream()
                .map(Candy::getPrice)
                .reduce(0, Integer::sum);
    }

    /**
     * Get candy total sugar weight int.
     *
     * @return sum sugar weight of all candies in present
     */
    public int getCandyTotalSugarWeight() {
        return candies.stream()
                .map(Candy::getSugarWeight)
                .reduce(0, Integer::sum);
    }

    /**
     * Get candy total weight int.
     *
     * @return sum weight of all candies in present
     */
    public int getCandyTotalWight() {
        return candies.stream()
                .map(Candy::getTotalWeight)
                .reduce(0, Integer::sum);
    }


    /**
     * Sort by comparator.
     *
     * @param comparator the comparator
     */
    public void sortBy(Comparator<T> comparator) {
        candies.sort(comparator);
    }

    /**
     * Add candy boolean.
     *
     * @param candy the candy
     * @return the boolean
     */
    public boolean addCandy(T candy) {
        return checkAdd(candy) && candies.add(candy);
    }

    /**
     * Delete candy by index.
     *
     * @param index the index of candy in {@link #candies}
     */
    public void deleteCandy(int index) {
        candies.remove(index);
    }

    /**
     * Gets candies between sugar weight.
     *
     * @param left  begin weight
     * @param right end weight
     * @return list of candies by sugar weight between {@param left} and {@param right}
     */
    public List<T> getCandiesBetweenSugarWeight(int left, int right) {
        return candies.stream()
                .filter(candy -> candy.getSugarWeight() > left && candy.getSugarWeight() < right)
                .collect(Collectors.toList());
    }

    /**
     * Get information about this instantiate
     *
     * @return the String
     */
    @Override
    public String toString() {
        return "CandyPresent{" +
                "curWeight=" + curWeight +
                ", maxWeight=" + maxWeight +
                ", candies=" + candies.size() +
                '}';
    }
}
