package org.sasanlabs.facade_cli.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.core.command.completion.CompletionProposal;
import org.springframework.shell.core.command.completion.CompletionProvider;

import java.util.List;

/**
 * Configuration for auto-completion of the root {@code vapp} command.
 *
 * @author Sayan Pal -> palsayan1000(GitHub ID).
 */
@Configuration(proxyBeanMethods = false)
public class RootCommandCompletionProvider {

    /**
     * Referenced by name ({@code "vappCompletion"}) from
     * {@code RootCommand#vapp()} through its {@code completionProvider} attribute.
     *
     * @return {@link CompletionProvider} the bean for the suggested auto-completion
     */
    @Bean
    public CompletionProvider vappCompletion() {
        return _ -> List.of(new CompletionProposal("vapp"));
    }
}
