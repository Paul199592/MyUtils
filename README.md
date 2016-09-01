# MyUtils
MyUtils is a utils class group for some android developer daily use fuction

##### About PaulActivity
When you extend your activity from this activity you can just change your code:
```android
ImageView img = (ImageView) findViewById(R.id.image);
```
to:
```android
ImageView img = f(R.id.image);
```
It can make your code cleaner!!!!
This is because I built a function in PaulActivity like this:
```android
protected <T>T f(int resourceId){
    T view = (T) findViewById(resourceId);
    return view;
}
```
