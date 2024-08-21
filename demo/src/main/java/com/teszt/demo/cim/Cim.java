package com.teszt.demo.cim;

import com.teszt.demo.szemely.Szemely;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Cimek")
public class Cim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "szemely_id", nullable = false)
    private Szemely szemely;

    @Column(name = "cim_tipus")
    private String cimTipus;

    @Column(name = "utca")
    private String utca;

    @Column(name = "varos")
    private String varos;

    @Column(name = "allam")
    private String allam;

    @Column(name = "orszag")
    private String orszag;

    @Column(name = "iranyitoszam")
    private String iranyitoszam;

}
