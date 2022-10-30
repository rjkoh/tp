package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FilterCurrModCommand;
import seedu.address.model.module.CurrModContainsKeywordsPredicate;

public class FilterCurrModCommandParserTest {

    private FilterCurrModCommandParser parser = new FilterCurrModCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FilterCurrModCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFilterTagCommand() {
        // no leading and trailing whitespaces
        FilterCurrModCommand expectedFilterCurrModCommand =
                new FilterCurrModCommand(new CurrModContainsKeywordsPredicate("Alice"));
        assertParseSuccess(parser, "Alice", expectedFilterCurrModCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n Alice \n \t", expectedFilterCurrModCommand);
    }

}