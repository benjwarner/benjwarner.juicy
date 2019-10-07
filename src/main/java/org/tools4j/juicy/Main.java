package org.tools4j.juicy;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ProcessModule());
        Process process = injector.getInstance(Process.class);
        process.run();
    }
}
