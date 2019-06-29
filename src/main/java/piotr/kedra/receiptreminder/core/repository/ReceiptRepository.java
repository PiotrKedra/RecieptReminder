package piotr.kedra.receiptreminder.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import piotr.kedra.receiptreminder.core.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    void removeById(Long id);
}
