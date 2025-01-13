package telegram.telegarm_intern.entity;

import jakarta.persistence.*;
import lombok.Data;
import telegram.telegarm_intern.enums.MoneyType;
import telegram.telegarm_intern.enums.TransactionType;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MoneyType moneyType;

    @Column(nullable = false)
    private Double amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Service service;

    private String description;

    @Column(nullable = true)
    private String filePath;

}
