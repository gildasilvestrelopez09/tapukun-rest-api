package comgetit.publishing;

import comgetit.publishing.dto.PublishingDTO;
import comgetit.publishing.exception.PublishingTypeException;
import comgetit.workarea.WorkArea;
import comgetit.workarea.WorkAreaRepository;
import comgetit.workarea.exception.WorkAreNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishingService {

    private final PublishingRepository publishingRepository;

    private final WorkAreaRepository workAreaRepository;

    @Autowired
    public PublishingService(
        PublishingRepository publishingRepository, WorkAreaRepository workAreaRepository) {
        this.publishingRepository = publishingRepository;
        this.workAreaRepository = workAreaRepository;
    }

    public Publishing createPublishing(final PublishingDTO publishingDTO) {
        WorkArea workArea = workAreaRepository.findById(publishingDTO.getWorkAreaId())
            .orElseThrow(WorkAreNotFoundException::new);
        PublishingType publishingType = convertToTypePublishing(publishingDTO.getTypePublishing());
        Publishing publishing = new Publishing();
        publishing.setPublishingType(publishingType);
        publishing.setWorkArea(workArea);
        publishing.setTariff(publishingDTO.getTariff());
        publishing.setAddress(publishingDTO.getAddress());
        publishing.setTimeRequiredOrOffered(publishingDTO.getTimeRequiredOrOffered());
        publishing.setTimeType(publishingDTO.getTimeType());
        publishing.setDescription(publishingDTO.getDescription());
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
