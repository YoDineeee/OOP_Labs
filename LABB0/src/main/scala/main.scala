import scala.util.Try
import java.io.IOException

object Main {
  def main(args: Array[String]): Unit = {
    val filePath = "src/main/resources/input.json"
    val reader = new ReadFile()

    println(s"Attempting to read JSON file from path: $filePath")

    Try {
      val creatures: List[Creatură] = reader.readJsonFile(filePath)
      creatures.foreach(println)
    } recover {
      case e: IOException => println(s"Error: ${e.getMessage}")
      case e: Exception => println(s"An error occurred: ${e.getMessage}")
    }
  }
}
