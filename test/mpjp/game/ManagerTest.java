package mpjp.game;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import mpjp.shared.MPJPException;
import mpjp.shared.PieceStatus;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleLayout;
import mpjp.shared.PuzzleSelectInfo;
import mpjp.shared.PuzzleView;
import mpjp.shared.geom.Point;

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
		assertEquals(manager, Manager.getInstance());
		
	}

	/**
	 * Check if a set of cuttings with is, al least one, is available.
	 */
	@Test
	void testGetAvailableCuttings() {
		Set<String> set = manager.getAvailableCuttings();
		
		assertNotNull(set,"expected a set of strings");
		
		assertTrue(set.size() > 0);
	}

	/**
	 * Check if images in test resources are available
	 */
	@Test
	void testGetAvailableImages() {
		Set<String> images = manager.getAvailableImages();

		for(String image: TEST_IMAGES)
			assertTrue(images.contains(image),
					"expected image from test resources: "+image);
	}

	/**
	 * Check if available workspace reflect those that where
	 * created so far, and map IDs to the correct type.   
	 * 
	 * @throws MPJPException if something unexpected happens
	 */
	@Test
	void testGetAvailableWorkspaces() throws MPJPException {
		Map<String, PuzzleSelectInfo> map = null;
		Set<String> keys = null;
		List<String> ids = new ArrayList<>();
		
		for(Puzzle puzzle: Puzzle.values()) {
			String id = manager.createWorkspace(puzzle.getPuzzleInfo());
			ids.add(id);
			
			map = manager.getAvailableWorkspaces();
			
			assertNotNull(map,"instance expected");
			
			keys = map.keySet();
		
			assertEquals(ids.size(),keys.size(),"Invalid size");
			assertEquals(new HashSet<>(ids),keys,"Unexpected keys");
		
			PuzzleSelectInfo info = map.get(id);
			
			assertNotNull(info,"PuzzleSelectInfo expected");
		}
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
		List<String> ids = new ArrayList<>();
		String id = manager.createWorkspace(puzzle.getPuzzleInfo());
		
		ids.add(id);
		
		assertNotNull(id,"Id expected");
		
		String filename = id+".ser";
		File file = new File(WorkspacePool.getPoolDirectory(),filename);
	
		assertTrue(file.exists(),"serialization file expected");
		
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
		Workspace workspace = new Workspace(puzzle.getPuzzleInfo());
		PuzzleLayout puzzleLayout = workspace.getCurrentLayout();
		Map<Integer, PieceStatus> pieces = puzzleLayout.getPieces();
		double radius = workspace.getSelectRadius();
		double delta = Math.sqrt(radius);
		
		for(Integer id: pieces.keySet()) {
			PieceStatus piece = pieces.get(id);
			Point point = piece.getPosition();
			Point near = new Point(
					point.getX()+getDelta(delta),
					point.getY()+getDelta(delta));
			Integer block = piece.getBlock();
			
			Integer selected = workspace.selectPiece(near);
			
			Integer selectedBlock = pieces.get(selected).getBlock();
			
			assertNotNull(selected,"Some piece selected");
			
			assertTrue(id == selected || selectedBlock > block,
					"At least a higher block expected");
		}
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
		Workspace workspace = new Workspace(puzzle.getPuzzleInfo());
		PuzzleStructure structure = workspace.getPuzzleStructure();
		PuzzleLayout puzzleLayout = workspace.getCurrentLayout();
		Map<Integer, PieceStatus> pieces = puzzleLayout.getPieces();
		int nBlocks = puzzleLayout.getBlocks().size();
		
		double pieceWidth = structure.getPieceWidth();
		
		Point p0 = pieces.get(0).getPosition();
		Point p1 = new Point(p0.getX()+pieceWidth,p0.getY());
		
		PuzzleLayout newLayout = workspace.connect(1, p1);
		
		assertTrue(newLayout.getBlocks().size()<nBlocks,"less blocks expected");
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
		PuzzleInfo info = puzzle.getPuzzleInfo();
		Workspace workspace = new Workspace(info);
		PuzzleView puzzleView = workspace.getPuzzleView();
		
		assertNotNull(puzzleView,"puzzle view expected");
		assertEquals(info.getWidth(),puzzleView.getPuzzleWidth(),"wrong width");
		assertEquals(info.getHeight(),puzzleView.getPuzzleHeight(),"wrong height");
		assertEquals(info.getImageName(),puzzleView.getImage(),"wrong image");

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
		PuzzleInfo info = puzzle.getPuzzleInfo();
		Workspace workspace = new Workspace(info);
		PuzzleLayout puzzleLayout = workspace.getCurrentLayout();
		int pieceCount = info.getRows() * info.getColumns();
		
		assertNotNull(puzzleLayout,"puzzleLayout expected");
		assertAll(
				() -> assertEquals(pieceCount,puzzleLayout.getPieces().size(),
						"unexpected #pieces"),
				() -> assertEquals(pieceCount,puzzleLayout.getBlocks().size(),
						"unexpected #blocks (initialy equal to #pieces)")
				);
	}

}
