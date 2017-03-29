package com.example.pablorojas.customlistviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.customviewindicator.CustomIndicator;

public class MainActivity extends AppCompatActivity {

  CustomIndicator customView;
  final int vertical = LinearLayout.VERTICAL;
  final int horizontal = LinearLayout.HORIZONTAL;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    customView = (CustomIndicator) findViewById(R.id.customview);
    settings();
  }

  private void settings() {
    customView.initWithImages(5);

    //customView.setOrientation(vertical);
    //customView.setImageResource(R.drawable.selectedpin, R.drawable.unselectedpin);
    //customView.setImageSize(40,40);
    //customView.setPosition(50,50,0,0);
    //customView.deleteImages(4);
    ///customView.setSelectedImage(3);
  }
}
