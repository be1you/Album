package com.example.stone.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Gallery;

import java.io.IOException;

public class myGallery extends Activity {

    public ImageView imageView;
    public int[] imageIDs=null;


    class ImageAdaper extends BaseAdapter {
        private Context context;
        private int itemBackground;
        public ImageAdaper (Context c) {
            context=c;
            TypedArray a  =obtainStyledAttributes(R.styleable.Gallery1);
            itemBackground=a.getResourceId(R.styleable.Gallery1_android_galleryItemBackground,0);
            Log.v("imageadaper resourceid", "info");
            a.recycle();
            Log.v("imageadaper recycle", "info");
        }
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
            //return imageIDs.length;
        }
        @Override
        public Object getItem(int arg0) {
            Log.v("imageadaper item", "info");

            return arg0;
        }
        @Override
        public long getItemId(int arg0) {
            Log.v("imageadaper itemid", "info");
            return arg0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView=new ImageView(context);
            imageView.setImageResource(imageIDs[position%imageIDs.length]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new Gallery.LayoutParams(350,300));//设置Gallery缩略图大小
            imageView.setBackgroundResource(itemBackground);
            Log.v("imageadaper getview", "info");
            return imageView;
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mygalley);
        Log.v("gallery imageview","info");


//        //播放音乐
//        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.backgroundmusic);
//        try {
//            mediaPlayer.prepare();
//        }
//        catch (IllegalStateException e){
//            e.printStackTrace();
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        mediaPlayer.start();


        Intent intent  = getIntent();
        Log.v("gallery iamgeview","info");

        imageIDs=intent.getIntArrayExtra("IMAGEIDS");

        Log.v("gallery imageviewextra", "info");

        imageView=(ImageView)findViewById(R.id.image1);
        Log.v("gallery imageviewid", "info");

        imageView.setImageResource(imageIDs[0]);
        Log.v("gallery imgviewresource", "info");

        Gallery gallery=(Gallery) findViewById(R.id.gallery1);
        Log.v("gallery galleryid", "info");

        gallery.setAdapter(new ImageAdaper(this));
        Log.v("gallery setadper", "info");

        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View v, int position, long id) {
                imageView.setImageResource(imageIDs[position%imageIDs.length]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Log.v("gallery adaper", "info");

    }
}
