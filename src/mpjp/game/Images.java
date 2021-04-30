package mpjp.game;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Images {
	static Set<String> extensions;
	static File imageDirectory;
	private final static String PATH="test/mpjp/resources";
	
	static void addExtension(String extension) {
		getExtensions().add(extension);
	}

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

	public static Set<String> getExtensions() {
		if (extensions == null) {
			extensions = new HashSet<String>();
			extensions.add("jpg");
		}

		return extensions;
	}

	public static File getImageDirectory() {
		if(imageDirectory==null) {
			imageDirectory=new File(PATH);
		}
		return imageDirectory;
	}

	public static void setImageDirectory(File imageDirectory) {
		Images.imageDirectory = imageDirectory;
	}

}
