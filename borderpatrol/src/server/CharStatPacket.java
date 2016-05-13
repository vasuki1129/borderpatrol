package server;

public class CharStatPacket {
	//Player Stat Information
	//
	//	Primary Stats
	public float PWR;
	public float WIS;
	public float STR;
	public float AGL;
	public float CHR;
	public float END;
	public float DEX;
	public float LUK;
	//	Secondary Stats
	public float health;
	public float mana;
	public float atk;
	public float will;
	public float acc;
	public float atkSpeed;
	public float charm;
	public float resist;
	public float carryWeight;
	//	Class Multipliers
	public float healthMult = 1.0f;
	public float manaMult = 1.0f;
	public float atkMult = 1.0f;
	public float willMult = 1.0f;
	public float accMult = 1.0f;
	public float atkSpeedMult = 1.0f;
	public float charmMult = 1.0f;
	public float resistMult = 1.0f;
	public float carryWeightMult = 1.0f;
	
	
	public String printStats(){
		applyStats();
		String out;
		out ="";
		out = out+"PWR: "+PWR + "\n";
		out = out+"WIS: "+WIS + "\n";
		out = out+"STR: "+STR + "\n";
		out = out+"AGL: "+AGL + "\n";
		out = out+"CHR: "+CHR + "\n";
		out = out+"END: "+END + "\n";
		out = out+"DEX: "+DEX + "\n";
		out = out+"LUK: "+LUK + "\n";
		out = out+"=========" + "\n";
		out = out+"Health: "+health + "\n";
		out = out+"Mana: "+mana + "\n";
		out = out+"Attack: "+atk + "\n";
		out = out+"Will: "+will + "\n";
		out = out+"Accuracy: "+acc + "\n";
		out = out+"Attack Speed: "+atkSpeed + "\n";
		out = out+"Charm: "+charm + "\n";
		out = out+"Resist: "+resist + "\n";
		out = out+"Carry Weight: "+carryWeight + "\n";
		out = out+"=========" + "\n";
		out = out+"Health Mult: "+healthMult + "\n";
		out = out+"Mana Mult: "+manaMult + "\n";
		out = out+"Attack Mult: "+atkMult + "\n";
		out = out+"Will Mult: "+willMult + "\n";
		out = out+"Accuracy Mult: "+accMult + "\n";
		out = out+"AS Mult: "+atkSpeedMult + "\n";
		out = out+"Charm Mult: "+charmMult + "\n";
		out = out+"Resist Mult: "+resistMult + "\n";
		out = out+"Carry Weight Mult: "+carryWeightMult + "\n";
		return out;
		
	}
	
	
	
	
	
	
	
	//multiplies and sets all character stats from base stats, items, and multipliers 
	public void applyStats(){
			//Base formulas;
			health = (END*40) * (1+(LUK/100));
			mana = (WIS*26) * (1+(LUK/100));
			atk = (STR *4) * (1+(LUK/100));
			will = (PWR*6) * (1+(LUK/100));
			acc = (DEX/100) * (1+(LUK/100));
			atkSpeed = ((AGL+DEX)/100) * (1+(LUK/100));
			charm = (CHR*2) * (1+(LUK/100));
			resist = (END/220) * (1+(LUK/100));
			carryWeight = ((PWR+STR+END)*10) * (1+(LUK/100));
			
			//Then apply the mults
			health = health*healthMult;
			mana = mana*manaMult;
			atk = atk * atkMult;
			will = will * willMult;
			acc = acc * accMult;
			atkSpeed = atkSpeed * atkSpeedMult;
			charm = charm * charmMult;
			resist = resist * resistMult;
			carryWeight = carryWeight * carryWeightMult;
			
	}
	
	
	public void defaultStats(){
		PWR = 10;
		WIS = 10;
		STR = 10;
		AGL = 10;
		CHR = 10;
		END = 10;
		DEX = 10;
		LUK = 10;
		
	}
}
