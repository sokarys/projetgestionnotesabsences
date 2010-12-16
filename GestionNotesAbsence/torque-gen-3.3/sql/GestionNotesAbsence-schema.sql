
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
    PRIMARY KEY(classe_id));


# -----------------------------------------------------------------------
# etudiant
# -----------------------------------------------------------------------
drop table if exists etudiant;

CREATE TABLE etudiant
(
    etudiant_id INTEGER NOT NULL AUTO_INCREMENT,
    nom VARCHAR(128) NOT NULL,
    prenom VARCHAR(128) NOT NULL,
    classe_id INTEGER NOT NULL,
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
# cours
# -----------------------------------------------------------------------
drop table if exists cours;

CREATE TABLE cours
(
    cours_id INTEGER NOT NULL AUTO_INCREMENT,
    etudiant_id INTEGER NOT NULL,
    classe_id INTEGER NOT NULL,
    PRIMARY KEY(cours_id));


# -----------------------------------------------------------------------
# controle
# -----------------------------------------------------------------------
drop table if exists controle;

CREATE TABLE controle
(
    controle_id INTEGER NOT NULL AUTO_INCREMENT,
    coef INTEGER NOT NULL,
    date DATETIME NOT NULL,
    cours_id INTEGER NOT NULL,
    PRIMARY KEY(controle_id));


# -----------------------------------------------------------------------
# note
# -----------------------------------------------------------------------
drop table if exists note;

CREATE TABLE note
(
    note_id INTEGER NOT NULL AUTO_INCREMENT,
    note INTEGER NOT NULL,
    controle_id INTEGER NOT NULL,
    etudiant_id INTEGER NOT NULL,
    PRIMARY KEY(note_id));

ALTER TABLE etudiant
    ADD CONSTRAINT etudiant_FK_1
    FOREIGN KEY (classe_id)
    REFERENCES classe (classe_id)
;

ALTER TABLE absence
    ADD CONSTRAINT absence_FK_1
    FOREIGN KEY (etudiant_id)
    REFERENCES etudiant (etudiant_id)
;

ALTER TABLE cours
    ADD CONSTRAINT cours_FK_1
    FOREIGN KEY (etudiant_id)
    REFERENCES etudiant (etudiant_id)
;

ALTER TABLE cours
    ADD CONSTRAINT cours_FK_2
    FOREIGN KEY (classe_id)
    REFERENCES classe (classe_id)
;

ALTER TABLE controle
    ADD CONSTRAINT controle_FK_1
    FOREIGN KEY (cours_id)
    REFERENCES cours (cours_id)
;

ALTER TABLE note
    ADD CONSTRAINT note_FK_1
    FOREIGN KEY (controle_id)
    REFERENCES controle (controle_id)
;

ALTER TABLE note
    ADD CONSTRAINT note_FK_2
    FOREIGN KEY (etudiant_id)
    REFERENCES etudiant (etudiant_id)
;

