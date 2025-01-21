package com.springboot.helper;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RandomPasswordGenerator {

    public static String generate(int numberOfUpperCaseLetters,
                                  int numberOfLowerCaseLetters,
                                  int numberOfNumeric,
                                  int numberOfSpecialChars) {
        // 65, 90 은 Unicode이다, A ~ Z를 뜻함.
        String upperCaseLetters = RandomStringUtils.random(numberOfUpperCaseLetters, 65, 90, true, false);
        // 97 ~ 122 는 Unicode이다, a ~ z를 뜻함.
        String lowerCaseLetters = RandomStringUtils.random(numberOfLowerCaseLetters, 97, 122, true, false);
        // 0 ~ 9의 숫자 범위를 뜻함.
        String numbers = RandomStringUtils.randomNumeric(numberOfNumeric);
        // 33 ~ 47은 Unicode이다. 특수문자를 뜻한다.
        String specialChars = RandomStringUtils.random(numberOfSpecialChars, 33, 47, false, false);

        // combineLetters를 호출하여 대문자, 소문자, 숫자, 특수문자를 하나의 문자열로 변환함.
        String combinedLetters = combineLetters(upperCaseLetters, lowerCaseLetters, numbers, specialChars);
        // shuffleLetters를 호출하여 합쳐진 문자열을 랜덤하게 섞은 후 섞은 문자열을 List로 반환.
        List<Character> shuffledLetters = shuffleLetters(combinedLetters);
        return shuffledLetters.stream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    private static List<Character> shuffleLetters(String combinedLetters) {
        // combinedLetters.chars() -> 각 문자는 Unicode 값으로 처리됨
        List<Character> shuffledLetters = combinedLetters.chars().mapToObj(c -> (char) c).collect(toList());
        // 리스트 안의 요소들을 랜덤하게 섞음
        Collections.shuffle(shuffledLetters);
        return shuffledLetters;
    }
    // 대문자, 소문자, 숫자, 특수문자를 하나의 문자열로 변환하여 반환.
    private static String combineLetters(String upperCaseLetters, String lowerCaseLetters, String numbers, String specialChars) {
        return upperCaseLetters.concat(lowerCaseLetters).concat(numbers).concat(specialChars);
    }
}
