package com.umbra.manager.modes;

import com.umbra.manager.IComunicator;
import com.umbra.manager.TextComunicator;

public class ModesInstantiator {
    private static IMode uniquePuzzleMode = null, uniqueMazeMode = null, uniqueBattleMode = null, uniqueVultoMode = null;
    private static IComunicator comunicator = new TextComunicator();

    static public IMode puzzleModeInstance(){
        if(uniquePuzzleMode == null){
            uniquePuzzleMode = new PuzzleMode();
            uniquePuzzleMode.init(comunicator);
        }
        return uniquePuzzleMode;
    }
    static public IMode mazeModeInstance(){
        if(uniqueMazeMode == null){
            uniqueMazeMode = new MazeMode();
            uniqueMazeMode.init(comunicator);
        }
        return uniqueMazeMode;
    }
    static public IMode battleModeInstance(){
        if(uniqueBattleMode == null){
            uniqueBattleMode = new BattleMode();
            uniqueBattleMode.init(comunicator);
        }
        return uniqueBattleMode;
    }
    static public IMode vultoModeInstance(){
        if(uniqueVultoMode == null){
            uniqueVultoMode = new VulteMode();
            uniqueVultoMode.init(comunicator);
        }
        return uniqueVultoMode;
    }
    static public void puzzleModeReset(){
        uniquePuzzleMode.dispose();
        uniquePuzzleMode.init(comunicator);
    }
    static public void mazeModeReset(){
        uniqueMazeMode.dispose();
        uniqueMazeMode.init(comunicator);
    }
    static public void battleModeReset(){
        uniqueBattleMode.dispose();
        uniqueBattleMode.init(comunicator);
    }
    static public void vultoModeReset(){
        uniqueVultoMode.dispose();
        uniqueVultoMode.init(comunicator);
    }
}
