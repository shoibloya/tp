package seedu.duke.parser.module;

import seedu.duke.exceptions.StorageException;
import seedu.duke.module.Module;

import java.util.ArrayList;

//@@author nvbinh15

/**
 * A class that deals with parsing data related to Module.
 */
public class ParserModule {

    /**
     * Formats Module to store to the storage file.
     *
     * @param module The Module to be stored.
     * @return The formatted string representation of the Module.
     */
    public static String formatModuleToStore(Module module) {
        String code = module.getCode();
        String name = module.getName();
        String expectedGrade = module.getExpectedGrade();
        int modularCredits = module.getModularCredits();
        String data = code + "|" + name + "|" + expectedGrade + "|" + modularCredits + "\n";
        return data;
    }

    /**
     * Retrieves a Module from the data in the storage file.
     *
     * @param data The formatted string representation of the Module in the storage file.
     * @return The Module to be retrieved.
     * @throws StorageException If there is something wrong with the storage file.
     */
    public static Module retrieveStoredModule(String data) throws StorageException {
        String[] tokens = data.split("\\|");
        if (tokens.length != 4) {
            throw new StorageException();
        }
        assert tokens.length == 4;
        String code = tokens[0];
        String name = tokens[1];
        String expectedGrade = tokens[2];
        int modularCredits = Integer.parseInt(tokens[3]);
        try {
            return new Module(code, name, modularCredits, expectedGrade);
        } catch (Exception e) {
            throw new StorageException();
        }
    }

    public static String formatCapInfoToStore(double currentCap, int totalMcTaken) {
        String data = currentCap + "|" + totalMcTaken + '\n';
        return data;
    }

    public static ArrayList<Double> retrieveStoredCapInfo(String data) throws StorageException {
        String[] tokens = data.split("\\|");
        if (tokens.length != 2) {
            throw new StorageException();
        }
        assert tokens.length == 2;
        ArrayList<Double> capInfo = new ArrayList();
        double cap = Double.parseDouble(tokens[0]);
        double mc = Double.parseDouble(tokens[1]);
        capInfo.add(cap);
        capInfo.add(mc);
        return capInfo;
    }
}
