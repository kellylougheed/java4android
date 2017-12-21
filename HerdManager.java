package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mEastGate;

    /**
     * The output Gate object.
     */
    private Gate mWestGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    public static final int HERD = 24;

    public void HerdManger(OutputInterface out, Gate gate1, Gate gate2) {
        this.mWestGate = gate1;
        this.mEastGate = gate2;
        this.mWestGate.open(Gate.IN);
        this.mEastGate.open(Gate.OUT);
    }

    public void simulateHerd(Random rand) {
        rand.setSeed(1234);
        int snails_in_pen = this.HERD;
        int snails_in_pasture = 0;
        mOut.println("East Gate: " + this.mEastGate.toString());
        mOut.println("West Gate: " + this.mWestGate.toString());
        mOut.println("There are currently " +
                snails_in_pen + " snails in the pen and " +
                snails_in_pasture + " snails in the pasture");
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            int num_snails, change;
            if (snails_in_pasture == 0) {
                num_snails = rand.nextInt(snails_in_pen) + 1;
                change = this.mEastGate.thru(num_snails);
            }
            else if (snails_in_pen == 0) {
                num_snails = rand.nextInt(snails_in_pasture) + 1;
                change = this.mWestGate.thru(num_snails);
            }
            else {
                boolean gate = rand.nextBoolean();
                if (gate) {
                    num_snails = rand.nextInt(snails_in_pen) + 1;
                    change = this.mEastGate.thru(num_snails);
                }
                else {
                    num_snails = rand.nextInt(snails_in_pasture) + 1;
                    change = this.mWestGate.thru(num_snails);
                }
            }

            snails_in_pen += change;
            snails_in_pasture = this.HERD - snails_in_pen;

            mOut.println("There are currently " +
                    snails_in_pen + " snails in the pen and " +
                    snails_in_pasture + " snails in the pasture");
        }
    }


}
