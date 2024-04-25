package dev.rfonseca85.adaptavistcli;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

/**
 * This class implements the PromptProvider interface and is used to customize
 * the command line prompt in the shell.
 * It sets the prompt to "adaptavist-cli:>" with a blue foreground color.
 * 
 * @author Rafael Fonseca
 * @since 2024-04-24
 */
@Component
public class ClidemoPromptProvider implements PromptProvider {

  @Override
  public AttributedString getPrompt() {
    return new AttributedString("adaptavist-cli:>",
        AttributedStyle.DEFAULT.foreground(AttributedStyle.BLUE));
  }
}