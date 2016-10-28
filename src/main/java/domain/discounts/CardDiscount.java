//package domain.discounts;
//
//import domain.BaseEntity;
//import domain.Card;
//import infrastructure.utils.PizzaUtils;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.Column;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Component
//public class CardDiscount extends BaseEntity {
//    private final static int PERCENTAGE_LIMIT = 30;
//    private final static int CARD_PERCENTAGE = 10;
//
//    @Column(name = "status", length = 20, nullable = false)
//    @Enumerated(EnumType.STRING)
//    private boolean status;
//    @Column(name = "discount")
//    private Double discount;
//
//    Card card;
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
////    private boolean isCardActivated() {
////        return order.getCustomer().hasCard();
////    }
////
////
//    private double getCardBalance() {
//        return card.get;
//    }
////
////    private double getInitialPriceMaxPercentage() {
////        double initialPrice = getInitialPrice();
////        return PizzaUtils.getPercentageOfNumber(initialPrice, PERCENTAGE_LIMIT);
////    }
////
////    private boolean isMoreThanPercentageOfTotalPrice() {
////        double initialPricePercentage = getInitialPriceMaxPercentage();
////        double cardPercentage = getCardDiscount();
////        return (cardPercentage > initialPricePercentage);
////    }
////
////    private double getInitialPrice() {
////        return order.getInitialPrice();
////    }
////}
