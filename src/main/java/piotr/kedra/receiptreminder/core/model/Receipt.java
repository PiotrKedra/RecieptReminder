package piotr.kedra.receiptreminder.core.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "receipt")
public class Receipt {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "receiptId")
    private Long id;

    private String title;
    private Date dateOfPurchase;
    private Date endOfWarranty;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<ReceiptPhoto> receiptPhotos;

    public Receipt() {
    }

    public Receipt(String title, Date dateOfPurchase, Date endOfWarranty, List<ReceiptPhoto> receiptPhotos) {
        this.title = title;
        this.dateOfPurchase = dateOfPurchase;
        this.endOfWarranty = endOfWarranty;
        this.receiptPhotos = receiptPhotos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getEndOfWarranty() {
        return endOfWarranty;
    }

    public void setEndOfWarranty(Date endOfWarranty) {
        this.endOfWarranty = endOfWarranty;
    }

    public List<ReceiptPhoto> getReceiptPhotos() {
        return receiptPhotos;
    }

    public void setReceiptPhotos(List<ReceiptPhoto> receiptPhotos) {
        this.receiptPhotos = receiptPhotos;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateOfPurchase=" + dateOfPurchase +
                ", endOfWarranty=" + endOfWarranty +
                '}';
    }
}
