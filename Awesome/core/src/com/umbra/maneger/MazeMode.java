package com.umbra.maneger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MazeMode implements IMode{
    private boolean beginning;
    private String initialText;
    private BufferedReader reader;
    private static String dir = MazeMode.class.getResource(".").getPath() + "/";

    @Override
    public void init() {
        try {
            reader = new BufferedReader(new FileReader("Textos/initialText.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        beginning = true;
    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void draw() {
        if(beginning){

        }else{

        }
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {

    }
}
