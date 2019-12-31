/**
* This program generates a random number between
* 1 and 10,000 and checks if the number is a perfect
* square. It also prints out all the perfect squares
* in the range.
*
* @author  Christopher Dodge
* @version 1.0
* @since   2019-12-30
*/
import java.util.Random;

public class Test{
  /**
  * This is the main program method.
  * @param args Unused.
  * @return void.
  */
  public static void main(String[] args){
    Test.log("-- Test 1: Random Number Test -----------------------------------------");
    Test.log("Starting perfect square test with a random number between 1 and 10,000.");
    int randInt = Test.getRandIntInRange(1, 10000);
    Test.log("Using random number:" + randInt + ".");
    boolean isT1Perf = Test.isPerfectSquare(randInt);
    Test.log(randInt + " is" + (isT1Perf ? "" : " not") + " a perfect square.\n");
    
    Test.log("-- Test 2: Show Perfect Squares in Range ------------------------------");
    Test.log("Starting perfect square test of all numbers between 1 and 10,000:");
    for(int i = 1; i <= 10000; ++i){
      boolean isT2Perf = Test.isPerfectSquare(i);
      if(isT2Perf){
        Test.log(i + "");
      }
    }
  }
  
  /**
  * This is a short hand System.out.print method.
  * It also appends a newline to each message.
  * @param msg The string written to the out buffer.
  * @returns void.
  */
  public static void log(String msg){
    System.out.print(msg + "\n");
  }

  /**
  * This generates a random integer in the given range.
  * Both the min and max inputs are inclusive in the calculation.
  * @param min The minimum range integer.
  * @param max The maximum range integer.
  * @returns int The random number in the given range.
  */
  public static int getRandIntInRange(int min, int max) {
    Random r = new Random();
    return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
  }

  /**
  * This checks if a given integer is a perfect square.
  * @param num The integer to check.
  * @returns boolean True if the integer is a perfect square; false otherwise.
  */
  public static boolean isPerfectSquare(int num){
    // 1 is a perfect square
    if(num == 1){
      return true;
    } else {
      // divide the number by an ever increasing amount until quotient < 2
      // (Any quotient less than 2 is invalid for a perfect square >= 4)
      int denominator = 2;
      int quotient = num / denominator++;
      while(quotient > 1){
        if((quotient * quotient) == num){
          return true;
        } else {
          quotient = num / denominator++;
        }
      }  
    }
    
  	return false;
  }
}

