package org.sasanlabs.facade_cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the starting class for Vulnerable App CLI application. Let's begin this amazing Journey!!!
 *
 * <p>Package layout:
 * <ul>
 *   <li>{@code cli} - Spring Shell command methods (what the user types)</li>
 *   <li>{@code service} - the logic that the commands call</li>
 *   <li>{@code config} - Spring configuration and beans</li>
 *   <li>{@code model} - types/interfaces for endpoint calls and formatted results</li>
 *   <li>{@code client} - classes that send requests and return typed results</li>
 * </ul>
 *
 * @author Sayan Pal -> palsayan1000(GitHub ID).
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}