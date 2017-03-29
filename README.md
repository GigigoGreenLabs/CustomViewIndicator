# CustomViewIndicator

[![](https://jitpack.io/v/GigigoGreenLabs/CustomViewIndicator.svg)](https://jitpack.io/#GigigoGreenLabs/CustomViewIndicator)

# Example of use

 ```
    CustomIndicator customView = (CustomIndicator) findViewById(R.id.customview);

    customView.initWithImages(int numberImages);

```


You can set the attributes in you xml file:

```
 <com.example.customviewindicator.CustomIndicator
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:id="@+id/customview"
      app:size="50"
      app:orientation="0"
      app:selectedImage="@drawable/selectedpin"
      app:unselectedImage="@drawable/unselectedpin">
  </com.example.customviewindicator.CustomIndicator>

```


Or in your java file:

```
    customView.setOrientation(LinearLayout.HORIZONTAL);
```

Sets the orientation.

``` 
    customView.setImageSize(int height, int width);
``` 

Sets image size.

``` 
    customView.setPosition(int marginLeft,int marginTop,int marginRight,int marginBottom); 
``` 

Sets the margin of de custom view.

```
    customView.deleteImages(int number);
``` 

Delete last number of images of the ImageView array.

``` 
    customView.setSelectedImage(int position);
``` 

Sets the selected Image.

``` 
    customView.getSelectedImage();
``` 
Returns the selected Image.
 

 
 You can use this library importing the dependency in your build.gradle file

```
Add it in your root build.gradle at the end of repositories:

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Add the dependency
 
  dependencies {
	        compile 'com.github.GigigoGreenLabs:CustomViewIndicator:1.0'
	}
```



License
----

Copyright 2016 Gigigo.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 
 
