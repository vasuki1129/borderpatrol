package server;

import server.networking.CharStatPacket;

public class CharClass {
	
	
	String className;
	
	
	float healthMult = 1.0f;
	float manaMult = 1.0f;
	float atkMult = 1.0f;
	float willMult = 1.0f;
	float accMult = 1.0f;
	float atkSpeedMult = 1.0f;
	float charmMult = 1.0f;
	float resistMult = 1.0f;
	float carryWeightMult = 1.0f;
	
	
	
	
	public static CharClass setClass(String className){
		
		CharClass chr = new CharClass();
		
		switch(className){
		case "archer":
			chr.healthMult = 0.8f;
			chr.manaMult = 1.0f;
			chr.atkMult = 1.4f;
			chr.willMult = 1.0f;
			chr.accMult = 1.2f;
			chr.atkSpeedMult = 1.3f;
			chr.charmMult = 1.0f;
			chr.resistMult = 1.0f;
			chr.carryWeightMult = 1.0f;
			chr.className = "Archer";
			return chr;
			
		}
		return chr;
		
		
	}
	
	
	public CharStatPacket applyMult(CharStatPacket pkt){
		CharStatPacket pk = new CharStatPacket();
		pk.health = pkt.health *healthMult;
		pk.mana = pkt.mana *manaMult;
		pk.atk = pkt.atk *atkMult;
		pk.will = pkt.will *willMult;
		pk.acc = pkt.acc *accMult;
		pk.atkSpeed = pkt.atkSpeed *atkSpeedMult;
		pk.charm = pkt.charm *charmMult;
		pk.resist = pkt.resist *resistMult;
		pk.carryWeight = pkt.carryWeight *carryWeightMult;
		
		return pk;
	}
	

	
	
	
	
	
	
}
