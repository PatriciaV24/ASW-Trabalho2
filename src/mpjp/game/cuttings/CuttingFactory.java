package mpjp.game.cuttings;

import java.util.Set;

public interface CuttingFactory {
	Cutting createCutting(String name){
	//se nome for invalido ir para mpjp exception	
	}
	
	Set<String> getAvailableCuttings(){
		Set<String> s = new Set<String>();
		return s;
	}
}
