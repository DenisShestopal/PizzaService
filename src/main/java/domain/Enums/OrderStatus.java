package domain.enums;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;

public enum OrderStatus {
        NEW,
        IN_PROGRESS,
        CANCELED,
        DONE;

    private enum Transition {
        FROM_NEW(NEW, IN_PROGRESS, CANCELED, DONE),
        FROM_IN_PROGRESS(IN_PROGRESS, CANCELED, DONE),
        FROM_CANCELED(CANCELED),
        FROM_DONE(DONE);

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
                return OrderStatus.DONE;
        if (status.equals(OrderStatus.DONE))
                return OrderStatus.DONE;
        else return status;
    }

    public OrderStatus getPreviousStatus(OrderStatus status){
        if (status.equals(OrderStatus.NEW))
            return OrderStatus.NEW;
        if (status.equals(OrderStatus.DONE))
            return OrderStatus.IN_PROGRESS;
        if (status.equals(OrderStatus.IN_PROGRESS))
            return OrderStatus.NEW;
        else return status;
    }

    public OrderStatus getCancelStatus(){
        return OrderStatus.CANCELED;
    }
}
