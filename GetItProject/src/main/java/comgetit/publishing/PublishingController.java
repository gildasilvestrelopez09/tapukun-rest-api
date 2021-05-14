package comgetit.publishing;

import comgetit.publishing.dto.PublicationsDTO;
import comgetit.publishing.dto.PublishingDTO;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishingController {

    private PublishingService publishingService;

    @Autowired
    public PublishingController(PublishingService publishingService) {
        this.publishingService = publishingService;
    }

    @PostMapping("/publishing")
    public ResponseEntity<Long> createPublishing(
        @RequestBody @Valid final PublishingDTO publishingDTO
    ) {
        Publishing publishing = publishingService.createPublishing(publishingDTO);
        return new ResponseEntity(publishing.getId(), HttpStatus.CREATED);
    }
    
    @GetMapping("/publications")
    public List<PublicationsDTO> getAllPublications() {
        return publishingService.getAllPublications();
    }

    @GetMapping("/publications/workarea")
    public List<PublicationsDTO> searchByWorkArea(@RequestParam("search") String workAreaName) {
        return publishingService.searchByWorkArea(workAreaName);
    }
}
