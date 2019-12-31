package com.pluralsight.javatesting;

public final class Cafe {
    private int beansInStock = 0;
    private int milkInStock = 0;

    public int getBeansInStock() {
        return this.beansInStock;
    }
    public int getMilkInStock() {
        return this.milkInStock;
    }

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

        return new Coffee(null, requiredBeans, requiredMilk);
    }

    public void restockBeans(int weightInGrams) {
        this.requirePositive(weightInGrams);
        this.beansInStock += weightInGrams;
    }

    public void restockMilk(int weightInGrams) {
        this.requirePositive(weightInGrams);
        this.milkInStock += weightInGrams;
    }

    private void requirePositive(int value) {
        if (value < 1) {
            throw new IllegalArgumentException();
        }
    }
}
