package com.example.pablorojas.customlistviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.customviewindicator.CustomIndicator;

public class MainActivity extends AppCompatActivity {

  CustomIndicator customView;
  int vertical = LinearLayout.VERTICAL;
  int horizontal = LinearLayout.HORIZONTAL;



  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    customView = (CustomIndicator) findViewById(R.id.customview);
    settings();
  }

  private void settings() {
    customView.setOrientation(horizontal);
    customView.setImageResource(R.mipmap.ic_launcher, R.mipmap.ic_launcher_round);
    customView.setNumberOfImages(4);
    customView.setImageSize(150,150);
    customView.setPosition(50,50,0,0);
    customView.deleteImages(4);
    customView.setSelectedImage(3);
    int lastImage = customView.getSelectedImage();
    Toast.makeText(this, "Ultima imagen seleccionada "+ lastImage, Toast.LENGTH_SHORT).show();
    //customView.setGravity(gravity);
  }
}
