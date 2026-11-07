package org.sasanlabs.facade_cli.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ResourceBanner;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Logic behind the root {@code vapp} command: renders the OWASP VulnerableApp banner.
 *
 * @author Sayan Pal -> palsayan1000(GitHub ID).
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RootCommandService {

    private final Environment environment;

    /**
     * Renders {@code banner.without.welcome.txt} from the classpath into a string. The
     * Spring {@link ResourceBanner} resolves placeholders (such as version values) using
     * the {@link Environment}, and the output is captured in memory instead of being
     * printed directly, so the shell can print it.
     *
     * @return the rendered banner text
     */
    public String renderBanner() {
        log.info("Rendering Banner...");

        var banner = new ResourceBanner(
                new ClassPathResource("banner.without.welcome.txt")
        );
        var output = new ByteArrayOutputStream();

        // autoflush is on; the stream is closed by try-with-resources
        try (var printStream = new PrintStream(
                output, true, StandardCharsets.UTF_8
        )) {
            banner.printBanner(environment, getClass(), printStream);
        }

        return output.toString(StandardCharsets.UTF_8);
    }

}
