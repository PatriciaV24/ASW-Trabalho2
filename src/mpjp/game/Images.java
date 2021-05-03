package mpjp.game;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Static methods for accessing the names of the images that may be used in
 * jigsaw puzzles. The static properties imageDirectory and extensions may be
 * used to control what images are selected.
 * 
 * @author Manuel Sá up201805273
 * @author Patricia Vieira up201805238
 **/
public class Images {
	static Set<String> extensions;
	static File imageDirectory;
	private final static String PATH = "test/mpjp/resources";
	
	/**Add an extension to the current list*/
	static void addExtension(String extension) {
		getExtensions().add(extension);
	}

	/**A set of image names that can be used in MPJP jigsaw puzzles*/
	static Set<String> getAvailableImages() {
		Set<String> images = new HashSet<String>();
		for (File x : getImageDirectory().listFiles()) {
			for (String ext : getExtensions()) {

				if (x.getName().endsWith(ext)) {
					images.add(x.getName());
				}
			}
		}
		return images;
	}

	/**Current set of valid extensions*/
	public static Set<String> getExtensions() {
		if (extensions == null) {
			extensions = new HashSet<String>();
			extensions.add("jpg");
		}

		return extensions;
	}

	/**Current image directory*/
	public static File getImageDirectory() {
		if (imageDirectory == null) {
			imageDirectory = new File(PATH);
		}
		return imageDirectory;
	}

	/**Change image directory*/
	public static void setImageDirectory(File imageDirectory) {
		Images.imageDirectory = imageDirectory;
	}

}
