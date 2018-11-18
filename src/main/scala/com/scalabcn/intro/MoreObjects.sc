abstract class BaseConfiguration(val host: String, val port: Int)

object Configuration extends BaseConfiguration("localhost", 8080) {
  val relativePath = "/base"
  def senderAddress(userType: Int) = ???
}

Configuration.host
Configuration.port
Configuration.relativePath