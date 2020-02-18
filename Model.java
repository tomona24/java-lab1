import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Model {

    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;

    // fields
    private String firstName;
    private String lastName;
    private int height;
    private double weight;
    private boolean canTravel;
    private boolean smokes;

    // constructor
    public Model(){
    }


    /**
     *
     * @param firstName
     * @param lastName
     * @param height
     * @param weight
     * @param traveler
     * @param smoker
     */
    public Model(String firstName, String lastName, int height, double weight, boolean traveler, boolean smoker) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(height);
        setWeight(weight);
        setCanTravel(traveler);
        setSmokes(smoker);
    }


    /**
     *
     * @param firstName
     * @param lastName
     * @param height
     * @param weight
     */
    public Model(String firstName, String lastName, int height, double weight) {
        setFirstName(firstName);
        setLastName(lastName);
        setHeight(height);
        setWeight(weight);
        this.canTravel = true;
        this.smokes = false;
    }

    // methods
    //**************************************
    // setter
    // *************************************

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if (firstName.length() >= 3 && firstName.length() <= 20){
        this.firstName = firstName;
        }
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        if (lastName.length() >= 3 && lastName.length() <= 20){
            this.lastName = lastName;
        }
    }

    /**
     *
     * @param traveler
     */
    public void setCanTravel(boolean traveler) {
        this.canTravel = traveler;
    }

    /**
     *
     * @param smoker
     */
    public void setSmokes(boolean smoker) {
        this.smokes = smoker;
    }

    /**
     *
     * @param inches
     */
    public void setHeight(int inches) {
        if (inches >= 24 && inches <= 84) {
            this.height = inches;
        }
    }

    /**
     *
     * @param feet
     * @param inches
     */
    public void setHeight(int feet, int inches) {
        int height = (feet * 12) + inches;
        if (height >= 24 && height <= 84) {
            this.height = height;
        }
    }

    /**
     *
     * @param pounds
     */
    public void setWeight(double pounds) {
        if (pounds >= 80 && pounds <= 280) {
            this.weight =  pounds;
        }
    }

    /**
     *
     * @param kilograms
     */
    public void setWeight(long kilograms) {
        double pounds = kilograms * POUNDS_PER_KG;
        if (pounds >= 80 && pounds <= 280) {
            this.weight =  pounds;
        }
    }


    /**
     *
     * @return
     */
    public String getFirstName() { return this.firstName; }

    /**
     *
     * @return
     */
    public String getLastName() { return this.lastName; }

    /**
     *
     * @return
     */
    public int getHeight() { return this.height; }

    /**
     *
     * @return
     */
    public double getWeight() { return this.weight; }

    /**
     *
     * @return
     */
    public boolean getCanTravel() { return this.canTravel; }

    /**
     *
     * @return
     */
    public boolean getSmokes() { return this.smokes; }



    //**************************************
    // accessor
    // *************************************

    public void getHeightInFeetAndInches() {
        int feet = getHeight() / INCHES_PER_FOOT;
        int inch = getHeight() - feet;
        if (inch == 0) {
            System.out.println(feet + " feet");
        } else if(inch == 1){
            System.out.println(feet + " feet " + inch + " inch" );
        } else {
            System.out.println(feet + " feet " + inch + " inches" );
        }
    }

    /**
     *
     * @return
     */
    public double getWeightKg(){
        double kg =  Math.round(this.weight / POUNDS_PER_KG);
        return kg;
    } // e.g. 103 (Math.round() the number)


    //**************************************
    // print
    // *************************************
    public void printDetails() {
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeight() + " inches");;
        System.out.println("Weight: " + Math.round(getWeight()) + " pounds");
        if (getCanTravel()) {
            System.out.println("Does travel ");
        } else {
            System.out.println("Does not travel ");
        }
        if (getSmokes()) {
            System.out.println("Does smoke ");
        } else {
            System.out.println("Does not smoke ");
        }
    }


    //**************************************
    // other
    // *************************************
    public int calculatePayDollarsPerHour(){
        int sum = BASE_RATE_DOLLARS_PER_HOUR;
        if (this.smokes == true) {
            sum -= SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        }
        if (this.height >= TALL_INCHES || this.weight <= THIN_POUNDS) {
            sum += TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        }
        if (this.canTravel == true) {
            sum += TRAVEL_BONUS_DOLLARS_PER_HOUR;
        }
        return sum;
    }


    public void displayModelDetails(){
        System.out.println("Name: " + getFirstName() + " " + getLastName());
        getHeightInFeetAndInches();
        System.out.println("Weight: " + getWeight() + " pounds");

        if (getCanTravel()) {
            System.out.println("Travels: yep");
        } else {
            System.out.println("Travels: nope");
        }
        if (getSmokes()) {
            System.out.println("Smokes: yep");
        } else {
            System.out.println("Smokes: nope");
        }
        System.out.println("Hourly rate: $" + calculatePayDollarsPerHour());
    }
}
