package piotr.kedra.receiptreminder.core.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "receiptPhoto")
public class ReceiptPhoto implements Serializable {

    @ManyToOne
    @JoinColumn(name = "receiptId", nullable = false)
    private Receipt receipt;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "photoId")
    private Long id;
    private byte[] receiptImg;

    public ReceiptPhoto() {
    }

    public ReceiptPhoto(Receipt receipt, byte[] receiptImg) {
        this.receipt = receipt;
        this.receiptImg = receiptImg;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getReceiptImg() {
        return receiptImg;
    }

    public void setReceiptImg(byte[] receiptImg) {
        this.receiptImg = receiptImg;
    }
}
