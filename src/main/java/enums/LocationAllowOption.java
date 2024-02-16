package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The options to choose on the Location Allow page.
 */
@Getter
@AllArgsConstructor
public enum LocationAllowOption {
    WHILE_USING_APP("While using the app"),
    ONLY_THIS_TIME("Only this time"),
    NOT_ALLOW("Don't allow");

    public final String allowOption;
}
