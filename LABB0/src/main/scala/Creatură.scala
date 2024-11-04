import play.api.libs.json.{Json, OFormat}

case class Creatură(
                     id: Int,
                     isHumanoid: Boolean,
                     planet: String,
                     age: Int,
                     traits: List[String]
                   )

object Creatură {
  // Ensure implicit Reads and Writes are defined
  implicit val format: OFormat[Creatură] = Json.format[Creatură]
}
