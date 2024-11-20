package tn.pi.ms_organismetype.Web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.ms_organismetype.DTO.OrganismeDTO;
import tn.pi.ms_organismetype.Services.OrganismeService;

import java.util.List;

@RestController
@RequestMapping("/organismes")
@Tag(name = "Organisme Controller", description = "APIs for managing Organismes")
public class OrganismeController {

    @Autowired
    private OrganismeService organismeService;

    @GetMapping
    @Operation(summary = "Get all Organismes", description = "Retrieve a list of all Organismes")
    public List<OrganismeDTO> getAllOrganismes() {
        return organismeService.getAllOrganismes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Organisme by ID", description = "Retrieve an Organisme by its ID")
    public ResponseEntity<OrganismeDTO> getOrganismeById(@PathVariable Long id) {
        OrganismeDTO organismeDTO = organismeService.getOrganismeById(id);
        return ResponseEntity.ok(organismeDTO);
    }

    @PostMapping("/add")
    @Operation(summary = "Create a new Organisme", description = "Add a new Organisme to the system")
    public OrganismeDTO createOrganisme(@RequestBody OrganismeDTO organismeDTO) {
        return organismeService.createOrganisme(organismeDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an Organisme", description = "Remove an Organisme by its ID")
    public ResponseEntity<Void> deleteOrganisme(@PathVariable Long id) {
        organismeService.deleteOrganisme(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an Organisme", description = "Update the details of an existing Organisme by its ID")
    public ResponseEntity<OrganismeDTO> updateOrganisme(@PathVariable Long id, @RequestBody OrganismeDTO updatedOrganisme) {
        OrganismeDTO updatedOrganismeDTO = organismeService.updateOrganisme(id, updatedOrganisme);
        return ResponseEntity.ok(updatedOrganismeDTO);
    }
}