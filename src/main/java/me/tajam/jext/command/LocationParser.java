package me.tajam.jext.command;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class LocationParser {

  private final String stringX;
  private final String stringY;
  private final String stringZ;
  private final Player sender;

  public LocationParser(String stringX, String stringY, String stringZ, Player sender) throws IllegalStateException {
    this.stringX = stringX;
    this.stringY = stringY;
    this.stringZ = stringZ;
    this.sender = sender;
  }

  public Location parse() {
    final int intX;
    if (stringX.equals("~")) {
      intX = sender.getLocation().getBlockX();
    } else {
      intX = (int)Float.parseFloat(stringX);
    }

    final int intY;
    if (stringY.equals("~")) {
      intY = sender.getLocation().getBlockY();
    } else {
      intY = (int)Float.parseFloat(stringY);
    }

    final int intZ;
    if (stringZ.equals("~")) {
      intZ = sender.getLocation().getBlockZ();
    } else {
      intZ = (int)Float.parseFloat(stringZ);
    }

    return new Location(sender.getWorld(), intX, intY, intZ);
  }
}