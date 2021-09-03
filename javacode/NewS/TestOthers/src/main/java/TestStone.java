import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

public class TestStone{
    private static final int Rock = 1;
    private static final int Paper =2;
    private static final int Scissors =3;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("begin");
        boolean ip = true;
        int sout = 10;
        int randsout = 11;
        String judge = "n";
        Scanner scanner = new Scanner(System.in);
        while(ip){
            System.out.println("begin2");
            while(sout==10){
                System.out.println("请输入数字来选择石头剪刀布，按回车键确定");
                System.out.println("1，石头");
                System.out.println("2，布");
                System.out.println("3，剪刀");
                System.out.print("请输入你的选项：");
                try {
                    sout = scanner.nextInt();
                    if (sout<1||sout>3){
                        sout = 10;
                        System.out.println("输入错误，请输入0~2之间的数字");
                    }
                }catch (Exception e){
                    sout = 10;
                    System.out.println("输入错误，请输入0~2之间的数字");
                }
            }
            Choice("用户",sout);
            Thread.sleep(1000);
            randsout = new Random().nextInt(4);
            Choice("系统",randsout);
            Thread.sleep(1000);
            if (randsout == sout){
                System.out.println("双方平局，请再战！");
            }else if ((randsout - sout == 1) || (randsout - sout ==2)){
                System.out.println("系统赢得胜利！");
            }else{
                System.out.println("恭喜你赢得胜利，请再接再励！");
            }
            System.out.println("是否离开游戏,y/n?");
            judge = scanner.next();
            if (judge.equals("y")){
                System.out.println("即将退出游戏，下次再见");
                sleep(5000);
                ip = false;
            }else{
                judge = "n";
                sout = 10;
            }

        }
    }

    //递归减秒
    static void sleep(int time) throws InterruptedException {
        int stime = 0;
        if (time>0){
            if (time>1000){
                time=time-1000;
            }else{
                time=0;
            }
            if (time>=1000){
                stime = time/1000;
            }
            Thread.sleep(1000);
            System.out.println("系统将在"+stime+"s后退出！");
            sleep(time);
        }
    }

    //获取当前状态
    static void Choice(String name,int no){
        switch (no)
        {
            case Rock:
                System.out.println(name+"手势为石头");
                break;
            case Paper:
                System.out.println(name+"手势为布");
                break;
            case Scissors:
                System.out.println(name+"手势为剪刀");
                break;
        }
    }

    @Test
    public void test(){
        System.out.println("begin");
        boolean flag = true;
        while(flag){
            int ss = new Random().nextInt(4);
            System.out.println("输出的数字为"+ss);
            if (ss==3){
                flag = false;
                System.out.println("程序运行结束，最终结果为："+ss);            }
        }
    }

}
