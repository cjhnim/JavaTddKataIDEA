package CoffeeMachine;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by francis on 2017-02-14.
 */
class CoffeeMachineTest {
    private CoffeeMachine machine;

    @BeforeEach
    void setUp() {
        machine = new CoffeeMachine();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void testChanges_돈넣지않고잔돈받아보자() {

        Integer[] expectCoins = {};
        assertArrayEquals(expectCoins, machine.getCoinChange());
    }

    @Test
    public void testChanges_10원을가지고10원커피먹어보자() {
        int money = 10;
        int price = 10;

        machine.orderCoffee(money, price);

        Integer[] expectCoins = {};
        assertArrayEquals(expectCoins, machine.getCoinChange());
    }

    @Test
    public void testChanges_20원을가지고10원커피먹어보자() {
        int money = 20;
        int price = 10;

        machine.orderCoffee(money, price);

        Integer[] expectCoins = {10};
        assertArrayEquals(expectCoins, machine.getCoinChange());
    }

    @Test
    public void testChanges_30원을가지고10원커피먹어보자() {

        int money = 30;
        int price = 10;

        machine.orderCoffee(money, price);

        Integer[] expectCoins = {10, 10};
        assertArrayEquals(expectCoins, machine.getCoinChange());
    }

    @Test
    public void testChanges_100원을가지고50원커피먹어보자() {
        int money = 100;
        int price = 50;

        machine.orderCoffee(money, price);

        Integer[] expectCoins = {50};
        assertArrayEquals(expectCoins, machine.getCoinChange());
    }

    @Test
    public void testChanges_110원을가지고50원커피먹어보자() {
        int money = 110;
        int price = 50;

        machine.orderCoffee(money, price);

        Integer[] expectCoins = {50, 10};
        assertArrayEquals(expectCoins, machine.getCoinChange());
    }

    @Test
    public void testChanges_310원을가지고50원커피먹어보자() {
        int money = 310;
        int price = 50;

        machine.orderCoffee(money, price);

        Integer[] expectCoins = {100, 100, 50, 10};
        assertArrayEquals(expectCoins, machine.getCoinChange());
    }

    @Test
    public void testChanges_911원을가지고50원커피먹어보자() {
        int money = 911;
        int price = 50;

        machine.orderCoffee(money, price);

        Integer[] expectCoins = {500, 100, 100, 100, 50, 10, 10};
        assertArrayEquals(expectCoins, machine.getCoinChange());
    }
}