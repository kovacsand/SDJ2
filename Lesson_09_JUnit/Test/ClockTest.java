import org.junit.Test;

import static org.junit.Assert.*;

public class ClockTest
{
  private Clock c;

  @org.junit.Before public void setUp() throws Exception
  {
    c = new Clock(8,15,30);
    //c = new Clock(29730);
  }

  @org.junit.After public void tearDown() throws Exception
  {

  }

  //Constructor
  @Test
  public void oneArgumentConstructorWithValidInput()
  {
    Clock c = new Clock(1);
  }

  @Test
  public void oneArgumentConstructorWithAnotherValidInput()
  {
    Clock c = new Clock(120);
  }

  @Test
  public void oneArgumentConstructorWithLargeValidInput()
  {
    Clock c;
    c = new Clock(720000);
    assertNotNull(c);
  }

  @Test (expected = IllegalArgumentException.class)
  public void oneArgumentConstructorWithInvalidInput()
  {
    Clock c = new Clock(-1);
  }

  @Test
  public void oneArgumentConstructorWithValidInputTwice()
  {
    Clock c1 = new Clock(0);
    Clock c2 = new Clock(1);
  }

  @Test
  public void threeArgumentConstructorWithValidInput()
  {
    Clock c = new Clock(12, 10, 30);
  }

  @Test
  public void threeArgumentConstructorWithAnotherValidInput()
  {
    Clock c = new Clock(13, 8, 29);
  }

  @Test (expected = IllegalArgumentException.class)
  public void threeArgumentConstructorWithInvalidHourInput()
  {
    Clock c = new Clock(24, 59, 0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void threeArgumentConstructorWithInvalidMinuteInput()
  {
    Clock c = new Clock(0, -1, 59);
  }

  @Test (expected = IllegalArgumentException.class)
  public void threeArgumentConstructorWithInvalidSecondInput()
  {
    Clock c = new Clock(23, 0, 60);
  }

  //One
  @Test
  public void testGetHour()
  {
    assertEquals(8, c.getHour());
  }

  @Test
  public void testGetMinute()
  {
    assertEquals(15, c.getMinute());
  }

  //This seems to be returning the minute
  @Test
  public void testGetSecond()
  {
    assertEquals(30, c.getSecond());
  }

  @Test
  public void testGetTimeInSeconds()
  {
    assertEquals(29730, c.getTimeInSeconds());
  }

  @Test
  public void testSetOneArgument()
  {
    c.set(3725);
    assertEquals(3725, c.getTimeInSeconds());
  }

  @Test
  public void testSetOneArgumentUnderBoundary()
  {
    c.set(86399);
    assertEquals(59, c.getSecond());
  }

  @Test
  public void testSetOneArgumentAtBoundary()
  {
    c.set(86400);
    assertEquals(0, c.getSecond());
  }

  @Test
  public void testSetOneArgumentAboveBoundary()
  {
    c.set(86401);
    assertEquals(1, c.getSecond());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSetOneArgumentInvalid()
  {
    c.set(-1);
  }

  @Test
  public void testSetThreeArguments()
  {
    c.set(10, 5, 40);
    assertEquals(5, c.getMinute());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testSetHourInvalid()
  {
    c.set(25, 0, 0);
  }

  @Test
  public void testTic()
  {
    c.tic();
    assertEquals(29731, c.getTimeInSeconds());
  }

  @Test
  public void testToString()
  {
    assertEquals("08:15:30", c.toString());
  }


  //----------------------------------White-box testing for tic()---------------
  /*
  Updating the clock to the next second.
    Regular update      14:15:16  -> 14:15:17
    Minute is changing  14:15:59  -> 14:16:00
    Hour is changing    14:59:59  -> 15:00:00
    Midnight            23:59:59  -> 00:00:00
   */
  @Test
  public void testTicRegularUpdate()
  {
    c.set(14,15,16);
    c.tic();
    assertEquals("14:15:17", c.toString());
  }

  @Test
  public void testTicMinuteChanging()
  {
    c.set(14, 15, 59);
    c.tic();
    assertEquals("14:16:00", c.toString());
  }

  @Test
  public void testTicHourChanging()
  {
    c.set(14, 59, 59);
    c.tic();
    assertEquals("15:00:00", c.toString());
  }

  //Fails due to the different systems for displaying time. Hour 0 = 24
  @Test
  public void testTicMidnight()
  {
    c.set(23, 59, 59);
    System.out.println(c);
    c.tic();
    System.out.println(c);
    c.tic();
    System.out.println(c);
    System.out.println(86401 / 86400);
    assertEquals("00:00:00", c.toString());
  }
}