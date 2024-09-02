//Q3
import scala.io.StdIn._

class Account(initialBalance: Double) {

  private var balance: Double = initialBalance

  // deposit money into the account
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $amount. New balance: $balance")
    } else {
      println("Deposit amount must be positive.")
    }
  }

  // withdraw money from the account
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount. New balance: $balance")
    } else if (amount > balance) {
      println("Insufficient funds.")
    } else {
      println("Withdraw amount must be positive.")
    }
  }

  // transfer money to another account
  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)  // Withdraw from this account
      toAccount.deposit(amount)  // Deposit to the target account
      println(s"Transferred $amount to another account.")
    } else if (amount > balance) {
      println("Insufficient funds to transfer.")
    } else {
      println("Transfer amount must be positive.")
    }
  }

  // check the current balance
  def getBalance: Double = balance
}

object BankApp extends App {

  // get inputs from user
  println("Enter initial balance for account 1:")
  val initialBalance1 = readDouble()
  val account1 = new Account(initialBalance1)

  println("Enter initial balance for account 2:")
  val initialBalance2 = readDouble()
  val account2 = new Account(initialBalance2)

  // Deposit money into account 1
  println("Enter amount to deposit into account 1:")
  val depositAmount = readDouble()
  account1.deposit(depositAmount)

  // Withdraw money from account 1
  println("Enter amount to withdraw from account 1:")
  val withdrawAmount = readDouble()
  account1.withdraw(withdrawAmount)

  // Transfer money from account 1 to account 2
  println("Enter amount to transfer from account 1 to account 2:")
  val transferAmount = readDouble()
  account1.transfer(transferAmount, account2)

  // Print the final balances
  println(s"Final balance of account 1: ${account1.getBalance}")
  println(s"Final balance of account 2: ${account2.getBalance}")
}
