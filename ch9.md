### Evaluating performance

> 反射对性能的影响有三点
>> 1. 构造class对象，动态加载合委托模式，会有消耗
>> 1. 运行时消耗，运行时Method.invoke会比编译好的方法耗时
>> 1. 粒度过大导致的消耗，比如动态代理在方法前后做些事情，但并不是所有方法都需要这个特殊处理

> using microbenchmarks
>> 好的mirobenchmarks
>>> 1. 循环控制，并且可以获取这种控制的消耗
>>> 1. 预热，被评估的代码有可能需要消除方差，比如类加载初始化的消耗应该排除在外，可以在评估之外提前执行一次代码
>>> 1. 时钟
>>> 1. 编译优化的坑，比如评估循环控制消耗的时候，编译优化会优化空循环，导致无法获取这种消耗
>>> 1. GC或者网络开销的干扰