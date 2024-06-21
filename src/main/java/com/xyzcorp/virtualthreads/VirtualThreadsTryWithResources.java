package com.xyzcorp.virtualthreads;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.*;

public class VirtualThreadsTryWithResources {
    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<Long> submit = executorService.submit(() -> {
                try (InputStream inputStream = new URI("https://openjdk.org/").toURL().openStream();
                     InputStreamReader in = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                     BufferedReader reader = new BufferedReader(in)) {

                    return reader.lines()
                        .flatMap(line -> Arrays.stream(line.split("\\W+")))
                        .filter(word -> word.equalsIgnoreCase("java"))
                        .count();
                }
            });

            System.out.println("Submitted");

            //The timeout is not respected here
            System.out.println(submit.get(1, TimeUnit.SECONDS));
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
