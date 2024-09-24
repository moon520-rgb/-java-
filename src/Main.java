import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------");
        System.out.println("您现在准备和电脑开始猜拳啦!");
        System.out.println("请输入你准备和电脑玩几次猜拳:");
        Scanner scanner = new Scanner(System.in);//这个类的输入赋值给count，玩几次
        Scanner scanner1 = new Scanner(System.in);//这个赋值给玩家出的拳，每次可以改变。
        computerGuess computerGuess = new computerGuess();
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.println("请输入本轮你准备出石头(0)，剪刀(1)，还是布(2)");
            int realTom = scanner1.nextInt();
            //computerGuess computerGuess = new computerGuess();
            int realCom = computerGuess.computerNum();//前面定义了类，这里只是修改值，不用再重新定义类，浪费空间。
            System.out.println("本轮电脑出拳为:" + realCom);
            isVictory isvictory = new isVictory(realCom, realTom);
            isvictory.whoVictory();
            System.out.println("----------------");
            if (i == count - 1)
                System.out.println("游戏已经玩完啦！");
            else {
                System.out.println("本轮猜拳结束，请继续下一轮");
                System.out.println("-----------------------");
            }
        }
    }
}

class computerGuess {//电脑出拳，随即为0，1，2，并返回这个值
    int comGuessNum;

    public int computerNum() {
        Random random = new Random();//用随机类中的nextInt
        comGuessNum = random.nextInt(3);//从0,1,2三个数随机返回一个整数给变量,括号里是几，就返回0-几这个范围的一个数
        return comGuessNum;
    }
}

//0:石头 1:剪刀 2:布
class isVictory {//判定谁获胜的类，传入人和电脑各自出的什么拳。
    int comGuessNum;
    int tomGuessNum;
    String res;

    public isVictory(int comGuessNum, int tomGuessNum) {//构造方法，初始化。
        this.comGuessNum = comGuessNum;
        this.tomGuessNum = tomGuessNum;
    }

    public void whoVictory() {
        if (comGuessNum == tomGuessNum)
            System.out.println("谁也没有胜利，打成平手啦!");
        else if ((comGuessNum == 0 && tomGuessNum == 1) || (comGuessNum == 1 && tomGuessNum == 2) || (comGuessNum == 2 && tomGuessNum == 0))
            System.out.println("电脑获胜啦,您输啦!");
        else if ((comGuessNum == 0 && tomGuessNum == 2) || (comGuessNum == 1 && tomGuessNum == 0) || (comGuessNum == 2 && tomGuessNum == 1))
            System.out.println("电脑输啦，您赢啦!");
        else
            System.out.println("你出了错误的手势，请重新出");

    }
}
