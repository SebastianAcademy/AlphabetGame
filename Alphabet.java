package com.company.Alphabet;

import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Tullduvan on 2017-07-08.
 */
public class Alphabet {
    public static void main(String[] args)throws InterruptedException {
        Terminal terminal = new SwingTerminal(100, 50);
        terminal.enterPrivateMode();
        Timer timer = new Timer();
        boolean reset = true;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String welcome = "This is my alphabet game!";
        String welcome2 = "Try to write the alphabet as fast as you can.";
        String rule = "If you print one character wrong the game will end!";
        while(reset) {
            terminal.setCursorVisible(true);
            int i = 0, startx = 5, starty = 5;
            Printer forprinting = new Printer(terminal, startx, starty);
            forprinting.WriterTerminal(startx, starty, welcome);
            starty++;
            forprinting.WriterTerminal(startx, starty, welcome2);
            starty++;
            forprinting.WriterTerminal(startx, starty, rule);
            starty++;
            forprinting.WriterTerminal(startx,starty, alphabet);
            toTyping startTyping = new toTyping(startx, starty, i, alphabet, reset, terminal);
            Key key =null;
            reset = startTyping.typing(key, forprinting);
            terminal.clearScreen();
        }
        System.exit(0);
    }

}
