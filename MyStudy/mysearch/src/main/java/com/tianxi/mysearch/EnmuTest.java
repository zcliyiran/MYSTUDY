package com.tianxi.mysearch;

/**
 * Created by admin on 17/4/12.
 */

public enum EnmuTest {
    instancse,
    instancse2;
    MySingleton instasnce;

   AB instance;
    EnmuTest(){//枚举类的构造方法在类加载是被实例化
        instance = new AB();
        instance2 = new MySingleton();
    }

    public AB getInstance(){
        return instance;
    }




    private MySingleton instance2;

//     EnmuTest(){//枚举类的构造方法在类加载是被实例化
//
//    }

    public MySingleton getInstance2(){
        return instance2;
    }
//}
}
class MySingleton{//需要获实现单例的类，比如数据库连接Connection
    public MySingleton(){}
}
class AB{

    public AB() {
    }
}