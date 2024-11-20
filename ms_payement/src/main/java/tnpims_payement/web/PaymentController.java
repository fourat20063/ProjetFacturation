package tnpims_payement.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tnpims_payement.entities.Payement;
import tnpims_payement.services.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payments")
@Tag(name = "Payment Controller", description = "APIs for managing Payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    @Operation(summary = "Get all Payments", description = "Retrieve a list of all Payments")
    public List<Payement> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Payment by ID", description = "Retrieve a Payment by its ID")
    public ResponseEntity<Payement> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @Operation(summary = "Create a new Payment", description = "Add a new Payment to the system")
    public Payement createPayment(@RequestBody Payement payment) {
        return paymentService.savePayment(payment);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Payment", description = "Update the details of an existing Payment by its ID")
    public ResponseEntity<Payement> updatePayment(@PathVariable Long id, @RequestBody Payement updatedPayment) {
        return paymentService.updatePayment(id, updatedPayment)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Payment", description = "Remove a Payment by its ID")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        if (paymentService.deletePayment(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}