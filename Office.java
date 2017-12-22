package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office 
       extends Building {
       
    private String mBusinessName;
    private int mParkingSpaces = 0;
    private static int sTotalOffices = 0;

    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = businessName;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName, int parkingSpaces) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = businessName;
        this.mParkingSpaces = parkingSpaces;
        sTotalOffices++;
    }

    public String getBusinessName() {
        return this.mBusinessName;
    }

    public int getParkingSpaces() {
        return this.mParkingSpaces;
    }

    public void setBusinessName(String businessName) {
        this.mBusinessName = businessName;
    }

    public void setParkingSpaces(int parkingSpaces) {
        this.mParkingSpaces = parkingSpaces;
    }

    public String toString() {
        String str = "Business: ";
        if (this.getBusinessName() != null) {
            str += this.getBusinessName();
        } else {
            str += "unoccupied";
        }
        if (this.getParkingSpaces() > 0) {
            str += "; has " + this.getParkingSpaces() + " parking spaces";
        }
        str += " (total offices: " + this.sTotalOffices + ")";
        return str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Office) {
            if (this.calcBuildingArea() == ((Office) obj).calcBuildingArea() &&
                    this.getParkingSpaces() == ((Office) obj).getParkingSpaces()) {
                return true;
            }
        }
        return false;
    }

}
