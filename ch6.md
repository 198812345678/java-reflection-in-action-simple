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

> 6.4
>> class有三种状态，unloaded,只是一个class文件的状态；loaded，class对象已经被创建；active，有实例或者子类被加载或者有方法在执行
>> 
>> 6.4.1
>>> active class 被替换有两个条件，一要维护所有实例的引用，二要有方法能够把实例从一种实现换到另一种,evolve方法的目的是新的替换实现要根据老的实现生成
>>> 主要设计思路是，client端通过AbstractProduct获取当前实例的代理对象（TODO 为啥要用代理），AbstractProduct.newInstance返回当前最新实现类的实例化对象，AbstractProduct.reload刷新最新的实现类
>>
>> 类签名不改变（不然所有类及其依赖的类名字都要改），所以替换类存在于另外的pakage里；使用不同的类加载器实现替换类，是为了避免使用相同类加载器遇到签名相同的类导致老的类混淆进来（TODO 不同的package怎么会有同名类？）
>> TODO : 为啥用代理，为啥维护所有老的实现对象，为啥用弱引用
