package CoffeeMachine;

import java.util.*;

public class CoffeeMachine {

    private static final int COIN_500 = 500;
    private static final int COIN_100 = 100;
    private static final int COIN_50 = 50;
    private static final int COIN_10 = 10;

    private static int[] coinType = {COIN_500, COIN_100, COIN_50, COIN_10};
    private Vector<Integer> coinChange = new Vector<>();

    public void orderCoffee(int money, int price) {

        int change = calculateChange(money, price);

        for (int currentCoinType : coinType) {
            while (changeMoreThanCurrentCoinType(change, currentCoinType)) {

                int coinCount = countCoinPerCurrentCoinType(change, currentCoinType);

                for (int i = 0; i < coinCount; i++)
                    coinChange.add(currentCoinType);

                change -= calculateRemainChange(currentCoinType, coinCount);
            }
        }

        giveCoin10IfRemainChangeLessThan10(change);
    }

    public Integer[] getCoinChange() {
        return (Integer[]) coinChange.toArray(new Integer[0]);
    }

    private void giveCoin10IfRemainChangeLessThan10(int change) {
        if (change < COIN_10 && change > 0)
            coinChange.add(COIN_10);
    }

    private int calculateRemainChange(int currentCoinType, int coinCount) {
        return currentCoinType * coinCount;
    }

    private int countCoinPerCurrentCoinType(int change, int thisCoin) {
        return change / thisCoin;
    }

    private boolean changeMoreThanCurrentCoinType(int change, int thisCoin) {
        return change >= thisCoin;
    }

    private int calculateChange(int money, int price) {
        return money - price;
    }

}
