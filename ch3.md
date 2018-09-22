### Dynamic loading and reflective construction

* newInstance方法要求有无参构造方法

* 还可以通过Constructor来实例化对象，Constructor类似Method

* 序列化和反序列化都需要特殊处理数组, 实例化数据的时候基本类型和非基本类型区分处理

* 反射处理序列化和反序列化要考虑, readeObject()和writObject()方法的使用, 针对transient关键字的处理, final属性的处理

* 针对没有无参构造方法的类型, 要保存映射,知道使用哪个构造方法

