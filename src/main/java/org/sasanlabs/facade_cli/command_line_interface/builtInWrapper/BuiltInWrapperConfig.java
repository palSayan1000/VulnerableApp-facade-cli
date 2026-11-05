package org.sasanlabs.facade_cli.command_line_interface.builtInWrapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.jline.command.History;
import org.springframework.shell.core.command.*;

/**
 * Registers Spring Shell's built-in commands as beans so they can be injected into
 * the vapp wrapper commands.
 *
 * @author Sayan Pal -> palsayan1000(GitHub ID).
 */
@Configuration(proxyBeanMethods = false)
public class BuiltInWrapperConfig {

    /**
     * @return the built-in {@link Clear} command bean
     */
    @Bean
    public Clear vappClearBean() {
        return new Clear();
    }

    /**
     * @param commandRegistry the registry {@link Script} uses to look up and run the
     *                        commands listed in a script file
     * @return the built-in {@link Script} command bean
     */
    @Bean
    public Script vappScriptBean(@Lazy CommandRegistry commandRegistry) {
        return new Script(commandRegistry);
    }

    /**
     * @param jLineHistory the JLine line-reader history that {@link History} reads
     *                     previously run commands from
     * @return the built-in {@link History} command bean
     */
    @Bean
    public History vappHistoryBean(org.jline.reader.History jLineHistory) {
        return new History(jLineHistory);
    }

    /**
     * @return the built-in {@link Version} command bean
     */
    @Bean
    public Version vappVersionBean() {
        return new Version();
    }
}
