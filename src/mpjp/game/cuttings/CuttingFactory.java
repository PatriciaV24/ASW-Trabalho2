package mpjp.game.cuttings;

import java.util.Set;

import mpjp.shared.MPJPException;

/**
 * Definition of a factory method to produce cuttings. This type must provide a
 * method that returns a Cutting given its name, and a list of available cutting
 * names. This interface is part of Factory Method design pattern.
 *
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
public interface CuttingFactory {
	Cutting createCutting(String name) throws MPJPException;
	
	Set<String> getAvailableCuttings();
}
