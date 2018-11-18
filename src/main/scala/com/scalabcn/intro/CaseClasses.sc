case class MyClass(a: String, c: Boolean)

// EQUALS TO
class MyClass(val a: String, val c: Boolean) {
  def == (other: MyClass): Boolean = ??? // EQUALS
  def copy(a: String = this.a, c: Boolean = this.c): MyClass = new MyClass(a, c)
  override def hashCode: Int = ???
  override def toString: String = ???
}

object MyClass {
  def apply(a: String, c: Boolean): Unit = new MyClass(a, c)
  def unapply(myClass: MyClass): Option[(String, Boolean)] = ???
  // AKA def unapply(myClass: MyClass): Option[Tuple2[String, Boolean]] = ???
}