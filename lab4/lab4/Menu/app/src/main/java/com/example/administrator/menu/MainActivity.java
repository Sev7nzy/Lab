package com.example.administrator.menu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.BLACK;

public class MainActivity extends AppCompatActivity {
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView)findViewById(R.id.txt);
        registerForContextMenu(txt);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflator=new MenuInflater(this);
        inflator.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflator=new MenuInflater(this);
        inflator.inflate(R.menu.context, menu);
        menu.setHeaderTitle("选择背景色");

    }
    @Override
    public boolean onContextItemSelected(MenuItem mi) {
        //勾选菜单项
        mi.setCheckable(true);  //①
        switch(mi.getItemId())
        {
            case R.id.red:
                mi.setCheckable(true);
                txt.setBackgroundColor(Color.RED);
                break;
            case R.id.black:
                mi.setCheckable(true);
                txt.setBackgroundColor(BLACK);
                break;
        }
        return true;

    }
    //菜单项被单击后的回调方法
    @Override
    public boolean onOptionsItemSelected(MenuItem mi) {
        if(mi.isCheckable())
        {
            mi.setCheckable(true);//②
        }
        switch(mi.getItemId())
        {
            case R.id.font_10:
                txt.setTextSize(10*2);
                break;
            case R.id.font_16:
                txt.setTextSize(16*2);
                break;
            case R.id.font_20:
                txt.setTextSize(20*2);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                mi.setCheckable(true);
                break;
            case R.id.black_font:
                txt.setTextColor(BLACK);
                mi.setCheckable(true);
                break;
            case R.id.plain_item:
                Toast toast= Toast.makeText(MainActivity.this, "您单击了普通菜单项",Toast.LENGTH_SHORT);
                toast.show();
                break;

        }
        return true;
    }
}
