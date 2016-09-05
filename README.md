# MyUtils 1.01
MyUtils is a utils class group for some android developer daily use fuction

## 中文使用引导 [点击这里](https://github.com/Paul199592/MyUtils/blob/master/README_CHN.md).

#### About PaulActivity & PaulFragment
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
#### About CacheImageLoader
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
#### About FragmentStackManager & FragmentStackManagerV4
This is two stack class for manage the fragment, you can use it like this:
```java
Button back = f(R.id.btn_back);
Button change = f(R.id.btn_change);
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (FragmentStackManager.getInstance().size() > 0){ // Check is that any fragment in stack
            Fragment fragment = FragmentStackManager.getInstance().pop(); // Get last fragment and remove it in stack
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragment, fragment);
            transaction.commit();
        }
    }
});
change.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
            TestFragment1 fragment = new TestFragment1();
            FragmentStackManager.getInstance().push(fragment); // Add the fragment into stack
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragment, fragment);
            transaction.commit();
    }
});
```
Also you can remove the Fragment in the stack like this:
```java
FragmentStackManager.getInstance().removeAll(new TestFragment1()); // Remove all fragment belong to TestFragment1
FragmentStackManager.getInstance().removeFirst(new TestFragment2()); //Remove the first fragment belong to TestFragment2 in stack
FragmentStackManager.getInstance().removeLast(new TestFragment2()); //Remove the last fragment belong to TestFragment2 in stack
```
#### About UriToUrlParsor
This is a class for trans the uri to url path, you can use like this:
 ```java
UriToUrlParsor.getPath(this, uri);
```
#### About FileOpener
This is a class for help you automatically select the open app on intent, you can use like this:
 ```java
FileOpener.openFile(this, new File(path));
```

