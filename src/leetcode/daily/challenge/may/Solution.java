package leetcode.daily.challenge.may;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : ssuddhapally
 * @since : 16/05/21, Sun
 **/
class Solution {
  public int minKnightMoves(int x, int y) {
    boolean[][] visited = new boolean[900][900];
    Queue<Pair> q = new LinkedList<>();
    visited[300][300] = true;
    q.add(new Pair(300, 300, 0));
    while(!q.isEmpty())
    {
      Pair p = q.poll();
      int tempX=p.getX();
      int tempY = p.getY();
      int tempLevel = p.getLevel()+1;
      if(tempX == (x+300) && tempY ==(y+300)) return p.getLevel();
      int tempXM1 = tempX-1;
      int tempYM1 = tempY-1;
      int tempXM2 = tempX-2;
      int tempYM2 = tempY-2;
      int tempXA1 = tempX+1;
      int tempYA1 = tempY+1;
      int tempYA2 = tempY+2;
      int tempXA2 = tempX+2;
      addIfNotVisited(visited, q, tempLevel, tempYM1, tempYM2, tempXA1, tempYA1, tempYA2, tempXA2);
      addIfNotVisited(visited,  q, tempLevel, tempYM1, tempYM2, tempXM1, tempYA1, tempYA2, tempXM2);
    }
    return -1;
  }

  private void addIfNotVisited(boolean[][] visited, Queue<Pair> q, int tempLevel, int tempYM1, int tempYM2, int tempXA1, int tempYA1, int tempYA2, int tempXA2) {
    changeXAndAddToQueue(visited,  q, tempLevel, tempXA1, tempYA1, tempYA2, tempXA2);
    changeXAndAddToQueue(visited, q, tempLevel, tempXA1, tempYM1, tempYM2, tempXA2);
  }

  private void changeXAndAddToQueue(boolean[][] visited, Queue<Pair> q, int tempLevel, int tempXA1, int tempYA1, int tempYA2, int tempXA2) {
    if(tempXA1>-1 && tempYA2 >-1 && tempXA1<900 && tempYA2 < 900 && !visited[tempXA1][tempYA2])
    {
      q.add(new Pair(tempXA1, tempYA2, tempLevel));
      visited[tempXA1][tempYA2] = true;
    }
    if(tempXA2>-1 && tempYA1 >-1 && tempXA2<900 && tempYA1 < 900 && !visited[tempXA2][tempYA1])
    {
      q.add(new Pair(tempXA2, tempYA1, tempLevel));
      visited[tempXA2][tempYA1] = true;
    }
  }

  static class Pair{
    private final int x;
    private final int y;
    private final int level;
    Pair(int x, int y,int level){
      this.x = x;
      this.y =y;
      this.level = level;
    }
    public  int getX(){
      return x;
    }
    public int getY(){
      return y;
    }
    public int getLevel(){
      return level;
    }
  }
}