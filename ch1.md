### A few basics

>       this.getClass().getName()是具体子类的名字


> 一个场景，使用的第三方组件中有setColor方法的多个实现，入参相同，但是这些实现相互独立没有实现同一个接口
> 要给公司其他同事提供接口，内部使用这个第三方库实现功能
> 针对第三方库的每一种实现提供一个接口给同事调不合适
> 自己封装一层，对外暴漏自定义的类型，内部实现做适配，这样有很多判断而且是写死的
> 利用反射，暴漏出的接口接收第三方库的具体实现类作为参数，内部实现利用反射调用第三方库，不判断具体实现类型


> * introspection 自省能力，是指在运行时可以查看程序的结构行为等
> * metaobjects 用以表达程序自身的对象，比如Class，Method
> * base-level objects 用以实现代码业务逻辑的对象

> getClass 方法是Object类的方法，所以所有对象都可以获取其类型，并且是final方法，保证方法的语义不变

> getDeclaredMethods可以得到所有访问级别的方法, 要是类本身声明的，继承的不算

> 8种基本类型和void也有class对象

> 基本类型作为入参和返回值的时候，反射会执行自动装箱

> 对于返回void的方法，反射invoke会返回null

> Class.getInterfaces 如果是class调用返回implements后的声明的，如果是interface调用返回extends后声明的，不会递归