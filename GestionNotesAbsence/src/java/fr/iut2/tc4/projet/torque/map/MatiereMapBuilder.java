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
 * Table des matieres
 *
  *  This class was autogenerated by Torque on:
  *
  * [Wed Dec 15 08:56:21 CET 2010]
  *
  */
public class MatiereMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "fr.iut2.tc4.projet.torque.map.MatiereMapBuilder";

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

        dbMap.addTable("matiere");
        TableMap tMap = dbMap.getTable("matiere");
        tMap.setJavaName("Matiere");
        tMap.setOMClass( fr.iut2.tc4.projet.torque.Matiere.class );
        tMap.setPeerClass( fr.iut2.tc4.projet.torque.MatierePeer.class );
        tMap.setDescription("Table des matieres");
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("gestion");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("matiere_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("matiere");
        }

        ColumnMap cMap = null;


  // ------------- Column: matiere_id --------------------
        cMap = new ColumnMap( "matiere_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(true);
        cMap.setNotNull(true);
        cMap.setJavaName( "MatiereId" );
        cMap.setAutoIncrement(true);
        cMap.setProtected(false);
        cMap.setDescription("matiere Id");
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
        cMap.setDescription("nom de la matiere");
        cMap.setInheritance("false");
        cMap.setSize( 128 );
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: description --------------------
        cMap = new ColumnMap( "description", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "Description" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("Description de la matiere");
        cMap.setInheritance("false");
        cMap.setSize( 128 );
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: prof --------------------
        cMap = new ColumnMap( "prof", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "Prof" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("nom du prof");
        cMap.setInheritance("false");
        cMap.setSize( 128 );
        cMap.setPosition(4);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
