object LibraryManagementSystem {

  case class Book(title: String, author: String, isbn: String)

  var library: Set[Book] = Set(
    Book("1984", "George Orwell", "1234567890"),
    Book("To Kill a Mockingbird", "Harper Lee", "2345678901"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "3456789012")
  )

  def addBook(book: Book): Unit = {
    if (library.exists(_.isbn == book.isbn)) {
      println("Book with this ISBN already exists in the library.")
    } else {
      library += book
      println(s"Book '${book.title}' by ${book.author} added to the library.")
    }
  }

  def removeBookByISBN(isbn: String): Unit = {
    val bookOption = library.find(_.isbn == isbn)
    bookOption match {
      case Some(book) =>
        library -= book
        println(s"Book '${book.title}' by ${book.author} removed from the library.")
      case None =>
        println("No book found with this ISBN.")
    }
  }

  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    if (library.isEmpty) {
      println("The library is currently empty.")
    } else {
      println("Current library collection:")
      library.foreach { book =>
        println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      }
    }
  }

  def searchBookByTitle(title: String): Unit = {
    val bookOption = library.find(_.title.equalsIgnoreCase(title))
    bookOption match {
      case Some(book) =>
        println(s"Book found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None =>
        println(s"No book found with the title '$title'.")
    }
  }

  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.isEmpty) {
      println(s"No books found by the author '$author'.")
    } else {
      println(s"Books by $author:")
      booksByAuthor.foreach { book =>
        println(s"Title: ${book.title}, ISBN: ${book.isbn}")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    import scala.io.StdIn.readLine

    var continue = true

    while (continue) {
      println("\nLibrary Management System")
      println("1. Display library")
      println("2. Add a book")
      println("3. Remove a book by ISBN")
      println("4. Check if a book is in the library by ISBN")
      println("5. Search for a book by title")
      println("6. Display all books by a specific author")
      println("7. Exit")
      print("Choose an option: ")

      readLine() match {
        case "1" =>
          displayLibrary()

        case "2" =>
          println("Enter book title: ")
          val title = readLine()
          println("Enter book author: ")
          val author = readLine()
          println("Enter book ISBN: ")
          val isbn = readLine()
          addBook(Book(title, author, isbn))

        case "3" =>
          println("Enter ISBN of the book to remove: ")
          val isbn = readLine()
          removeBookByISBN(isbn)

        case "4" =>
          println("Enter ISBN to check: ")
          val isbn = readLine()
          val exists = isBookInLibrary(isbn)
          println(s"Is the book in the library? $exists")

        case "5" =>
          println("Enter title of the book to search: ")
          val title = readLine()
          searchBookByTitle(title)

        case "6" =>
          println("Enter author to display all books by: ")
          val author = readLine()
          displayBooksByAuthor(author)

        case "7" =>
          continue = false

        case _ =>
          println("Invalid option. Please choose a valid option.")
      }
    }
  }
}
