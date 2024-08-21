CREATE TABLE Szemelyek (
    id INT PRIMARY KEY,
    nev VARCHAR(255),
    szuletesi_datum DATE
);

CREATE TABLE Cimek (
    id INT PRIMARY KEY,
    szemely_id INT,
    cim_tipus VARCHAR(50),
    utca VARCHAR(255),
    varos VARCHAR(255),
    allam VARCHAR(255),
    orszag VARCHAR(255),
    iranyitoszam VARCHAR(20),
    FOREIGN KEY (szemely_id) REFERENCES Szemelyek(id)
);

CREATE TABLE Elerhetosegek (
    id INT PRIMARY KEY,
    szemely_id INT,
    tipus VARCHAR(50),
    ertek VARCHAR(255),
    FOREIGN KEY (szemely_id) REFERENCES Szemelyek(id)
);
