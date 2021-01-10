# GradientBackground

Little Android dynamic gradient background library

![](https://raw.githubusercontent.com/thrashedbrain/GradientBackground/master/picture.gif)

# Setup

## Add a gradle dependency

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```
implementation 'com.github.thrashedbrain:GradientBackground:0.2.1'
```

## Usage 

```java
gradBg = new GradientBackground.Builder()
                .addColor("#ff5400", "#ffb600")
                .addColor("#9d4edd", "#ff9100")
                .setDuration(5500)
                .build();
        gradBg.init();
        gradBg.start(frameLayout);
```

Also add

```java
@Override
    protected void onPause() {
        gradBg.onPause();
        super.onPause();
    }
```

```java
@Override
    protected void onResume() {
        super.onResume();
        gradBg.onResume();
    }
```
