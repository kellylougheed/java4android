package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    public void setCorralGates(Gate [] gate, Random selectDirection) {
        for (int i = 0; i < gate.length; i++) {
            gate[i].setSwing(selectDirection.nextInt(3)-1);
        }
    }

    public boolean anyCorralAvailable(Gate [] corral) {
        for (int i = 0; i < corral.length; i++) {
            if (corral[i].getSwingDirection() == Gate.IN) {
                return true;
            }
        }
        return false;
    }

    public int corralSnails(Gate [] corral, Random rand) {

        mOut.println("Initial gate setup:");
        for (int i = 1; i <= corral.length; i++) {
            mOut.println("Gate " + i + ": " + corral[i].toString());
        }

        int snails_in_pasture = 5;
        int attempts = 0;

        while (snails_in_pasture > 0) {
            int snails = rand.nextInt(snails_in_pasture);
            int gate = rand.nextInt(corral.length);
            int change = corral[gate].thru(snails);

            snails_in_pasture -= change;
            attempts++;

            mOut.println(snails + " are trying to move through corral " + gate);
        }

        return attempts;
    }

}
