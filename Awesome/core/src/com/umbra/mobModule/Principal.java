package com.umbra.mobModule;

import mobModule.itemComponent.*;

import java.util.Hashtable;

public class Principal {
	public static void main(String[] args) {
		Hashtable<String,IAttribute> lista = new Hashtable<String,IAttribute>();
		IAttribute forca = new mobModule.Attribute("Força", 8000),
				   hp = new Attribute("HP", 100);
		lista.put("Força", forca);
		lista.put("HP", hp);
		IInventory inv = new Inventory(5);
		IItem fosforo = new ItemIlumination("Fósforo", "Brilhante", 1, null, 8000),
			  faca = new Item("Faca", "Fuck-Yeah", 100, null);
		IItemBattle espada = new ItemBattle("Espada", "Foda", 100, null);
		espada.newModAtt(new ModAtt("Força", 10));
		
		IPlayer jogador = new Player("Player", null, lista, inv);
		jogador.getInventory().adItem(fosforo);
		jogador.getInventory().adItem(faca);
		System.out.println(jogador.getInventory().dropItem("Fósforo").getName());
		System.out.println(jogador.getInventory().dropItem("Faca").getDescription());
		
		System.out.println("\n");
		/*Teste do recem adicionado getItem()*/
		jogador.getInventory().adItem(espada);
		System.out.println(jogador.getInventory().getItem("Espada").getName());
		System.out.println(jogador.getInventory().getItem("Espada").getDescription());
		
		System.out.println("\n");
		
		/*Teste de modificação de atributo*/
		System.out.println(jogador.getAtt("Força").getValue());
		IPlayer jogadorModificado = (IPlayer) espada.updateMob(jogador);
		System.out.println(jogadorModificado.getAtt("Força").getValue());
		/*Adicionar mais itens da problema se a intensão for criar um singleton*/
		System.out.println("\n");
				
		
	}
}
