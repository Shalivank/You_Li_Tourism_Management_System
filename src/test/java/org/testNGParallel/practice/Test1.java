package org.testNGParallel.practice;

import org.testng.annotations.Test;

public class Test1 {
   @Test(groups="reg")
   public void tset1()
   {
	   System.out.println("hiii");
   }
   // changes done by engg-1
   @Test
   public void test2()
   {
	   System.out.println("hello");
   }
}
