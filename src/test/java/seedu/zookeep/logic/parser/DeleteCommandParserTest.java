package seedu.zookeep.logic.parser;

import static seedu.zookeep.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.zookeep.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.zookeep.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.zookeep.logic.commands.DeleteCommand;
import seedu.zookeep.model.animal.Id;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the DeleteCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the DeleteCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class DeleteCommandParserTest {

    private DeleteCommandParser parser = new DeleteCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertParseSuccess(parser, "1234", new DeleteCommand(new Id("1234")));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
    }
}
