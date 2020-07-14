package org.pine.test;

import org.pine.api.Pine;
import org.pine.api.PineLiker;

public class BasicUse {
    public static void main(String[] args) {
        Pine.init("redis", "121.199.43.220:6379:wp123456", 2);
        // Or use : Pine.init("distkv", "127.0.0.1:8082");

        PineLiker liker = Pine.newLiker();
        liker.topic("nihao").likesFrom("zhangsan");
        liker.topic("nihao").likesFrom("zhangsan");
        System.out.println("topic 'nihao' likesFrom num  = " + liker.topic("nihao").count());

        liker.topic("nihao").likesFrom("lisi");
        System.out.println("topic 'nihao' likesFrom num  = " + liker.topic("nihao").count());

        System.out.println("is Ture? " + liker.topic("nihao").unlikesFrom("zhangsan"));
        System.out.println("is False? " + liker.topic("nihao2").unlikesFrom("zhangsan"));
        //liker.topic("nihao2").unlikesFrom("zhangsan");

        System.out.println("topic 'nihao' likesFrom num  = " + liker.topic("nihao").count());

        Pine.shutdown();
    }
}