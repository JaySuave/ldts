
public class Hero {
    int posX,posY;
    public Hero(int x,int y){
        posX = x;
        posY = y;
    }
    public int getPosX(){
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void moveUp(){
        this.posY -= 1;
    }

    public void moveDown(){
        this.posY += 1;
    }

    public void moveRight(){
        this.posX += 1;
    }

    public void moveLeft(){
        this.posX -= 1;
    }
}
