package me.tajam.jext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Log {

  private final String title;
  private ChatColor themeColor;
  private final List<Token> tokens;

  public Log(String title) {
    this.tokens = new ArrayList<>();
    this.themeColor = ChatColor.WHITE;
    this.title = title;
  }

  public Log() {
    this("Jext");
  }

  /**
   * Set message theme to normal and add a header (White)
   * Return the instance with the header set
   * @return Log
   */
  public Log norm() {
    this.themeColor = ChatColor.RESET;
    return head();
  }

  /**
   * Set message theme to success and add a header (Green)
   * Return the instance with the header set
   * @return Log
   */
  public Log okay() {
    this.themeColor = ChatColor.GREEN;
    return head();
  }

  /**
   * Set message theme to warning and add a header (Yellow)
   * Return the instance with the header set
   * @return Log
   */
  public Log warn() {
    this.themeColor = ChatColor.YELLOW;
    return head();
  }

  /**
   * Set message theme to error and add a header (Red)
   * Return the instance with the header set
   * @return Log
   */
  public Log eror() {
    this.themeColor = ChatColor.RED;
    return head();
  }

  /**
   * Set message theme to infomative and add a header (Blue)
   * Return the instance with the header set
   * @return Log
   */
  public Log info() {
    this.themeColor = ChatColor.BLUE;
    return head();
  }

  /**
   * Add header pattern following the theme colour
   * Return the instance itself for chaining
   * @return Log
   */
  private Log head() {
    return rst("[").t(title).rst("] ");
  }

  /**
   * Add theme-coloured text
   * Return the instance itself for chaining
   * @return Log
   */
  public Log t(String themeColoredMessage) {
    this.tokens.add(new Token(themeColoredMessage, themeColor));
    return this;
  }

  /**
   * Add theme-coloured placeholder
   * Return the instance itself for chaining
   * @return Log
   */
  public Log t() {
    this.tokens.add(new Token(themeColor));
    return this;
  }

  /**
   * Add green-coloured text
   * Return the instance itself for chaining
   * @return Log
   */
  public Log g(String greenMessage) {
    this.tokens.add(new Token(greenMessage, ChatColor.GREEN));
    return this;
  }

  /**
   * Add green-coloured placeholder
   * Return the instance itself for chaining
   * @return Log
   */
  public Log g() {
    this.tokens.add(new Token(ChatColor.GREEN));
    return this;
  }

  /**
   * Add yellow-coloured text
   * Return the instance itself for chaining
   * @return Log
   */
  public Log y(String yellowMessage) {
    this.tokens.add(new Token(yellowMessage, ChatColor.YELLOW));
    return this;
  }

  /**
   * Add yellow-coloured placeholder
   * Return the instance itself for chaining
   * @return Log
   */
  public Log y() {
    this.tokens.add(new Token(ChatColor.YELLOW));
    return this;
  }

  /**
   * Add orange-coloured (gold) text
   * Return the instance itself for chaining
   * @return Log
   */
  public Log o(String goldenMessage) {
    this.tokens.add(new Token(goldenMessage, ChatColor.GOLD));
    return this;
  }

  /**
   * Add orange-coloured (gold) placeholder
   * Return the instance itself for chaining
   * @return Log
   */
  public Log o() {
    this.tokens.add(new Token(ChatColor.GOLD));
    return this;
  }

  /**
   * Add red-coloured text
   * Return the instance itself for chaining
   * @return Log
   */
  public Log r(String redMessage) {
    this.tokens.add(new Token(redMessage, ChatColor.RED));
    return this;
  }

  /**
   * Add red-coloured placeholder
   * Return the instance itself for chaining
   * @return Log
   */
  public Log r() {
    this.tokens.add(new Token(ChatColor.RED));
    return this;
  }

  /**
   * Add blue-coloured text
   * Return the instance itself for chaining
   * @return Log
   */
  public Log b(String blueMessage) {
    this.tokens.add(new Token(blueMessage, ChatColor.BLUE));
    return this;
  }

  /**
   * Add blue-coloured placeholder
   * Return the instance itself for chaining
   * @return Log
   */
  public Log b() {
    this.tokens.add(new Token(ChatColor.BLUE));
    return this;
  }

  /**
   * Add teal-coloured text
   * Return the instance itself for chaining
   * @return Log
   */
  public Log a(String aquaMessage) {
    this.tokens.add(new Token(aquaMessage, ChatColor.AQUA));
    return this;
  }

  /**
   * Add teal-coloured placeholder
   * Return the instance itself for chaining
   * @return Log
   */
  public Log a() {
    this.tokens.add(new Token(ChatColor.AQUA));
    return this;
  }

  /**
   * Add dark teal-coloured text
   * Return the instance itself for chaining
   * @return Log
   */
  public Log da(String darkAquaMessage) {
    this.tokens.add(new Token(darkAquaMessage, ChatColor.DARK_AQUA));
    return this;
  }

  /**
   * Add dark teal-coloured placeholder
   * Return the instance itself for chaining
   * @return Log
   */
  public Log da() {
    this.tokens.add(new Token(ChatColor.DARK_AQUA));
    return this;
  }

  /**
   * Add purple-coloured text
   * Return the instance itself for chaining
   * @return Log
   */
  public Log p(String purpleMessage) {
    this.tokens.add(new Token(purpleMessage, ChatColor.LIGHT_PURPLE));
    return this;
  }

  /**
   * Add purple-coloured placeholder
   * Return the instance itself for chaining
   * @return Log
   */
  public Log p() {
    this.tokens.add(new Token(ChatColor.LIGHT_PURPLE));
    return this;
  }

  /**
   * Add dark purple-coloured text
   * Return the instance itself for chaining
   * @return Log
   */
  public Log dp(String darkPurpleMessage) {
    this.tokens.add(new Token(darkPurpleMessage, ChatColor.DARK_PURPLE));
    return this;
  }

  /**
   * Add dark purple-coloured placeholder
   * Return the instance itself for chaining
   * @return Log
   */
  public Log dp() {
    this.tokens.add(new Token(ChatColor.DARK_PURPLE));
    return this;
  }

  /**
   * Add gray-coloured text
   * Return the instance itself for chaining
   * @return Log
   */
  public Log gr(String grayMessage) {
    this.tokens.add(new Token(grayMessage, ChatColor.GRAY));
    return this;
  }

  /**
   * Add gray-coloured placeholder
   * Return the instance itself for chaining
   * @return Log
   */
  public Log gr() {
    this.tokens.add(new Token(ChatColor.GRAY));
    return this;
  }

  /**
   * Add magic-coloured text
   * Return the instance itself for chaining
   * @return Log
   */
  public Log mag(String magicMessage) {
    this.tokens.add(new Token(magicMessage, ChatColor.MAGIC));
    return this;
  }

  /**
   * Add magic-coloured placeholder
   * Return the instance itself for chaining
   * @return Log
   */
  public Log mag() {
    this.tokens.add(new Token(ChatColor.MAGIC));
    return this;
  }

  /**
   * Reset colour and add text
   * Return the instance itself for chaining
   * @return Log
   */
  public Log rst(String plainColoredMessage) {
    this.tokens.add(new Token(plainColoredMessage, ChatColor.RESET));
    return this;
  }

  /**
   * Reset colour and add placeholder
   * Return the instance itself for chaining
   * @return Log
   */
  public Log rst() {
    this.tokens.add(new Token(ChatColor.RESET));
    return this;
  }

  /**
   * Send the message to the console with parameter
   * set to replace the placeholders.
   * @return void
   */
  public void send(Object... objects) {
    final Queue<Object> objectQueue = new LinkedList<>(Arrays.asList(objects));
    Bukkit.getConsoleSender().sendMessage(constructMessage(objectQueue));
  }

  /**
   * Send the message to specified target with parameter
   * set to replace the placeholders.
   * @return void
   */
  public void send(CommandSender target, Object... objects) {
    final Queue<Object> objectQueue = new LinkedList<>(Arrays.asList(objects));
    String message = constructMessage(objectQueue);
    if (target instanceof Player) {
      Player player = (Player)target;
      player.sendMessage(message);
    } else {
      Bukkit.getConsoleSender().sendMessage(message);
    }
  }

  /**
   * Generate string with parameter set to replace
   * the placeholders.
   * @return String
   */
  public String text(Object... objects) {
    final Queue<Object> objectQueue = new LinkedList<>(Arrays.asList(objects));
    return constructMessage(objectQueue);
  }

  private String constructMessage(Queue<Object> parameters) {
    StringBuilder message = new StringBuilder();
    for (Token token : tokens) {
      message.append(token.toString(parameters));
    }
    return message.toString();
  }

  private static class Token {

    private final String message;
    private final ChatColor color;
    private final boolean parameter;

    private Token(String message, ChatColor color, boolean parameter) {
      this.message = message;
      this.color = color;
      this.parameter = parameter;
    }

    public Token(String message, ChatColor color) {
      this(message, color, false);
    }

    public Token(ChatColor color) {
      this("", color, true);
    }

    public String toString(Queue<Object> objects) {
      if (parameter) {
        final Object object = objects.poll();
        String replacement = "";
        if (object != null) replacement = object.toString();
        return this.color + replacement;
      } else {
        return this.color + this.message;
      }
    }

  }

}