package guessnumber;

public class number {
    //判断用户猜的数对不对
    public String answer(int guess, int numToGuess) {
        if (guess> numToGuess) {
            return "输入的数字比目标数字大,请重新输入数字：";
        }

        if (guess < numToGuess) {
            return "输入的数字比目标数字小,请重新输入数字：";
        }
        return "答对了！";
    }
}