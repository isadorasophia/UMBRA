package com.umbra;

import anima.context.exception.ContextException;
import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;
import anima.factory.exception.FactoryException;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.umbra.manager.Selector;
import com.umbra.manager.interfaces.ISelectorComponent;
import com.umbra.manager.modes.ModesInstantiator;
import com.umbra.mobModule.mobComponent.impl.MobManager;
import com.umbra.mobModule.mobComponent.inter.IMobManager;
import com.umbra.vultoModule.IVulto;
import com.umbra.vultoModule.Vulto;

public class Umbra extends ApplicationAdapter {

	ISelectorComponent selector;

	@Override
	public void create () {
		IGlobalFactory factory = null;
		try {
			factory = ComponentContextFactory.createGlobalFactory();
		} catch (ContextException e) {
			e.printStackTrace();
		} catch (FactoryException e) {
			e.printStackTrace();
		}

		factory.registerPrototype(MobManager.class);
        IMobManager mobManeger = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.mobModule.mobComponent.impl.MobManager>");
		factory.registerPrototype(Vulto.class);
		IVulto vulto = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.vultoModule.Vulto>");
		factory.registerPrototype(Selector.class);
		selector = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.manager.Selector>");
		selector.connect(vulto);
		selector.connect(mobManeger);
		selector.init();
	}

	@Override
	public void render () {
		if(selector.update(Gdx.graphics.getDeltaTime())){
			selector.dispose();
			create();
			ModesInstantiator.deletAll();
			selector.init();
		} else
			selector.draw();
	}

	public void dispose (){
		selector.dispose();
	}

}
