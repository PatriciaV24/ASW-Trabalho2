package mpjp.shared;

import java.io.Serializable;

/**
 * Information required to create a jigsaw puzzle. This class groups data that
 * needs to be redirected to different methods and classes, following a design
 * pattern known as Collecting Parameter.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 *
 */
public class PuzzleInfo implements Serializable {
	private static final long serialVersionUID = 6472018774762213505L;
	int columns;
	String cuttingName;
	double height;
	String imageName;
	int rows;
	double width;

	public PuzzleInfo() {
	}

	public PuzzleInfo(String imageName, String cuttingName, int rows, int columns, double width, double height) {
		this.columns = columns;
		this.cuttingName = cuttingName;
		this.height = height;
		this.imageName = imageName;
		this.rows = rows;
		this.width = width;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public String getCuttingName() {
		return cuttingName;
	}

	public void setCuttingName(String cuttingName) {
		this.cuttingName = cuttingName;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
}
