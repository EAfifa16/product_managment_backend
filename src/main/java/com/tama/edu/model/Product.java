package com.tama.edu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product_Details")
public class Product {

    @Id
    @Column(name = "Prd_Id")
    String prdId;
    @Column(name = "Prd_Name")
    String prdName;
    @Column(name = "Prd_Type")
    String prdType;
}
