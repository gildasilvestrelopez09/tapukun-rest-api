package comgetit.photogallery.dto;
import comgetit.photogallery.PhotoGallery;
import comgetit.user.dto.UserDTO;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class PhotoGalleryDTO {
    
    @NotNull
    private Long photoGalleryId;
    
    @NotNull
    private byte[] image;

    @NotBlank
    @Size(min = 10, max = 250)
    private String description;

    private Date createdAt;

    public PhotoGalleryDTO(final PhotoGallery photoGallery) {
        this.photoGalleryId = photoGallery.getId();
        this.description = photoGallery.getDescription();
        this.image = photoGallery.getImage();
        this.createdAt = photoGallery.getCreated();
    }

    public Long getPhotoGalleryId() {
        return photoGalleryId;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    
    public byte[] getImage() {
    	return image;
    }
}
