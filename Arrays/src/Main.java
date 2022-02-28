import java.util.Arrays;

public class Main {

    public static int[] addInt(int[] array, int add) {
        // Adds specified value to the end of the array
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = add;
        return array;
    }

    public static int[] popInt(int[] array) {
        // Removes the last index of the array
        return Arrays.copyOf(array, array.length - 1);
    }

    public static int[] insertInt(int[] array, int value, int index) {
        // Copies the array to a new array called arrayPaste with one extra index then adds specified value in chosen index
        int[] arrayPaste = Arrays.copyOf(array, array.length + 1);
        for (int i = 0; i < arrayPaste.length; i++) {
            if (i == index) {
                for (int a = arrayPaste.length - 2, b = 1; a >= i; a--, b++) {
                    arrayPaste[arrayPaste.length - b] = arrayPaste[a];
                }
                arrayPaste[i] = value;
                break;
            }
        }
        return arrayPaste;
    }

    // Trying out the static methods
    public static void main(String[] args) {
        int[] array = {2, 3, 5};

        // Add a value to the end of an array
        System.out.println(Arrays.toString(addInt(array, 6)));

        // Removing a value at the end of the array
        System.out.println(Arrays.toString(popInt(array)));

        // Adding a value at index 2 of an array
        System.out.println(Arrays.toString(insertInt(array, 4, 2)));
    }
}