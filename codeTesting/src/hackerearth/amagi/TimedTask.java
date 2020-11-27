package hackerearth.amagi;

import java.util.concurrent.*;

/**
 * @author : ssuddhapally
 * @since : 27/10/20, Tue
 **/
public class TimedTask {
  public static void main(String[] args) {
    final ExecutorService executorService = Executors.newFixedThreadPool(10);
    final Future<?> future = executorService.submit(() -> {
      try {
        Thread.sleep(10_000);
        System.out.println("still continuing");
      } catch (InterruptedException e) {
        System.out.println("Work Interrupted");
        e.printStackTrace();
      }
    });
    try {
      future.get(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      System.out.println("Interrupted");
      e.printStackTrace();
    } catch (ExecutionException e) {
      System.out.println("Execution Exception");
      e.printStackTrace();
    } catch (TimeoutException e) {

      future.cancel(true);
      boolean cancelled = future.isCancelled();
      System.out.println("is cancelled : " + cancelled);
      e.printStackTrace();
    }
  }
}