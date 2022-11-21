package me.day10.constructor;

class A {}
class B {}

public class ConstructorNotGoodCode {
    private A a;
    private B b;

    // 안좋음
    public ConstructorNotGoodCode() { // - 1 맥북
        a = new A();
        b = new B();
    }

    // 이 코드가 더 좋음
    public ConstructorNotGoodCode(A a, B b) { // - 2 리모콘 (리모콘 / 건전지 회사)
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "ConstructorNotGoodCode{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}