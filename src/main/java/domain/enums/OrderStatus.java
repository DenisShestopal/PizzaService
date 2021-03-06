package domain.enums;

import java.util.*;

public enum OrderStatus {
        NEW,
        IN_PROGRESS,
        CANCELED,
    PAYED;

    private enum Transition {
        FROM_NEW(NEW, IN_PROGRESS, CANCELED, PAYED),
        FROM_IN_PROGRESS(IN_PROGRESS, CANCELED, PAYED),
        FROM_CANCELED(CANCELED),
        FROM_DONE(PAYED);

        OrderStatus from;

        EnumSet<OrderStatus> toStatuses;

        Transition(OrderStatus from, OrderStatus... to) {
            this.from = from;
            toStatuses = EnumSet.noneOf(OrderStatus.class);
            toStatuses.addAll(Arrays.asList(to));
        }

        static final Map<OrderStatus, Set<OrderStatus>> transitions =
                new EnumMap<>(OrderStatus.class);

        static {
            for (Transition trans : Transition.values()) {
                transitions.put(trans.from, EnumSet.copyOf(trans.toStatuses));
            }
        }

    }

    public boolean canChangeTo(OrderStatus newStatus) {
        return Transition.transitions.get(this).contains(newStatus);
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
