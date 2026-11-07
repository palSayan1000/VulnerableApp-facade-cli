package org.sasanlabs.facade_cli.cli;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sasanlabs.facade_cli.service.RootCommandService;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.stereotype.Component;

/**
 * Root command of the facade CLI. Prints the OWASP VulnerableApp tagline, both when the
 * application is ready and on demand through {@code vapp}.
 *
 * <p>This class only declares the command; the banner rendering is done in
 * {@link RootCommandService}.
 *
 * @author Sayan Pal -> palsayan1000(GitHub ID).
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class RootCommand {

    private final RootCommandService rootCommandService;

    /**
     * Returns the BANNER of OWASP VulnerableApp.
     *
     * @return the banner text (tagline and logo) printed by the shell
     */
    @Command(
            name = "VulnerableApp",
            alias = {"vapp", "Vapp", "Vulnerable-App"},
            completionProvider = "vappCompletion",
            value = "Prints the tagline and logo of OWASP VulnerableApp."
    )
    public String vapp() {
        log.info("VulnerableApp root command executing....");

        return rootCommandService.renderBanner();
    }
}
