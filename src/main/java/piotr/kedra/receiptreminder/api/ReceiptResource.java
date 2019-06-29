package piotr.kedra.receiptreminder.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import piotr.kedra.receiptreminder.core.model.Receipt;
import piotr.kedra.receiptreminder.core.repository.ReceiptRepository;


@RestController
@RequestMapping("/receipt")
public class ReceiptResource {

    private final ReceiptRepository receiptRepository;

    @Autowired
    public ReceiptResource(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity create(@RequestBody Receipt receipt){
        System.out.println(receipt);

        try {
            receiptRepository.save(receipt);
            return ResponseEntity.ok(receipt.getId());
        }catch (RuntimeException exception) {
            return ResponseEntity.status(500)
                    .build();
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(receiptRepository.getOne(id));
        }catch (Exception exception){
            return ResponseEntity.status(404)
                    .build();
        }
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity delete(@PathVariable("id") Long id){
        System.out.println(id);

        receiptRepository.removeById(id);
        return ResponseEntity.ok()
                .build();

    }

    @Transactional
    @PutMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity update(@PathVariable("id") Long id, @RequestBody Receipt receipt){
        System.out.println(receipt);
        Receipt receiptToUpdate = receiptRepository.getOne(id);
        receiptToUpdate.setDateOfPurchase(receipt.getDateOfPurchase());
        receiptToUpdate.setEndOfWarranty(receipt.getEndOfWarranty());
        receiptToUpdate.setReceiptPhotos(receipt.getReceiptPhotos());
        receiptToUpdate.setTitle(receipt.getTitle());

        receiptRepository.save(receiptToUpdate);
        return ResponseEntity.ok()
                .build();

    }
}

