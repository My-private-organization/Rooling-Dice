import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main( String[] args ) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("input.txt"));

        int number = scanner.nextInt();
        int target = scanner.nextInt();

        int[] faces = new int[number];

        for (int i = 0; i < number; i++)
            faces[i] = scanner.nextInt();

        System.out.println(Offline10.rollingDiceProblemUsingDp(number, faces, target));

//        System.out.println(Offline10.rollDiceSolutionNaive(number, faces, target));
    }
}
