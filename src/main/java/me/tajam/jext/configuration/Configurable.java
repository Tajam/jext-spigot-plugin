package me.tajam.jext.configuration;

public interface Configurable {
  
  void save(ConfigWriter writer);

  void load();

}
