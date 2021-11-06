package seedu.duke.exceptions.journal;

import seedu.duke.exceptions.ClickException;

public class NotebookNotFoundForEntry extends ClickException {
    public NotebookNotFoundForEntry() {
        super("Notebook hasn't been created yet!");
    }
}
