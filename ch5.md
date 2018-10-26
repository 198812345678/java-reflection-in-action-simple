### call stack introspection

> 简单说明
>> * 每一个线程运行时都有一个call stack，包含多个stack frame
>> * 每一个frame代表一个方法的调用
>> * stack frame 中包含方法标识、当前执行语句的位置、方法的参数、本地变量和变量的值
>> * （TODO）Each stack frame represents the method last called by the method in the frame below it
>> * java中，call stack底部的一个stack frame是main方法或者thread的run方法
>> * 可以通过call stack获取线程运行的上下文，上下文中包括当前执行的方法名，调用到当前方法的方法路径

> java中不能直接拿到调用堆栈（？通过当前线程也能获取到吧 {@link com.will.simple.java.reflection.in.action.ch5.StackTraceTest.test}），通过Throwable对象可以获取到

> static修饰的逻辑中，没办法用对象