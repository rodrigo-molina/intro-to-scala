class MyClass(_a: String, _c: Boolean) {
  val a = _a
  private var c = _c
  def setC(other: Boolean):Unit = this.c = other
}


val myClass = new MyClass("a", true)
myClass.a
myClass.c // NOP
myClass.setC(false)