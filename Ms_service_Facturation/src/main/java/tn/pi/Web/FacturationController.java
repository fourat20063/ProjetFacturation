package tn.pi.Web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.pi.DTO.FacturationDTO;
import tn.pi.Services.FacturationService;

import java.util.List;

@RestController
@RequestMapping("/facturations")
public class FacturationController {

    private final FacturationService facturationService;

    @Autowired
    public FacturationController(FacturationService facturationService) {
        this.facturationService = facturationService;
    }


    @PostMapping("/Add")
    public ResponseEntity<FacturationDTO> creerFacturation(@RequestBody FacturationDTO facturationDTO) {
        FacturationDTO nouvelleFacturation = facturationService.creerFacturation(facturationDTO);
        return new ResponseEntity<>(nouvelleFacturation, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<FacturationDTO>> obtenirToutesLesFacturations() {
        List<FacturationDTO> facturations = facturationService.obtenirToutesLesFacturations();
        return new ResponseEntity<>(facturations, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<FacturationDTO> obtenirFacturationParId(@PathVariable Long id) {
        FacturationDTO facturation = facturationService.obtenirFacturationParId(id);
        return new ResponseEntity<>(facturation, HttpStatus.OK);
    }


    @PutMapping("/facturations/{id}")
    public ResponseEntity<FacturationDTO> mettreAJourFacturation(
            @PathVariable Long id,
            @RequestBody FacturationDTO facturationDTO) {
        FacturationDTO miseAJour = facturationService.mettreAJourFacturation(id, facturationDTO);
        return ResponseEntity.ok(miseAJour);
    }


    @GetMapping("/refAbonne/{refAbonne}")
    public ResponseEntity<FacturationDTO> obtenirFacturationParRefAbonne(@PathVariable String refAbonne) {
        FacturationDTO facturationDTO = facturationService.obtenirFacturationParRefAbonne(refAbonne);
        return new ResponseEntity<>(facturationDTO, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerFacturation(@PathVariable Long id) {
        facturationService.supprimerFacturation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
