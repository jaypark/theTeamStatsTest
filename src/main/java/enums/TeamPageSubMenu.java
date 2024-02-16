package enums;

import helper.EnumHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TeamPageSubMenu implements EnumHandler {
    NEWS("NEWS"),
    CHAT("CHAT"),
    TEAM_STATS("TEAM STATS"),
    SCHEDULE("SCHEDULE"),
    PLAYER_STATS("PLAYER STATS"),
    ROSTER("ROSTER"),
    INFO("INFO");

    public final String displayedMenuName;
}
