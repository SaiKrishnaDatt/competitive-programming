package hackerearth.juneCircuit.Problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author : ssuddhapally
 * @since : 06/06/21, Sun
 **/
public class Solution {

  static final int MAX = 10000000;
  public static void main(String[] args) throws IOException {
    int exponent = 1000000;
    int base = 2;
    power(base, exponent);
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int itr = Integer.parseInt(br.readLine());
//    for (int i = 0; i < itr; i++) {
//      String[] s = br.readLine().split(" ");
//      long a = Long.parseLong(s[0]);
//      long b = Long.parseLong(s[1]);
//      System.out.println(Math.pow(2, 1000000));
//      int c = (int) (Math.pow(2, a) % 1000000007) - 1;
//      //System.out.println(((int) (Math.pow(c, b) % 1000000007)));
    //}
  }

  static int multiply(int x, int res[], int res_size) {

    // Initialize carry
    int carry = 0;

    // One by one multiply n with
    // individual digits of res[]
    for (int i = 0; i < res_size; i++) {
      int prod = res[i] * x + carry;

      // Store last digit of
      // 'prod' in res[]
      res[i] = prod % 10;

      // Put rest in carry
      carry = prod / 10;
    }

    // Put carry in res and
    // increase result size
    while (carry > 0) {
      res[res_size] = carry % 10;
      carry = carry / 10;
      res_size++;
    }
    return res_size;
  }

  // This function finds
// power of a number x
  static void power(int x, int n) {

    //printing value "1" for power = 0
    if(n == 0 ){
      System.out.print("1");
      return;
    }
    int res[] = new int[MAX];
    int res_size = 0;
    int temp = x;

    // Initialize result
    while (temp != 0) {
      res[res_size++] = temp % 10;
      temp = temp / 10;
    }

    // Multiply x n times
    // (x^n = x*x*x....n times)
    for (int i = 2; i <= n; i++)
      res_size = multiply(x, res, res_size);

    System.out.print(x + "^" + n + " = ");
    for (int i = res_size - 1; i >= 0; i--)
      System.out.print(res[i]);
  }
}
