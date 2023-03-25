/*
 * User: levon
 * Date: 25.03.2023
 * Time: 20:34
 */

import java.util.concurrent.ThreadLocalRandom;

public class Main {
  private static final String[] strings = {"fish", "dish", "fosh", "fort", "dizzy"};
  private static final int tries = 10;

  public static void main(String[] args) {
    final ThreadLocalRandom random = ThreadLocalRandom.current();

    System.out.println("Hello!");
    for (int i = 0; i < tries; i++) {
      String s1 = strings[random.nextInt(0, strings.length)];
      String s2 = strings[random.nextInt(0, strings.length)];
      System.out.println("s1: " + s1 + ", s2: " + s2 + ", Compare: " + compare(s1, s2));
    }

  }

  /**
   * Comparing 2 string by dynamic programming
   * @param str1 String
   * @param str2 String
   * @return num of identical chars
   */
  public static int compare(String str1, String str2) {
    char[] cs1 = str1.toCharArray();
    char[] cs2 = str2.toCharArray();
    int[][] dp = new int[cs1.length][cs2.length];

    for (int i = 0; i < cs1.length; i++) {
      for (int j = 0; j < cs2.length; j++) {
        if (cs1[i] == cs2[j]) {
          dp[i][j] = dp[Math.max(i - 1, 0)][Math.max(j - 1, 0)] + 1;
        } else {
          dp[i][j] = Math.max(dp[Math.max(i - 1, 0)][j], dp[i][Math.max(j - 1, 0)]);
        }
      }
    }

    return dp[cs1.length - 1][cs2.length - 1];
  }
}