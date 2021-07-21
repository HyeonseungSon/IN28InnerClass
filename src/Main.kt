/*
중첩 클래스 (Inner Class)
 - 내부 Class 는 외부 Class 로부터 생성된 객체를 통해서만 객체 생성이 가능하다.
 - 외부 Class 는 내부 Class 의 Member 를 자유롭게 사용할 수 없지만
  내부 Class 는 외부 Class 의 Member 를 자유롭게 사용할 수 있다.
    [형식]
    var a1 = Outer1()
    var a2 = a1.Inner1()
 */
fun main() {

    val obj1 = Outer1()
    val obj2 = obj1.Inner1()

    obj2.innerMethod2()

    obj1.outerMethod1()
    obj1.outerMethod2()
}

class Outer1 {

    val outerMember1 = 100

    fun outerMethod1() {
        println("Outer Method")
    }

    fun outerMethod2() {

        /*
        Outer Class 에서는 Inner Class 에 직접 접근이 불가능합니다.
        Outer Class 입장에서는
        Inner Class 객체가 생성 되었을지 확신할 수 없기 때문입니다.
         */
        // println("innerMember1 : $innerMember1")
        // innerMethod1()

        // 아래와 같이 내부 Class 객체를 생성한 후 접근해야 합니다.
        val obj3 = Inner1()
        println("obj3.innerMember1 : $obj3.innerMember1")
        obj3.innerMethod1()
        obj3.innerMethod2()

        println("-----------------------------")

        val t1 = TestClass2()
        t1.testMethod1()

        val t2 = TestClass3()
        t2.interMethod1()

        /*
        TestClass1 을 상속받은 이름이 없는 익명의 객체 (object) 를 생성한 후 바로 사용합니다.
        한 번만 사용이 가능합니다. (이름이 없기 때문입니다.)
         */
        val t3 = object : TestClass1(){
            override fun testMethod1() {
                println("익명 중첩 클래스의 testMethod1")
            }
        }

        t3.testMethod1()

        /*
        Interface 에도 적용이 가능합니다.
        Interface 를 구현한 객체를 즉시 사용할 수 있습니다.
        마찬가지로 한 번만 사용이 가능합니다.
         */
        val t4 = object : TestInter1 {
            override fun interMethod1() {
                println("익명 중첩클래스의 interMethod1")
            }
        }
        t4.interMethod1()

    }

    // Inner Class (내부 Class)
    inner class Inner1 {

        val innerMember1 = 200

        fun innerMethod1() {
            println("Inner Method")
        }

        fun innerMethod2() {
            println("outerMember1 : $outerMember1")
            outerMethod1()
        }
    }
}

abstract class TestClass1{
    abstract fun testMethod1()
}

interface TestInter1{
    fun interMethod1()
}

class TestClass2 : TestClass1(){

    override fun testMethod1() {
        println("TestClass2의 testMethod1")
    }
}

class TestClass3 : TestInter1{

    override fun interMethod1() {
        println("TestClass3의 interMethod1")
    }
}











