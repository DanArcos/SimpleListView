package com.android.arcosahedron.simplelistview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/*This is an implementation of a very basic ListView
* We must extend MainActivity to ListActivity in order to gain access to functions list setListAdapter()
* */
public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main); //Notice the main xml file is not used in this implementation

        //Add in data here
        String[] companies = new String[]{"Capcom", "SEGA", "Nintendo", "SCEA", "Square Enix", "Mojang", "Bungie", "Valve"};

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

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list); UNCOMMENT THIS FOR SIMPLE LIST USE

        /*OR WE CAN USE A CUSTOM VIEW...The third parameter is the ID of the TextView from activity_main that will be populated with the data */
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_main, R.id.label, list);

        //OR WE CAN USE OUR CUSTOM ADAPTER
        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, companies);

        //Now that the adapter is created, set it.
        //The full function is -> ListActivity.setListAdapter(adapter)
        setListAdapter(adapter);

    }

    //onListItemClick is the method that gets called when we click on an item
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //getListAdapter() retrieves the list adapter so we can retrieve the item we want
        //getItem(position) gives us the item that we want.
        //Notice: this must be cast to a (String)
        String item = (String)getListAdapter().getItem(position);

        //Implement a toast indicating that we have clicked on an item!
        Toast.makeText(this,"You have tapped "+item,Toast.LENGTH_SHORT).show();
    }
}
