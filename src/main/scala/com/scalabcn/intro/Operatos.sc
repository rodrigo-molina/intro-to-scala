case class Euro(value: Int) {
  def add(other: Euro): Euro =
    Euro(this.value + other.value)

  def add(other1: Euro, other2: Euro): Euro =
    Euro(this.value + other1.value + other2.value)
}

// Method call
val amount = Euro(1).add(Euro(1))

// Operator
val twoEuros = Euro(1) add Euro(1)
val tenEuros = twoEuros add (twoEuros, Euro(6))


case class Euro2(value: Int) {

  // Left to Right: a + b + c = (a + b) + c
  def +(other: Euro2): Euro2 =
    Euro2(this.value + other.value)

  // Ends with : => Right to Left
  // Right to Left: a + b + c = a + (b + c)
  def +:(value: Int): Euro2 =
    Euro2(this.value + value)

  // only '+', '-', '!' or '~' supported
  def unary_- : Euro2 = Euro2(-this.value)

  def asString: String = s"$value €"
}

val oneEuro2 = new Euro2(1)
// Infix notation
val twoEuros2 = oneEuro2 + oneEuro2
// Infix Right ot Left notation
val threeEuros2 = 1 +: twoEuros2
// Prefix notation (Same as twoEuro.unary_-)
val minusTwoEuros = -twoEuros2
// Postfix notation
val twoEurosAsString = twoEuros2 asString
