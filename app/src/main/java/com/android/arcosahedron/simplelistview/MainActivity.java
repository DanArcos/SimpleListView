package com.android.arcosahedron.simplelistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/*This is an implementation of a very basic ListView
* There will be no custom view implementations here
* We must extend MainActivity to ListActivity in order to gain access to functions list setListAdapter()
* */
public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); //Notice we do not even use the main xml file in this implementation

        String[] companies = new String[]{"Capcom", "SEGA", "Nintendo", "SCEA", "Square Enix", "Mojang","Bungie"};

        /*
        * Add all data from "companies" array into an array list
        * Creating this array list is  optional.
        * It is done here so that in the future we can modify the ArrayList named "list" without risk of modifying the contents of the original String array "companies"
        * */
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i< companies.length; i++){
            list.add(companies[i]);
        }

        //Create the list adapter that will convert our data set into a list view
        //ArrayAdapter<Data Type>(Context, layoutView, data set)
        //Context = this, layoutView = a default view created by the android OS, data set = list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);
        setListAdapter(adapter);

    }
}
