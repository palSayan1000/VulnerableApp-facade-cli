package org.sasanlabs.facade_cli.cli.builtinwrapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sasanlabs.facade_cli.service.builtinwrapper.BuiltInWrapperService;
import org.springframework.shell.core.command.CommandContext;
import org.springframework.shell.core.command.annotation.Argument;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.CommandGroup;
import org.springframework.stereotype.Component;

/**
 * Exposes Spring Shell's built-in commands under the {@code vapp} prefix, for example
 * {@code vapp clear} or {@code vapp version}.
 *
 * <p>Each method only logs and delegates to {@link BuiltInWrapperService}, which runs the
 * real built-in command.
 *
 * @author Sayan Pal -> palsayan1000(GitHub ID).
 */
@Slf4j
@Component
@RequiredArgsConstructor
@CommandGroup(name = "VulnerableApp", prefix = "vapp",
        description = "Root-Commands calls the built-in commands")
public class BuiltInWrapperCommands {

    private final BuiltInWrapperService builtInWrapperService;

    /**
     * {@code vapp clear}: clears the terminal screen.
     *
     * @param ctx the shell context of the running command
     * @throws Exception if the built-in clear command fails
     */
    @Command(
            name = "clear",
            alias = {"Clear", "CLEAR"},
            description = "Calls built-in clear."
    )
    public void vappClear(CommandContext ctx) throws Exception {
        log.info("Clear command executing....");

        builtInWrapperService.vappClear(ctx);
    }

    /**
     * {@code vapp history}: shows the commands run earlier in this shell.
     *
     * @param ctx the shell context of the running command
     * @throws Exception if the built-in history command fails
     */
    @Command(
            name = "history",
            alias = {"History", "HISTORY"},
            description = "Calls the built-in history."
    )
    public void vappHistory(CommandContext ctx) throws Exception {
        log.info("History command executing....");

        builtInWrapperService.vappHistory(ctx);
    }

    /**
     * {@code vapp script <file>}: runs the commands listed in a script file.
     *
     * @param file path of the script file to run
     * @param ctx  the shell context of the running command
     * @throws Exception if the built-in script command fails
     */
    @Command(
            name = "script",
            alias = {"Script", "SCRIPT"},
            description = "Calls the built-in script."
    )
    public void vappScript(
            @Argument(index = 0, description = "Path of the script file to run") String file,
            CommandContext ctx) throws Exception {
        log.info("Script command executing....");

        builtInWrapperService.vappScript(file, ctx);
    }

    /**
     * {@code vapp version}: prints the application version.
     *
     * @param ctx the shell context of the running command
     * @throws Exception if the built-in version command fails
     */
    @Command(
            name = "version",
            alias = {"Version", "VERSION"},
            description = "Calls the built-in version."
    )
    public void vappVersion(CommandContext ctx) throws Exception {
        log.info("Version command executing.....");

        builtInWrapperService.vappVersion(ctx);
    }
}
