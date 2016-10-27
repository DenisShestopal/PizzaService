package domain.discounts;

public enum DiscountState {
    ACTIVE {
        public DiscountState reverseState() {
            return INACTIVE;
        }
    },
    INACTIVE {
        public DiscountState reverseState() {
            return ACTIVE;
        }
    };

    public abstract DiscountState reverseState();
}
