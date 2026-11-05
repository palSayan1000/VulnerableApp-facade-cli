package org.sasanlabs.facade_cli.command_line_interface;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.stereotype.Component;

/**
 * Root command of the facade CLI. Prints the OWASP VulnerableApp tagline, both when the
 * application is ready and on demand through {@code vapp}.
 *
 * @author Sayan Pal -> palsayan1000(GitHub ID).
 */
@Slf4j
@Component
public class RootCommand {

    private static final String BOLD = "\u001B[1m";
    private static final String ORANGE = "\u001B[38;5;208m";
    private static final String RESET = "\u001B[0m";

    private static final String TAGLINE =
            BOLD + ORANGE + "Break it. Scan it. Reproduce it. Benchmark against it. Improve it." + RESET;

    /**
     * Prints the tagline once the application has started.
     */
    @EventListener(ApplicationStartedEvent.class)
    void printAtStartup() {
        System.out.println(vapp() + "\n");
    }

    /**
     * Returns the tagline of OWASP VulnerableApp, styled in bold orange using ANSI codes.
     *
     * @return the tagline text
     */
    @Command(
            name = "VulnerableApp",
            alias = {"vapp", "Vapp", "Vulnerable-App"},
            completionProvider = "vappCompletion",
            value = "Prints the tagline and logo of OWASP VulnerableApp."
    )
    public String vapp() {
        // writing logs
        log.info("VulnerableApp command executed.");
        return TAGLINE;
    }

}
