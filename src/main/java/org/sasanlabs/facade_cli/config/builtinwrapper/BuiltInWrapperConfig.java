package org.sasanlabs.facade_cli.config.builtinwrapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.core.command.Clear;
import org.springframework.shell.core.command.CommandRegistry;
import org.springframework.shell.core.command.Script;
import org.springframework.shell.core.command.Version;
import org.springframework.shell.jline.command.History;

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
     * {@code @Lazy} is used on the registry to avoid a circular dependency, because the
     * registry itself contains the commands that depend on this bean.
     *
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
