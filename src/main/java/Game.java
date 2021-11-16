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

public class Game {
    private final TerminalScreen screen;
    Hero hero = new Hero(0,0);
    public Game(int c,int r) throws IOException{
        Terminal terminal = new DefaultTerminalFactory().createTerminal();

        TerminalSize terminalSize = new TerminalSize(c, r);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        hero.setPosX(10);
        hero.setPosY(10);

    }
    private void draw() throws IOException{
        screen.clear();
        screen.setCharacter(hero.getPosX(), hero.getPosY(), TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }
    public void run() throws IOException{
        while(true){
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                screen.close();
            }
            if(key.getKeyType() == KeyType.EOF){
                break;
            }
        }
    }
    private void processKey(KeyStroke key){
        switch(key.getKeyType()){
            case ArrowDown:
                hero.moveDown();
                break;
            case ArrowUp:
                hero.moveUp();
                break;
            case ArrowLeft:
                hero.moveLeft();
                break;
            case ArrowRight:
                hero.moveRight();
                break;
            default:
                break;
        }
    }

    private int x = 10;
    private int y = 10;
}
