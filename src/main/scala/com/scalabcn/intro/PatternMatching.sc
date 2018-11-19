case class Person(id: String, tuple:(Int, Boolean), age: Int)

val persons = List(
  Person("xrl_23", (1, true), 25),
  Person("xrl_24", (1, true), 30),
  Person("xrl_25", (2, false), 50)
)

persons match {
  case Person("xrl_23", _, _) :: xs => "first person is xrl_23"
  case Person(id, _, _) :: xs if id == "xrl_23" => "first person is xrl_23"
  case List(_, Person(a, (_, true), _), _*) => s"match person $a with true value"
  case List(p1, p2, p3, p4) => "match a list of 4 people"
  case x :: Person(_, (_, true), age) :: Nil if age > 25 => "2nd person of a 2 length list true and > 25"
  case list @ (x :: Nil) => s"1 person list: $list"
  case Nil => "match Empty list constant"
  case xs => "else"
  //case _ => "another else, this is unreachable code. Compiler complains"
}

val t = ("Victor & Rodrigo", true)
val(name, likesScala) = t
s"It's $likesScala that $name like scala"

// Partial function
val print3: PartialFunction[Int, Unit] = {
  case 3 => println(3)
}

// List(1, 2, 3).map(print3) // BOOM!

val print3Verbose = new PartialFunction[Int, Unit] {
  override def isDefinedAt(x: Int) = x match
  { case 3 => true }

  override def apply(v1: Int) = v1 match
    { case 3 => println(3) }
}

persons.map {
  case p@Person("", _, _) => p
}
