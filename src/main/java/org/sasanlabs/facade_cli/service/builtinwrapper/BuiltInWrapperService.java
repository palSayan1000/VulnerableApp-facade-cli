package org.sasanlabs.facade_cli.service.builtinwrapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.core.command.Clear;
import org.springframework.shell.core.command.CommandContext;
import org.springframework.shell.core.command.Script;
import org.springframework.shell.core.command.Version;
import org.springframework.shell.jline.command.History;
import org.springframework.stereotype.Service;

/**
 * Executes Spring Shell's built-in commands for the wrapper commands in
 * {@code cli.builtinwrapper}. The built-in command beans come from
 * {@code BuiltInWrapperConfig}.
 *
 * @author Sayan Pal -> palsayan1000(GitHub ID).
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BuiltInWrapperService {

    // built-in command beans
    private final Clear clear;
    private final History history;
    private final Script script;
    private final Version version;

    /**
     * Runs the built-in {@code clear} command.
     *
     * @param ctx the shell context of the running command
     * @throws Exception if the built-in command fails
     */
    public void vappClear(CommandContext ctx) throws Exception {
        clear.execute(ctx);

        log.info("Clear command execution done.");
    }

    /**
     * Runs the built-in {@code history} command.
     *
     * @param ctx the shell context of the running command
     * @throws Exception if the built-in command fails
     */
    public void vappHistory(CommandContext ctx) throws Exception {
        history.execute(ctx);

        log.info("History command execution done.");
    }

    /**
     * Runs the built-in {@code script} command.
     *
     * @param file path of the script file, used here for logging
     * @param ctx  the shell context of the running command
     * @throws Exception if the built-in command fails
     */
    public void vappScript(String file, CommandContext ctx) throws Exception {
        script.execute(ctx);

        log.info("Script command execution done for file: {}", file);
    }

    /**
     * Runs the built-in {@code version} command.
     *
     * @param ctx the shell context of the running command
     * @throws Exception if the built-in command fails
     */
    public void vappVersion(CommandContext ctx) throws Exception {
        version.execute(ctx);

        log.info("Version command execution done.");
    }
}