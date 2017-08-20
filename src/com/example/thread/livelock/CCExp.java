package com.example.thread.livelock;

public class CCExp {

    interface Min {
    }

    class A {
    }

    class B extends A implements Min {
    }

    class C extends B {
    }


    CCExp(){
        A a = new A();
        B b = new B();
        C c = new C();

        //m is null, can be cast to everything :-P
        Min m = null;
        b = (C) m;
        m = (Min) b;
        A a2 = (A) (Min) m;
        B b2 = (B) a2;
        Min m2 = (C) b2;
        C c2 = (C) m2;

        //Read right to left
        //B is-an A
        A aa = b;

        // A !is-a B
        //B bb = a;
    }

    public static void main(String args[]) {
       new CCExp();
    }
}
