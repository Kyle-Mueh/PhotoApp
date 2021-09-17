package LTPhotoApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import LTPhotoApp.model.PhotoApiResponseItem;

/** Communicates and gathers information from api
 * 
 * @author Kyle Muehlenthaler
 *
 */
public class PhotoApiClient {
	public List<PhotoApiResponseItem> getPhotosForAlbum(int albumNumber) throws IOException {
		List<PhotoApiResponseItem> photos = new ArrayList<PhotoApiResponseItem>();

		//Uses input to query for only the requested albums
		URL url = new URL("https://jsonplaceholder.typicode.com/photos?albumId=" + albumNumber);

		// Open connection to URL
		URLConnection con = url.openConnection();

		//Set up to retrieve information from the api
		InputStream is = con.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		// Will be used to iterate through all of the lines listed in the quered URL
		while ((br.readLine()) != null && br.ready()) {
			// Uses the following line as a trigger to start search
			if (br.readLine().equals("  {")) {
				//Skipping unnecessary data line
				Scanner line = new Scanner(br.readLine());
				line.close();
				// Scan following line for the photo's id
				line = new Scanner(br.readLine());
				// Used to jump over unnecessary data
				line.next();
				// id is meant to be the photo id value listed in the line
				String id = line.next();
				line.close();
				// Parses line and removes the attached comma
				id = id.substring(0, id.length() - 1);



				// Takes the next line of data to gather title
				line = new Scanner(br.readLine());
				line.next();
				// scan following line for photo's title
				String title = line.nextLine();
				line.close();
				// Parses line and removes the attached comma and quotation marks
				title = title.substring(2, title.length() - 2);

				//each iteration makes a new Response Item
				PhotoApiResponseItem photo= new PhotoApiResponseItem();
				photo.setId(id);
				photo.setTitle(title);
				
				//Adds the filled response Item to a list
				photos.add(photo);
			}

		}
		
		//Returns list of photos' IDs and Titles
		return photos;
	}
}
