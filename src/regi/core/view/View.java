package regi.core.view;

public interface View {
    /**
     * Starts the main loop of the view interface. This method continuously prepares
     * the view, retrieves an operation, and prompts the user for input. If the user
     * input is not "y" (case-insensitive), the application will exit.
     */
    default void start() {
        while (true) {
            prepare();
            getOperation();
            String operation = prompt();
            if (!operation.equalsIgnoreCase("y")) {
                System.exit(0);
            }
        }
    }
    void prepare();
    String prompt();
    void getOperation();

    String getName();
    String getBirthdate();

    String getAge();


}