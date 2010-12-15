INSERT INTO Etudiant (nom, prenom)
       VALUES  ('Super', 'Man'),
                ('Bat' , 'Man'),
                ('Spider', 'Man'),
                ('Super', 'Touriste');
INSERT INTO absence (dateDebut, dateFin, motif, etudiant_id)
       VALUES  (CURRENT_DATE,CURRENT_DATE, 'Sauver le monde',1),
               (CURRENT_DATE,CURRENT_DATE, 'Sauver un chat',2),
                (CURRENT_DATE,CURRENT_DATE, 'Morsure',3);
INSERT INTO matiere (nom, description, prof)
       VALUES  ('combat','combat contre les force du mal','blanchon'),
                ('repos','cours pour apprendre a se reposer','brunet-manquat'),
                ('SI','apprentissage de l utilite des SI','coat');
INSERT INTO classe (nom, etudiant_id, matiere_id)
       VALUES  ('Hero',1,1),
                ('Hero',2,1),
                ('Hero',1,3),
                ('Hero',2,3),
                ('Semi-Hero',3,3),
                ('Boulet',4,2);

INSERT INTO controle (coef,date,note,matiere_id,etudiant_id)
       VALUES  (5,CURRENT_DATE,15,3,1),
                (5,CURRENT_DATE,17,3,2),
                (5,CURRENT_DATE,5,3,3);
