package comgetit.publishing;

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

    public Publishing createPublishing(final Long userId, final PublishingDTO publishingDTO) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
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
}
