package LTPhotoApp;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import LTPhotoApp.model.PhotoApiResponseItem;
import LTPhotoApp.PhotoApiClient;

public class PhotoAppTests {

	@Test
	public void testResponseItemId() {
		PhotoApiResponseItem i= new PhotoApiResponseItem();
		i.setId("23");
		i.setTitle("Test Title");
		
		assertEquals("23", i.getId());
	}
	@Test
	public void testResponseItemTitle() {
		PhotoApiResponseItem i= new PhotoApiResponseItem();
		i.setId("23");
		i.setTitle("Test Title");
		
		assertEquals("Test Title", i.getTitle());
	}
	@Test
	public void testResponseItemTitleNull() {
		PhotoApiResponseItem i= new PhotoApiResponseItem();
		
		assertNull(i.getTitle());
	}
	@Test
	public void testResponseItemIdNull() {
		PhotoApiResponseItem i= new PhotoApiResponseItem();
		//tests id getter with no input
		assertNull(i.getId());
	}
	@Test
	public void testClientEmpty() throws IOException {
		PhotoApiClient i= new PhotoApiClient();
		//tests out of album bounds
		assertEquals(0,i.getPhotosForAlbum(0).size());
	}
	@Test
	public void testClientOver() throws IOException {
		PhotoApiClient i= new PhotoApiClient();
		//tests out of album bounds
		assertEquals(0,i.getPhotosForAlbum(99999).size());
	}
	@Test
	public void testClientFull() throws IOException {
		PhotoApiClient i= new PhotoApiClient();
		//tests out of album bounds
		assertEquals(50,i.getPhotosForAlbum(1).size());
	}

}
