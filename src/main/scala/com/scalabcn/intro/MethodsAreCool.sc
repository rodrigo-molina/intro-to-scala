// Named parameters & default values
def greet(name: String, greeting: String = "Hello", exclamation:Boolean = false): String =
s"$greeting $name" + (if(exclamation) "!" else "")

greet("john Snow")
greet("john Snow", "You know nothing")
greet("john Snow", greeting = "You know nothing")
greet("Cersey", exclamation = true)

def map[A, B] (l: A*) (f: A => B): List[B] = {
  for (element <- l.toList) yield f(element)
}

map(1, 2, 3, 4) { i =>
  i + 0.2d

}