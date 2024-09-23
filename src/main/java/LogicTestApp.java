import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogicTestApp {
    public static void main(String[] args) {
        String[] input = {"cook", "save", "taste", "aves", "vase", "state", "map"};

        List<List<String>> outerOutput = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            String string = input[i];
            if (outerOutput.stream().anyMatch(list -> list.contains(string))) {
                continue;
            }

            // Save every char in index 0 of input as array of chars and sort it
            char[] charArray = input[i].toCharArray();
            Arrays.sort(charArray);

            // Save to innerOutput
            List<String> innerOutput = new ArrayList<>();
            innerOutput.add(input[i]);

            for (int j = 0; j < input.length; j++) {
                if (i != j) {
                    // Save every char in index 1 of input as array of chars and sort it
                    char[] charArray2 = input[j].toCharArray();
                    Arrays.sort(charArray2);

                    // If sorted index 0 equals to sorted index 1, save to innerOutput
                    if (Arrays.equals(charArray, charArray2)) {
                        if (!innerOutput.contains(input[j])) {
                            innerOutput.add(input[j]);
                        }
                    }
                }
            }

            // Save innerOutput to outerOutput
            outerOutput.add(innerOutput);
        }

        // Print result
        System.out.println("[");
        outerOutput.forEach(list -> System.out.printf(" %s\n", list));
        System.out.println("]");
    }
}
