# GradientBackground

Little Android dynamic gradient background library

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
implementation "com.thrashedbrain.gradientbackground:0,1-alpha"
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
