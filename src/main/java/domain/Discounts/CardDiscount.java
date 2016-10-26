package domain.discounts;

import domain.Order;
import infrastructure.utils.Utils;
import org.springframework.stereotype.Component;

@Component
public class CardDiscount extends  Discount {
    private final static int PERCENTAGE_LIMIT = 30;
    private final static int CARD_PERCENTAGE = 10;

    @Override
    public boolean canBeApplied(Order order) {
        this.order = order;
        return isCardActivated();
    }

    @Override
    public double getDiscount(Order order) {
        if (isMoreThanPercentageOfTotalPrice()) {
            return getInitialPriceMaxPercentage();
        }
        return getCardDiscount();
    }

    private double getCardDiscount() {
        return Utils.getPercentageOfNumber(getCardBalance(), CARD_PERCENTAGE);
    }

    private boolean isCardActivated() {
        return order.getCustomer().hasCard();
    }


    private double getCardBalance() {
        return order.getCustomer().getCardBalance();
    }

    private double getInitialPriceMaxPercentage() {
        double initialPrice = getInitialPrice();
        return Utils.getPercentageOfNumber(initialPrice, PERCENTAGE_LIMIT);
    }

    private boolean isMoreThanPercentageOfTotalPrice() {
        double initialPricePercentage = getInitialPriceMaxPercentage();
        double accumulationCardPercentage = getCardDiscount();
        return (accumulationCardPercentage > initialPricePercentage);
    }

    private double getInitialPrice() {
        return order.getInitialPrice();
    }
}
