package tn.pi.ms_organismetype.Web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.ms_organismetype.DTO.TypeDTO;
import tn.pi.ms_organismetype.Services.TypeService;

import java.util.List;

@RestController
@RequestMapping("/types")
@Tag(name = "Type Controller", description = "APIs for managing Types")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping
    @Operation(summary = "Get all Types", description = "Retrieve a list of all Types")
    public List<TypeDTO> getAllTypes() {
        return typeService.getAllTypes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Type by ID", description = "Retrieve a Type by its ID")
    public ResponseEntity<TypeDTO> getTypeById(@PathVariable Long id) {
        TypeDTO typeDTO = typeService.getTypeById(id);
        return ResponseEntity.ok(typeDTO);
    }

    @PostMapping("/add")
    @Operation(summary = "Create a new Type", description = "Add a new Type to the system")
    public TypeDTO createType(@RequestBody TypeDTO typeDTO) {
        return typeService.createType(typeDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Type", description = "Remove a Type by its ID")
    public ResponseEntity<Void> deleteType(@PathVariable Long id) {
        typeService.deleteType(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Type", description = "Update the details of an existing Type by its ID")
    public ResponseEntity<TypeDTO> updateType(@PathVariable Long id, @RequestBody TypeDTO updatedType) {
        TypeDTO updatedTypeDTO = typeService.updateType(id, updatedType);
        return ResponseEntity.ok(updatedTypeDTO);
    }
}