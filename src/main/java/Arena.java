import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;
import java.security.Key;

public class Arena {
    private int width,height;
    private Hero hero;

    public Arena(int width, int height){
        this.height = height;
        this.width = width;
        hero = new Hero(new Position(10,10));
    }

    public void draw(TerminalScreen screen) throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    public void processKey(KeyStroke key){
        switch(key.getKeyType()){
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            default:
                break;
        }
    }

    public void moveHero(Position position) {
        while (true) {
            if (canHeroMove(position)) {
                hero.setPosition(position);
                break;
            }
            else{
                System.out.println("You can´t move there!");
                break;
            }
        }
    }



    public boolean canHeroMove(Position position){
        if(position.getX() >= 1 && position.getY() >= 1 && position.getX() <= (width - 1) && position.getY() <= (height - 1)){
            return true;
        }
        else{
            return false;
        }
    }
}
