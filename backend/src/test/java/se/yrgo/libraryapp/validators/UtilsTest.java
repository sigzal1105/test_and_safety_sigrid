package se.yrgo.libraryapp.validators;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UtilsTest {

    @ParameterizedTest
    @ValueSource(strings = { "Iv@n23", "TILLh3llo", "LuKa30mAn", "iv@nT1Ll",
            "A<>&|',._-/{[]}?!£$*+\"#§~¨`´()^¤=0123456789" })
    void removesNonLetters(String str) {

        assertThat(Utils.onlyLettersAndWhitespace(str)).isAlphabetic();
    }

    @ParameterizedTest
    @ValueSource(strings = { "Iv@n 23", "TILL h3llo", "LuKa 30 mAn", "iv@n T1Ll", "   " })
    void keepsWhitespaces(String str) {

        assertThat(Utils.onlyLettersAndWhitespace(str)).containsWhitespaces();
    }

    @ParameterizedTest
    @ValueSource(strings = { "HELLO", "gooDByE", "WOr lD", "see YA", "last test", "H", "a" })
    void isLowerCase(String str) {

        assertThat(Utils.onlyLettersAndWhitespace(str)).isEqualTo(str.toLowerCase());
    }

    @ParameterizedTest
    @ValueSource(strings = { "HELLO", "gooDByE", "WOr lD", "see YA", "last test", "H", "a" })
    void isNotLowerCase(String str) {

        assertThat(Utils.onlyLettersAndWhitespace(str)).isNotEqualTo(str.toUpperCase());
    }

    @ParameterizedTest
    @ValueSource(strings = { "1337" })
    void validLeet(String str) {

        assertThat(Utils.cleanAndUnLeet(str)).isEqualTo("leet");
    }
}
