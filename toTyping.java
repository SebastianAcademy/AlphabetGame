package com.company.Alphabet;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Tullduvan on 2017-07-08.
 */
public class toTyping {
    public int startx;
    public int starty;
    public int i;
    public String alphabet;
    public Terminal terminal;

    public toTyping(int startx, int starty, int i, String alphabet, Terminal terminal) {
        this.startx = startx;
        this.starty = starty;
        this.i = i;
        this.alphabet = alphabet;
        this.terminal = terminal;
    }

    public void typing (Key key, Printer forprinting)throws InterruptedException{

                while (true) {
                    key = waitPressKey(key, terminal);
                    if (key.getCharacter() == alphabet.charAt(this.i)) {
                        forprinting.print(startx, key);
                    } else {
                        starty++;
                        break;
                    }
                    this.i++;
                    if (i == alphabet.length()) {
                        starty++;
                        forprinting.WriterTerminal(startx, starty, "Great, your time is: ");
                        key = waitPressKey(key, terminal);
                        if (key.getKind() == Key.Kind.Escape)
                            System.exit(0);
                    }

                }
                forprinting.WriterTerminal(startx, starty, "Sorry, you failed!");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }

    public static Key waitPressKey (Key key, Terminal terminal)throws InterruptedException{
        do {
            Thread.sleep(5);
            key = terminal.readInput();
        }
        while (key == null);

        return key;
    }
}
