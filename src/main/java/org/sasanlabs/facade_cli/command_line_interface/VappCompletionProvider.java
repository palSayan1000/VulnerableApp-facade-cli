package org.sasanlabs.facade_cli.command_line_interface;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.core.command.completion.CompletionProposal;
import org.springframework.shell.core.command.completion.CompletionProvider;

import java.util.List;

/**
 * @author Sayan Pal -> palsayan1000(GitHub ID).
 */
@Configuration(proxyBeanMethods = false)
public class VappCompletionProvider {

    /**
     * @return {@link CompletionProvider} the bean for the suggested auto-completion
     **/
    @Bean
    public CompletionProvider vappCompletion() {
        return _ -> List.of(new CompletionProposal("vapp"));
    }

}
