package tnpims_payement.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tnpims_payement.entities.Canal;
import tnpims_payement.services.CanalService;

import java.util.List;

@RestController
@RequestMapping("/canals")
@Tag(name = "Canal Controller", description = "APIs for managing Canals")
public class CanalController {

    private final CanalService canalService;

    public CanalController(CanalService canalService) {
        this.canalService = canalService;
    }

    @GetMapping
    @Operation(summary = "Get all Canals", description = "Retrieve a list of all Canals")
    public List<Canal> getAllCanals() {
        return canalService.getAllCanals();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Canal by ID", description = "Retrieve a Canal by its ID")
    public ResponseEntity<Canal> getCanalById(@PathVariable Long id) {
        return canalService.getCanalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @Operation(summary = "Create a new Canal", description = "Add a new Canal to the system")
    public Canal createCanal(@RequestBody Canal canal) {
        return canalService.saveCanal(canal);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Canal", description = "Update the details of an existing Canal by its ID")
    public ResponseEntity<Canal> updateCanal(@PathVariable Long id, @RequestBody Canal updatedCanal) {
        return canalService.updateCanal(id, updatedCanal)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Canal", description = "Remove a Canal by its ID")
    public ResponseEntity<Void> deleteCanal(@PathVariable Long id) {
        if (canalService.deleteCanal(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
