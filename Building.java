package mooc.vandy.java4android.buildings.logic;

/**
 * This is the Building class file.
 */
public class Building {
    
    private int mLength;
    private int mWidth;
    private int mLotLength;
    private int mLotWidth;

    public Building(int length, int width, int lotLength, int lotWidth) {
        this.mLength = length;
        this.mWidth = width;
        this.mLotLength = lotLength;
        this.mLotWidth = lotWidth;
    }

    public int getLength() {
        return this.mLength;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getLotLength() {
        return this.mLotLength;
    }

    public int getLotWidth() {
        return this.mLotWidth;
    }

    public void setLength(int length) {
        this.mLength = length;
    }

    public void setWidth(int width) {
        this.mWidth = width;
    }

    public void setLotLength(int lotLength) {
        this.mLotLength = lotLength;
    }

    public void setLotWidth(int lotWidth) {
        this.mLotWidth = lotWidth;
    }

    public int calcBuildingArea() {
        return this.mLength * this.mWidth;
    }

    public int calcLotArea() {
        return this.mLotLength * this.mLotWidth;
    }

    public String toString() {
        String str = "Building area: " + calcBuildingArea() + "\n";
        str += "Lot area: " + calcLotArea();
        return str;
    }
    
}
