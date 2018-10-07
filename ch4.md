### Using Java dynamic proxy

> 一种场景
> 对于一个普通的类，如果要对每个方法的出参入参做trace，就要实现一个trace版本，如果要保证每个方法的执行都是原子的，就要实现一个原子版本，如果既要trace又要原子，还要另一个版本
> 加入每一种能力和将能力组合起来，都需要通过实现新的版本的话，类的数量是指数增加的
> 代理能解决这个问题？

> 创建的代理对象也是Object的子类，对于Object定义的方法代理类会怎么处理
* hashCode, equals, and toString 三个方法会像其他普通方法一样，被派发到InvocationHandler去invoke
* clone()方法要看接口有没有继承Cloneable {@link com.will.simple.java.reflection.in.action.ch4.ProxyObj.clone}
* 除此之外的其他方法，会像其他正常对象一样，调用到代理对象的方法上，因此代理对象不能代理多线程编程用到的锁/wait等方法

> java.lang.reflect.InvocationHandler.invoke的返回值
* com.will.simple.java.reflection.in.action.common.MethodUtil.invokeVoidMethod 返回void不用特殊处理
* target接口返回基本类型，invoke会返回包装类型，要注意不能返回null，否则会有空指针异常
* 返回类型不能转换成target接口返回类型的，会抛类型转换异常

> 对于生成的代理对象，instance of 操作 Proxy 和 Target的接口，都是true，但是对于Target是false


