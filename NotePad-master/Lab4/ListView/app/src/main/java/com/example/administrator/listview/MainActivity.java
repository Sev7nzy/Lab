package com.example.administrator.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private String[] names =new String[]
            {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private  int[] imageIds=new int[]
            {R.drawable.lion ,R.drawable.tiger , R.drawable.monkey, R.drawable.dog,R.drawable.cat,
            R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String, Object>>listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0;i<names.length;i++)
        {
            Map<String, Object>listItem = new HashMap<String, Object>();
            listItem.put("name", names[i]);
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                listItems,R.layout.simple,new String[]{"name","image"},
                new int[]{R.id.name,R.id.image});
        ListView list = (ListView) findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast toast =Toast.makeText(MainActivity.this,names[position],Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Toast toast =Toast.makeText(MainActivity.this,names[position],Toast.LENGTH_SHORT);
                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
