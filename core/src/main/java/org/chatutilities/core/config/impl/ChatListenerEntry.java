package org.chatutilities.core.config.impl;

import net.labymod.api.client.gui.screen.widget.widgets.input.SliderWidget.SliderSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.TextFieldWidget.TextFieldSetting;
import net.labymod.api.client.gui.screen.widget.widgets.input.dropdown.DropdownWidget.DropdownSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.property.ConfigProperty;

public class ChatListenerEntry extends Config {

  @SwitchSetting
  private final ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

  @TextFieldSetting
  private final ConfigProperty<String> displayName = new ConfigProperty<>("");

  @DropdownSetting
  private final ConfigProperty<MatchType> matchType = new ConfigProperty<>(MatchType.EQUALS);

  @TextFieldSetting
  private final ConfigProperty<String> regex = new ConfigProperty<>("");

  @TextFieldSetting
  private final ConfigProperty<String> text = new ConfigProperty<>("");

  private SoundConfig soundConfig = new SoundConfig();

  @SliderSetting(min = 0, max = 10, steps = 0.1F)
  private final ConfigProperty<Float> delay = new ConfigProperty<>(0F);

  private BlackListConfig blackListConfig = new BlackListConfig();

  private ServerConfig serverConfig = new ServerConfig();

  public ChatListenerEntry() {
  }

  public ChatListenerEntry(
      boolean enabled,
      String displayName,
      MatchType matchType,
      String regex,
      String text,
      SoundConfig soundConfig,
      float delay,
      BlackListConfig blackListConfig,
      ServerConfig serverConfig
  ) {
    this.enabled.set(enabled);
    this.displayName.set(displayName);
    this.matchType.set(matchType);
    this.regex.set(regex);
    this.text.set(text);
    this.soundConfig = soundConfig;
    this.delay.set(delay);
    this.blackListConfig = blackListConfig;
    this.serverConfig = serverConfig;
  }

  public ConfigProperty<Boolean> getEnabled() {
    return enabled;
  }

  public ConfigProperty<MatchType> getMatchType() {
    return matchType;
  }

  public ConfigProperty<String> getText() {
    return text;
  }

  public ConfigProperty<Float> getDelay() {
    return delay;
  }

  public ConfigProperty<String> getDisplayName() {
    return displayName;
  }

  public ConfigProperty<String> getRegex() {
    return regex;
  }

  public BlackListConfig getBlackListConfig() {
    return blackListConfig;
  }

  public SoundConfig getSoundConfig() {
    return soundConfig;
  }


  public ServerConfig getServerConfig() {
    return serverConfig;
  }

  public ChatListenerEntry copy() {
    return new ChatListenerEntry(
        this.enabled.get(),
        this.displayName.get(),
        this.matchType.get(),
        this.regex.get(),
        this.text.get(),
        this.soundConfig,
        this.delay.get(),
        this.blackListConfig,
        this.serverConfig
    );
  }

  public enum MatchType {
    EQUALS,
    CONTAINS,
    REGEX,
    SIMPLIFIED_REGEX
  }

}
