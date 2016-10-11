package Domain;

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
}
