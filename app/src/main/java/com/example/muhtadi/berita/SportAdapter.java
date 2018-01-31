package com.example.muhtadi.berita;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Muhtadi on 31/01/2018.
 */

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder>{

    //init varaible
    private GradientDrawable mGradientDrawable;
    private ArrayList<Sport> mArrayList;
    private Context mContex;


    public SportAdapter(ArrayList<Sport> mArrayList, Context mContex) {
        this.mArrayList = mArrayList;
        this.mContex = mContex;

        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        Drawable drawable = ContextCompat.getDrawable(mContex, R.drawable.img_basketball);
        if (drawable !=null){
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
        }

    }

    @Override
    public SportAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContex).inflate
                (R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(SportAdapter.ViewHolder holder, int position) {
        Sport currentSport = mArrayList.get(position);
        holder.bindTO(currentSport);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        TextView info;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            info = itemView.findViewById(R.id.news_description);
            imageView = itemView.findViewById(R.id.sports_image);

            itemView.setOnClickListener(this);

        }

        public void bindTO(Sport currentSport) {
            title.setText(currentSport.getTitle());
            info.setText(currentSport.getInfo());

            Glide.with(mContex).load(currentSport.getImage()).
                    placeholder(mGradientDrawable).into(imageView);
        }

        @Override
        public void onClick(View view) {

            Sport myposition = mArrayList.get(getAdapterPosition());

            Intent myIntent = new Intent(mContex, detail.class);

            myIntent.putExtra("gambar", myposition.getImage());
            myIntent.putExtra("title", myposition.getTitle());
            myIntent.putExtra("desc", myposition.getDesc());

            mContex.startActivity(myIntent);
        }
    }
}

























//public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder>{
//
//    //member variable
//    private GradientDrawable mGradientDrawable;
//    private ArrayList<Sport> mSportData;
//    private Context mContext;
//
//    /**
//     * Constructor that passes in the sports data and the context
//     * @param context Context of the application
//     * @param sportsData ArrayList containing the sports data
//     */
//    SportAdapter(Context context, ArrayList<Sport> sportsData){
//        this.mSportData = sportsData;
//        this.mContext = context;
//
//        //Prepare gray placeholder
//        mGradientDrawable = new GradientDrawable();
//        mGradientDrawable.setColor(Color.GRAY);
//
//        //Make the placeholder same size as the images
//        Drawable drawable = ContextCompat.getDrawable
//                (mContext,R.drawable.img_badminton);
//        if(drawable != null) {
//            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//        }
//
//    }
//
//    /**
//     * Required method for creating the viewholder objects.
//     * @param parent The ViewGroup into which the new View will be added after it is bound to an adapter position.
//     * @param viewType The view type of the new View.
//     * @return The newly create ViewHolder.
//     */
//    @Override
//    public SportAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
//    }
//
//    /**
//     * Required method that binds the data to the viewholder.
//     * @param holder The viewholder into which the data should be put.
//     * @param position The adapter position.
//     */
//    @Override
//    public void onBindViewHolder(SportAdapter.ViewHolder holder, int position) {
//        //get current sport
//        Sport currentSport = mSportData.get(position);
//        //populet the text view with data
//        holder.bindTo(currentSport);
//
//    }
//
//    /**
//     * Required method for determining the size of the data set.
//     * @return Size of the data set.
//     */
//    @Override
//    public int getItemCount() {
//        return mSportData.size();
//    }
//
//    /**
//     * ViewHolder class that represents each row of data in the RecyclerView
//     */
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//        //member variable for the text view
//        private TextView mTitleText;
//        private TextView mInfoText;
//        private ImageView mSportImage;
//
//        /**
//         * Constructor for the ViewHolder, used in onCreateViewHolder().
//         * @param itemView The rootview of the list_item.xml layout file
//         */
//        public ViewHolder(View itemView) {
//            super(itemView);
//
//            //initialize the view
//            mTitleText = itemView.findViewById(R.id.title);
//            mInfoText = itemView.findViewById(R.id.news_description);
//            mSportImage = itemView.findViewById(R.id.sports_image);
//
//            itemView.setOnClickListener(this);
//        }
//
//        void bindTo(Sport currentSport){
//            //Populate the textviews with data
//            mTitleText.setText(currentSport.getTitle());
//            mInfoText.setText(currentSport.getInfo());
//
//            //Load the images into the ImageView using the Glide library
//            Glide.with(mContext).load(currentSport.getImageResource()).placeholder(mGradientDrawable).into(mSportImage);
//        }
//
//        @Override
//        public void onClick(View view) {
//            Sport currentSport = mSportData.get(getAdapterPosition());
//
//            Intent detailIntent = new Intent(mContext, DetailActivity.class);
//            detailIntent.putExtra("title", currentSport.getTitle());
//            detailIntent.putExtra("image", currentSport.getImageResource());
//            detailIntent.putExtra("desc", currentSport.getDescription());
//
//            mContext.startActivity(detailIntent);
//        }
//    }
//}
