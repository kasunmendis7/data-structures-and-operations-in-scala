class Account(var balance: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
    }
  }

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05  
    } else {
      balance += balance * 0.10  
    }
  }

  def checkBalance(): Double = balance

  override def toString: String = f"Account Balance: Rs.$balance%.2f"
}

object BankAccounts{
  type Bank = List[Account]

  // 4.1 List of Accounts with negative balances
  def accountsWithNegativeBalances(bank: Bank): List[Account] = {
    bank.filter(_.balance < 0)
  }

  // 4.2 Calculate the sum of all account balances
  def sumOfAllBalances(bank: Bank): Double = {
    bank.map(_.balance).sum
  }

  // 4.3 Apply interest function to all accounts and calculate final balances
  def applyInterestToAll(bank: Bank): Unit = {
    bank.foreach(_.applyInterest())
  }

  def main(args: Array[String]): Unit = {
    // Create a list of accounts
    val account1 = new Account(1000.0)   // Positive balance
    val account2 = new Account(-200.0)   // Negative balance
    val account3 = new Account(300.0)    // Positive balance
    val account4 = new Account(-500.0)   // Negative balance

    val bank: Bank = List(account1, account2, account3, account4)

    // 4.1 List of Accounts with negative balances
    val negativeAccounts = accountsWithNegativeBalances(bank)
    println("Accounts with negative balances:")
    negativeAccounts.foreach(acc => println(acc))

    // 4.2 Calculate the sum of all account balances
    val totalBalance = sumOfAllBalances(bank)
    println(f"Total sum of all balances: Rs.$totalBalance%.2f")

    // 4.3 Apply interest and calculate final balances
    applyInterestToAll(bank)
    println("Final balances after applying interest:")
    bank.foreach(acc => println(acc))
  }
}
