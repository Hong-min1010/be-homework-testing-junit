package com.springboot.homework;

import com.springboot.helper.RandomPasswordGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomPasswordGeneratorTest {
    @DisplayName("실습 3: 랜덤 패스워드 생성 테스트")
    @Test
    public void generateTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        // given, when
        int numberOfUpperCaseLetters = 3;
        int numberOfLowerCaseLetters = 5;
        int numberOfNumeric = 2;
        int numberOfSpecialChars = 7;

        // 예상 비밀번호 길이(A)
        int expectedPasswordLength = numberOfUpperCaseLetters + numberOfLowerCaseLetters + numberOfNumeric + numberOfSpecialChars;

        // 랜덤으로 섞은 비밀번호(B)
        String randomPassword = RandomPasswordGenerator.generate(numberOfUpperCaseLetters, numberOfLowerCaseLetters, numberOfNumeric, numberOfSpecialChars);

        // then

        // A B 길이 비교
        assertEquals(expectedPasswordLength, randomPassword.length());

        // A B 대문자 갯수 비교
        assertEquals(numberOfUpperCaseLetters, randomPassword.chars()
                .filter(c -> Character.isUpperCase(c))
                .count());

        // A B 소문자 갯수 비교
        assertEquals(numberOfLowerCaseLetters, randomPassword.chars()
                .filter(c -> Character.isLowerCase(c))
                .count());

        // A B 숫자 갯수 비교
        assertEquals(numberOfNumeric, randomPassword.chars()
                .filter(c-> Character.isDigit(c))
                .count());

        // A B 특수문자 갯수 비교 (!Character.isLetterOrDigit() -> 문자나 숫자가 아닌것을 의미함)
        assertEquals(numberOfSpecialChars, randomPassword.chars()
                .filter(c -> !Character.isLetterOrDigit(c))
                .count());
    }
}
