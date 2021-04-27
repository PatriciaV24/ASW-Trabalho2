package mpjp.game;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import mpjp.shared.MPJPException;

/**
* Template for a test class on Manager - YOU NEED TO IMPLEMENTS THESE TESTS!
* 
*/
class ManagerTest extends PuzzleData {
	static Manager manager;
	
	/**
	 * Get the singleton instance for tests 
	 */
	@BeforeAll
	static void firstSetUp() {
		manager = Manager.getInstance();
	}
	
	/**
	 * Reset the singleton to its previous state
	 */
	@BeforeEach
	void setUp() {
		manager.reset();
	}
	
	/**
	 * GetIntance should return always the same instance
	 */
	@RepeatedTest(value = 10)
	void testGetInstance() {
		fail();
	}

	/**
	 * Check if a set of cuttings with is, al least one, is available.
	 */
	@Test
	void testGetAvailableCuttings() {
		fail();
	}

	/**
	 * Check if images in test resources are available
	 */
	@Test
	void testGetAvailableImages() {
		fail();
	}

	/**
	 * Check if available workspace reflect those that where
	 * created so far, and map IDs to the correct type.   
	 * 
	 * @throws MPJPException if something unexpected happens
	 */
	@Test
	void testGetAvailableWorkspaces() throws MPJPException {
		fail();
	}

	/**
	 * Check if workspaces created from an info return an ID
	 * and that IDs change even after a minimal delay  
	 *  
	 * @param puzzle with data for testing
	 * @throws InterruptedException on error during sleep 
	 * @throws MPJPException if something unexpected happens
	 */
	@ParameterizedTest
	@EnumSource(Puzzle.class)
	void testCreateWorkspace(Puzzle puzzle) 
			throws InterruptedException, MPJPException {
		fail();
	}

	/**
	 * Check if piece selection using current layout.
	 * Using their locations it should retrieve either the
	 * same piece or one with a higher block id, if two or
	 * more pieces overlap
	 * 
	 * @param puzzle to test
	 * @throws MPJPException if an unexpected exception occurs
	 */
	@ParameterizedTest
	@EnumSource(Puzzle.class)
	void testSelectPiece(Puzzle puzzle) throws MPJPException {
		fail();
	}

	/**
	 * Check if placing the first piece (0) at the center raises no exception,
	 * but trying place a non existing piece does raize an exception.
	 * 
	 * @param puzzle to test
	 * @throws MPJPException if something unexpected happens
	 */
	@ParameterizedTest
	@EnumSource(Puzzle.class)
	void testConnect(Puzzle puzzle) throws MPJPException {
		fail();
	}

	/**
	 * Check if puzzle view corresponds to given puzzle info
	 * 
	 * @param puzzle to test
	 * @throws MPJPException  if unexpected exceptions occurs
	 */
	@ParameterizedTest
	@EnumSource(Puzzle.class)
	void testGetPuzzleView(Puzzle puzzle) throws MPJPException {
		fail();
	}

	/**
	 * Check if puzzle layout corresponds to given puzzle info,
	 * particularly in the number of pieces, and the initial
	 * layout should be unsolved. 
	 * 
	 * @param puzzle to test
	 * @throws MPJPException  if unexpected exceptions occurs
	 */
	@ParameterizedTest
	@EnumSource(Puzzle.class)
	void testGetCurrentLayout(Puzzle puzzle) throws MPJPException {
		fail();
	}

}
