package SWE;

public class SWE_Account
{
  private double balance;
  private long account_no;

  public SWE_Account(long account_no)
  {
    this.account_no = account_no;
    balance = 0;
  }

  public double checkBalance()
  {
    return balance;
  }

  public void deposit(double amount) throws InvalidDepositException
  {
    if (amount < 0)
      throw new InvalidDepositException();
    balance += amount;
  }

  public void withdraw(double amount) throws InvalidWithdrawException
  {
    if (amount < 0 || balance < amount)
      throw new InvalidWithdrawException();
    else
      balance -= amount;

  }

  public long getAccountNo()
  {
    return account_no;
  }
}
