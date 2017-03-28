# CustomViewIndicator

[![](https://jitpack.io/v/GigigoGreenLabs/CustomViewIndicator.svg)](https://jitpack.io/#GigigoGreenLabs/CustomViewIndicator)

# Example of use

 ```
    CustomIndicator customView = (CustomIndicator) findViewById(R.id.customview);
    customView.setImageResource(R.mipmap.ic_launcher, R.mipmap.ic_launcher_round);
    customView.addNewImage(int numberOfImages);
```

sets the selected and the unselected image to the view, adds to arrayImages new ImageView and loads into view

```
    customView.setOrientation(LinearLayout.HORIZONTAL);
```

sets the orientation

``` 
    customView.setImageSize(int height, int width);
``` 

sets image size

``` 
    customView.setPosition(int marginLeft,int marginTop,int marginRight,int marginBottom); 
``` 

sets the margin of de custom view

```
    customView.deleteImages(int number);
``` 

deletes last images of arrayImages

``` 
    customView.setSelectedImage(int position);
``` 
sets the selected Image

``` 
    customView.getSelectedImage();
``` 
Returns the selected Image
 

 
 You can use this library importing the glide or picasso dependency in your build.gradle file

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
 
### TODO


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
 
 
