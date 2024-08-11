import scala.io.StdIn._

object CaesarCipher extends App {

  // Function to encrypt the plaintext using Caesar Cipher
  def encrypt(plaintext: String, shift: Int): String = {
    plaintext.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        ((char - base + shift) % 26 + base).toChar
      } else {
        char
      }
    }
  }

  // Function to decrypt the ciphertext using Caesar Cipher
  def decrypt(ciphertext: String, shift: Int): String = {
    ciphertext.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        ((char - base - shift + 26) % 26 + base).toChar
      } else {
        char
      }
    }
  }

  // General cipher function that takes a function (either encrypt or decrypt) as a parameter
  def cipher(func: (String, Int) => String, text: String, shift: Int): String = {
    func(text, shift)
  }

  // Get inputs from the user
  println("Enter the text:")
  val text = readLine()

  println("Enter the shift value (integer):")
  val shift = readInt()

  println("Type 'E' to encrypt or 'D' to decrypt:")
  val choice = readLine().toUpperCase()

  val result = choice match {
    case "E" => cipher(encrypt, text, shift)
    case "D" => cipher(decrypt, text, shift)
    case _ =>
      println("Invalid choice. Please type 'E' for encryption or 'D' for decryption.")
      ""
  }

  if (result.nonEmpty) {
    println(s"Result: $result")
  }
}
