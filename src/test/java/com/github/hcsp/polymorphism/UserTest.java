package com.github.hcsp.polymorphism;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void testCollectNames() {
        List<User> users =
                Arrays.asList(
                        new User(100, "b"),
                        new User(10, "z"),
                        new User(1, "a"),
                        new User(2000, "a"));
        Assertions.assertEquals(
                users.stream().map(User::getName).collect(Collectors.toList()),
                User.collectNames(users));
    }

    @Test
    public void hasAnonymousInnerClass() {
        Stream<String> entries =
                Stream.of(System.getProperty("java.class.path").split(File.pathSeparator));
        File targetClassDir =
                entries.filter(
                                entry ->
                                        entry.endsWith("target/classes")
                                                || entry.endsWith("target\\classes"))
                        .findFirst()
                        .map(File::new)
                        .orElseThrow(IllegalStateException::new);
        Assertions.assertTrue(
                new File(targetClassDir, "com/github/hcsp/polymorphism/User$1.class").isFile());
    }
}
