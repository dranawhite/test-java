package com.dranawhite.spring.aop;

/**
 * @author liangyq 2017/8/18
 */
class ApolopyImpl implements Apolopy {

    @Override
    public void sayAgain() {
        System.out.println("Spring Aspect-引入增强");
    }
}
