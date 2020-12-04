package leetcode.easy.twenty20.dec.day2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : ssuddhapally
 * @since : 03/12/20, Thu
 **/
public class RandomTest {

  static final int size=10;
  RandomTest(){
  }
  public static void main(String[] args) {
    Random random = new Random();
    int rand = 0;
    while (true){
      rand = random.nextInt(size);
      if(rand !=0) break;
    }
    System.out.println(rand);

  }
}
