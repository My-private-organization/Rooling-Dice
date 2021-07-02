public class Offline10 {

    private static int modulus( int number ) {
        return (int) (number % (Math.pow(10, 9) + 7));
    }

    public static int rollingDiceProblemUsingDp( int diceNumber, int[] faces, int targetSum ) {

        int[][] summationTable = new int[diceNumber + 1][targetSum + 1];

        summationTable[0][0] = 1;

        for (int i = 1; i <= diceNumber; i++) {

            for (int j = i; j <= targetSum; j++) {

                summationTable[i][j] = modulus(summationTable[i][j - 1] + summationTable[i - 1][j - 1]);

                if (j > faces[i - 1])
                    summationTable[i][j] -= summationTable[i - 1][j - faces[i - 1] - 1];
            }
        }

        return modulus(summationTable[diceNumber][targetSum]);
    }


    public static int rollDiceSolutionNaive( int numberOfDices, int[] faces, int targetSum ) {

        if (numberOfDices == 0 && targetSum == 0)
            return 1;

        else if (targetSum < 0)
            return 0;

        else if (numberOfDices == 0)
            return 0;

        int result = 0;

        for (int i = 1; i <= faces[numberOfDices - 1]; i++) {
            result += rollDiceSolutionNaive(numberOfDices - 1, faces, targetSum - i);
        }

        return (int) (result % (Math.pow(10, 9) + 7));
    }
}
