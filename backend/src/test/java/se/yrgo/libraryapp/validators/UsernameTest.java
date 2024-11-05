package se.yrgo.libraryapp.validators;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class UsernameTest {

    @ParameterizedTest
    @ValueSource(strings = { "iv@n", "T1LL", "1uKA", "@._-", ".van", "T-l1", "luK@", "28174618276198246iv@n2ill_-.LUKAaosdogwg@@@@323______---..."})
    void validUsername(String validName) {
        assertThat(Username.validate(validName)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"_n@me wITh s-p.äce_", "   ", "i&_", "=", "öööööååååääää"})
    @EmptySource
    void invalidUsername(String invalidName) {
        assertThat(Username.validate(invalidName)).isFalse();
    }
}
