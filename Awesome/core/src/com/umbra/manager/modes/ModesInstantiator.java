package com.umbra.manager.modes;

import anima.context.exception.ContextException;
import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;
import anima.factory.exception.FactoryException;
import com.umbra.battleModule.BattleManager;
import com.umbra.battleModule.IBattleManager;
import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IMapModeComponent;
import com.umbra.manager.interfaces.IBattleModeComponent;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.TextComunicator;
import com.umbra.manager.interfaces.IMode;
import com.umbra.mapModule.IMap;
import com.umbra.mapModule.Map;

public class ModesInstantiator {

    private static IMode uniquePuzzleMode = null, uniqueVultoMode = null,
            uniqueGameOverMode = null, uniqueInicialMode = null;
    private static IMapModeComponent uniqueMazeMode = null;
    private static IBattleModeComponent uniqueBattleMode = null;
    private static IGlobalFactory factory = null;
    private static IComunicator comunicator = new TextComunicator();

    static public void init(){
        try {
            factory = ComponentContextFactory.createGlobalFactory();
        } catch (ContextException e) {
            e.printStackTrace();
        } catch (FactoryException e) {
            e.printStackTrace();
        }
    }

    static public IMode inicialModeInstance(Characters characters){
        if(uniqueInicialMode == null){
            factory.registerPrototype(InitialMode.class);
            uniqueInicialMode = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.manager.modes.InicialMode>");
            uniqueInicialMode.init(comunicator,characters);
        }
        return uniqueInicialMode;
    }

    static public IMode puzzleModeInstance(Characters characters){
        if(uniquePuzzleMode == null){
            factory.registerPrototype(PuzzleMode.class);
            uniquePuzzleMode = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.manager.modes.PuzzleMode>");
            uniquePuzzleMode.init(comunicator,characters);
        }
        return uniquePuzzleMode;
    }

    static public IMode mazeModeInstance(Characters characters){
        if(uniqueMazeMode == null){
            factory.registerPrototype(MazeMode.class);
            uniqueMazeMode = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.manager.modes.MazeMode>");
            factory.registerPrototype(Map.class);
            IMap map = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.mapModule.Map>");
            uniqueMazeMode.connect(map);
            uniqueMazeMode.init(comunicator,characters);
        }
        return uniqueMazeMode;
    }

    static public IMode battleModeInstance(Characters characters){
        if(uniqueBattleMode == null){
            factory.registerPrototype(BattleMode.class);
            uniqueBattleMode = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.manager.modes.BattleMode>");
            factory.registerPrototype(BattleManager.class);
            IBattleManager bm = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.battleModule.BattleManager>");
            uniqueBattleMode.connect(bm);
            uniqueBattleMode.init(comunicator,characters);
        }
        return uniqueBattleMode;
    }

    static public IMode vultoModeInstance(Characters characters){
        if(uniqueVultoMode == null){
            factory.registerPrototype(VulteMode.class);
            uniqueVultoMode = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.manager.modes.VulteMode>");
            uniqueVultoMode.init(comunicator,characters);
        }
        return uniqueVultoMode;
    }

    static public IMode gameOverModeInstance(Characters characters){
        if(uniqueGameOverMode == null){
            factory.registerPrototype(GameOverMode.class);
            uniqueGameOverMode = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.manager.modes.GameOverMode>");
            uniqueGameOverMode.init(comunicator,characters);
        }
        return uniqueGameOverMode;
    }

    static public void inicialModeReset(Characters characters){
        uniqueInicialMode.dispose();
        uniqueInicialMode.init(comunicator,characters);
    }

    static public void puzzleModeReset(Characters characters){
        uniquePuzzleMode.dispose();
        uniquePuzzleMode.init(comunicator,characters);
    }

    static public void mazeModeReset(Characters characters){
        uniqueMazeMode.dispose();
        IMap map = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.mapModule.Map>");
        uniqueMazeMode.connect(map);
        uniqueMazeMode.init(comunicator,characters);
    }

    static public void battleModeReset(Characters characters){
        uniqueBattleMode.dispose();
        IBattleManager bm = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.battleModule.BattleManager>");
        uniqueBattleMode.connect(bm);
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
