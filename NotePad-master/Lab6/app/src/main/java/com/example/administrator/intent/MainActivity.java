package com.example.administrator.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    WebView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bu =(Button)findViewById(R.id.bn);
        show=(WebView)findViewById(R.id.show);
        editText=(EditText)findViewById(R.id.et);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                String text=editText.getText().toString();
                Uri uri= Uri.parse(text);
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            String text=editText.getText().toString();
            show.loadUrl(text);
            return true;
        }
        return false;
    }
}
