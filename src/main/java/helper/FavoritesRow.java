package helper;

import io.appium.java_client.MobileElement;
import lombok.Getter;
import lombok.Setter;

/**
 * FavoritesRow is the structure of the row when choosing
 * favorite team or league during the onboarding step.
 */
@Getter
@Setter
public class FavoritesRow {
    public MobileElement rowIcon;
    public MobileElement rowName;
    public MobileElement rowFavoriteIndicator;
}
