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

//an underlined variable name is static
//a variable name in all caps is final
//+ indicates the field or method is public
//− indicates the field or method is private
//the parameter list for a method is listed in () with descriptive name and type
//the return type is listed after the method
//if no constructors are listed, assume only the default is used