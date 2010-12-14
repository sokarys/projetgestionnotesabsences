package fr.iut2.tc4.projet.torque;


import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.BaseObject;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.Persistent;
import org.apache.torque.util.Criteria;
import org.apache.torque.util.Transaction;





/**
 * Test Table
 *
 * This class was autogenerated by Torque on:
 *
 * [Tue Dec 14 18:33:31 CET 2010]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Test
 */
public abstract class BaseTest extends BaseObject
{
    /** Serial version */
    private static final long serialVersionUID = 1292348011746L;

    /** The Peer class */
    private static final TestPeer peer =
        new TestPeer();


    /** The value for the testId field */
    private int testId;

    /** The value for the name field */
    private String name;


    /**
     * Get the TestId
     *
     * @return int
     */
    public int getTestId()
    {
        return testId;
    }


    /**
     * Set the value of TestId
     *
     * @param v new value
     */
    public void setTestId(int v) throws TorqueException
    {

        if (this.testId != v)
        {
            this.testId = v;
            setModified(true);
        }



        // update associated Book
        if (collBooks != null)
        {
            for (int i = 0; i < collBooks.size(); i++)
            {
                ((Book) collBooks.get(i))
                        .setTestId(v);
            }
        }
    }

    /**
     * Get the Name
     *
     * @return String
     */
    public String getName()
    {
        return name;
    }


    /**
     * Set the value of Name
     *
     * @param v new value
     */
    public void setName(String v) 
    {

        if (!ObjectUtils.equals(this.name, v))
        {
            this.name = v;
            setModified(true);
        }


    }

       


    /**
     * Collection to store aggregation of collBooks
     */
    protected List collBooks;

    /**
     * Temporary storage of collBooks to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initBooks()
    {
        if (collBooks == null)
        {
            collBooks = new ArrayList();
        }
    }


    /**
     * Method called to associate a Book object to this object
     * through the Book foreign key attribute
     *
     * @param l Book
     * @throws TorqueException
     */
    public void addBook(Book l) throws TorqueException
    {
        getBooks().add(l);
        l.setTest((Test) this);
    }

    /**
     * Method called to associate a Book object to this object
     * through the Book foreign key attribute using connection.
     *
     * @param l Book
     * @throws TorqueException
     */
    public void addBook(Book l, Connection con) throws TorqueException
    {
        getBooks(con).add(l);
        l.setTest((Test) this);
    }

    /**
     * The criteria used to select the current contents of collBooks
     */
    private Criteria lastBooksCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getBooks(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List getBooks()
        throws TorqueException
    {
        if (collBooks == null)
        {
            collBooks = getBooks(new Criteria(10));
        }
        return collBooks;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Test has previously
     * been saved, it will retrieve related Books from storage.
     * If this Test is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List getBooks(Criteria criteria) throws TorqueException
    {
        if (collBooks == null)
        {
            if (isNew())
            {
               collBooks = new ArrayList();
            }
            else
            {
                criteria.add(BookPeer.TEST_ID, getTestId() );
                collBooks = BookPeer.doSelect(criteria);
            }
        }
        else
        {
            // criteria has no effect for a new object
            if (!isNew())
            {
                // the following code is to determine if a new query is
                // called for.  If the criteria is the same as the last
                // one, just return the collection.
                criteria.add(BookPeer.TEST_ID, getTestId());
                if (!lastBooksCriteria.equals(criteria))
                {
                    collBooks = BookPeer.doSelect(criteria);
                }
            }
        }
        lastBooksCriteria = criteria;

        return collBooks;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getBooks(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getBooks(Connection con) throws TorqueException
    {
        if (collBooks == null)
        {
            collBooks = getBooks(new Criteria(10), con);
        }
        return collBooks;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Test has previously
     * been saved, it will retrieve related Books from storage.
     * If this Test is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getBooks(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collBooks == null)
        {
            if (isNew())
            {
               collBooks = new ArrayList();
            }
            else
            {
                 criteria.add(BookPeer.TEST_ID, getTestId());
                 collBooks = BookPeer.doSelect(criteria, con);
             }
         }
         else
         {
             // criteria has no effect for a new object
             if (!isNew())
             {
                 // the following code is to determine if a new query is
                 // called for.  If the criteria is the same as the last
                 // one, just return the collection.
                 criteria.add(BookPeer.TEST_ID, getTestId());
                 if (!lastBooksCriteria.equals(criteria))
                 {
                     collBooks = BookPeer.doSelect(criteria, con);
                 }
             }
         }
         lastBooksCriteria = criteria;

         return collBooks;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Test is new, it will return
     * an empty collection; or if this Test has previously
     * been saved, it will retrieve related Books from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Test.
     */
    protected List getBooksJoinTest(Criteria criteria)
        throws TorqueException
    {
        if (collBooks == null)
        {
            if (isNew())
            {
               collBooks = new ArrayList();
            }
            else
            {
                criteria.add(BookPeer.TEST_ID, getTestId());
                collBooks = BookPeer.doSelectJoinTest(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(BookPeer.TEST_ID, getTestId());
            if (!lastBooksCriteria.equals(criteria))
            {
                collBooks = BookPeer.doSelectJoinTest(criteria);
            }
        }
        lastBooksCriteria = criteria;

        return collBooks;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Test is new, it will return
     * an empty collection; or if this Test has previously
     * been saved, it will retrieve related Books from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Test.
     */
    protected List getBooksJoinAuthor(Criteria criteria)
        throws TorqueException
    {
        if (collBooks == null)
        {
            if (isNew())
            {
               collBooks = new ArrayList();
            }
            else
            {
                criteria.add(BookPeer.TEST_ID, getTestId());
                collBooks = BookPeer.doSelectJoinAuthor(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(BookPeer.TEST_ID, getTestId());
            if (!lastBooksCriteria.equals(criteria))
            {
                collBooks = BookPeer.doSelectJoinAuthor(criteria);
            }
        }
        lastBooksCriteria = criteria;

        return collBooks;
    }



        
    private static List fieldNames = null;

    /**
     * Generate a list of field names.
     *
     * @return a list of field names
     */
    public static synchronized List getFieldNames()
    {
        if (fieldNames == null)
        {
            fieldNames = new ArrayList();
            fieldNames.add("TestId");
            fieldNames.add("Name");
            fieldNames = Collections.unmodifiableList(fieldNames);
        }
        return fieldNames;
    }

    /**
     * Retrieves a field from the object by field (Java) name passed in as a String.
     *
     * @param name field name
     * @return value
     */
    public Object getByName(String name)
    {
        if (name.equals("TestId"))
        {
            return new Integer(getTestId());
        }
        if (name.equals("Name"))
        {
            return getName();
        }
        return null;
    }

    /**
     * Set a field in the object by field (Java) name.
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByName(String name, Object value )
        throws TorqueException, IllegalArgumentException
    {
        if (name.equals("TestId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setTestId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Name"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setName((String) value);
            return true;
        }
        return false;
    }

    /**
     * Retrieves a field from the object by name passed in
     * as a String.  The String must be one of the static
     * Strings defined in this Class' Peer.
     *
     * @param name peer name
     * @return value
     */
    public Object getByPeerName(String name)
    {
        if (name.equals(TestPeer.TEST_ID))
        {
            return new Integer(getTestId());
        }
        if (name.equals(TestPeer.NAME))
        {
            return getName();
        }
        return null;
    }

    /**
     * Set field values by Peer Field Name
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPeerName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
      if (TestPeer.TEST_ID.equals(name))
        {
            return setByName("TestId", value);
        }
      if (TestPeer.NAME.equals(name))
        {
            return setByName("Name", value);
        }
        return false;
    }

    /**
     * Retrieves a field from the object by Position as specified
     * in the xml schema.  Zero-based.
     *
     * @param pos position in xml schema
     * @return value
     */
    public Object getByPosition(int pos)
    {
        if (pos == 0)
        {
            return new Integer(getTestId());
        }
        if (pos == 1)
        {
            return getName();
        }
        return null;
    }

    /**
     * Set field values by its position (zero based) in the XML schema.
     *
     * @param position The field position
     * @param value field value
     * @return True if value was set, false if not (invalid position / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPosition(int position, Object value)
        throws TorqueException, IllegalArgumentException
    {
    if (position == 0)
        {
            return setByName("TestId", value);
        }
    if (position == 1)
        {
            return setByName("Name", value);
        }
        return false;
    }
     
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     *
     * @throws Exception
     */
    public void save() throws Exception
    {
        save(TestPeer.DATABASE_NAME);
    }

    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.
     * Note: this code is here because the method body is
     * auto-generated conditionally and therefore needs to be
     * in this file instead of in the super class, BaseObject.
     *
     * @param dbName
     * @throws TorqueException
     */
    public void save(String dbName) throws TorqueException
    {
        Connection con = null;
        try
        {
            con = Transaction.begin(dbName);
            save(con);
            Transaction.commit(con);
        }
        catch(TorqueException e)
        {
            Transaction.safeRollback(con);
            throw e;
        }
    }

    /** flag to prevent endless save loop, if this object is referenced
        by another object which falls in this transaction. */
    private boolean alreadyInSave = false;
    /**
     * Stores the object in the database.  If the object is new,
     * it inserts it; otherwise an update is performed.  This method
     * is meant to be used as part of a transaction, otherwise use
     * the save() method and the connection details will be handled
     * internally
     *
     * @param con
     * @throws TorqueException
     */
    public void save(Connection con) throws TorqueException
    {
        if (!alreadyInSave)
        {
            alreadyInSave = true;



            // If this object has been modified, then save it to the database.
            if (isModified())
            {
                if (isNew())
                {
                    TestPeer.doInsert((Test) this, con);
                    setNew(false);
                }
                else
                {
                    TestPeer.doUpdate((Test) this, con);
                }
            }


            if (collBooks != null)
            {
                for (int i = 0; i < collBooks.size(); i++)
                {
                    ((Book) collBooks.get(i)).save(con);
                }
            }
            alreadyInSave = false;
        }
    }


    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key testId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
        setTestId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
        setTestId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getTestId());
    }
 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public Test copy() throws TorqueException
    {
        return copy(true);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     *
     * @param con the database connection to read associated objects.
     */
    public Test copy(Connection con) throws TorqueException
    {
        return copy(true, con);
    }

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     */
    public Test copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Test(), deepcopy);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     * @param con the database connection to read associated objects.
     */
    public Test copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Test(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Test copyInto(Test copyObj) throws TorqueException
    {
        return copyInto(copyObj, true);
    }

  
    /**
     * Fills the copyObj with the contents of this object using connection.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param con the database connection to read associated objects.
     */
    protected Test copyInto(Test copyObj, Connection con) throws TorqueException
    {
        return copyInto(copyObj, true, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     */
    protected Test copyInto(Test copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setTestId(testId);
        copyObj.setName(name);

        copyObj.setTestId( 0);

        if (deepcopy)
        {


        List vBooks = getBooks();
        if (vBooks != null)
        {
            for (int i = 0; i < vBooks.size(); i++)
            {
                Book obj = (Book) vBooks.get(i);
                copyObj.addBook(obj.copy());
            }
        }
        else
        {
            copyObj.collBooks = null;
        }
        }
        return copyObj;
    }
        
    
    /**
     * Fills the copyObj with the contents of this object using connection.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     * @param con the database connection to read associated objects.
     */
    protected Test copyInto(Test copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setTestId(testId);
        copyObj.setName(name);

        copyObj.setTestId( 0);

        if (deepcopy)
        {


        List vBooks = getBooks(con);
        if (vBooks != null)
        {
            for (int i = 0; i < vBooks.size(); i++)
            {
                Book obj = (Book) vBooks.get(i);
                copyObj.addBook(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collBooks = null;
        }
        }
        return copyObj;
    }
    
    

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public TestPeer getPeer()
    {
        return peer;
    }

    /**
     * Retrieves the TableMap object related to this Table data without
     * compiler warnings of using getPeer().getTableMap().
     *
     * @return The associated TableMap object.
     */
    public TableMap getTableMap() throws TorqueException
    {
        return TestPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Test:\n");
        str.append("TestId = ")
           .append(getTestId())
           .append("\n");
        str.append("Name = ")
           .append(getName())
           .append("\n");
        return(str.toString());
    }
}
