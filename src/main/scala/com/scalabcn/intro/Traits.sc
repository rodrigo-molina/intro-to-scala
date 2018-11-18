trait TraitSample {
  var x = 1

  def mutateX(newX:Int) = this.x = newX
  def showMe(): String = s"Current x value: $x"
}

// Anonymous class
val aTrait: TraitSample = new TraitSample {}
val otherTrait: TraitSample = new TraitSample {}

aTrait.showMe
aTrait.mutateX(2)
aTrait.showMe
otherTrait.showMe


sealed trait Runner {
  def runVelocity:Int
  def run  = println(s"I'm running at $runVelocity")
}

sealed trait Flyer {
  def flyVelocity:Int
  def fly  = println(s"I'm flying at $flyVelocity")
}

case class Duck(runVelocity: Int, flyVelocity: Int) extends Runner with Flyer

val duck = Duck(5, 10)
duck.fly
duck.run