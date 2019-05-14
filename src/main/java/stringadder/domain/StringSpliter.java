package stringadder.domain;

import sun.security.krb5.internal.ccache.CCacheInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StringSpliter {
    private static final String CUSTOM_SEPARATOR_PICKER = "//|\n";
    private static final int NUMBER_STRING_POSITION = 2;
    private static final int ADDITIONAL_SEPARATOR_POSITION = 1;
    private List<String> seperators = new ArrayList<>(Arrays.asList(",", ":"));

    public StringSpliter(List<String> seperators) {
        this.seperators.addAll(seperators);
    }

    public StringSpliter() {
    }

    static List<String> splitBySeparators(String numbersWithSeparator, List<String> separators) {
        String separatorsToRex = String.join("|", separators);

        return Arrays.asList(numbersWithSeparator.split(separatorsToRex));
    }

    String setAdditionalSeparatorsFrom(String input) {
        try {
            seperators.add(input.split(CUSTOM_SEPARATOR_PICKER)[ADDITIONAL_SEPARATOR_POSITION]);
            return input.split(CUSTOM_SEPARATOR_PICKER)[NUMBER_STRING_POSITION];
        } catch (Exception e) {
            return input;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringSpliter that = (StringSpliter) o;
        return Objects.equals(seperators, that.seperators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seperators);
    }
}
