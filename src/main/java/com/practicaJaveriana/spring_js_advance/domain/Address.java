package com.practicaJaveriana.spring_js_advance.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name="address")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @SequenceGenerator(
            name="address_sequence",
            sequenceName="address_sequence",
            allocationSize = 1,
            initialValue = 8000
    )
    @GeneratedValue(
         strategy = GenerationType.SEQUENCE,
         generator = "address_sequence"
    )
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @ManyToOne(
            fetch = FetchType.LAZY,
            //Siempre debe existir un cliente para realizar la asociación a las addresses
            // No puede existir una direccion sin relacion a cliente
            optional = false
    )//Ahora con la anotación @Join definimos con quien y cual campo se tiene que relacionar la clase address
    @JoinColumn(name="client_id")
    private Client client;

    @Override
    public boolean equals(Object o){
        if(this == o)return true;
        if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Address address = (Address) o;
        return id != null && Objects.equals(id, address.id);
    }

    public int hashCode(){
        return getClass().hashCode();
    }
}
