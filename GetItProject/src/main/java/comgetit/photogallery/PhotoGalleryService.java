package comgetit.photogallery;

import comgetit.photogallery.dto.PhotoGalleryDTO;
import comgetit.photogallery.dto.PhotoGalleryCreationDTO;
import comgetit.user.User;
import comgetit.user.UserRepository;
import comgetit.user.exception.UserNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PhotoGalleryService {

    private final PhotoGalleryRepository photoGalleryRepository;

    private final UserRepository userRepository;

    @Autowired
    public PhotoGalleryService(PhotoGalleryRepository photoGalleryRepository
        , UserRepository userRepository) {
        this.photoGalleryRepository = photoGalleryRepository;
        this.userRepository = userRepository;
    }

    public PhotoGallery createPhotoGallery(final PhotoGalleryCreationDTO photoGalleryCreationDTO) {
        User user = userRepository.findById(photoGalleryCreationDTO.getUserId())
            .orElseThrow(UserNotFoundException::new);
         
        PhotoGallery photoGallery = new PhotoGallery(UUID.randomUUID().getMostSignificantBits()
            ,photoGalleryCreationDTO.getDescription()
            , user, new Date(), photoGalleryCreationDTO.getImage());
        return photoGalleryRepository.save(photoGallery);
    }

    public List<PhotoGalleryDTO> getPhotosGalleryByUserId(String userId) {
   
        return photoGalleryRepository.findPhotosGalleryByUserIdOrderByCreatedDesc(userId)
            .stream().map(PhotoGalleryDTO::new)
            .collect(Collectors.toList());
    }
}
