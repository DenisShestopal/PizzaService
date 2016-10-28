package domain.discounts;
//
//import infrastructure.utils.PizzaUtils;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.stereotype.Component;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Component
//public class CardDiscount {
//    private final static int PERCENTAGE_LIMIT = 30;
//    private final static int CARD_PERCENTAGE = 10;
//
////    @Override
////    public boolean canBeApplied(Order order) {
////        this.order = order;
////        return isCardActivated();
////    }
////
////    @Override
////    public double getDiscount(Order order) {
////        if (isMoreThanPercentageOfTotalPrice()) {
////            return getInitialPriceMaxPercentage();
////        }
////        return getCardDiscount();
////    }
//
//    private double getCardDiscount() {
//        return PizzaUtils.getPercentageOfNumber(getCardBalance(), CARD_PERCENTAGE);
//    }
//
//    private boolean isCardActivated() {
//        return order.getCustomer().hasCard();
//    }
//
//
//    private double getCardBalance() {
//        return order.getCustomer().getCardBalance();
//    }
//
//    private double getInitialPriceMaxPercentage() {
//        double initialPrice = getInitialPrice();
//        return PizzaUtils.getPercentageOfNumber(initialPrice, PERCENTAGE_LIMIT);
//    }
//
//    private boolean isMoreThanPercentageOfTotalPrice() {
//        double initialPricePercentage = getInitialPriceMaxPercentage();
//        double cardPercentage = getCardDiscount();
//        return (cardPercentage > initialPricePercentage);
//    }
//
//    private double getInitialPrice() {
//        return order.getInitialPrice();
//    }
//}
