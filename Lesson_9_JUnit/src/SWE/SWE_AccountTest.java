package SWE;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO some kind of credit system, balance can be -1000

class SWE_AccountTest
{
  private SWE_Account account;
  private final long ACCOUNT_NO = 12345678910L;

  @org.junit.jupiter.api.BeforeEach void setUp()
  {
    account = new SWE_Account(ACCOUNT_NO);
  }

  @org.junit.jupiter.api.AfterEach void tearDown()
  {
  }

  private void safeWithdraw(double amount)
  {
    try
    {
      account.withdraw(amount);
    }
    catch (InvalidWithdrawException e) {}
  }

  private void safeDeposit(double amount)
  {
    try
    {
      account.deposit(amount);
    }
    catch (InvalidDepositException e) {}
  }

  @Test
  void createNewAccount()
  {
    account = new SWE_Account(ACCOUNT_NO);
  }

  @Test
  void accountNumberEqualsGivenAccountNumber()
  {
    assertEquals(ACCOUNT_NO, account.getAccountNo());
  }

  @Test
  void newAccountBalanceIsZero()
  {
    assertEquals(0, account.checkBalance());
  }

  @Test
  void canDepositOneDollar()
  {
    safeDeposit(1);
  }

  @Test
  void canWithdrawOneDollarIfTheBalanceIsAtLeastOneDollar()
  {
    safeDeposit(1);
    safeWithdraw(1);
  }

  @Test
  void depositOneDollarThenBalanceIsOneDollar()
  {
    safeDeposit(1);
    assertEquals(1, account.checkBalance());
  }

  @Test
  void depositTwoDollarsThenWithdrawOneThenBalanceIsOneDollar()
  {
    safeDeposit(2);
    safeWithdraw(1);
    assertEquals(1, account.checkBalance());
  }

  @Test
  void withdrawOneDollarThrowsInvalidWithdrawErrorWhenBalanceIsZero()
  {
    assertThrows(InvalidWithdrawException.class, () -> account.withdraw(1));
  }

  @Test
  void depositMinusOneDollarThrowsInvalidDepositError()
  {
    assertThrows(InvalidDepositException.class, () -> account.deposit(-1));
  }

  @Test
  void withdrawMinusOneDollarThrowsInvalidWithdrawError()
  {
    assertThrows(InvalidWithdrawException.class, () -> account.withdraw(-1));
  }
}