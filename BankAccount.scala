//Q4
import scala.io.StdIn._

class Account(val accountNumber: String, initialBalance: Double) {
  
  private var balance: Double = initialBalance

  // deposit money into the account
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited $amount to account $accountNumber. New balance: $balance")
    } else {
      println("Deposit amount must be positive.")
    }
  }

  // withdraw money from the account
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew $amount from account $accountNumber. New balance: $balance")
    } else if (amount > balance) {
      println("Insufficient funds.")
    } else {
      println("Withdraw amount must be positive.")
    }
  }

  // transfer money to another account
  def transfer(amount: Double, toAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)  
      toAccount.deposit(amount) 
      println(s"Transferred $amount from account $accountNumber to account ${toAccount.accountNumber}.")
    } else if (amount > balance) {
      println("Insufficient funds to transfer.")
    } else {
      println("Transfer amount must be positive.")
    }
  }

  // apply interest to the balance
  def applyInterest(): Unit = {
    balance += {
      if (balance > 0) balance * 0.05
      else balance * 0.1
    }
  }

  // check the current balance
  def getBalance: Double = balance

  // get account details 
  override def toString: String = f"Account $accountNumber: Balance: $balance%.2f"
}

object BankApp extends App {
  // list of accounts
  val bank: List[Account] = List(
    new Account("ACC123", 1000.0),
    new Account("ACC124", -150.0),
    new Account("ACC125", 500.0),
    new Account("ACC126", -50.0),
    new Account("ACC126", 6000.0),
    new Account("ACC126", 750.0),
    new Account("ACC126", -20.0),
    new Account("ACC126", -15.0)
  )

  // list of accounts with negative balances
  def negativeBalances(accounts: List[Account]): List[Account] = {
    accounts.filter(account => account.getBalance < 0)
  }

  // calculate the sum of all account balances
  def sumOfBalances(accounts: List[Account]): Double = {
    accounts.map(_.getBalance).sum
  }

  // calculate the final balances after applying interest
  def applyInterestToAll(accounts: List[Account]): Unit = {
    accounts.foreach(_.applyInterest())
  }

  // Displaying accounts with negative balances
  println("Accounts with negative balances:")
  negativeBalances(bank).foreach(account => println(account))

  // Calculating and displaying the sum of all balances
  val totalBalance = sumOfBalances(bank)
  println(s"\nSum of all account balances: $totalBalance")

  // Applying interest
  applyInterestToAll(bank)

  // Displaying final balances
  println("\nFinal balances after applying interest:")
  bank.foreach(account => println(account))
}
