package com.company.Alphabet;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

/**
 * Created by Tullduvan on 2017-07-08.
 */
public class Printer {
    Terminal terminal;
    public int x;
    public int y;

    public Printer(Terminal terminal, int x, int y) {
        this.terminal = terminal;
        this.x = x;
        this.y = y;
    }
    public void print(int startx, Key key){
        terminal.moveCursor(x, y);
        x++;
        terminal.putCharacter(key.getCharacter());
        terminal.moveCursor(x, y);
    }

    public void WriterTerminal (int startx, int starty, String input) {
        for (int i = 0; i < input.length(); i++) {
            terminal.moveCursor(startx, starty);
            terminal.putCharacter(input.charAt(i));
            startx++;
        }
        y = starty;
        terminal.moveCursor(x, y);
    }
}
