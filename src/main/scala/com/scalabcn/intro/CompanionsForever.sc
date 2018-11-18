
class Configuration(private val foo: List[String]) {
  val port = Configuration.port
}

object Configuration {
  val host = "localhost"
  private val port = 8080
  def merge(config: Configuration) = host :: config.foo
}