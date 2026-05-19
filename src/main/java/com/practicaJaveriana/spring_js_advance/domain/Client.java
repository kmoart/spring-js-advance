package com.practicaJaveriana.spring_js_advance.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="client")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @SequenceGenerator(
            name="client_sequence",
            sequenceName="client_sequence",
            allocationSize = 1,
            initialValue = 999
    )//Una vez creada la secuencia se la asignamos al id con GeneratedValue
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne
    private User user;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_product",
            joinColumns = {
                    @JoinColumn(name = "fk_client")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "fk_product")
            }
    )
    private Set<Product> products= new HashSet<>();

    @Override
    public boolean equals(Object o){
        if(this == o)return true;
        if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return id != null && Objects.equals(id, client.id);
    }

    public int hashCode(){
        return getClass().hashCode();
    }
}
