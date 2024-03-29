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
 * Table des etudiant
 *
  *  This class was autogenerated by Torque on:
  *
  * [Sun Dec 19 12:20:45 CET 2010]
  *
  */
public class EtudiantMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "fr.iut2.tc4.projet.torque.map.EtudiantMapBuilder";

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

        dbMap.addTable("etudiant");
        TableMap tMap = dbMap.getTable("etudiant");
        tMap.setJavaName("Etudiant");
        tMap.setOMClass( fr.iut2.tc4.projet.torque.Etudiant.class );
        tMap.setPeerClass( fr.iut2.tc4.projet.torque.EtudiantPeer.class );
        tMap.setDescription("Table des etudiant");
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("gestion");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("etudiant_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("etudiant");
        }

        ColumnMap cMap = null;


  // ------------- Column: etudiant_id --------------------
        cMap = new ColumnMap( "etudiant_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(true);
        cMap.setNotNull(true);
        cMap.setJavaName( "EtudiantId" );
        cMap.setAutoIncrement(true);
        cMap.setProtected(false);
        cMap.setDescription("etudiant Id");
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
        cMap.setDescription("nom de l'etudiant");
        cMap.setInheritance("false");
        cMap.setSize( 128 );
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: prenom --------------------
        cMap = new ColumnMap( "prenom", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "Prenom" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("prenom de l'etudiant");
        cMap.setInheritance("false");
        cMap.setSize( 128 );
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: classe_id --------------------
        cMap = new ColumnMap( "classe_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "ClasseId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("classe id");
        cMap.setInheritance("false");
        cMap.setForeignKey("classe", "classe_id");
        cMap.setPosition(4);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
