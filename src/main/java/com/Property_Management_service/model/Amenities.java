package com.Property_Management_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import  jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import jakarta.annotation.Nonnull;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Amenities")
public class Amenities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "amen_id")
    private Long amId;

    @ManyToOne
    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE )
    @JoinColumn(name = "flat_id",referencedColumnName = "id")

    private FlatInfo flatInfo;

    @Column(name="name")
    private String name;

}
