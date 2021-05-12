package me.tajam.jext.config.field;

import java.util.ArrayList;

import org.bukkit.configuration.ConfigurationSection;

public interface ConfigFieldList<T> {

  String getPath();
  ArrayList<T> getData();
  void updateData(ConfigurationSection section);

}