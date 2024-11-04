import play.api.libs.json._
import scala.io.Source
import java.io.{IOException, FileNotFoundException}
import java.nio.file.{Files, Paths}

case class Creatură(id: Int, isHumanoid: Option[Boolean], planet: Option[String], age: Option[Int], traits: List[String] = List())


class ReadFile {

  implicit val creaturaReads: Reads[Creatură] = Json.reads[Creatură]

  def readJsonFile(filePath: String): List[Creatură] = {
    // Check if the file exists
    if (!Files.exists(Paths.get(filePath))) {
      throw new FileNotFoundException(s"File not found: $filePath")
    }

    try {

      val jsonFile = Source.fromFile(filePath).getLines().mkString
      val json: JsValue = Json.parse(jsonFile)


      (json \ "data").validate[List[Creatură]] match {
        case JsSuccess(creatures, _) => creatures
        case JsError(errors) =>
          throw new Exception("Failed to parse JSON: " + errors.mkString(", "))
      }
    } catch {
      case e: IOException =>
        throw new IOException(s"Error reading the file: ${e.getMessage}", e)
    }
  }
}
