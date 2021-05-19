package comgetit.publishing;

import comgetit.publishing.dto.PublicationDTO;
import comgetit.publishing.dto.PublicationCreationDTO;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicationController {

    private PublicationService publicationService;

    @Autowired
    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @PostMapping("/publishing")
    public ResponseEntity<Long> createPublishing(
        @RequestBody @Valid final PublicationCreationDTO publicationCreationDTO
    ) {
        Publication publication = publicationService.createPublishing(publicationCreationDTO);
        return new ResponseEntity(publication.getId(), HttpStatus.CREATED);
    }
    
    @GetMapping("/publications")
    public List<PublicationDTO> getAllPublications() {
        return publicationService.getAllPublications();
    }

    @GetMapping("/publications/search")
    public List<PublicationDTO> searchByWorkArea(@RequestParam("workarea") String workAreaName) {
        return publicationService.searchByWorkArea(workAreaName);
    }
}
