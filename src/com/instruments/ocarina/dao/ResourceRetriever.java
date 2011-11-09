package com.instruments.ocarina.dao;

import java.io.*;

import android.content.ContentResolver;
import android.net.Uri;

public class ResourceRetriever implements IResourceRetriever {
	private Uri cacheDirectory; // local location to cache files.
	private ContentResolver resolver;

	/**
	 * Constructor for class.
	 * 
	 * @param cacheDir
	 *            File object that should contain the directory to use for
	 *            cache. Usually gotten with getCacheDir() of app context.
	 * @param resolve
	 *            ContentResolver passed from main Activity that allows resource
	 *            retrieval.
	 */
	public ResourceRetriever(File cacheDir, ContentResolver resolve) {
		cacheDirectory = Uri.parse("file://" + cacheDir.getAbsolutePath());
		resolver = resolve;
	}

	/* (non-Javadoc)
	 * @see com.instruments.ocarina.dao.IResourceRetriever#getResource(android.net.Uri)
	 */
	@Override
	public File getResource(Uri resource) {
		File cachedResource = null;
		if (resource.getScheme() == "file") {
			//check for cache file existence and use cached copy.
			if ((new File(cacheDirectory.getPath() + File.pathSeparator
					+ (new File(resource.getPath())).getName())).exists()) {
				cachedResource = new File(cacheDirectory.getPath()
						+ File.pathSeparator
						+ (new File(resource.getPath())).getName());
			} 
			//byte copy source to cache file.
			else {
				cachedResource = new File(cacheDirectory.getPath()
						+ File.pathSeparator
						+ (new File(resource.getPath())).getName());
				try {
					//open source file as inputstream and copy to cache file.
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
		} else if (resource.getScheme() == "android.resource") {
			//check for cache file existence and use cached copy.
			if (new File(cacheDirectory.getPath() + File.pathSeparator
					+ resource.getLastPathSegment()).exists()) {
				cachedResource = new File(cacheDirectory.getPath()
						+ File.pathSeparator + resource.getLastPathSegment());
			} 
			//byte copy source to cache file.
			else {
				cachedResource = new File(cacheDirectory.getPath()
						+ File.pathSeparator + resource.getLastPathSegment());
				try {
					//resolve built-in resource to inputstream to allow copying to cache.
					copyFile(resolver.openInputStream(resource),
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
