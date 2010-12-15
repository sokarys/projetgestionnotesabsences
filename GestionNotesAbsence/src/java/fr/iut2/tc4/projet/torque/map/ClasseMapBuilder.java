package fr.iut2.tc4.projet.torque.map;

import java.util.Date;
import java.math.BigDecimal;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.adapter.DB;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.TableMap;
import org.apache.torque.map.ColumnMap;
import org.apache.torque.map.InheritanceMap;

/**
 * Table des classes
 *
  *  This class was autogenerated by Torque on:
  *
  * [Wed Dec 15 15:22:40 CET 2010]
  *
  */
public class ClasseMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "fr.iut2.tc4.projet.torque.map.ClasseMapBuilder";

    /**
     * The database map.
     */
    private DatabaseMap dbMap = null;

    /**
     * Tells us if this DatabaseMapBuilder is built so that we
     * don't have to re-build it every time.
     *
     * @return true if this DatabaseMapBuilder is built
     */
    public boolean isBuilt()
    {
        return (dbMap != null);
    }

    /**
     * Gets the databasemap this map builder built.
     *
     * @return the databasemap
     */
    public DatabaseMap getDatabaseMap()
    {
        return this.dbMap;
    }

    /**
     * The doBuild() method builds the DatabaseMap
     *
     * @throws TorqueException
     */
    public synchronized void doBuild() throws TorqueException
    {
        if ( isBuilt() ) {
            return;
        }
        dbMap = Torque.getDatabaseMap("gestion");

        dbMap.addTable("classe");
        TableMap tMap = dbMap.getTable("classe");
        tMap.setJavaName("Classe");
        tMap.setOMClass( fr.iut2.tc4.projet.torque.Classe.class );
        tMap.setPeerClass( fr.iut2.tc4.projet.torque.ClassePeer.class );
        tMap.setDescription("Table des classes");
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("gestion");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("classe_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("classe");
        }

        ColumnMap cMap = null;


  // ------------- Column: classe_id --------------------
        cMap = new ColumnMap( "classe_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(true);
        cMap.setNotNull(true);
        cMap.setJavaName( "ClasseId" );
        cMap.setAutoIncrement(true);
        cMap.setProtected(false);
        cMap.setDescription("classe Id");
        cMap.setInheritance("false");
        cMap.setPosition(1);
        tMap.addColumn(cMap);
  // ------------- Column: nom --------------------
        cMap = new ColumnMap( "nom", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "Nom" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("nom de la classe");
        cMap.setInheritance("false");
        cMap.setSize( 255 );
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: etudiant_id --------------------
        cMap = new ColumnMap( "etudiant_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "EtudiantId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("etudiant id");
        cMap.setInheritance("false");
        cMap.setForeignKey("etudiant", "etudiant_id");
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: matiere_id --------------------
        cMap = new ColumnMap( "matiere_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "MatiereId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("matiere id");
        cMap.setInheritance("false");
        cMap.setForeignKey("matiere", "matiere_id");
        cMap.setPosition(4);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
