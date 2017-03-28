package com.example.customviewindicator;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;

/**
 * Created by pablo.rojas on 27/3/17.
 */

public class CustomIndicator extends LinearLayout {
  private LinearLayout contentView;
  private ArrayList<ImageView> arrayImages;
  private int lastImageSelected;
  private int selectedImageResource;
  private int notSelectedImageResource;

  public CustomIndicator(Context context) {
    super(context);
    inicializar();
  }

  public CustomIndicator(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    inicializar();
  }

  public CustomIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    inicializar();
  }

  public CustomIndicator(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    inicializar();
  }

  private void inicializar() {
    String infService = Context.LAYOUT_INFLATER_SERVICE;
    LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
    li.inflate(R.layout.custom_view, this, true);

    arrayImages = new ArrayList<ImageView>();
    lastImageSelected = 0;
    contentView = (LinearLayout) findViewById(R.id.linearCustom);

  }

  public void setOrientation(int orientation) {
    contentView.setOrientation(orientation);
  }

  public void addNewImage(int numberImages) {
    for (int i = 0; i < numberImages; i++) {
      ImageView imagen = new ImageView(getContext());
      arrayImages.add(imagen);

      if (i == lastImageSelected){
        imagen.setBackgroundResource(selectedImageResource);
      }else{
        imagen.setBackgroundResource(notSelectedImageResource);
      }
      contentView.addView(imagen);
    }
  }

  public void setImageSize(int height, int width) {
    for (ImageView imageView : arrayImages) {
      LayoutParams params = (LayoutParams) imageView.getLayoutParams();
      params.height = height;
      params.width = width;
      imageView.setLayoutParams(params);
    }
  }

  public void setPosition(int left, int top, int right, int bottom){
    LayoutParams params = (LayoutParams) contentView.getLayoutParams();
    params.setMargins(left, top, right, bottom);
    contentView.setLayoutParams(params);
  }

  public void setGravity(int gravity){
    LayoutParams params = (LayoutParams) contentView.getLayoutParams();
    params.bottomMargin = gravity;
    contentView.setLayoutParams(params);
  }

  public void deleteImages(int numimages) {
    for (int i = 0; i < numimages; i++) {
      arrayImages.remove(arrayImages.size()-1);
      resetLayout();
    }
  }

  private void resetLayout() {
    contentView.removeAllViews();
    for (ImageView imageView : arrayImages) {
      contentView.addView(imageView);
    }
  }

  public void setSelectedImage(int position) {
    arrayImages.get(lastImageSelected).setBackgroundResource(notSelectedImageResource);
    lastImageSelected = position -1;
    arrayImages.get(lastImageSelected).setBackgroundResource(selectedImageResource);
  }

  public void setImageResource(int imageSelectedResource, int imageNotSelectedResource) {
    this.notSelectedImageResource = imageNotSelectedResource;
    this.selectedImageResource = imageSelectedResource;
  }

  public int getSelectedImage() {
    return lastImageSelected+1;
  }
}