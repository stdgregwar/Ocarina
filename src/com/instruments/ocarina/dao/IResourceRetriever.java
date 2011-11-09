package com.instruments.ocarina.dao;

import java.io.File;

import android.net.Uri;

public interface IResourceRetriever {

	/**
	 * Method to get resource from multiple possible locations and cache it
	 * locally.
	 * 
	 * @param resource
	 *            Uri that describes the resource and location to to cached.
	 * @return File object containing the path to the cached file.
	 */
	public abstract File getResource(Uri resource);

}