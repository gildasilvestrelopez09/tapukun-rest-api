package comgetit.photogallery.dto;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PhotoGalleryCreationDTO {

    @NotBlank
    @Size(min = 10, max = 250)
    private String description;

    @NotNull
    private Long userId;
    
    private String image;

    public PhotoGalleryCreationDTO(@NotBlank @Size(min = 10, max = 250) String description,
        @NotNull Long userId, String image) {
        this.description = description;
        this.image = image;
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public Long getUserId() {
        return userId;
    }
    
    public String getImage() {
    	return image;
    }
}
