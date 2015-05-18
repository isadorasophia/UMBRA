package com.umbra.manager;

public class ModesInstantiator {
    private static IMode uniquePuzzleMode = null, uniqueMazeMode = null, uniqueBattleMode = null, uniqueVultoMode = null;
    private static IComunicator comunicator = new TextComunicator();

    static IMode puzzleModeInstance(){
        if(uniquePuzzleMode == null){
            uniquePuzzleMode = new PuzzleMode();
            uniquePuzzleMode.init(comunicator);
        }
        return uniquePuzzleMode;
    }
    static IMode mazeModeInstance(){
        if(uniqueMazeMode == null){
            uniqueMazeMode = new MazeMode();
            uniqueMazeMode.init(comunicator);
        }
        return uniqueMazeMode;
    }
    static IMode battleModeInstance(){
        if(uniqueBattleMode == null){
            uniqueBattleMode = new BattleMode();
            uniqueBattleMode.init(comunicator);
        }
        return uniqueBattleMode;
    }
    static IMode vultoModeInstance(){
        if(uniqueVultoMode == null){
            uniqueVultoMode = new VulteMode();
            uniqueVultoMode.init(comunicator);
        }
        return uniqueVultoMode;
    }
    static void puzzleModeReset(){
        uniquePuzzleMode.dispose();
        uniquePuzzleMode.init(comunicator);
    }
    static void mazeModeReset(){
        uniqueMazeMode.dispose();
        uniqueMazeMode.init(comunicator);
    }
    static void battleModeReset(){
        uniqueBattleMode.dispose();
        uniqueBattleMode.init(comunicator);
    }
    static void vultoModeReset(){
        uniqueVultoMode.dispose();
        uniqueVultoMode.init(comunicator);
    }
}
