package Carrots.v1;

import BlockingQueue.BlockingQueue;
import Carrots.Carrot;

public class Test
{
  public static void main(String[] args)
  {
     BlockingQueue bq = new BlockingQueue(20);

     //Peeling
     new Thread(() -> {
       while (true)
       {
         bq.put(new Carrot());
         try
         {
           Thread.sleep(300);
         }
         catch (InterruptedException e)
         {
           e.printStackTrace();
         }
       }
     }).start();

     //Eating
     new Thread(() -> {
       while (true)
       {
         bq.take();
         try
         {
           Thread.sleep(600);
         }
         catch (InterruptedException e)
         {
           e.printStackTrace();
         }
       }
     }).start();

     //Printing out
     new Thread(() ->
     {
       while (true)
       {
         System.out.println(bq);
         try
         {
           Thread.sleep(400);
         }
         catch (InterruptedException e)
         {
           e.printStackTrace();
         }
       }
     }).start();
  }
}
