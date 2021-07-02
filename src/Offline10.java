public class Offline10 {

    public static long noOfWays( int numberOfDices, int[] faces, int targetSum ) {

        long[][] summationTable = new long[numberOfDices + 1][targetSum + 1];

        for (int j = 1; j <= faces[0] && j <= targetSum; j++)
            summationTable[1][j] = 1;

        for (int i = 2; i <= numberOfDices; i++) {
            for (int j = 1; j <= targetSum; j++) {
                for (int k = 1; k < j && k <= faces[i - 1]; k++)
                    summationTable[i][j] += summationTable[i - 1][j - k];
            }
        }

        return summationTable[numberOfDices][targetSum];
    }


    public static int rollDice( int numberOfDices, int[] faces, int targetSum ) {

        if (numberOfDices == 0 && targetSum == 0)
            return 1;

        else if (targetSum < 0)
            return 0;

        else if (numberOfDices == 0)
            return 0;

        int result = 0;

        for (int i = 1; i <= faces[numberOfDices - 1]; i++) {
            result += rollDice(numberOfDices - 1, faces, targetSum - i);
        }

        return result;
    }
}
