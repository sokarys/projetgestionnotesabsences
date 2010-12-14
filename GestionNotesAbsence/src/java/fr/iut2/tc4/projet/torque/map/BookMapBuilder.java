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
 * Book Table
 *
  *  This class was autogenerated by Torque on:
  *
  * [Tue Dec 14 18:33:31 CET 2010]
  *
  */
public class BookMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "fr.iut2.tc4.projet.torque.map.BookMapBuilder";

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

        dbMap.addTable("book");
        TableMap tMap = dbMap.getTable("book");
        tMap.setJavaName("Book");
        tMap.setOMClass( fr.iut2.tc4.projet.torque.Book.class );
        tMap.setPeerClass( fr.iut2.tc4.projet.torque.BookPeer.class );
        tMap.setDescription("Book Table");
        tMap.setPrimaryKeyMethod(TableMap.NATIVE);
        DB dbAdapter = Torque.getDB("gestion");
        if (dbAdapter.getIDMethodType().equals(DB.SEQUENCE))
        {
            tMap.setPrimaryKeyMethodInfo("book_SEQ");
        }
        else if (dbAdapter.getIDMethodType().equals(DB.AUTO_INCREMENT))
        {
            tMap.setPrimaryKeyMethodInfo("book");
        }

        ColumnMap cMap = null;


  // ------------- Column: book_id --------------------
        cMap = new ColumnMap( "book_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(true);
        cMap.setNotNull(true);
        cMap.setJavaName( "BookId" );
        cMap.setAutoIncrement(true);
        cMap.setProtected(false);
        cMap.setDescription("Book Id");
        cMap.setInheritance("false");
        cMap.setPosition(1);
        tMap.addColumn(cMap);
  // ------------- Column: title --------------------
        cMap = new ColumnMap( "title", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "Title" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("Book Title");
        cMap.setInheritance("false");
        cMap.setSize( 255 );
        cMap.setPosition(2);
        tMap.addColumn(cMap);
  // ------------- Column: isbn --------------------
        cMap = new ColumnMap( "isbn", tMap);
        cMap.setType( "" );
        cMap.setTorqueType( "VARCHAR" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "ISBN" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("ISBN Number");
        cMap.setInheritance("false");
        cMap.setSize( 24 );
        cMap.setPosition(3);
        tMap.addColumn(cMap);
  // ------------- Column: test_id --------------------
        cMap = new ColumnMap( "test_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "TestId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("Foreign Key test");
        cMap.setInheritance("false");
        cMap.setForeignKey("test", "test_id");
        cMap.setPosition(4);
        tMap.addColumn(cMap);
  // ------------- Column: author_id --------------------
        cMap = new ColumnMap( "author_id", tMap);
        cMap.setType( new Integer(0) );
        cMap.setTorqueType( "INTEGER" );
        cMap.setUsePrimitive(true);
        cMap.setPrimaryKey(false);
        cMap.setNotNull(true);
        cMap.setJavaName( "AuthorId" );
        cMap.setAutoIncrement(false);
        cMap.setProtected(false);
        cMap.setDescription("Foreign Key Author");
        cMap.setInheritance("false");
        cMap.setForeignKey("author", "author_id");
        cMap.setPosition(5);
        tMap.addColumn(cMap);
        tMap.setUseInheritance(false);
    }
}
