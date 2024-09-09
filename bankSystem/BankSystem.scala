class Account(private var balance: Double) {
  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited Rs.$amount. New balance: Rs.$balance")
    } else {
      println("Deposit amount must be positive.")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew Rs.$amount. Remaining balance: Rs.$balance")
    } else if (amount > balance) {
      println(s"Insufficient funds. Current balance: Rs.$balance")
    } else {
      println("Withdrawal amount must be positive.")
    }
  }

  def transfer(amount: Double, targetAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      targetAccount.deposit(amount)
      println(s"Transferred Rs.$amount to target account. Your remaining balance: Rs.$balance")
    } else if (amount > balance) {
      println("Transfer failed: insufficient funds.")
    } else {
      println("Transfer amount must be positive.")
    }
  }

  def checkBalance(): Double = {
    balance
  }
}

object BankSystem {
  def main(args: Array[String]): Unit = {

    val account1 = new Account(1000.0)  
    val account2 = new Account(500.0)  

    println(s"Account 1 initial balance: Rs.${account1.checkBalance()}")
    println(s"Account 2 initial balance: Rs.${account2.checkBalance()}")

    account1.deposit(200.0)           
    account1.withdraw(150.0)            
    account1.transfer(300.0, account2)  

    println(s"Account 1 final balance: Rs.${account1.checkBalance()}")
    println(s"Account 2 final balance: Rs.${account2.checkBalance()}")
  }
}
