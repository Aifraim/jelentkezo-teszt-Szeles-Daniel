INSERT INTO Szemelyek (id, nev, szuletesi_datum) VALUES (1, 'Kis Pista', '1990-01-01');
INSERT INTO Cimek (id, szemely_id, cim_tipus, utca, varos, allam, orszag, iranyitoszam)
    VALUES (1, 1, 'állandó', 'Nagy utca 1', 'Budapest', 'Pest', 'Magyarország', '1111');
INSERT INTO Elerhetosegek (id, szemely_id, tipus, ertek) VALUES (1, 1, 'email', 'kispista@gmail.com');
