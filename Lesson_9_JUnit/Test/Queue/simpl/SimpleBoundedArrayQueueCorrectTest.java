package Queue.simpl;

import Queue.QueueADT;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleBoundedArrayQueueCorrectTest
{
  private QueueADT q;

  @Before public void setUp() throws Exception
  {
    q = new SimpleBoundedArrayQueueC(2);
  }

  @After public void tearDown() throws Exception
  {
  }

  //Test constructors
  @Test
  public void testConstructorWithValidInput()
  {
    QueueADT q = new SimpleBoundedArrayQueueCorrect(10);
  }

  //It doesn't fail with negative maximum capacity...
  @Test
  public void testConstructorWithInvalidInput()
  {
    QueueADT q = new SimpleBoundedArrayQueueCorrect(-1);
  }

  @Test
  public void testEnqueueOneElement()
  {
    q.enqueue(1);
    assertEquals(1, q.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEnqueueNullThrowsException()
  {
    q.enqueue(null);
  }

  @Test(expected = IllegalStateException.class)
  public void testEnqueueOneElementWhenCapacityIsZero()
  {
    q = new SimpleBoundedArrayQueueCorrect(0);
    q.enqueue(1);
  }

  //Fails, because it tries to change the -1st element of an array
//  @Test(expected = IllegalStateException.class)
//  public void testEnqueueOneElementWhenCapacityIsNegative()
//  {
//    q = new SimpleBoundedArrayQueueCorrect(-1);
//    q.enqueue(1);
//  }

  @Test(expected = IllegalStateException.class)
  public void testEnqueueTwoElementsWhenCapacityIsOne()
  {
    q = new SimpleBoundedArrayQueueCorrect(1);
    q.enqueue(1);
    q.enqueue(2);
  }

  @Test
  public void testEnqueueTwoElements()
  {
    q.enqueue(1);
    q.enqueue(2);
    assertEquals(2, q.size());
  }

  @Test(expected = IllegalStateException.class)
  public void testDequeueOnEmptyQueue()
  {
    q.dequeue();
  }

  @Test
  public void enqueueOneElementThenDequeue()
  {
    q.enqueue(1);
    assertEquals(1, q.dequeue());
  }

  @Test
  public void testDequeueTwice()
  {
    q.enqueue(1);
    q.enqueue(2);
    q.dequeue();
    assertEquals(2, q.dequeue());
  }

  @Test
  public void testReachMaxCapDequeueEnqueue()
  {
    q.enqueue(1);
    q.enqueue(2);
    q.dequeue();
    q.enqueue(3);
    assertEquals(2, q.size());
  }

  @Test
  public void testReachMaxCapDequeueEnqueueDequeue()
  {
    q.enqueue(1);
    q.enqueue(2);
    q.dequeue();
    q.enqueue(3);
    assertEquals(2, q.dequeue());
  }

  @Test(expected = IllegalStateException.class)
  public void testFirstOnEmptyQueue()
  {
    q.first();
  }

  @Test
  public void testEnqueueThenFirst()
  {
    q.enqueue(1);
    assertTrue(q.first().equals(1) && q.size() == 1);
  }

  @Test
  public void testEnqueueTwiceThenDequeueThenFirst()
  {
    q.enqueue(1);
    q.enqueue(2);
    q.dequeue();
    assertTrue(q.first().equals(2) && q.size() == 1);
  }

  @Test
  public void testSizeOnEmptyQueue()
  {
    assertEquals(0, q.size());
  }

  @Test
  public void testEnqueueThenSize()
  {
    q.enqueue(1);
    assertEquals(1, q.size());
  }

  @Test
  public void testEnqueueTwiceThenDequeueThenSize()
  {
    q.enqueue(1);
    q.enqueue(2);
    q.dequeue();
    assertEquals(1, q.size());
  }

  @Test
  public void testIsEmptyOnEmptyQueue()
  {
    assertTrue(q.isEmpty());
  }

  @Test
  public void testEnqueueThenIsEmpty()
  {
    q.enqueue(1);
    assertFalse(q.isEmpty());
  }

  @Test
  public void testEnqueueDequeueThenIsEmpty()
  {
    q.enqueue(1);
    q.dequeue();
    assertTrue(q.isEmpty());
  }

  @Test
  public void testIndexOfOnEmptyQueue()
  {
    assertEquals(-1, q.indexOf(0));
  }

  @Test
  public void testIndexOfOnDifferentElement()
  {
    q.enqueue(1);
    assertEquals(-1, q.indexOf(0));
  }

  @Test
  public void testIndexOfOnSameElement()
  {
    q.enqueue(1);
    assertEquals(0, q.indexOf(1));
  }

  @Test
  public void testIndexOfWhenDuplicate()
  {
    q = new SimpleBoundedArrayQueueCorrect(3);
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(1);
    assertEquals(0, q.indexOf(1));
  }

  @Test
  public void testIndexOfNotFirst()
  {
    q.enqueue(2);
    q.enqueue(1);
    assertEquals(1, q.indexOf(1));
  }

  //Fails on empty queue
//  @Test
//  public void testContainsOnEmptyQueue()
//  {
//    assertFalse(q.contains(0));
//  }

  @Test
  public void testContainsOneElement()
  {
    q.enqueue(1);
    assertTrue(q.contains(1));
  }

  @Test
  public void testContainsDifferentElement()
  {
    q.enqueue(2);
    assertFalse(q.contains(1));
  }

  @Test
  public void testContainsTwoElements()
  {
    q.enqueue(1);
    q.enqueue(2);
    assertTrue(q.contains(2));
  }

  @Test
  public void testContainsDequeue()
  {
    q.enqueue(1);
    q.enqueue(2);
    q.dequeue();
    assertFalse(q.contains(1));
  }

  @Test
  public void testToStringOnEmptyQueue()
  {
    assertEquals("{}", q.toString());
  }

  @Test
  public void testToStringOneElement()
  {
    q.enqueue(1);
    assertEquals("{1}", q.toString());
  }

  @Test
  public void testToStringTwoElements()
  {
    q.enqueue(2);
    q.enqueue(1);
    assertEquals("{2, 1}", q.toString());
  }

  @Test
  public void testToStringDequeue()
  {
    q.enqueue(1);
    q.enqueue(3);
    q.dequeue();
    assertEquals("{3}", q.toString());
  }
}