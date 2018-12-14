package com.example.stone.photo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listview extends ListActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> list = new ArrayList<String>();
        list.add("2018.11");
        list.add("2018.12");
        ListAdapter a = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        setListAdapter(a);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        int [] imageIDs = null;

        switch (position){
            case 0:
                imageIDs=new int[5];
                imageIDs[0]=R.drawable.image01;
                imageIDs[1]=R.drawable.image02;
                imageIDs[2]=R.drawable.image03;
                imageIDs[3]=R.drawable.image04;
                imageIDs[4]=R.drawable.image05;
                break;
            case 1:
                imageIDs=new int[5];
                imageIDs[0]=R.drawable.image06;
                imageIDs[1]=R.drawable.image07;
                imageIDs[2]=R.drawable.image08;
                imageIDs[3]=R.drawable.image09;
                imageIDs[4]=R.drawable.image10;
                break;
            default:
                break;
        }
        Log.v("list click","case");
        Intent intent = new Intent(listview.this,myGallery.class);
        intent.putExtra("IMAGEIDS",imageIDs);
        startActivity(intent);
    }
}
