package de.kimrudolph.dbmigrations;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String smiley;
}
