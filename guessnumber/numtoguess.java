package guessnumber;

public class numtoguess {
    public int numToGuess(int numToGuess, int rangeStart, int rangeEnd) {
        if (numToGuess <= rangeStart) {
            numToGuess = rangeStart + 1;
        }

        if (numToGuess > rangeEnd) {
            numToGuess = rangeEnd - 1;
        }

        return numToGuess;
    }
}
