package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */



    public void process(int size) {

        // Draw upper frame
        drawHorizontalFrame(size);

        // Draw top half
        if (size > 1) {
            for (int i = 1; i < size; i++) {
                mOut.print("|");
                drawSpaces(size, i);
                mOut.print("/");
                if (i > 1) {
                    for (int j = 2 * i - 2; j > 0; j--) {
                        printDashOrEquals(i);
                    }
                }
                mOut.print("\\");
                drawSpaces(size, i);
                mOut.print("|");
                mOut.print("\n");
            }
        }

        // Draw middle
        mOut.print("|<");
        // Determine if dashes or equals signs
        int dash = 0;
        if (!(size % 2 == 0)) {
            dash = 1;
        }
        for (int i = 0; i < (size * 2) - 2; i++) {
            printDashOrEquals(dash);
        }
        mOut.print(">|");
        mOut.print("\n");

        // Draw bottom half
        if (size > 1) {
            for (int i = size-1; i >= 1; i--) {
                mOut.print("|");
                drawSpaces(size, i);
                mOut.print("\\");
                if (i > 1) {
                    for (int j = 2 * i - 2; j > 0; j--) {
                        printDashOrEquals(i);
                    }
                }
                mOut.print("/");
                drawSpaces(size, i);
                mOut.print("|");
                mOut.print("\n");
            }
        }

        // Draw lower frame
        drawHorizontalFrame(size);
    }

    public void drawHorizontalFrame(int size) {
        mOut.print("+");
        for (int i = 0; i < size * 2; i++) {
            mOut.print("-");
        }
        mOut.print("+");
        mOut.print("\n");
    }

    public void drawSpaces(int size, int i) {
        for (int j = 0; j < size - i; j++) {
            mOut.print(" ");
        }
    }

    public void printDashOrEquals(int i) {
        if (i % 2 == 0) {
            mOut.print("-");
        } else {
            mOut.print("=");
        }
    }

}
