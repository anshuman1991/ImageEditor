package com.anshuman.imageeditor;

import android.media.ExifInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;


public class SaveImageTagActivity extends ActionBarActivity implements View.OnClickListener {

    private String imagePath;

    private float x;

    private float y;

    private EditText place;

    private EditText brand;

    private EditText URL;

    private Button doneButton;

    private ExifInterface exifInterface;

    private static int tagNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_image_tag);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            imagePath = extras.getString("FILE_PATH");
            x = extras.getFloat("X_VALUE");
            y = extras.getFloat("Y_VALUE");
        }
        place = (EditText) findViewById(R.id.editText_place);
        brand = (EditText) findViewById(R.id.editText_brand);
        URL = (EditText) findViewById(R.id.editText_URL);
        doneButton = (Button) findViewById(R.id.save_button);
        doneButton.setOnClickListener(this);
        try {
          exifInterface = new ExifInterface(imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tagNumber++;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_save_image_tag, menu);
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
    public void onClick(View v) {
        saveInputFieldsToImage();
    }

    public void saveInputFieldsToImage(){
        exifInterface.setAttribute("TAG_X_COORD", String.valueOf(x));
        exifInterface.setAttribute("TAG_Y_COORD", String.valueOf(y));
        
    }
}
