
# -----------------------------------------------------------------------
# etudiant
# -----------------------------------------------------------------------
drop table if exists etudiant;

CREATE TABLE etudiant
(
    etudiant_id INTEGER NOT NULL AUTO_INCREMENT,
    nom VARCHAR(128) NOT NULL,
    prenom VARCHAR(128) NOT NULL,
    PRIMARY KEY(etudiant_id));


# -----------------------------------------------------------------------
# absence
# -----------------------------------------------------------------------
drop table if exists absence;

CREATE TABLE absence
(
    absence_id INTEGER NOT NULL AUTO_INCREMENT,
    dateDebut DATETIME NOT NULL,
    dateFin DATETIME NOT NULL,
    motif VARCHAR(128) NOT NULL,
    etudiant_id INTEGER NOT NULL,
    PRIMARY KEY(absence_id));


# -----------------------------------------------------------------------
# matiere
# -----------------------------------------------------------------------
drop table if exists matiere;

CREATE TABLE matiere
(
    matiere_id INTEGER NOT NULL AUTO_INCREMENT,
    nom VARCHAR(128) NOT NULL,
    description VARCHAR(128) NOT NULL,
    prof VARCHAR(128) NOT NULL,
    PRIMARY KEY(matiere_id));


# -----------------------------------------------------------------------
# classe
# -----------------------------------------------------------------------
drop table if exists classe;

CREATE TABLE classe
(
    classe_id INTEGER NOT NULL AUTO_INCREMENT,
    nom VARCHAR(255) NOT NULL,
    etudiant_id INTEGER NOT NULL,
    matiere_id INTEGER NOT NULL,
    PRIMARY KEY(classe_id));


# -----------------------------------------------------------------------
# controle
# -----------------------------------------------------------------------
drop table if exists controle;

CREATE TABLE controle
(
    controle_id INTEGER NOT NULL AUTO_INCREMENT,
    coef INTEGER NOT NULL,
    date DATETIME NOT NULL,
    note INTEGER NOT NULL,
    matiere_id INTEGER NOT NULL,
    etudiant_id INTEGER NOT NULL,
    PRIMARY KEY(controle_id));

ALTER TABLE absence
    ADD CONSTRAINT absence_FK_1
    FOREIGN KEY (etudiant_id)
    REFERENCES etudiant (etudiant_id)
;

ALTER TABLE classe
    ADD CONSTRAINT classe_FK_1
    FOREIGN KEY (etudiant_id)
    REFERENCES etudiant (etudiant_id)
;

ALTER TABLE classe
    ADD CONSTRAINT classe_FK_2
    FOREIGN KEY (matiere_id)
    REFERENCES matiere (matiere_id)
;

ALTER TABLE controle
    ADD CONSTRAINT controle_FK_1
    FOREIGN KEY (etudiant_id)
    REFERENCES etudiant (etudiant_id)
;

ALTER TABLE controle
    ADD CONSTRAINT controle_FK_2
    FOREIGN KEY (matiere_id)
    REFERENCES matiere (matiere_id)
;

