package com.example.customviewindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by pablo.rojas on 27/3/17.
 */

public class CustomIndicator extends LinearLayout {
  private LinearLayout contentView;
  private ArrayList<ImageView> arrayImages;
  private int lastImageSelected;
  private int selectedImageResource;
  private int unselectedImageResource;
  private int height;
  private int width;
  private int orientation;

  public CustomIndicator(Context context) {
    super(context);
    init(null, 0);
  }

  public CustomIndicator(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs, 0);
  }

  public CustomIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs, defStyleAttr);
  }

  private void init(AttributeSet attrs, int defStyle) {
    String infService = Context.LAYOUT_INFLATER_SERVICE;
    LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
    li.inflate(R.layout.custom_view, this, true);
    arrayImages = new ArrayList<ImageView>();
    lastImageSelected = 0;
    selectedImageResource = 0;
    unselectedImageResource = 0;
    height = 0;
    width = 0;
    orientation = 0;
    contentView = (LinearLayout) findViewById(R.id.linearCustom);
    loadAttributes(attrs, defStyle);
  }

  private void loadAttributes(AttributeSet attrs, int defStyle) {
    final TypedArray a =
        getContext().obtainStyledAttributes(attrs, R.styleable.CustomIndicator, defStyle, 0);
    int size = a.getInteger(R.styleable.CustomIndicator_size, 100);
    height = size;
    width = size;
    orientation = a.getInteger(R.styleable.CustomIndicator_orientation, LinearLayout.HORIZONTAL);
    selectedImageResource =
        a.getResourceId(R.styleable.CustomIndicator_selectedImage, R.drawable.selectedpin);
    unselectedImageResource =
        a.getResourceId(R.styleable.CustomIndicator_unselectedImage, R.drawable.unselectedpin);
    if (orientation == 1) {
      setOrientation(LinearLayout.VERTICAL);
    } else {

    }
    a.recycle();
  }

  public void setOrientation(int orientation) {
    contentView.setOrientation(orientation);
  }

  public void initWithImages(int numberImages) {
    if (selectedImageResource == 0 && unselectedImageResource == 0) {
      Toast.makeText(getContext(), "Imagenes no seleccionadas", Toast.LENGTH_SHORT).show();
    } else {
      for (int i = 0; i < numberImages; i++) {
        ImageView image = new ImageView(getContext());
        arrayImages.add(image);

        if (i == lastImageSelected) {
          image.setBackgroundResource(selectedImageResource);
        } else {
          image.setBackgroundResource(unselectedImageResource);
        }
        contentView.addView(image);
      }
    }
    if (width != 0 && height != 0) {
      setImageSize(width, height);
    } else {
      setImageSize(100, 100);
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

  public void setPosition(int left, int top, int right, int bottom) {
    LayoutParams params = (LayoutParams) contentView.getLayoutParams();
    params.setMargins(left, top, right, bottom);
    contentView.setLayoutParams(params);
  }

  public void deleteImages(int numberImages) {
    for (int i = 0; i < numberImages; i++) {
      arrayImages.remove(arrayImages.size() - 1);
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
    arrayImages.get(lastImageSelected).setBackgroundResource(unselectedImageResource);
    lastImageSelected = position - 1;
    arrayImages.get(lastImageSelected).setBackgroundResource(selectedImageResource);
  }

  public void setImageResource(int imageSelectedResource, int imageNotSelectedResource) {
    this.unselectedImageResource = imageNotSelectedResource;
    this.selectedImageResource = imageSelectedResource;
  }

  public int getSelectedImage() {
    return lastImageSelected + 1;
  }
}