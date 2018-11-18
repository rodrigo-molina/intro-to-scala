import scala.annotation.tailrec

def map[A, B] (list: List[A], f: A => B): List[B] =
  for (elmeent <- list) yield f(elmeent)

val numbers: List[Int] = List(1, 2, 3, 4)
map(numbers, (i: Int) => i + 0.2d)
// IDEM
numbers.map(i => i + 0.2d)


// Recursive version without pattern matching
def map2[A, B] (list: List[A], f: A => B): List[B] =
  if (list.isEmpty) Nil
  else f(list.head) :: map2 (list.tail, f)

// Tail recursive without pattern matching
def map3[A, B] (list: List[A], f: A => B): List[B] = {
  @tailrec
  def mapRec(acc: List[B], list: List[A], f: A => B): List[B] =
    if (list.isEmpty) acc
    else mapRec(acc :+ f(list.head), list.tail, f)

  mapRec(List.empty[B], list, f)
  }