package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {

    private int mSwing = CLOSED;

    public static final int OUT = -1;
    public static final int IN = 1;
    public static final int CLOSED = 0;

    public boolean setSwing(int direction) {
        if (direction == IN || direction == OUT || direction == CLOSED) {
            this.mSwing = direction;
            return true;
        }
        return false;
    }

    public int getSwingDirection() {
        return this.mSwing;
    }

    public boolean open(int direction) {
        if (direction == IN || direction == OUT) {
            setSwing(direction);
            return true;
        }
        return false;
    }

    public void close() {
        setSwing(CLOSED);
    }

    public int thru(int count) {
        if (this.mSwing == IN) {
            return count;
        } else if (this.mSwing == OUT) {
            return count * -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        switch (this.mSwing) {
            case CLOSED:
                return "This gate is closed";
            case IN:
                return "This gate is open and swings to enter the pen only";
            case OUT:
                return "This gate is open and swings to exit the pen only";
            default:
                return "This gate has an invalid swing direction";
        }
    }



}
