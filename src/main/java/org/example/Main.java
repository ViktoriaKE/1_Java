package org.example;

/**
 * The main class to demonstrate the usage of the {@link Container} class.
 */
public class Main {

    /**
     * The main method to run the demonstration.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a new container for floating-point numbers
        Container<Float> container = new Container<>();

        // Add floating-point numbers to the container
        container.add(9.81f);
        container.add(42.0f);
        container.add(7.25f);

        // Display the initial state of the container
        displayContainerState(container, "Initial");

        // Display the size and retrieve an element
        System.out.println("Total items in the container: " + container.size());
        System.out.println("Item at index 0: " + container.get(0));

        // Iterate through the items in the container
        System.out.println("All elements in the container:");
        for (Float item : container) {
            System.out.print(item + " ");
        }
        System.out.println();

        // Remove an item and display the updated state
        container.remove(1);
        displayContainerState(container, "After removal at index 1");

        // Display the final state of the container
        System.out.println("Size after removal: " + container.size());
        System.out.println("Final hash code: " + container.hashCode());
    }

    /**
     * Helper method to display the state of the container.
     * @param container the container to display
     * @param label the label for the state
     */
    private static void displayContainerState(Container<Float> container, String label) {
        System.out.println(label + " contents of the container: " + container);
        System.out.println(label + " hash code: " + container.hashCode());
    }
}

