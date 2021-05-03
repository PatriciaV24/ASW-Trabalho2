package mpjp.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import mpjp.shared.MPJPException;
import mpjp.shared.PuzzleInfo;
import mpjp.shared.PuzzleSelectInfo;

/**
 * A pool of workspaces where jigsaw puzzles are actually solved. At any given
 * moment, different puzzles may be solved in parallel. A pool indexes
 * workspaces by their ID (Workspace.getId()), stores them both in memory, and
 * persists them on the file system using serialization. The files with wokspace
 * serialization are kept in a directory specified by the property poolDirectory
 * that can be managed using static getters and setters.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 */
public class WorkspacePool {

	static final java.lang.String SERIALIAZTION_SUFFIX = ".ser";
	private static File PoolDirectory;

	private static Map<String, Workspace> workspaces;
	private static Map<String, File> files;

	/** Constructor */
	public WorkspacePool() {
		workspaces = new HashMap<String, Workspace>();
		files = new HashMap<String, File>();
		PoolDirectory = new File(".");
	}

	public static File getPoolDirectory() {
		return PoolDirectory;
	}

	public static void setPoolDiretory​(File poolDirectory) {
		WorkspacePool.PoolDirectory = poolDirectory;
	}

	public static void setPoolDiretory​(String pathname) {
		PoolDirectory = new File(pathname);
	}

	String createWorkspace​(PuzzleInfo info) throws MPJPException {
		Workspace workspace = new Workspace(info);
		workspaces.put(workspace.getId(), workspace);
		try {
			backup​(workspace.getId(), workspace);
			return workspace.getId();
		} catch (Exception e) {
			throw new MPJPException("Not Serializable");
		}
	}

	Workspace getWorkspace​(String id) throws MPJPException {
		return workspaces.get(id);
	}

	Map<String, PuzzleSelectInfo> getAvailableWorkspaces() {
		Map<String, PuzzleSelectInfo> info = new HashMap<String, PuzzleSelectInfo>();
		for (Entry<String, Workspace> workspace : workspaces.entrySet()) {
			info.put(workspace.getKey(), workspace.getValue().getPuzzleSelectInfo());
		}
		return info;
	}

	private File CreateWorkspaceFile(String workspaceId) {
		return new File(PoolDirectory, workspaceId + SERIALIAZTION_SUFFIX);
	}

	File getFile​(String workspaceId) {
		if (!files.containsKey(workspaceId)) {
			files.put(workspaceId, CreateWorkspaceFile(workspaceId));
		}
		return files.get(workspaceId);
	}
	/**Serializes workspace*/
	void backup​(String workspaceId, Workspace workspace) throws MPJPException {
		try (FileOutputStream stream = new FileOutputStream(getFile​(workspaceId));
				ObjectOutputStream serializer = new ObjectOutputStream(stream);) {
			serializer.writeObject(workspace);
		} catch (IOException cause) {

		}
	}
	
	/**Recover a workspace form a serialization given its ID*/
	Workspace recover​(String workspaceId) throws MPJPException {
		Workspace space = null;
		try (FileInputStream stream = new FileInputStream(getFile​(workspaceId));
				ObjectInputStream deserializer = new ObjectInputStream(stream);) {
			space = (Workspace) deserializer.readObject();
			space.restore();
			workspaces.put(workspaceId, space);
		} catch (IOException | ClassNotFoundException cause) {
			System.out.println(cause);
		}

		return space;
	}

	void reset() {
		PoolDirectory = new File(".");
		workspaces = new HashMap<String, Workspace>();
	}
}
