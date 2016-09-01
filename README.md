# MyUtils
MyUtils is a utils class group for some android developer daily use fuction

##### About PaulActivity
When you extend your activity from this activity you can just change your code:
```java
ImageView img = (ImageView) findViewById(R.id.image);
```
to:
```java
ImageView img = f(R.id.image);
```
It can make your code cleaner!!!!
This is because I built a function in PaulActivity like this:
```java
protected <T>T f(int resourceId){
    T view = (T) findViewById(resourceId);
    return view;
}
```
##### About CacheImageLoader
I also created a class on ImageLoader, but the different is I built a cache interface for it, you can use the CacheImageLoader like this:
```java
ImageView test = f(R.id.txt_test);
        new CacheImageLoader(this)
                .from("http://www.opsactive.com/wp-content/uploads/2012/11/Surface-Screenshot.png")//The Image URL here
                .failedImage(R.drawable.failed)//The Resource Id for image when failed, also can put a bitmap here
                .loadingImage(R.drawable.loading)//The Resource Id for image when loading, also can put a bitmap here
                .cacheTypt(new BothCache())/*
                                                I built 3 kind of Cache logic here
                                                MemoryCache just use the memory, you can set new MemoryCache(percent), percent is a int value between 0 and 100, for seting the percent of memory use for cache initialize 
                                                DiskCache just use the storage, you can set new DiskCache(), the cache path will be sdcard/cache
                                                BothCache use both memory and storage to cache, will use 20 percent of memory for caching
                                                You also can set your own cache by write new ImageCache and implement the interface here
                                            */
                .into(test);// This is for the target ImageView
```
