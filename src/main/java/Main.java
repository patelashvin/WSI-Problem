import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

import java.util.*;



public class Main {

    public static void main(String args[]) {
        try {
            //Getting input String from user
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


    private static String processOutput(int[][] array){
        StringBuilder str = new StringBuilder(array.length);
        str.append("[").append(array[0][0]);
        int temp = array[0][1];
        for(int i = 1; i < array.length; i++) {
            if (temp >= (array[i][0] - 1)) {
                if (temp <= array[i][1]) {
                    temp = array[i][1];
                }
            } else {
                str.append(",").append(temp).append("] [").append(array[i][0]);
                temp = array[i][1];
            }
        }
        str.append(",").append(temp).append("]");
        return str.toString();
    }
}
