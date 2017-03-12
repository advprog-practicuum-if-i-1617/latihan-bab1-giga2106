package pac;

public class PAC {
    private int score;
    private int move ;
    private int food ;
    private int x =6,y=5;
    public void goUp (){
        y--;
        move--;
    }
    public void goDown (){
        y++;
        move--;
    }
    public void goRight (){
        x++;
        move--;
    }
    public void goLeft (){
        x--;
        move--;
    }
    public int getX (){
        return x;
    }
    public  int getY(){
        return y;
    }
    public void setMove (int m){
        move=m;
    }
    public void setFood (int f){
        food=f;
    }
    
    public void eat (){
        score++;
        
    }
    public int getMove (){
        return move;
    }
    public  int getScore(){
        return score;
    }
    
}
