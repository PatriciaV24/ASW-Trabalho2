package mpjp.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleSelectInfo;

public class WorkspacePool {
	static final String SERIALIAZTION_SUFFIX = ".ser";
	private static File path;
	private Map<String, PuzzleSelectInfo> availableWorkspaces;

	public WorkspacePool() {
		super();
		this.availableWorkspaces = new HashMap<String, PuzzleSelectInfo>();
	}

	void backup(String workspaceId, Workspace workspace) {
		try {
			FileOutputStream fileOut =
			         new FileOutputStream(workspace.getId()+SERIALIAZTION_SUFFIX);
			 ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(workspace);
	         out.close();
	         fileOut.close();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	String createWorkspace(PuzzleInfo info) {
		Workspace workspace;
		try {
			workspace = new Workspace(info);
			FileOutputStream fileOut =
			         new FileOutputStream(workspace.getId()+SERIALIAZTION_SUFFIX);
			 ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(workspace);
	         out.close();
	         fileOut.close();
	         return workspace.getId();
		} catch (IOException | MPJPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	Map<String, PuzzleSelectInfo> getAvailableWorkspaces() {
		return this.availableWorkspaces;
	}

	File getFile(String id) {
		for (File x : getPoolDirectory().listFiles()) {
			if (x.getName().startsWith(id)) {
				return x;
			}
		}
		return null;
	}

	static File getPoolDirectory() {
		return path;
	}

	Workspace recover(String workspaceId) {
		Workspace workspace = null;
		if(getPoolDirectory().canRead()){
			try(
				FileInputStream stream = new FileInputStream(getPoolDirectory());
				ObjectInputStream deserializer = new ObjectInputStream(stream);
					){
				workspace = (Workspace) deserializer.readObject();
					} catch(IOException | ClassNotFoundException cause){
						cause.printStackTrace();
						}
		}
		
		//else {
		//	workspace = new Workspace();
		//			}
		return workspace;
	}

	void reset() {
		this.availableWorkspaces = null;
	}

	static void setPoolDirectory(File PoolDirectory) {
		WorkspacePool.path = PoolDirectory;

	}

	static void setPoolDirectory(String pathname) {
		File nPath = new File(pathname);
		WorkspacePool.path = nPath;
	}
}
