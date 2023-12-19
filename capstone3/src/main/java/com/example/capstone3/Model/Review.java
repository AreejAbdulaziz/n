package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @PositiveOrZero
    @NotNull(message = "rating cannot be null")
    @Column(columnDefinition = "double not null")
    private double rating;
    @NotNull(message = "comment cannot be null")
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(columnDefinition = "varchar(225) not null")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "member_id",referencedColumnName = "id")
    @JsonIgnore
    private Member member;
}
