package seedu.duke.parser.module;

import seedu.duke.exceptions.StorageException;
import seedu.duke.module.Module;

public class ParserModule {

    public static String formatModuleToStore(Module module) {
        String code = module.getCode();
        String name = module.getName();
        String expectedGrade = module.getExpectedGrade();
        String data = code + "|" + name + "|" + expectedGrade + "\n";
        return data;
    }

    public static Module retrieveStoredModule(String data) throws StorageException {
        String[] tokens = data.split("\\|");
        assert tokens.length == 3;
        String code = tokens[0];
        String name = tokens[1];
        String expectedGrade = tokens[2];
        try {
            return new Module(code, name, expectedGrade);
        } catch (Exception e) {
            throw new StorageException();
        }
    }
}
