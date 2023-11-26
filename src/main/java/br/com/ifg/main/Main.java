package br.com.ifg.main;

import io.quarkus.runtime.Quarkus;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Main {
    public static void main(String... args) {
        Quarkus.run(args);
    }
}
