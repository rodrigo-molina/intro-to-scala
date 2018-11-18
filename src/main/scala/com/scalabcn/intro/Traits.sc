abstract class A {
  val message: String
}

trait B extends A {
  val message = "I'm an instance of class B"
}

trait C extends A {
  val loudMessage = message.toUpperCase()
}

class D extends B with C

val d = new D
println(d.message)
println(d.loudMessage)

// Construction
trait TBase                         {print("TBase=> ")}
trait T1 extends TBase              {print("T1=> ")}
trait T2 extends TBase              {print("T2=> ")}
trait T3 extends T1 with TBase      {print("T3=> ")}
class AA extends T1 with T2 with T3 {print("AA")}

val a = new AA


// Linearization
trait TTBase                            {def foo: Unit = {print(s"=> TTBase")}}
trait TT1 extends TTBase                {override def foo: Unit = {print(s"=>  TT1"); super.foo}}
trait TT2 extends TTBase                {override def foo: Unit = {print(s"=>  TT2"); super.foo}}
trait TT3 extends TT1 with TTBase       {override def foo: Unit = {print(s"=>  TT3"); super.foo}}
class AAA extends TT1 with TT2 with TT3 {override def foo: Unit = {print(s"AAA"); super.foo}}

val aaa = new AAA().foo