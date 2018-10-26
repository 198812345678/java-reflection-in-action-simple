### Using the class loader

> 委托模式
>> * class loader加载类从loadClass方法开始
>> * 第一步，当前class loader调用findLoadedClass方法寻找已经存在的class
>> * 第二步，如果没找到，调用parent class loader的localClass方法，这是个递归的过程，parent class loader还有可能调用他的parent class loader的localClass方法，这是委托模式
>> * 第三步，都没有找到，初始class loader调用findClass方法，读取字节码，然后defineClass方法生成class
>> * 第四步，还没找到抛异常ClassNotFoundException

> 所有class loader都继承ClassLoader类，但parent class loader并不是父类

> 对于一个class来说，调用defineClass生成该class的class loader是defining loader, getClassLoader方法返回的就是这个class loader
> 所有参与到这个过程中，调用loadClass方法的class loader叫做initiating loader，可能有多个
> 数组的class对象是JVM自动创建的，不是由class loader创建，getClassLoader方法返回的是其元素的class loader
> 基本类型的getClassLoader返回null 

> 自定义class loader推荐重写findClass方法，因为loadClass方法里实现了委托模式（重写可能打破这种模式？）

> system class loader的class path是启动时缓存的，所以运行时更改不起作用，运行时可以用自定义的classLoader加载class

> TODO 例子中的自定义classLoader每次加载的类都是一份copy，所以类的static数据都会重新初始化？

> java语言中类签名可以唯一标识一个class，JVM中签名和类加载器共同标识一个class

> defineClass方法生成class的时候，依赖的其他class会被对应加载器加载
> Class.forName()使用调用该方法的类的加载器，加载目标类

> listing 6.3中的ConstructOnce不能有任何引用，不然SimpleClassLoaderTest加载的时候ConstructOnce就会被system class loader加载，自定义加载器的findClass方法得不到执行
> 同时ConstructOnce如果在classPath中，System Class Loader能够加载他，就轮不到自定义加载器加载（因为System Class Loader是parent class loader）

