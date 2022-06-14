package guessnumber;

import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double randNum = 0;
        //要生成一个大于0.5的随机数，只有随机数大于0.5，循环才会退出
        while (randNum < 0.5) {
            randNum = Math.random();//生成随机数
        }

        //游戏设置
        int rangeStart = 30;
        int rangeEnd = 50;
        int guessTotal = 5;

        //游戏统计
        int totalGameCount = 0;
        int CorrectGuessCount = 0;

        //是否结束游戏
        boolean gameEnd = false;
        while (!gameEnd) {
            //生成指定范围内的随机数
            int mod = rangeEnd - rangeStart;
            if (rangeEnd < 0 || rangeStart < 0) {
                System.out.println("开始和结束必须是正数");
            }
            if (mod <= 1) {
                System.out.println("非法的数字范围：(" + rangeStart + "," + rangeEnd + ")");
            }
            int numToGuess = (int) (randNum * rangeEnd * 100);
            numToGuess = (numToGuess % mod) + rangeStart;

            numtoguess goalNum = new numtoguess();
            goalNum.numToGuess(numToGuess, rangeStart, rangeEnd);

            //剩余的猜测次数
            int leftToGuess = guessTotal;
            boolean currentGameCounted = false;
            boolean correctGuess = false;

            System.out.println("请输入您要猜测的数字，范围在(" + rangeStart + "," + rangeEnd + ")。输入-1代表结束游戏");
            while (leftToGuess > 0) {
                System.out.println("还剩" + leftToGuess + "次猜测次数。请输入本次猜测的数字");
                int guess = in.nextInt();
                if (guess < 0) {
                    gameEnd = true;
                    System.out.println("用户选择结束游戏");
                    break;
                }
                if (!currentGameCounted) {
                   // totalGameCount++;
                    currentGameCounted = true;
                }
                leftToGuess--;

                number num = new number();
                String answer = num.answer(guess, numToGuess);
                totalGameCount++;

                System.out.println(answer);
                if (answer.equals("恭喜您，答对了！") ) {
                    CorrectGuessCount++;
                    correctGuess = true;
                    gameEnd = true;
                    break;
                }
            }
            if (!correctGuess) {
                System.out.println("本次的目标数字是" + numToGuess);
            }
            System.out.println("一共猜了" + totalGameCount + "次。" + "猜对的次数为" + CorrectGuessCount + "次");
        }
    }

}
