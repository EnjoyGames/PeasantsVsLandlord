package com.wooou.pvl;

/**
 * Created by lenovo on 2018/5/25.
 */

//public class Test<T extends B<?>> implements A1 {

    public class Test<T extends B<A2>,A2 extends  A1> implements A1 {

    private T objT;

    public void runTest(){
        //这里需要的是T2,你this 实现的是A1
        //T2 从 A1 继承
        //所以 T 从 B<A1> 向下约束,变成 B<T2>
        //但是 类实现的是A1 不是T2
        //当然 报错
        objT.excuteA(this);
    }

    @Override
    public void helloA() {

    }


}
