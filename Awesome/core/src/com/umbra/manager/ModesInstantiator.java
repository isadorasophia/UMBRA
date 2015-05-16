package com.umbra.manager;

public class ModesInstantiator {
    private static IMode uniquePuzzleMode = null, uniqueMazeMode = null, uniqueBattleMode = null, uniqueVultoMode = null;

    static IMode puzzleModeInstance(){
        if(uniquePuzzleMode == null){
            uniquePuzzleMode = new PuzzleMode();
            uniquePuzzleMode.init();
        }
        return uniquePuzzleMode;
    }
    static IMode mazeModeInstance(){
        if(uniqueMazeMode == null){
            uniqueMazeMode = new MazeMode();
            uniqueMazeMode.init();
        }
        return uniqueMazeMode;
    }
    static IMode battleModeInstance(){
        if(uniqueBattleMode == null){
            uniqueBattleMode = new BattleMode();
            uniqueBattleMode.init();
        }
        return uniqueBattleMode;
    }
    static IMode vultoModeInstance(){
        if(uniqueVultoMode == null){
            uniqueVultoMode = new VulteMode();
            uniqueVultoMode.init();
        }
        return uniqueVultoMode;
    }
    static void puzzleModeReset(){
        uniquePuzzleMode.dispose();
        uniquePuzzleMode.init();
    }
    static void mazeModeReset(){
        uniqueMazeMode.dispose();
        uniqueMazeMode.init();
    }
    static void battleModeReset(){
        uniqueBattleMode.dispose();
        uniqueBattleMode.init();
    }
    static void vultoModeReset(){
        uniqueVultoMode.dispose();
        uniqueVultoMode.init();
    }
}
