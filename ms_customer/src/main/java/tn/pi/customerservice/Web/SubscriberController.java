package tn.pi.customerservice.Web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.customerservice.DTO.SubscriberDTO;
import tn.pi.customerservice.Entities.Subscriber;
import tn.pi.customerservice.Services.SubscriberService;

import java.util.List;

@RestController
@RequestMapping("/subscribers")
@Tag(name = "Subscriber Service", description = "Subscriber management APIs")
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;

    @GetMapping
    @Operation(summary = "Get all subscribers", description = "Retrieve a list of all subscribers.")
    public List<SubscriberDTO> getAllSubscribers() {
        return subscriberService.getAllSubscribers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get subscriber by ID", description = "Retrieve a subscriber by their unique ID.")
    public ResponseEntity<SubscriberDTO> getSubscriberById(@PathVariable Long id) {
        SubscriberDTO subscriberDTO = subscriberService.getSubscriberById(id);
        return ResponseEntity.ok(subscriberDTO);
    }

    @PostMapping("/add")
    @Operation(summary = "Create a new subscriber", description = "Add a new subscriber to the database.")
    public SubscriberDTO createSubscriber(@RequestBody SubscriberDTO subscriberDTO) {
        return subscriberService.createSubscriber(subscriberDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a subscriber", description = "Remove a subscriber from the database by ID.")
    public ResponseEntity<Void> deleteSubscriber(@PathVariable Long id) {
        subscriberService.deleteSubscriber(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a subscriber", description = "Update the information of an existing subscriber by ID.")
    public ResponseEntity<SubscriberDTO> updateSubscriber(@PathVariable Long id, @RequestBody SubscriberDTO updatedSubscriber) {
        SubscriberDTO updatedSubscriberDTO = subscriberService.updateSubscriber(id, updatedSubscriber);
        return ResponseEntity.ok(updatedSubscriberDTO);
    }

}
