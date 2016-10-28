package domain.enums;

import java.util.*;

public enum PaymentStatus {

    NEW,
    IN_PROGRESS,
    PAYED,
    CANCELED;

    private enum Transition {
        FROM_NEW(NEW, IN_PROGRESS, PAYED, CANCELED),
        FROM_IN_PROGRESS(IN_PROGRESS, PAYED, CANCELED),
        FROM_CANCELED(PAYED),
        FROM_DONE(CANCELED);

        PaymentStatus from;

        EnumSet<PaymentStatus> toStatuses;

        Transition(PaymentStatus from, PaymentStatus... to) {
            this.from = from;
            toStatuses = EnumSet.noneOf(PaymentStatus.class);
            toStatuses.addAll(Arrays.asList(to));
        }

        static final Map<PaymentStatus, Set<PaymentStatus>> transitions =
                new EnumMap<>(PaymentStatus.class);

        static {
            for (PaymentStatus.Transition trans : PaymentStatus.Transition.values()) {
                transitions.put(trans.from, EnumSet.copyOf(trans.toStatuses));
            }
        }

    }

    public boolean canChangeTo(OrderStatus newStatus) {
        return PaymentStatus.Transition.transitions.get(this).contains(newStatus);
    }

    public OrderStatus getNextStatus(OrderStatus status){
        if (status.equals(OrderStatus.NEW))
            return OrderStatus.IN_PROGRESS;
        if (status.equals(OrderStatus.IN_PROGRESS))
            return OrderStatus.PAYED;
        if (status.equals(OrderStatus.PAYED))
            return OrderStatus.PAYED;
        else return status;
    }

    public OrderStatus getPreviousStatus(OrderStatus status){
        if (status.equals(OrderStatus.NEW))
            return OrderStatus.NEW;
        if (status.equals(OrderStatus.PAYED))
            return OrderStatus.IN_PROGRESS;
        if (status.equals(OrderStatus.IN_PROGRESS))
            return OrderStatus.NEW;
        else return status;
    }

    public OrderStatus getCancelStatus(){
        return OrderStatus.CANCELED;
    }
}
