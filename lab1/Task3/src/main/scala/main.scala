object main {
  def main(args: Array[String]): Unit = {
    val display1 = new Display(1920, 1080, 401, "Model A")
    val display2 = new Display(2560, 1440, 529, "Model B")
    val display3 = new Display(3840, 2160, 163, "Model C")

    val assistant = new Assistant("Alex")

    assistant.assignDisplay(display1)
    assistant.assignDisplay(display2)
    assistant.assignDisplay(display3)

    assistant.assist()

    assistant.buyDisplay(display2)
  }
}
