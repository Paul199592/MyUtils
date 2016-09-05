# MyUtils 1.01
这是一个由Paul Liang开发的用于处理Android程序员日常所遇到的问题的工具类的集合



#### 关于 PaulActivity & PaulFragment这两个类
当你将你的Fragment或者Activity拓展至这两个类，你可很简单将以下代码:
```java
ImageView img = (ImageView) findViewById(R.id.image);
```
转换成这样:
```java
ImageView img = f(R.id.image);
```
这可以让你的代码变得很整洁!!!!<br>
因为我在对应类中加入了如下的方法:
```java
protected <T>T f(int resourceId){
    T view = (T) findViewById(resourceId);
    return view;
}
```
#### 关于 CacheImageLoader
这是一个图片加载类，可以将图片依据不同的缓存策略缓存至本地或者内存中，你可以如此使用:
```java
ImageView test = f(R.id.txt_test);
        new CacheImageLoader(this)
                .from("http://www.opsactive.com/wp-content/uploads/2012/11/Surface-Screenshot.png")//图片的URL链接
                .failedImage(R.drawable.failed)//加载失败提示图片的资源ID或者bitmap对象
                .loadingImage(R.drawable.loading)//加载中提示图片图片的资源ID或者bitmap对象
                .cacheTypt(new BothCache())/*
                                                我已经构建了三种默认的缓存策略
                                                MemoryCache 是一个仅使用内存的缓存策略, 使用如下: new MemoryCache(percent), percent 是一个0-100的整数值，用于设定缓存占用内存的百分比
                                                DiskCache 是一个仅使用存储进行缓存的策略, 使用如下: new DiskCache(), 缓存文件的路径如下: sdcard/cache
                                                BothCache 是一个同时使用内存和存储的缓存策略，将使用20%的可分配内存，使用如下: new BothCache()
                                                同时你也可以自己建立一个缓存策略，只需在类中实现 ImageCache 这个接口就好
                                            */
                .into(test);// 这是图片加载所在的控件
```
#### 关于 FragmentStackManager & FragmentStackManagerV4
这是两个针对Fragment栈管理的类，你可以像这样使用:
```java
Button back = f(R.id.btn_back);
Button change = f(R.id.btn_change);
back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (FragmentStackManager.getInstance().size() > 0){ // 查看栈内是否有fragment
            Fragment fragment = FragmentStackManager.getInstance().pop(); // 弹栈
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
            FragmentStackManager.getInstance().push(fragment); // 压栈
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.fragment, fragment);
            transaction.commit();
    }
});
```
当然你也可以像这样，删除栈中指定的fragment:
```java
FragmentStackManager.getInstance().removeAll(new TestFragment1()); // Remove all fragment belong to TestFragment1
FragmentStackManager.getInstance().removeFirst(new TestFragment2()); //Remove the first fragment belong to TestFragment2 in stack
FragmentStackManager.getInstance().removeLast(new TestFragment2()); //Remove the last fragment belong to TestFragment2 in stack
```
#### 关于 UriToUrlParsor
这是一个能够完美将Uri转换成Url的类，同时对应多种uri格式，使用如下：
 ```java
UriToUrlParsor.getPath(this, uri);
```
#### 关于 FileOpener
这是一个能自动根据你的文件类型生成意图的类， 你可像这样使用它:
 ```java
FileOpener.openFile(this, new File(path));
```

