package com.pluralsight.javatesting;

import org.junit.Assert;
import org.junit.Test;

import static com.pluralsight.javatesting.CoffeeType.Espresso;
import static com.pluralsight.javatesting.CoffeeType.Latte;

public class CafeTest {
    private static final int ESPRESSO_BEANS = Espresso.getRequiredBeans();
    private static final int NO_MILK = 0;
    private static final int NO_BEANS = 0;
    private static final int LATTE_MILK = Latte.getRequiredMilk();

    @Test
    public void canBrewEspresso() {
        Cafe cafe = cafeWithBeans();

        Coffee coffee = cafe.brew(Espresso);

        Assert.assertEquals("Wrong coffee type", Espresso, coffee.getCoffeeType());
        Assert.assertEquals("Wrong amount of milk",NO_MILK, coffee.getMilk());
        Assert.assertEquals("Wrong number of beans", ESPRESSO_BEANS, coffee.getBeans());
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        Cafe cafe = cafeWithBeans();

        Coffee coffee = cafe.brew(Espresso);

        Assert.assertEquals(NO_BEANS, cafe.getBeansInStock());
    }

    @Test
    public void canBrewLatte() {
        Cafe cafe = cafeWithBeans();
        cafe.restockMilk(LATTE_MILK);

        Coffee coffee = cafe.brew(Latte);

        Assert.assertEquals("Wrong coffee type", Latte, coffee.getCoffeeType());
    }

    @Test(expected = IllegalStateException.class)
    public void lattesRequiresMilk() {
        Cafe cafe = cafeWithBeans();

        Coffee coffee = cafe.brew(Latte);
    }

    private Cafe cafeWithBeans() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);
        return cafe;
    }
}
