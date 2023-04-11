/**
 * Write a description of class Desk here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Desk
{
    // instance variables - replace the example below with your own
    private static final double minimumCost = 200.00;
    private static final double drawerCharge = 30.00;
    private static final int sizeThreshold = 750;
    private static final double sizeCharge = 50.00;

    private static final double speciesCharge_exotic = 150.00;
    private static final double speciesCharge_hardwood = 125;
    private static final double speciesCharge_standard = 0.00;

    //dimensions in inches
    private double xLength;
    private double yWidth;
    private double customerPrice;
    private double speciesFee;
    private double sizeFee;
    private double drawerFee;
    private int orderNumber;
    private int drawerCount;
    public Desk.WoodType type;


    /* input into BlueJ as Desk.WoodType.MAHOGANY, as an example */
    enum WoodType
    {
        MAHOGANY,
        OAK,
        PINE
    }


    /**
     * Constructor for objects of class Desk
     */
    public Desk(int order, double length, double width, Desk.WoodType typeOfWood, int drawers)
    {
        this.orderNumber = order;
        this.xLength = length;
        this.yWidth = width;
        this.type = typeOfWood;
        this.drawerCount = drawers;
        this.setFees();
        this.customerPrice = getCalculatedPrice();


    }
    public double getSize()
    {
        return xLength * yWidth;

    }

    private double getSpeciesFee()
    {
        switch(type)
        {

            case MAHOGANY:
                return speciesCharge_exotic;
            case OAK:
                return speciesCharge_hardwood;
            case PINE:
                return speciesCharge_standard;
            default:
                System.out.println("Species Charge Not Applied");
                return 0;
        }
    }
    private double getDrawerFee()
    {
        if (drawerCount >= 0)
        {
            return drawerCount * 30;
        }
        else return 0;
    }
    private double getSizeFee()
    {
        if (this.getSize() >= sizeThreshold)
        {
            return sizeCharge;
        }
        else
        {
            return 0;
        }
    }
    private void setFees()
    {
        speciesFee = getSpeciesFee();
        drawerFee = getDrawerFee();
        sizeFee = getSizeFee();

    }

    private double getCalculatedPrice()
    {
        double price = minimumCost;
        price += speciesFee;
        price += drawerFee;
        price += sizeFee;

        return price;
    }
    public void OutputPriceWithFees()
    {
        System.out.println("Standard Desk Fee: $" + minimumCost);
        System.out.println("Species Fee: $" + speciesFee + "(" + type + ")");
        System.out.println("Size Fee: $" + sizeFee + "(" + getSize() + " square inches)");
        System.out.println("Drawer Fee: $" + drawerFee + "(" + drawerCount + " drawers)");
        getPrice();
    }
    public void getPrice()
    {
        System.out.println("Customer Price: " + customerPrice);
    }
}