package me.tajam.jext.command;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.tajam.jext.disc.DiscContainer;
import me.tajam.jext.disc.DiscPlayer;
import me.tajam.jext.Log;
import me.tajam.jext.command.ParameterLocation.Axis;
import me.tajam.jext.config.ConfigDiscManager;

class ExecutorPlayAt extends ExecutorAdapter {

  ExecutorPlayAt() {
    super("playat");
    addParameter(new ParameterLocation(true, Axis.X));
    addParameter(new ParameterLocation(true, Axis.Y));
    addParameter(new ParameterLocation(true, Axis.Z));
    addParameter(new ParameterDisc(true));
    addParameter(new ParameterNumber(false, 0.5f, 1.0f, 1.5f).setName("pitch"));
    addParameter(new ParameterNumber(false, 4.0f, 1.0f, 0.5f).setName("volume"));
  }

  @Override
  boolean executePlayer(Player sender, String[] args) {
    final Location location;
    try {
      location = new LocationParser(args[0], args[1], args[2], sender).parse();
    } catch (NumberFormatException e) {
      new Log().eror().t("Invalid location value!").send(sender);
      return true;
    }

    final DiscContainer disc = ConfigDiscManager.getInstance().getDisc(args[3]);
    if (disc == null) {
      new Log().eror().t("Disc with the namespace ").o(args[3]).t(" doesn't exists.").send(sender);
      return true;
    }
    final DiscPlayer discPlayer = new DiscPlayer(disc);

    if (args.length >= 5) {
      try {
        final float pitch = Float.parseFloat(args[4]);
        discPlayer.setPitch(pitch);
      } catch (NumberFormatException e) {
        new Log().eror().t("Wrong number format for pitch parameter.").send(sender);
        return true;
      }
    }

    if (args.length >= 6) {
      try {
        final float volume = Float.parseFloat(args[5]);
        discPlayer.setVolume(volume);
      } catch (NumberFormatException e) {
        new Log().eror().t("Wrong number format for volume parameter.").send(sender);
        return true;
      }
    }

    discPlayer.play(location);
    return true;
  }
}