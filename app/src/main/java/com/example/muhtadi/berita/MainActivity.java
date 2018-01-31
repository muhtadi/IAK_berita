package com.example.muhtadi.berita;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //init value
    RecyclerView mRecycler;
    ArrayList<Sport> mArraylist;
    SportAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler =findViewById(R.id.recycleView);

        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        mArraylist = new ArrayList<>();

        mAdapter = new SportAdapter(mArraylist, this);

        mRecycler.setAdapter(mAdapter);

        initData();
    }

    private void initData() {
        //get data from string.xml

        String sportTitle[] = getResources().
                getStringArray(R.array.sport_title);

        String sportInfo[] = getResources().
                getStringArray(R.array.sport_info);

        String sportDesc[] = getResources().
                getStringArray(R.array.sport_desc);

        TypedArray sportImage = getResources().
                obtainTypedArray(R.array.sport_image);

        mArraylist.clear();

        for (int i = 0; i<sportTitle.length;i++){
            mArraylist.add(new Sport(sportTitle[i], sportInfo[i],
                    sportImage.getResourceId(i,0), sportDesc[i]));
        }

        sportImage.recycle();

        mAdapter.notifyDataSetChanged();
    }
}



















//
//public class MainActivity extends AppCompatActivity {
//
//    //member variable
//    private RecyclerView mRecycleView;
//    private ArrayList<Sport> mSportData;
//    private SportAdapter mAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        //initialze the recycle view
//        mRecycleView = findViewById(R.id.recycleView);
//
//        //set the layout manager
//        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
//
//        //initialze the array list that will contain the data
//        mSportData = new ArrayList<>();
//
//        //Initialize the adapter and set it ot the RecyclerView
//        mAdapter = new SportAdapter(this, mSportData);
//
//        mRecycleView.setAdapter(mAdapter);
//
//        //get the data
//        initializeData();
//
//    }
//
//    /**
//     * Method for initializing the sports data from resources.
//     */
//    private void initializeData() {
//        //Get the resources from the XML file
//        String sportList[] = getResources().getStringArray(R.array.sport_title);
//        String sportInfo[] = getResources().getStringArray(R.array.sport_info);
//        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);
//        String sportDesc[] = getResources().getStringArray(R.array.sport_description);
//
//        //clear the exiting data (to avoid duplication
//        mSportData.clear();
//
//        //Create the ArrayList of Sports objects with the titles and information about each sport
//        for (int i = 0; i<sportList.length; i++){
//            mSportData.add(new Sport(sportList[i], sportInfo[i], sportsImageResources.getResourceId(i,0), sportDesc[i]));
//        }
//
//        //Recycle the typed array
//        sportsImageResources.recycle();
//
//        //Notify the adapter of the change
//        mAdapter.notifyDataSetChanged();
//    }
//}
