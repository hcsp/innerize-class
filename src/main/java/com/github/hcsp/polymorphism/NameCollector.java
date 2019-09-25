package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class NameCollector implements Consumer<User> {
    private final List<String> names = new ArrayList<>();

    @Override
    public void accept(User user) {

    }

    public List<String> getNames() {
        return names;
    }
}
