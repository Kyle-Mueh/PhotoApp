package LTPhotoApp;

import java.io.IOException;
import java.util.List;

import LTPhotoApp.model.PhotoApiResponseItem;
/**
 * Main resides here to run application
 * 
 * @author Kyle Muehlenthaler
 *
 */
public class PhotoAlbum {

	private PhotoApiClient photoApiClient;
	private UserIO userIO;

	public PhotoAlbum() {
		photoApiClient = new PhotoApiClient();
		userIO = new UserIO();
	}

	public PhotoAlbum(PhotoApiClient photoApiClient) {
		this.photoApiClient = photoApiClient;
		userIO = new UserIO();
	}

	public static void main(String[] args) throws IOException {
		
		new PhotoAlbum().run();

	}

	public void run() throws IOException {
		
		// num is meant to be the album number input from user
		int num;

		//Prompts user for an integer input
		String input=userIO.promptForInput();
		
		try {
		num = Integer.parseInt(input);
		}catch(NumberFormatException e) {
			System.out.println(input + " is not a valid number");
			return;
		}

		// Formatting for viewing which album is being viewed
		System.out.println("> photo-album " + num + "\n");


		//Creates a list of photo data sets
		List<PhotoApiResponseItem> apiResponse = photoApiClient.getPhotosForAlbum(num);

		//for Each photo in List apiResponse
		for (PhotoApiResponseItem photo : apiResponse) {
			
			//Formats and prints data in a readable manner
			System.out.println("[" + photo.getId() + "] " + photo.getTitle());
		}
	}
}
