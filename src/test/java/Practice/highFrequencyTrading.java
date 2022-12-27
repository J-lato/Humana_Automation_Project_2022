import java.util.Random;

public class HighFrequencyTradingAlgorithm {
  // Constants
  private static final int NUM_TRADES = 1000;
  private static final int MIN_PRICE = 100;
  private static final int MAX_PRICE = 200;

  public static void main(String[] args) {
    Random rand = new Random();

    // Simulate trades
    for (int i = 0; i < NUM_TRADES; i++) {
      // Generate a random price
      int price = MIN_PRICE + rand.nextInt(MAX_PRICE - MIN_PRICE + 1);

      // Decide whether to buy or sell
      if (rand.nextBoolean()) {
        System.out.println("Buying at price: " + price);
      } else {
        System.out.println("Selling at price: " + price);
      }
    }
  }
}
