package com.example.deskcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends Activity
{

private static final int MAXIMUM_DIMENSIONS =60;
private static final int MINIMUM_DIMENSIONS = 24;


private static final int MINIMUM_DRAWERS = 0;
private static final int MAXIMUM_DRAWERS = 3;

private static TextView priceView;
private static Spinner lengthSpinner;
private static Spinner widthSpinner;
private static Spinner woodTypeSpinner;
private static Spinner drawerCountSpinner;

@Override
public void onCreate(Bundle savedInstanceState)
{


	super.onCreate(savedInstanceState);
	priceView = findViewById(R.id.price_view);
	setContentView(R.layout.activity_main);


	// CONFIGURE LENGTH SPINNER
	lengthSpinner = findViewById(R.id.length_spinner);
	ConfigureSpinner(lengthSpinner, MINIMUM_DIMENSIONS, MAXIMUM_DIMENSIONS);
	lengthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
	{
		@Override
		public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
		{
			Desk.setxLength(Integer.parseInt(lengthSpinner.getSelectedItem().toString()));
			updatePrice();
		}

		@Override
		public void onNothingSelected(AdapterView<?> adapterView)
		{

		}
	});
	lengthSpinner.setClickable(true);


	//CONFIGURE WIDTH SPINNER
	widthSpinner = findViewById(R.id.width_spinner);
	ConfigureSpinner(widthSpinner, MINIMUM_DIMENSIONS, MAXIMUM_DIMENSIONS);
	widthSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
	{
		@Override
		public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
		{
			Desk.setyWidth(Integer.parseInt(widthSpinner.getSelectedItem().toString()));
			updatePrice();
		}

		@Override
		public void onNothingSelected(AdapterView<?> adapterView)
		{

		}
	});

	//CONFIGURE DRAWER COUNT SPINNER
	drawerCountSpinner = findViewById(R.id.drawer_spinner);
	ConfigureSpinner(drawerCountSpinner, MINIMUM_DRAWERS, MAXIMUM_DRAWERS);
	drawerCountSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
	{
		@Override
		public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
		{
			Desk.setDrawerCount(Integer.parseInt(drawerCountSpinner.getSelectedItem().toString()));
			updatePrice();
		}

		@Override
		public void onNothingSelected(AdapterView<?> adapterView)
		{

		}
	});

	woodTypeSpinner = findViewById(R.id.wood_spinner);
	ConfigureSpinner(woodTypeSpinner, Desk.WoodType.values());
	woodTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
	{
		@Override
		public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
		{
			switch(woodTypeSpinner.getSelectedItem().toString())
			{
				case "PINE":
					Desk.type = Desk.WoodType.PINE;
					break;

				case "OAK":
					Desk.type = Desk.WoodType.OAK;
					break;

				case "MAHOGANY":
					Desk.type = Desk.WoodType.MAHOGANY;
					break;
			}

			updatePrice();
		}

		@Override
		public void onNothingSelected(AdapterView<?> adapterView)
		{

		}
	});



}

private void updatePrice()
{
	TextView tv = findViewById(R.id.price_view);
	DecimalFormat df = new DecimalFormat("0.00");
	String s = String.valueOf(df.format(Desk.getCalculatedPrice()));
	tv.setText(s);
}

private void ConfigureSpinner(Spinner spin, int min, int max)
{

	ArrayList vals = new ArrayList();
	for (int i = min; i <= max; i++)
	{
		vals.add(i);
	}
	ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
			android.R.layout.simple_spinner_item, vals);
	spin.setAdapter(adapter);
}

private void ConfigureSpinner(Spinner spin, Desk.WoodType[] types)
{
	ArrayList<String> strings = new ArrayList<String>();
	for (int i = 0; i < types.length; i++)
	{
		String woodType = types[i].name();
		String str = "";
		strings.add(woodType);
	}
	ArrayAdapter<String> adapter =
			new ArrayAdapter<String>(this,
					android.R.layout.simple_spinner_item,
	strings);
	spin.setAdapter(adapter);

}

}