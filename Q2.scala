import scala.io.StdIn._

object StudentRecords extends App {
  
  // Function to validate user input
  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty"))
    } else if (marks < 0 || totalMarks < 0) {
      (false, Some("Marks and total marks must be non-negative"))
    } else if (marks > totalMarks) {
      (false, Some("Marks cannot exceed total marks"))
    } else {
      (true, None)
    }
  }

 
  def getStudentInfo(): (String, Int, Int, Double, Char) = { //read student information
    println("Enter student's name:")
    val name = readLine()
    println("Enter student's marks:")
    val marks = readInt()
    println("Enter total possible marks:")
    val totalMarks = readInt()

    val (isValid, errorMessage) = validateInput(name, marks, totalMarks)//validate input
    if (!isValid) {
      println(s"Error: ${errorMessage.getOrElse("Invalid input")}")
      getStudentInfo() // Retry if input is invalid
    } else {
      val percentage = (marks.toDouble / totalMarks) * 100 //calculate the percentage and grade
      val grade = percentage match {
        case p if p >= 90 => 'A'
        case p if p >= 75 => 'B'
        case p if p >= 50 => 'C'
        case _ => 'D'
      }
      (name, marks, totalMarks, percentage, grade)
    }
  }

  // Function to print student record
  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Student Name: $name")
    println(s"Marks: $marks")
    println(s"Total Marks: $totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

  // Function to prompt user for input until valid data is provided
  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var isValid = false
    var studentInfo: (String, Int, Int, Double, Char) = ("", 0, 0, 0.0, 'D')

    while (!isValid) {
      println("Enter student's name:")
      val name = readLine()
      println("Enter student's marks:")
      val marks = readInt()
      println("Enter total possible marks:")
      val totalMarks = readInt()

      val (validationResult, errorMessage) = validateInput(name, marks, totalMarks)
      if (validationResult) {
        val percentage = (marks.toDouble / totalMarks) * 100
        val grade = percentage match {
          case p if p >= 90 => 'A'
          case p if p >= 75 => 'B'
          case p if p >= 50 => 'C'
          case _ => 'D'
        }
        studentInfo = (name, marks, totalMarks, percentage, grade)
        isValid = true
      } else {
        println(s"Error: ${errorMessage.getOrElse("Invalid input")}")
      }
    }

    studentInfo
  }

  val studentRecord = getStudentInfoWithRetry()
  printStudentRecord(studentRecord)
}
