package project1.model;

import project1.model.Entity.Candy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CandyPresent<T extends Candy> {
    private int curWeight;
    private int maxWeight;
    private List<T> candies;

    public CandyPresent(int maxWeight) {
        this.curWeight = 0;
        this.maxWeight = maxWeight;
        this.candies = new ArrayList<>();
    }

    public int getCurWeight() {
        return curWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public List<T> getCandies() {
        return candies;
    }

    public void setCandies(List<T> candies) {
        this.candies.addAll(candies);
        setCurWeight();
    }

    private void setCurWeight() {
        curWeight = candies.stream()
                .map(Candy::getTotalWeight)
                .reduce(0, Integer::sum);
    }

    private boolean checkAdd(T candy) {
        if (candy != null &&
                (candy.getTotalWeight() + curWeight) <= maxWeight) {
            curWeight += candy.getTotalWeight();
            return true;
        } else return false;
    }

    public void sortBy(Comparator<T> comparator) {
        candies.sort(comparator);
    }

    public boolean addCandy(T candy) {
        return checkAdd(candy) && candies.add(candy);
    }

    public void deleteCandy(int index){
        candies.remove(index);
    }


    public List<T> getCandiesBetweenSugarWeight(int left, int right) {
        return candies.stream()
                .filter(candy -> candy.getSugarWeight() > left && candy.getSugarWeight() < right)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "CandyPresent{" +
                "curWeight=" + curWeight +
                ", maxWeight=" + maxWeight +
                ", candies=" + candies.size() +
                '}';
    }
}
