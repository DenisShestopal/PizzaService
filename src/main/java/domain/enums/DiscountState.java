package domain.enums;

public enum DiscountState {
    ACTIVE {
        public DiscountState reverse() {
            return INACTIVE;
        }
    },
    INACTIVE {
        public DiscountState reverse() {
            return ACTIVE;
        }
    };

    public abstract DiscountState reverse();
}
