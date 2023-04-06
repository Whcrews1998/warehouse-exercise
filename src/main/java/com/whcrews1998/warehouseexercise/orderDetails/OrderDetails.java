package com.whcrews1998.warehouseexercise.orderDetails;

import com.whcrews1998.warehouseexercise.embeddable.Name;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OrderDetails {
    @Id
    @GeneratedValue
    private Integer id;


}
