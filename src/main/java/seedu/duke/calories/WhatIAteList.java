package seedu.duke.calories;

import seedu.duke.ui.Ui;

import java.util.Date;

/**
 * Represents a list of what the user has eaten.
 *  This would include the date of the record and
 *      the food items consumed
 *
 * @author ngnigel99
 */
public class WhatIAteList extends ListOfRecords<foodRecord> {

    private Date dayOfRecordList;

    public WhatIAteList(Date dayOfRecordList) {
        this.dayOfRecordList = dayOfRecordList;
    }

    /**
     * Adds a food Record to a list, then notifies the user of what  item
     *  they  have entered
     *
     * @author  ngnigel99
     * @param recordToAdd record to add to list
     */
    @Override
    public void addToList(foodRecord recordToAdd) {
        super.addToList(recordToAdd);
        Ui.printAddRecord(recordToAdd);
    }

    /**
     * Prints  index with suffix for visuals
     *
     * @author ngnigel99
     * @param index
     */
    public void printIndexWithSuffix(int index) {
        String[] suffixList = {"st", "nd", "rd", "th"};
        String suffixToPrint;
        if ((index - 2) / 10 == 0) {
            suffixToPrint =  suffixList[1];
        } else if ((index - 3) / 10 == 0) {
            suffixToPrint = suffixList[2];
        } else if ((index - 4) /  10 == 0) {
            suffixToPrint = suffixList[3];
        } else {
            suffixToPrint = suffixList[0];
        }
        System.out.println(index + suffixToPrint);
    }

    /**
     * Prints food records collated in list
     * In context, for today
     *
     * @author ngnigel99
     */
    @Override
    public void printList() {
        int index = 1;  //TODO integrate this with storage so it's not a magic number
        for (foodRecord listRecord : List) {
            printIndexWithSuffix(index);
            System.out.println("You consumed  " + listRecord.getFoodName()
                                + " , which has a calorie count of : "
                                + listRecord.getCalorieCount() + "!");
            index++;
        }
    }
}
