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

public class Manager {
	
	private WorkspacePool workspacePool; 
	private static Manager manager = new Manager(); 
	
	private Manager() {
		workspacePool = new WorkspacePool();
	}
	
	public static Manager getInstance() {
		return manager;
	}

	void reset() {
		workspacePool = new WorkspacePool(); 
	}

	public Set<String> getAvailableCuttings() {
		return new CuttingFactoryImplementation().getAvailableCuttings();
	}

	public Set<String> getAvailableImages() {
		return Images.getAvailableImages();
	}

	public Map<String,PuzzleSelectInfo> getAvailableWorkspaces(){
		return workspacePool.getAvailableWorkspaces();
	}

	public String createWorkspace(PuzzleInfo info) throws MPJPException {
		return workspacePool.createWorkspace​(info);
	}

	public Integer selectPiece(String workspaceId, Point point) throws MPJPException {
		return workspacePool.getWorkspace​(workspaceId).selectPiece(point);
	}

	public PuzzleLayout connect(String workspaceId, int pieceId, Point point) throws MPJPException {
		return workspacePool.getWorkspace​(workspaceId).connect(pieceId, point);
	}

	public PuzzleView getPuzzleView(String workspaceId) throws MPJPException {
		return workspacePool.getWorkspace​(workspaceId).getPuzzleView();
	}
	
	public PuzzleLayout getCurrentLayout(String workspaceId)throws MPJPException{
		return workspacePool.getWorkspace​(workspaceId).getCurrentLayout();
	}
}
