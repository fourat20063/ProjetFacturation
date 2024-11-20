package tnpims_payement.services;

import org.springframework.stereotype.Service;
import tnpims_payement.entities.Payement;
import tnpims_payement.repositories.PaymentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payement> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payement> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payement savePayment(Payement payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payement> updatePayment(Long id, Payement updatedPayment) {
        return paymentRepository.findById(id).map(existingPayment -> {
            existingPayment.setIdFacture(updatedPayment.getIdFacture());
            existingPayment.setRefPayment(updatedPayment.getRefPayment());
            existingPayment.setDatePayment(updatedPayment.getDatePayment());
            existingPayment.setCanal(updatedPayment.getCanal());
            return paymentRepository.save(existingPayment);
        });
    }

    public boolean deletePayment(Long id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
