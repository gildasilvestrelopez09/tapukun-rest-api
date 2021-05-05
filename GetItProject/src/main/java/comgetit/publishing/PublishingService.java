package comgetit.publishing;

import comgetit.publishing.dto.PublicationsDTO;
import comgetit.publishing.dto.PublishingDTO;
import comgetit.publishing.exception.PublishingTypeException;
import comgetit.user.User;
import comgetit.user.UserRepository;
import comgetit.user.exception.UserNotFoundException;
import comgetit.workarea.WorkArea;
import comgetit.workarea.WorkAreaRepository;
import comgetit.workarea.exception.WorkAreNotFoundException;
import java.util.Date;
import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishingService {

    private final PublishingRepository publishingRepository;

    private final WorkAreaRepository workAreaRepository;

    private final UserRepository userRepository;

    @Autowired
    public PublishingService(PublishingRepository publishingRepository
        , WorkAreaRepository workAreaRepository, UserRepository userRepository) {
        this.publishingRepository = publishingRepository;
        this.workAreaRepository = workAreaRepository;
        this.userRepository = userRepository;
    }

    public Publishing createPublishing(final PublishingDTO publishingDTO) {
        User user = userRepository.findById(publishingDTO.getUserId())
            .orElseThrow(UserNotFoundException::new);
        WorkArea workArea = workAreaRepository.findById(publishingDTO.getWorkAreaId())
            .orElseThrow(WorkAreNotFoundException::new);
        PublishingType publishingType = convertToTypePublishing(publishingDTO.getTypePublishing());
        Publishing publishing = new Publishing(UUID.randomUUID().getMostSignificantBits()
            , publishingType, workArea, publishingDTO.getTariff(), publishingDTO.getAddress()
            , publishingDTO.getTimeRequiredOrOffered(), publishingDTO.getDescription()
            , user, new Date());
        return publishingRepository.save(publishing);
    }

    public PublishingType convertToTypePublishing(String typePublishing) {
        try {
            return PublishingType.valueOf(typePublishing);
        } catch (IllegalArgumentException exception) {
            throw new PublishingTypeException(typePublishing);
        }
    }
    
    public List<PublicationsDTO> getAllPublications() {
        return publishingRepository.findAll().stream()
            .map(publication -> new PublicationsDTO(publication.getId(), publication.getPublishingType(), 
                                publication.getWorkArea(), publication.getTariff(),
                                publication.getAddress(), publication.getTimeRequiredOrOffered(), 
                                publication.getDescription(), publication.getUser().getId(), publication.getCreated()))
            .collect(Collectors.toList());
    }
}
