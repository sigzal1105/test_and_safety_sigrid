package se.yrgo.libraryapp.validators;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RealNameTest {

    @Disabled
    @ParameterizedTest
    @ValueSource (strings = {"balderdash", "blimey", "bullspit", "damn", "darn", "drat", "frack", "frick", "heck", "shiet"})
    void isValidName(String str) {
        
        assertThat(RealName.validate(str)).isTrue();
    }

    //@Disabled
    @ParameterizedTest
    @ValueSource (strings = {"balderdash", "blimey", "bullspit", "damn", "darn", "drat", "frack", "frick", "heck", "shiet"})
    void isNotValidName(String str) {
        
        assertThat(RealName.validate(str)).isFalse();
    }
}
