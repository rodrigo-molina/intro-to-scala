val f = new Function0[Int] {
  def apply: Int = 3
}

val sum3 = new Function1[Int, Int] {
  def apply(i: Int): Int = i + 3
}

val sum3Bis = (i: Int) => i + 3
// or val sum3Bis: Int => Int = i => i + 3

f()
sum3(1)
sum3Bis(1)

def sum(a: Int, b: Int, c: Int) = a + b + c

// Function value from method
val sumFunc: (Int, Int, Int) => Int = sum
// same as
val f2 = sum _
val sumCurried: Int => Int => Int => Int = sumFunc.curried
val sumTupled: ((Int, Int, Int)) => Int = sumFunc.tupled
val sumFuncBis: (Int, Int, Int) => Int = Function.untupled(sumFunc.tupled)

// Partially applied function
val sum31: Int => Int = sumCurried(2)(1)
val tuple = (1, 2, 2)
sumTupled(tuple) == (sumTupled apply tuple)
sum3(2)
