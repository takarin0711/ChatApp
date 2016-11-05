package com.example.takay_000.chatapp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.button;
import static android.R.attr.id;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public EditText editText;
    public String SaveText="";

    CustomAdapter customAdapter;

    // リソースに準備した画像ファイルからBitmapを作成しておく
    Bitmap image;
    Bitmap image2;

    // データの作成
    List<CustomData> objects = new ArrayList<CustomData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        image = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        image2 = BitmapFactory.decodeResource(getResources(), R.mipmap.computer);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);

        customAdapter = new CustomAdapter(this, 0, objects);

        editText = (EditText) findViewById(R.id.editText);

        ListView listView=(ListView)findViewById(R.id.ListView);

        listView.setAdapter(customAdapter);

    }

    @Override
    public void onClick(View v) {

        CustomData item1 = new CustomData();
        item1.setImagaData(image);
        item1.setTextData(editText.getText().toString());
        item1.setNameData("Taka");
        objects.add(item1);
        SaveText = SaveText + "Taka: " + editText.getText().toString() + "\r\n";

        // 1秒後に応答
        new Handler().postDelayed(func, 1000);

    }

    // 応答はEchoとした
    private final Runnable func= new Runnable() {
        @Override
        public void run() {
            CustomData item2 = new CustomData();
            item2.setImagaData(image2);
            item2.setTextData(editText.getText().toString());
            item2.setNameData("Computer");
            objects.add(item2);
            SaveText = SaveText + "Computer: " + editText.getText().toString() + "\r\n";
            editText.getEditableText().clear();
            System.out.println(SaveText);

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
        }else if(id == R.id.Output){ // 会話を保存して出力
            String path = Environment.getExternalStorageDirectory().getPath() + "/file.txt";
            try {
                FileOutputStream fos = new FileOutputStream(path);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(SaveText);
                bw.flush();
                bw.close();
            } catch (FileNotFoundException e) {
                Log.d("MainActivity", e.toString());
            } catch (IOException e) {
                Log.d("MainActivity", e.toString());
            }
        }else if(id == R.id.Input){ // 読み込み
            try{
                FileInputStream in = openFileInput( "file.txt" );
                BufferedReader reader = new BufferedReader( new InputStreamReader( in , "UTF-8") );
                String str = "";
                String tmp;
                while( (tmp = reader.readLine()) != null ){
                    str = str + tmp + "\n";
                }
                reader.close();
            }catch( IOException e ){
                e.printStackTrace();
            }
        }

        return super.onOptionsItemSelected(item);
    }

}
