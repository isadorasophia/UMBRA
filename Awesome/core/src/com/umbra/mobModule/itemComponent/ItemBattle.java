package com.umbra.mobModule.itemComponent;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.Exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.Exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.Type;
import com.umbra.mobModule.attComponent.IAttribute;
import com.umbra.mobModule.mobComponent.IMob;
import com.umbra.mobModule.modAttComponent.IModAtt;
import com.umbra.mobModule.modAttComponent.IModificator;
import com.umbra.mobModule.modAttComponent.ModAttCreator;

import java.util.ArrayList;
import java.util.List;


public class ItemBattle extends Item implements IItemBattle  {
    List<IModAtt> modatts;

    public ItemBattle(String name, String description, double findProb, IPosition pos){
        super(name, description, findProb, pos);
        this.modatts = null;
    }
    public ItemBattle(String name, String description, double findProb, IPosition pos, List<IModAtt> modatts){
        super(name, description, findProb, pos);
        this.modatts = modatts;
    }

    public void addModAtt(String attName, IModificator operation, double ... parameter){
        if(modatts == null){
            modatts = new ArrayList<>();
        }
        modatts.add(ModAttCreator.create(attName, operation, parameter));
    }

    public void addModAtt(String attName, double parameter){
        if(modatts == null){
            modatts = new ArrayList<>();
        }
        modatts.add(ModAttCreator.create(attName, parameter));
    }

    public void updateMob(IMob src) throws CannotDoubleModifyAttributeException {
        for(IModAtt modatt : modatts){
            if(src.hasAtt(modatt.getName())){
                IAttribute update = modatt.modify(src.getAtt(modatt.getName()));
                src.setAtt(modatt.getName(), update.getValue());
            }
        }
    }
    public void unupdateMob(IMob src) throws CannotUnmodifyWhatHasNotBeenModifiedException {
        for (IModAtt modatt : modatts) {
            if (src.hasAtt(modatt.getName())) {
                IAttribute update = modatt.unmodify();
                src.setAtt(modatt.getName(), update.getValue());
            }
        }
    }

    public Type getType(){
        return Type.ITEM_BATTLE;
    }
}
