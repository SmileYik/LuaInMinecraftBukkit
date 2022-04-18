package tk.smileyik.luainminecraftbukkit.test;

import org.bukkit.command.CommandSender;

import java.math.BigInteger;

public class LoopTest {
  public static String loop1(long times) {
    BigInteger sum = BigInteger.ZERO;
    for (long i = 0; i <= times; ++i) {
      sum = sum.add(BigInteger.valueOf(i));
    }
    return sum.toString();
  }

  public static String loop2(long times) {
    long sum = 0;
    for (long i = 0; i <= times; ++i) {
      sum += 1;
    }
    return String.valueOf(sum);
  }

  public static void doLoop(CommandSender sender, String timesStr, String way) {
    sender.sendMessage("start loop: ");
    long times = Long.parseLong(timesStr);
    String sum;
    long time = System.currentTimeMillis();
    if (way.equals("loop1")) {
      sum = loop1(times);
    } else {
      sum = loop2(times);
    }
    time = System.currentTimeMillis() - time;
    sender.sendMessage("sum is " + sum);
    sender.sendMessage("use time: " + time + "ms");
  }
}
