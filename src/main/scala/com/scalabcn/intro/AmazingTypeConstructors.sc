import java.util.UUID

case class User(userId: UUID, name: String)

def findExplosiveUser(userId: UUID): User = null
val explosiveUser = findExplosiveUser(UUID.randomUUID())
// val result = s"Hello $user.name" // BOOOOOOOOOOOOM

val chuckId = UUID.randomUUID()
val vandammeId = UUID.randomUUID()

val chuck = User(chuckId, "Chuck")
val vandamme = User(vandammeId, "Van Damme")

val users = List(chuck, vandamme)


// OPTION
def findUser(userId: UUID): Option[User] = users.find(p => p.userId == userId)
val chuckFound = findUser(chuckId)
val result = chuckFound.map(user => s"Hello ${user.name}").getOrElse("Who are you??")


def greet(user: User): String = s"Hello ${user.name}"
val randomUser = findUser(UUID.randomUUID())
val result2 = randomUser.map(greet).getOrElse("Who are you??")


// EITHER
case class UserNotFoundException(userId: UUID) extends RuntimeException(s"User with $userId not found")

def findEitherUser(userId: UUID): Either[UserNotFoundException, User] =
  users.find(p => p.userId == userId) match {
    case Some(user) => Right(user)
    case None => Left(UserNotFoundException(userId))
  }

val chuckEitherFound = findEitherUser(chuckId)
val resultEither = chuckEitherFound.map(greet)
  .getOrElse("Who are you??")

val randomEither: Either[UserNotFoundException, User] =
  findEitherUser(UUID.randomUUID())
val resultRandomEither = randomEither.map(greet)
  .getOrElse("Who are you??")
