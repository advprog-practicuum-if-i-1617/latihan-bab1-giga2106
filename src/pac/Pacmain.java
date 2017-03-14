package pac;
import java.util.Scanner;
public class Pacmain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PAC p1 = new PAC();
        String[][] obj = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i==0 || i==9) {
                    obj[i][j]= "#";
                }
                else if (j==0 || j==9) {
                    obj[i][j]= "#";
                }
                else if ((i==2||i==7) && (j!=1&&j!=8)){
                    obj[i][j]="#";
                }
                else if (i==4 && (j!=1&&j!=3&&j!=8)){
                    obj[i][j]="#";
                }
                else if ((i==5||i==6)&&(j==7||j==2)) {
                    obj[i][j]="#";
                }
                else if (i==3 && (j>2&&j<9)) {
                    obj[i][j]="@";
                }
                else {
                    obj[i][j]=" ";
                }
            }
        }
        obj [3][2] = "#";
        obj [4][3] = "@";
        obj[5][3] = "@";
        obj[5][4] = "@";
        obj[5][5] = "@";
        obj[5][6] = "O";
        p1.setMove(20);
        p1.setFood(10);
        while (p1.getMove() > 0 && p1.getScore()<10){
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(obj[i][j]);
                }
                System.out.println("");
            }
            System.out.println("X = " + p1.getX() + "Y = " + p1.getY());
            System.out.println("Step Left = " + p1.getMove());
            System.out.println("Score = " + p1.getScore());

            System.out.print("enter move w,a,s,d,q(for quit game) >> ");
            String button = in.nextLine();
            if (button.equalsIgnoreCase("w")) {
                if (obj[p1.getY() - 1][p1.getX()].equals(" ")) {
                    obj[p1.getY()][p1.getX()] = " ";
                    obj[p1.getY() - 1][p1.getX()] = "v";
                    p1.goUp();
                } else if (obj[p1.getY() - 1][p1.getX()].equals("@")) {
                    obj[p1.getY()][p1.getX()] = " ";
                    obj[p1.getY() - 1][p1.getX()] = "v";
                    p1.goUp();
                    p1.eat();
                } else if (obj[p1.getY() - 1][p1.getX()].equals("#")) {
                    continue;
                }
            } else if (button.equalsIgnoreCase("s")) {
                if (obj[p1.getY() + 1][p1.getX()].equals(" ")) {
                    obj[p1.getY()][p1.getX()] = " ";
                    obj[p1.getY() + 1][p1.getX()] = "^";
                    p1.goDown();
                } else if (obj[p1.getY() + 1][p1.getX()].equals("@")) {
                    obj[p1.getY()][p1.getX()] = " ";
                    obj[p1.getY() + 1][p1.getX()] = "^";
                    p1.goDown();
                    p1.eat();
                } else if (obj[p1.getY() + 1][p1.getX()].equals("#")) {
                    continue;
                }
            } else if (button.equalsIgnoreCase("a")) {
                if (obj[p1.getY()][p1.getX() - 1].equals(" ")) {
                    obj[p1.getY()][p1.getX() - 1] = ">";
                    obj[p1.getY()][p1.getX()] = " ";
                    p1.goLeft();
                } else if (obj[p1.getY()][p1.getX() - 1].equals("@")) {
                    obj[p1.getY()][p1.getX() - 1] = ">";
                    obj[p1.getY()][p1.getX()] = " ";
                    p1.goLeft();
                    p1.eat();
                } else if (obj[p1.getY()][p1.getX() - 1].equals("#")) {
                    continue;
                }
            } else if (button.equalsIgnoreCase("d")) {
                if (obj[p1.getY()][p1.getX() + 1].equals(" ")) {
                    obj[p1.getY()][p1.getX()] = " ";
                    obj[p1.getY()][p1.getX() + 1] = "<";
                    p1.goRight();
                } else if (obj[p1.getY()][p1.getX() + 1].equals("@")) {
                    obj[p1.getY()][p1.getX()] = " ";
                    obj[p1.getY()][p1.getX() + 1] = "<";
                    p1.goRight();
                    p1.eat();
                } else if (obj[p1.getY()][p1.getX() + 1].equals("#")) {
                    continue;
                }
            } else if (button.equalsIgnoreCase("q")){
                break;
            }
            else {
                continue;
            }
            System.out.println("----------------------");
        } 
        if (p1.getScore()==10) {
            System.out.println("******YOU WIN******");
        }
        else {
            System.out.println("______YOU LOSE______");
        }
    }
}
