package mpjp.game.cuttings;

import java.util.HashSet;
import java.util.Set;

import mpjp.shared.MPJPException;

public class CuttingFactoryImplementation implements CuttingFactory{
	
	public CuttingFactoryImplementation() {
		super();
	}

	@Override
	public Cutting createCutting(String name) throws MPJPException {
		Cutting c = null;
		switch (name) {
			case "Round":	
				c = new RoundCutting();
				break;
				
			case "Standard":
				c = new StandardCutting();
				break;
				
			case "Straight":
				c = new StraightCutting();
				break;
				
			case "Triangular":
				c = new TriangularCutting();
				break;
		}
		return c;
	}

	@Override
	public Set<String> getAvailableCuttings() {
		Set<String> cuts = new HashSet<String>();
		cuts.add("Round");
		cuts.add("Standard");
		cuts.add("Straight");
		cuts.add("Triangular");
		return cuts;
	}
	
}
