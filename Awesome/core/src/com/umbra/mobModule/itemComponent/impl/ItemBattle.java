package com.umbra.mobModule.itemComponent.impl;

import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.impl.Attribute;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.interenum.Type;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.mobComponent.impl.MobManager;
import com.umbra.mobModule.mobComponent.inter.IMob;
import com.umbra.mobModule.mobComponent.inter.IMobManager;
import com.umbra.mobModule.modAttComponent.impl.ModAttCreator;
import com.umbra.mobModule.modAttComponent.inter.IModAtt;
import com.umbra.mobModule.modAttComponent.inter.IModAttManager;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

import java.util.ArrayList;
import java.util.List;


public class ItemBattle extends Item implements IItemBattle  {
    List<IModAtt> modatts;

    public ItemBattle(String name, String description, double findProb, IPosition pos){
        super(name, description, findProb, pos);
        this.modatts = new ArrayList<IModAtt>();
    }
    public ItemBattle(String name, String description, double findProb, IPosition pos, List<IModAtt> modatts){
        super(name, description, findProb, pos);
        this.modatts = modatts;
    }

    public void addModAtt(String attName, IModificator operation, double ... parameter){
        if (modatts == null) {
            modatts = new ArrayList<IModAtt>();
        }
        
        try {
        	IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
        	factory.registerPrototype(ModAttCreator.class);
        	IModAttManager modattmanager = factory.createInstance(
        				   "<http://purl.org/NET/dcc/com.umbra.mobModule.modAttComponent.impl.ModAttCreator>");
        	IModAtt novo = modattmanager.create(attName, operation, parameter);
        	modatts.add(novo);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
    }

    public void addModAtt(String attName, double parameter){
        if (modatts == null) {
            modatts = new ArrayList<IModAtt>();
        }
        
        try {
        	IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
        	factory.registerPrototype(ModAttCreator.class);
        	IModAttManager modattmanager = factory.createInstance(
        				   "<http://purl.org/NET/dcc/com.umbra.mobModule.modAttComponent.impl.ModAttCreator>");
        	IModAtt novo = modattmanager.create(attName, parameter);
        	modatts.add(novo);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
    }

    public void updateMob(IMob src) throws CannotDoubleModifyAttributeException {
        for(IModAtt modatt : modatts){
            String att_name = modatt.getName();
            if(!src.hasAtt(att_name)){
                src.setAtt(att_name, Attribute.MAX);
            }
            IAttribute update = modatt.modify(src.getAtt(modatt.getName()));
            src.setAtt(modatt.getName(), update.getValue());
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
