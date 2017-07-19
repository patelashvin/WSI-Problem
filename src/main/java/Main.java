import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


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
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            int upperBound = array[i][0];
            int lowerBound = array[i][1];
            int [] tempArray = new int [2];
            tempArray[0] = upperBound;

            while( i < array.length-1 && lowerBound+1 >= array[i+1][0]){

                if(lowerBound+1 == array[i+1][0]){
                    lowerBound = array[i+1][0];
                }

                if(lowerBound < array[i+1][1]){
                    lowerBound = array[i+1][1];
                }

                i++;
            }
            tempArray[1] = lowerBound;
            str.append(Arrays.toString(tempArray));
            str.append(" ");
        }
        String output = str.toString().replace(", ", ",");
        return output.substring(0,output.length()-1);
    }
}
