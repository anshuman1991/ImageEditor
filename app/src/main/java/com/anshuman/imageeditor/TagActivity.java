package com.anshuman.imageeditor;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;


public class TagActivity extends ActionBarActivity implements View.OnLongClickListener, View.OnTouchListener {

    private String imagePath;

    private ImageView imageView;

    private float x;

    private float y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            imagePath = extras.getString("FILE_PATH");
        }
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setOnLongClickListener(this);
        imageView.setOnTouchListener(this);
    }

    @Override
    public boolean onLongClick(View v){
        Intent intent = new Intent(getApplicationContext(), SaveImageTagActivity.class);
        intent.putExtra("X_VALUE", x);
        intent.putExtra("Y_VALUE", y);
        intent.putExtra("FILE_PATH", imagePath);
        Toast.makeText(getApplicationContext(), "X : " + x + ", Y : " + y , Toast.LENGTH_LONG).show();
        return true;

    }

    @Override
    public void onResume(){
        super.onResume();
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        imageView.setImageBitmap(bitmap);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tag, menu);
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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        return false;
    }
}
