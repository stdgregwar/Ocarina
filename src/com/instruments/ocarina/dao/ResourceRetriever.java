package com.instruments.ocarina.dao;

import java.io.*;

import android.content.ContentResolver;
import android.net.Uri;

public class ResourceRetriever {
	private Uri cacheDirectory; //local location to cache files.
	private ContentResolver resolver;

	/**
	 * Constructor for class.
	 * 
	 * @param cacheDir
	 *            File object that should contain the directory to use for
	 *            cache. Usually gotten with getCacheDir() of app context.
	 * @param resolve ContentResolver passed from main Activity that allows resource retrieval.
	 */
	public ResourceRetriever(File cacheDir, ContentResolver resolve) {
		cacheDirectory = Uri.parse("file://" + cacheDir.getAbsolutePath());
		resolver=resolve;
	}

	/**
	 * Method to get resource from multiple possible locations and cache it
	 * locally.
	 * 
	 * @param resource
	 *            Uri that describes the resource and location to to cached.
	 * @return File object containing the path to the cached file.
	 */
	public File getResource(Uri resource) {
		File cachedResource = null;
		if (resource.getScheme() == "file") {
			if ((new File(cacheDirectory.getPath() + File.pathSeparator
					+ (new File(resource.getPath())).getName())).exists()) {
				cachedResource = new File(cacheDirectory.getPath()
						+ File.pathSeparator
						+ (new File(resource.getPath())).getName());
			} else {
				cachedResource = new File(cacheDirectory.getPath()
						+ File.pathSeparator
						+ (new File(resource.getPath())).getName());
				try {
					copyFile(new FileInputStream(new File(resource.getPath())),
							new FileOutputStream(cachedResource));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (resource.getScheme() == "android.resource") {
			if (new File(cacheDirectory.getPath() + File.pathSeparator
					+ resource.getLastPathSegment()).exists()) {
				cachedResource = new File(cacheDirectory.getPath()
						+ File.pathSeparator
						+ resource.getLastPathSegment());
			} else {
				cachedResource = new File(cacheDirectory.getPath()
						+ File.pathSeparator
						+ resource.getLastPathSegment());
				try {
					copyFile(resolver.openInputStream(resource),new FileOutputStream(cachedResource));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// TODO:Add support for other Schemes like http.
		return cachedResource;
	}

	/**
	 * Method to byte copy one stream to another (particularly to be used for
	 * files).
	 * 
	 * @param in
	 *            InputStream object containing the input file data.
	 * @param out
	 *            OutputStream object to write file data to.
	 * @throws IOException
	 *             Exception to throw when unable to read/write data.
	 */
	private void copyFile(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[1024];
		int read;
		while ((read = in.read(buffer)) != -1) {
			out.write(buffer, 0, read);
		}
	}

}
