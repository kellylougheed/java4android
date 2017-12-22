package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House 
       extends Building {
       
    private String mOwner = null;
    private boolean mPool = false;

    public House(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner) {
        super(length, width, lotLength, lotWidth);
        this.mOwner = owner;
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool) {
        super(length, width, lotLength, lotWidth);
        this.mOwner = owner;
        this.mPool = pool;
    }

    public String getOwner() {
        return this.mOwner;
    }

    public boolean hasPool() {
        return this.mPool;
    }

    public void setOwner(String owner) {
        this.mOwner = owner;
    }

    public void setPool(boolean pool) {
        this.mPool = pool;
    }

    public String toString() {
        String str = "Owner: " + this.getOwner();
        if (this.hasPool()) {
            str += "; has a pool";
        }
        if (this.calcLotArea() > this.calcBuildingArea()) {
            str += "; has a big open space";
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof House) {
            if (this.hasPool() == ((House) obj).hasPool() &&
                    this.calcBuildingArea() ==
                            ((House) obj).calcBuildingArea()) {
                return true;
            }
        }
        return false;
    }
    
}
