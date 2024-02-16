package enums;

import helper.EnumHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Sub menu options in the Search Results page.
 */
@Getter
@AllArgsConstructor
public enum SearchResultsSubMenu implements EnumHandler {
    ALL("ALL"),
    TEAMS("TEAMS"),
    PLAYERS("PLAYERS"),
    NEWS("NEWS");

    public final String displayedMenuName;
}
