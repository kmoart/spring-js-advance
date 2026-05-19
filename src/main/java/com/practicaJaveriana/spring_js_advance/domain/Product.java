package com.practicaJaveriana.spring_js_advance.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name="product")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @SequenceGenerator(
            name="product_sequence",
            sequenceName="product_sequence",
            allocationSize = 3,
            initialValue = 150
    )//Una vez creada la secuencia se la asignamos al id con GeneratedValue
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name="price")
    private Double price;

    @Override
    public boolean equals(Object o){
        if(this == o)return true;
        if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    public int hashCode(){
        return getClass().hashCode();
    }
}
