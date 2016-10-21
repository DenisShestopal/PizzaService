package Domain.Enums;

public enum Status {

    NEW {
        @Override
        public Status nextStatus() {
            return IN_PROGRESS;
        }

        @Override
        public Status previousStatus() {
            throw new RuntimeException("Previous status for NEW does not exist.");
        }
    },
    IN_PROGRESS {
        @Override
        public Status nextStatus() {
            return DONE;
        }

        @Override
        public Status previousStatus() {
            return CANCELED;
        }
    },
    CANCELED {
        @Override
        public Status nextStatus() {
            throw new RuntimeException("Next status for CANCELED does not exist.");
        }

        @Override
        public Status previousStatus() {
            throw new RuntimeException("Previous status for CANCELED does not exist.");
        }
    },
    DONE {
        @Override
        public Status nextStatus() {
            throw new RuntimeException("Next status for DONE does not exist.");
        }

        @Override
        public Status previousStatus() {
            throw new RuntimeException("Previous status for DONE does not exist.");
        }
    };

    public abstract Status nextStatus();

    public abstract Status previousStatus();
}
