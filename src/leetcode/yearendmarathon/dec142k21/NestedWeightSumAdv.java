package leetcode.yearendmarathon.dec142k21;

/**
 * @author : ssuddhapally
 * @since : 15/12/21, Wed
 **/

/*

You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists.

The depth of an integer is the number of lists that it is inside of. For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth. Let maxDepth be the maximum depth of any integer.

The weight of an integer is maxDepth - (the depth of the integer) + 1.

Return the sum of each integer in nestedList multiplied by its weight.
Input: nestedList = [[1,1],2,[1,1]]
Output: 8
Explanation: Four 1's with a weight of 1, one 2 with a weight of 2.
1*1 + 1*1 + 2*2 + 1*1 + 1*1 = 8
*/

import java.util.ArrayList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 * <p>
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 * <p>
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 * public void add(NestedInteger ni);
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class NestedWeightSumAdv {
  int max = 0;

  public int depthSumInverse(List<NestedInteger> nestedList) {
    List<Pair> depths = new ArrayList<Pair>();
    boolean stillDeep = false;
    // stillDeep  = nestedList.isInteger();
    // if(!stillDeep) return 1;
    rec(nestedList, 1, depths);
    int res = 0;
    for (int i = 0; i < depths.size(); i++) {
      res += weigtOfOne(max, depths.get(i).value, depths.get(i).key);
    }
    return res;
  }

  void rec(List<NestedInteger> nestedList, int deep, List<Pair> depths) {
    for (int i = 0; i < nestedList.size(); i++) {
      NestedInteger n = nestedList.get(i);
      boolean stillDeep = n.isInteger();
      if (!stillDeep) {
        rec(n.getList(), deep + 1, depths);
      } else {
        if (max < deep) max = deep;
        Pair p = new Pair(n.getInteger(), deep);
        depths.add(p);
      }
    }
  }

  int weigtOfOne(int maxDeep, int eleDeep, int eleValue) {
    return (maxDeep - eleDeep + 1) * eleValue;
  }
}

class Pair {
  int key;
  int value;

  Pair(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

interface NestedInteger {

  //public NestedInteger();

  // public NestedInteger(int value);
  public boolean isInteger();

  public Integer getInteger();

  public void setInteger(int value);

  public void add(NestedInteger ni);

  public List<NestedInteger> getList();
}

//Implement NestedInteger