package Domain.Discounts;

import Domain.Order;
import Infrastructure.Utils.Utils;
import org.springframework.stereotype.Component;

@Component
public class CardDiscount extends  Discount {
    private final static int INITIAL_PRICE_PERCENTAGE_LIMIT = 30;
    private final static int CARD_PERCENTAGE = 10;

    @Override
    public boolean canBeApplied(Order order) {
        this.order = order;
        return isAccumulationCardActivated();
    }

    @Override
    public double getDiscount(Order order) {
        if (isMoreThanPercentageOfTotalPrice()) {
            return getInitialPriceMaxPercentage();
        }
        return getAccumulationCardDiscount();
    }

    private double getAccumulationCardDiscount() {
        return Utils.getPercentageOfNumber(getAccumulationCardBalance(), CARD_PERCENTAGE);
    }

    private boolean isAccumulationCardActivated() {
        return order.getCustomer().hasCard();
    }

    private double getAccumulationCardBalance() {
        return order.getCustomer().getCardBalance();
    }

    private double getInitialPriceMaxPercentage() {
        double initialPrice = getInitialPrice();
        return Utils.getPercentageOfNumber(initialPrice, INITIAL_PRICE_PERCENTAGE_LIMIT);
    }

    private boolean isMoreThanPercentageOfTotalPrice() {
        double initialPricePercentage = getInitialPriceMaxPercentage();
        double accumulationCardPercentage = getAccumulationCardDiscount();
        return (accumulationCardPercentage > initialPricePercentage);
    }

    private double getInitialPrice() {
        return order.getInitialPrice();
    }
}
