def foo(a: => String, b:String) = {println(a);println(b);println(a);println(b);}

foo({println("Resolving a"); "printing a"}, {println("Resolving b"); "printing b"})


val eagerResource: Int = init("eager")

lazy val lazyResource: Int = init("lazy")
def init(from: String): Int = {
  println(s"doing something expensive... from $from call")
  0
}


println("Resources usage")
eagerResource // already processed
lazyResource // processing
lazyResource // already processed