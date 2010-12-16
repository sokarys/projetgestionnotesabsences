INSERT INTO matiere (nom, description, prof)
       VALUES  ('combat','combat contre les force du mal','blanchon'),
                ('repos','cours pour apprendre a se reposer','brunet-manquat'),
                ('SI','apprentissage de l utilite des SI','coat');
INSERT INTO classe (nom)
       VALUES  ('Hero'),
               ('Semi-Hero'),
               ('Boulet');
INSERT INTO etudiant (nom, prenom,classe_id)
       VALUES  ('Super', 'Man',1),
                ('Bat' , 'Man',1),
                ('Spider', 'Man',2),
                ('Super', 'Touriste',3);
INSERT INTO absence (dateDebut, dateFin, motif, etudiant_id)
       VALUES  (CURRENT_DATE,CURRENT_DATE, 'Sauver le monde',1),
               (CURRENT_DATE,CURRENT_DATE, 'Sauver un chat',2),
               (CURRENT_DATE,CURRENT_DATE, 'Morsure',3);
INSERT INTO cours (matiere_id,classe_id)
       VALUES  (1,1),
                (3,1),
                (1,2),
                (2,2),
                (2,3);
INSERT INTO controle (coef,date,cours_id)
       VALUES  (5,CURRENT_DATE,1),
               (10,CURRENT_DATE,4);
INSERT INTO note (note,controle_id,etudiant_id)
       VALUES  (20,1,1),
                (15,1,2),
                (17,2,4);