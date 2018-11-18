sealed trait Gender
case object Male extends Gender
case object Female extends Gender

case class Person(personId: Long, name: String, surname: String, gender: Gender) {
  override def toString: String = s"{ name: $name, surname: $surname, gender: $gender }"
}
case class Dog(ownerId: Long, name: String)

val CHUCK = Person(1, "Chuck", "Norris", Male)
val CHUCKA = Person(2, "Chucka", "Norras", Female)
val BARB = Person(3, "Barbara", "Liskov", Female)
val LUIS = Person(4, "Luis", "Miguel", Male)

val persons: List[Person] = List(CHUCK, CHUCK, CHUCKA, BARB, LUIS)

val dogs = List(
  Dog(CHUCK.personId, "Makina"),
  Dog(CHUCK.personId, "Firulais"),
  Dog(LUIS.personId, "Pipi"))

def hasGender(gender: Gender): Person => Boolean = p => p.gender == gender
def isMale(p: Person) = hasGender(Male)(p)
def isFemale(p: Person) = hasGender(Female)(p)
def nameContains(p: Person, nameContains: String) = p.name.contains(nameContains)

// ALL
persons.foreach(println)

// FILTER
persons.filter(p => isMale(p) && nameContains(p, "Chu")).foreach(println)

//REDUCE
persons.filter(isFemale).foldLeft("")((acc, p) => acc + "," + p.name).foreach(println)

// FIND THOSE WITH DOGS
val result = persons.filter(p => dogs.exists(_.ownerId == p.personId)).foreach(println)

// OR BETTER
val personMap = persons.map(p => p.personId -> p).toMap
dogs.map(d => personMap(d.ownerId)).distinct

