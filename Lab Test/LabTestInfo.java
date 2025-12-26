package LabTest;
import java.util.ArrayList;
import java.util.List;

public class LabTestInfo {

    private final ArrayList<String> testList;


    public LabTestInfo() {
        this.testList = new ArrayList<>();
    }

    /**
     * Adds the test details to the testList.
     * Constraints: testDetails contains testName and cost separated by a colon ":".
     * Example: "Complete Blood Count:450"
     *
     * @param testDetails String in format "testName:cost"
     * @throws IllegalArgumentException if format is invalid or cost is not a valid non-negative integer
     */
    public void addTestDetails(String testDetails) {
        if (testDetails == null || !testDetails.contains(":")) {
            throw new IllegalArgumentException("Invalid input. Expected format: testName:cost");
        }
        String[] parts = testDetails.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid input. Expected format: testName:cost");
        }

        String testName = parts[0].trim();
        String costStr = parts[1].trim();

        if (testName.isEmpty()) {
            throw new IllegalArgumentException("Test name cannot be empty.");
        }

        int cost;
        try {
            cost = Integer.parseInt(costStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Cost must be a valid integer.");
        }

        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative.");
        }

       
        testList.add(testName + ":" + cost);
    }

    /**
     * Filters the tests within the specified cost range (inclusive),
     * adds the test name to a List, and returns the same.
     *
     * @param minimumCost inclusive minimum cost
     * @param maximumCost inclusive maximum cost
     * @return List<String> of test names within range
     * @throws IllegalArgumentException if minimumCost > maximumCost or either is negative
     */
    public List<String> getTestsWithinGivenCostRange(int minimumCost, int maximumCost) {
        if (minimumCost < 0 || maximumCost < 0) {
            throw new IllegalArgumentException("Minimum and maximum cost must be non-negative.");
        }
        if (minimumCost > maximumCost) {
            throw new IllegalArgumentException("Minimum cost cannot be greater than maximum cost.");
        }

        List<String> result = new ArrayList<>();
        for (String entry : testList) {
            // entry is "testName:cost"
            String[] parts = entry.split(":");
            String testName = parts[0].trim();
            int cost = Integer.parseInt(parts[1].trim());

            if (cost >= minimumCost && cost <= maximumCost) {
                result.add(testName);
            }
        }
        return result;
    }
}
