package LTPhotoApp.model;

import java.util.List;
/** Keeps a list of api responses
 * 
 * @author Kyle Muehlenthaler
 *
 */
public class PhotoApiResponse {
	private List<PhotoApiResponseItem> photos;
	
	public List<PhotoApiResponseItem> getPhotos(){
		return photos;
	}
	public void setPhotos(List<PhotoApiResponseItem> photos) {
		this.photos=photos;
	}
}
