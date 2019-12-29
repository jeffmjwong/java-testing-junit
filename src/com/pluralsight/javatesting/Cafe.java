package com.pluralsight.javatesting;

public class Cafe {
    private int beansInStock = 0;
    private int milkInStock = 0;

    public Coffee brew(CoffeeType coffeeType) {
        return brew(coffeeType, 1);
    }

    public Coffee brew(CoffeeType coffeeType, int quantity) {
        this.requirePositive(quantity);

        int requiredBeans = coffeeType.getRequiredBeans() * quantity;
        int requiredMilk = coffeeType.getRequiredMilk() * quantity;
        if (requiredBeans > this.beansInStock || requiredMilk > this.milkInStock) {
            throw new IllegalStateException("Insufficient beans or milk");
        }

        this.beansInStock -= requiredBeans;
        this.milkInStock -= requiredMilk;

        return new Coffee(coffeeType, requiredBeans, requiredMilk);
    }

    public void restockBeans(int weightInGrams) {
        this.requiredPositive(weightInGrams);
        this.beansInStock += weightInGrams;
    }
}
