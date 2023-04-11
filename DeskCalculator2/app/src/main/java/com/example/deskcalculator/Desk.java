package com.example.deskcalculator;

/**
 * Write a description of class com.example.deskcalculator.Desk here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Desk
{
// instance variables - replace the example below with your own
private static final double MINIMUM_COST = 200.00;
private static final int SIZE_THRESHOLD = 750;
private static final double SIZE_CHARGE = 50.00;

private static final double SPECIES_CHARGE_EXOTIC = 150.00;
private static final double SPECIES_CHARGE_HARDWOOD = 125;
private static final double SPECIES_CHARGE_STANDARD = 0.00;
private static final int DRAWER_CHARGE = 30;

//dimensions in inches
private static double xLength = 24;
private static double yWidth =24;
private static double speciesFee = 0;
private static double sizeFee = 0;
private static double drawerFee = 0;
private static int drawerCount = 0;
public static Desk.WoodType type = WoodType.PINE;


/* input into BlueJ as com.example.deskcalculator.Desk.WoodType.MAHOGANY, as an example */
enum WoodType
{
	MAHOGANY,
	OAK,
	PINE
}

/**
 * Constructor for objects of class com.example.deskcalculator.Desk
 */



public static double getSize()
{
	return xLength * yWidth;

}

private static double getSpeciesFee()
{
	switch(type)
	{

		case MAHOGANY:
			return SPECIES_CHARGE_EXOTIC;
		case OAK:
			return SPECIES_CHARGE_HARDWOOD;
		case PINE:
			return SPECIES_CHARGE_STANDARD;
		default:
			System.out.println("Species Charge Not Applied");
			return 0;
	}
}

private static double getDrawerFee()
{
	if(drawerCount >= 0)
	{
		return drawerCount * DRAWER_CHARGE;
	}else return 0;
}

private static double getSizeFee()
{
	if(getSize() >= SIZE_THRESHOLD)
	{
		return SIZE_CHARGE;
	}else
	{
		return 0;
	}
}


public static double getCalculatedPrice()
{
	double price = MINIMUM_COST;
	price += getSpeciesFee();
	price += getDrawerFee();
	price += getSizeFee();

	return price;
}

public static void OutputPriceWithFees()
{
	System.out.println("Standard com.example.deskcalculator.Desk Fee: $" + MINIMUM_COST);
	System.out.println("Species Fee: $" + speciesFee + "(" + type + ")");
	System.out.println("Size Fee: $" + sizeFee + "(" + getSize() + " square inches)");
	System.out.println("Drawer Fee: $" + drawerFee + "(" + drawerCount + " drawers)");
	getPrice();
}

public static void setDrawerCount(int drawers)
{
	drawerCount = drawers;
}

public static void setxLength(double length)
{
	xLength = length;
}

public static void setyWidth(double width)
{
	yWidth = width;
}

public void setType(WoodType type)
{
	this.type = type;
}
public static String getPrice()
{
	return "$" + getCalculatedPrice();
}
}