package mpjp.game;

import java.util.Map;
import java.util.Set;

import mpjp.game.cuttings.CuttingFactoryImplementation;
import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleLayout;
import mpjp.shared.PuzzleSelectInfo;
import mpjp.shared.PuzzleView;
import mpjp.shared.geom.Point;

/**
 * An instance of this class is responsible for managing the workspaces and
 * solving jigsaw puzzles. The methods of this class are those needed by web
 * client thus it follows the Façade design pattern. It also follows the
 * Singleton design pattern to provide a single instance of this class to the
 * application.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
public class Manager {
	private WorkspacePool workspacePool;
	private static Manager manager = new Manager();

	/** Constructor */
	private Manager() {
		workspacePool = new WorkspacePool();
	}

	/** Constructor */
	public static Manager getInstance() {
		return manager;
	}

	/** Reset this singleton for testing purposes. */
	void reset() {
		workspacePool = new WorkspacePool();
	}

	/** A set of cutting names available to produce puzzle pieces */
	public Set<String> getAvailableCuttings() {
		return new CuttingFactoryImplementation().getAvailableCuttings();
	}

	/** A set of images available for puzzle backgrounds */
	public Set<String> getAvailableImages() {
		return Images.getAvailableImages();
	}

	/** A map of workspace IDs (int) to PuzzleSelectInfo. */
	public Map<String, PuzzleSelectInfo> getAvailableWorkspaces() {
		return workspacePool.getAvailableWorkspaces();
	}

	/**
	 * Creates a workspace with given information and returns an ID to refer to it
	 * in methods such as getPuzzleView(String), {getCurrentLayout(String),
	 * selectPiece(String, Point), and connect(String, int, Point).
	 */
	public String createWorkspace(PuzzleInfo info) throws MPJPException {
		return workspacePool.createWorkspace​(info);
	}

	/**Select a piece in the given workspace, with its "center" near the given point*/
	public Integer selectPiece(String workspaceId, Point point) throws MPJPException {
		return workspacePool.getWorkspace​(workspaceId).selectPiece(point);
	}

	/**In the workspace with the given ID, connect piece with given iD after moving its center to the given point.*/
	public PuzzleLayout connect(String workspaceId, int pieceId, Point point) throws MPJPException {
		return workspacePool.getWorkspace​(workspaceId).connect(pieceId, point);
	}
	
	/**Puzzle view of given workspace*/
	public PuzzleView getPuzzleView(String workspaceId) throws MPJPException {
		return workspacePool.getWorkspace​(workspaceId).getPuzzleView();
	}

	/**Current layout of the workspace with given ID*/
	public PuzzleLayout getCurrentLayout(String workspaceId) throws MPJPException {
		return workspacePool.getWorkspace​(workspaceId).getCurrentLayout();
	}
}
