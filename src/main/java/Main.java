import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.sun.istack.internal.NotNull;
import java.util.*;



public class Main {

    public static void main(String args[]) {
        try {
            // Getting input String from user
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            scan.close();

            //Processing input String
            int[][] inputArray = processInput(input);

            //Processing output String
            System.out.println(processOutput(inputArray));

        } catch (JsonParseException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private static int[][] processInput(String str){
        String inputStr = str.replace(" ", ",");
        inputStr = "[" + inputStr + "]";
        Gson gson = new GsonBuilder().create();
        int[][] array = gson.fromJson(inputStr, int[][].class);
        Arrays.sort(array, Comparator.comparingInt(a -> a[0]));
        return array;
    }

    @NotNull
    private static String processOutput(int[][] array){
        Stack<int[]> stack = new Stack();
        stack.add(array[0]);
        for(int i = 1; i < array.length; i++) {
            int[] temp = stack.pop();
            if (temp[1] >= (array[i][0] - 1)) {
                if (temp[1] <= array[i][1]) {
                    temp[1] = array[i][1];
                }
                stack.push(temp);
            } else {
                stack.push(temp);
                stack.push(array[i]);
            }
        }
        String str = Arrays.deepToString(stack.toArray()).replace(", ", ",");
        str = str.replace("],[", "] [");
        int indexOfOpenBracket = str.indexOf("[");
        int indexOfLastBracket = str.lastIndexOf("]");
        return str.substring(indexOfOpenBracket+1, indexOfLastBracket);
    }
}
