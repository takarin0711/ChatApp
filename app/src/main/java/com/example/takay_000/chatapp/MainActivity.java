package com.example.takay_000.chatapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.button;
import static android.R.attr.id;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public EditText editText;
    // ArrayAdapter<String> adapter;

    CustomAdapter customAdapter;
    // リソースに準備した画像ファイルからBitmapを作成しておく
    Bitmap image;
    // データの作成
    List<CustomData> objects = new ArrayList<CustomData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        image = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);




        ListView listView=(ListView)findViewById(R.id.ListView);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);


        // adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        customAdapter = new CustomAdapter(this, 0, objects);

        editText = (EditText) findViewById(R.id.editText);

        listView.setAdapter(customAdapter);

    }

    @Override
    public void onClick(View v) {

        CustomData item1 = new CustomData();
        item1.setImagaData(image);
        item1.setTextData("taka: "+editText.getText().toString());
        customAdapter.add(item1);

        //adapter.add("Taka: "+editText.getText().toString());

        // 1秒後に応答
        new Handler().postDelayed(func, 1000);

    }

    private final Runnable func= new Runnable() {
        @Override
        public void run() {
            CustomData item2 = new CustomData();
            item2.setImagaData(image);
            item2.setTextData("Computer: "+editText.getText().toString());
            customAdapter.add(item2);

            // adapter.add("Computer: "+editText.getText().toString());
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
