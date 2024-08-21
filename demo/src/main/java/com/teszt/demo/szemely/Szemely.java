package com.teszt.demo.szemely;

import com.teszt.demo.cim.Cim;
import com.teszt.demo.elerhetoseg.Elerhetoseg;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Szemelyek")
public class Szemely {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nev")
    private String nev;

    @Column(name = "szuletesi_datum")
    private Date szuletesiDatum;

    @OneToMany(mappedBy = "szemely", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cim> cimek;

    @OneToMany(mappedBy = "szemely", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Elerhetoseg> elerhetosegek;

}
