package com.umbra.manager.modes;

import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.TextComunicator;
import com.umbra.manager.interfaces.IMode;

public class ModesInstantiator {
    private static IMode uniquePuzzleMode = null, uniqueMazeMode = null, uniqueBattleMode = null,
            uniqueVultoMode = null, uniqueGameOverMode = null;
    private static IComunicator comunicator = new TextComunicator();

    static public IMode puzzleModeInstance(Characters characters){
        if(uniquePuzzleMode == null){
            uniquePuzzleMode = new PuzzleMode();
            uniquePuzzleMode.init(comunicator,characters);
        }
        return uniquePuzzleMode;
    }
    static public IMode mazeModeInstance(Characters characters){
        if(uniqueMazeMode == null){
            uniqueMazeMode = new MazeMode();
            uniqueMazeMode.init(comunicator,characters);
        }
        return uniqueMazeMode;
    }
    static public IMode battleModeInstance(Characters characters){
        if(uniqueBattleMode == null){
            uniqueBattleMode = new BattleMode();
            uniqueBattleMode.init(comunicator,characters);
        }
        return uniqueBattleMode;
    }
    static public IMode vultoModeInstance(Characters characters){
        if(uniqueVultoMode == null){
            uniqueVultoMode = new VulteMode();
            uniqueVultoMode.init(comunicator,characters);
        }
        return uniqueVultoMode;
    }
    static public IMode gameOverModeInstance(Characters characters){
        if(uniqueGameOverMode == null){
            uniqueGameOverMode = new GameOverMode();
            uniqueGameOverMode.init(comunicator,characters);
        }
        return uniqueGameOverMode;
    }
    static public void puzzleModeReset(Characters characters){
        uniquePuzzleMode.dispose();
        uniquePuzzleMode.init(comunicator,characters);
    }
    static public void mazeModeReset(Characters characters){
        uniqueMazeMode.dispose();
        uniqueMazeMode.init(comunicator,characters);
    }
    static public void battleModeReset(Characters characters){
        uniqueBattleMode.dispose();
        uniqueBattleMode.init(comunicator,characters);
    }
    static public void vultoModeReset(Characters characters){
        uniqueVultoMode.dispose();
        uniqueVultoMode.init(comunicator,characters);
    }
    static public void gameOverModeReset(Characters characters){
        uniqueGameOverMode.dispose();
        uniqueGameOverMode.init(comunicator,characters);
    }
}
