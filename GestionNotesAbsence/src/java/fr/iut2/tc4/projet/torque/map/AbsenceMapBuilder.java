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
 * Table des absences
 *
  *  This class was autogenerated by Torque on:
  *
  * [Wed Dec 15 08:56:21 CET 2010]
  *
  */
public class AbsenceMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "fr.iut2.tc4.projet.torque.map.AbsenceMapBuilder";

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

        dbMap.addTable("absence");
        TableMap tMap = dbMap.getTable("absence");
        tMap.setJavaName("Absence");
        tMap.setOMClass( fr.iut2.tc4.projet.torque.Absence.class );
        tMap.setPeerClass( fr.iut2.tc4.projet.torque.AbsencePeer.class );
        tMap.setDescription("Table des absences");
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("gestion");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("absence_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("absence");
        }

        ColumnMap cMap = null;


  // ------------- Column: absence_id --------------------
        cMap = new ColumnMap( "absence_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(true);
        cMap.setNotNull(true);
        cMap.setJavaName( "AbsenceId" );
        cMap.setAutoIncrement(true);
        cMap.setProtected(false);
        cMap.setDescription("absence Id");
        cMap.setInheritance("false");
        cMap.setPosition(1);
        tMap.addColumn(cMap);
  // ------------- Column: dateDebut --------------------
        cMap = new ColumnMap( "dateDebut", tMap);
        cMap.setType( new Date() );
        cMap.setTorqueType( "TIMESTAMP" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "Datedebut" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("Date de debut");
        cMap.setInheritance("false");
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: dateFin --------------------
        cMap = new ColumnMap( "dateFin", tMap);
        cMap.setType( new Date() );
        cMap.setTorqueType( "TIMESTAMP" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "Datefin" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("Date de fin");
        cMap.setInheritance("false");
        cMap.setPosition(3);
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
        cMap.setPosition(4);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
