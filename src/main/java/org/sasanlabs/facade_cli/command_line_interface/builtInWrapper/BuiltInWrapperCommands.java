package org.sasanlabs.facade_cli.command_line_interface.builtInWrapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.core.command.*;
import org.springframework.shell.core.command.annotation.Argument;
import org.springframework.shell.core.command.annotation.Command;
import org.springframework.shell.core.command.annotation.CommandGroup;
import org.springframework.shell.jline.command.History;
import org.springframework.stereotype.Component;

/**
 * Exposes Spring Shell's built-in commands under the {@code vapp} prefix, for example
 * {@code vapp clear} and {@code vapp history}. Each method forwards the current
 * {@link CommandContext} to the matching built-in command bean defined in
 * {@code BuiltInWrapperConfig}.
 *
 * @author Sayan Pal -> palsayan1000(GitHub ID).
 */
@Slf4j
@Component
@RequiredArgsConstructor
@CommandGroup(name = "VulnerableApp", prefix = "vapp",
        description = "Root-Commands calls the built-in commands")
public class BuiltInWrapperCommands {

    // built-in command beans
    private final Clear clear;
    private final History history;
    private final Script script;
    private final Version version;

    /**
     * Clears the terminal screen by delegating to the built-in {@link Clear} command.
     *
     * @param ctx the context of the current command invocation
     * @throws Exception if the built-in command fails
     */
    @Command(
            name = "clear",
            alias = {"Clear", "CLEAR"},
            description = "Calls built-in clear."
    )
    public void vappClear(CommandContext ctx) throws Exception {
        log.info("Clear command executed.");
        clear.execute(ctx);
    }

    /**
     * Displays previously run commands by delegating to the built-in {@link History}
     * command. The {@code -f} option of the built-in command is not exposed here.
     *
     * @param ctx the context of the current command invocation
     * @throws Exception if the built-in command fails
     */
    @Command(
            name = "history",
            alias = {"History", "HISTORY"},
            description = "Calls the built-in history."
    )
    public void vappHistory(CommandContext ctx) throws Exception {
        log.info("History command executed.");
        history.execute(ctx);
    }

    /**
     * Runs the commands listed in a script file by delegating to the built-in
     * {@link Script} command.
     *
     * @param file the path of the script file to run
     * @param ctx  the context of the current command invocation
     * @throws Exception if the built-in command fails
     */
    @Command(
            name = "script",
            alias = {"Script", "SCRIPT"},
            description = "Calls the built-in script."
    )
    public void vappScript(
            @Argument(index = 0, description = "Path of the script file to run") String file,
            CommandContext ctx) throws Exception {
        log.info("Script command executed for file: {}", file);
        script.execute(ctx);
    }

    /**
     * Prints version information by delegating to the built-in {@link Version} command.
     *
     * @param ctx the context of the current command invocation
     * @throws Exception if the built-in command fails
     */
    @Command(
            name = "version",
            alias = {"Version", "VERSION"},
            description = "Calls the built-in version."
    )
    public void vappVersion(CommandContext ctx) throws Exception {
        log.info("Version command executed.");
        version.execute(ctx);
    }
}
