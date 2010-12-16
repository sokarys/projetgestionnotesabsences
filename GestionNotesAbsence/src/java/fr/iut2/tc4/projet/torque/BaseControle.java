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
 * Table des controles
 *
 * This class was autogenerated by Torque on:
 *
 * [Thu Dec 16 15:23:43 CET 2010]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Controle
 */
public abstract class BaseControle extends BaseObject
{
    /** Serial version */
    private static final long serialVersionUID = 1292509423917L;

    /** The Peer class */
    private static final ControlePeer peer =
        new ControlePeer();


    /** The value for the controleId field */
    private int controleId;

    /** The value for the coef field */
    private int coef;

    /** The value for the date field */
    private Date date;

    /** The value for the coursId field */
    private int coursId;


    /**
     * Get the ControleId
     *
     * @return int
     */
    public int getControleId()
    {
        return controleId;
    }


    /**
     * Set the value of ControleId
     *
     * @param v new value
     */
    public void setControleId(int v) throws TorqueException
    {

        if (this.controleId != v)
        {
            this.controleId = v;
            setModified(true);
        }



        // update associated Note
        if (collNotes != null)
        {
            for (int i = 0; i < collNotes.size(); i++)
            {
                ((Note) collNotes.get(i))
                        .setControleId(v);
            }
        }
    }

    /**
     * Get the Coef
     *
     * @return int
     */
    public int getCoef()
    {
        return coef;
    }


    /**
     * Set the value of Coef
     *
     * @param v new value
     */
    public void setCoef(int v) 
    {

        if (this.coef != v)
        {
            this.coef = v;
            setModified(true);
        }


    }

    /**
     * Get the Date
     *
     * @return Date
     */
    public Date getDate()
    {
        return date;
    }


    /**
     * Set the value of Date
     *
     * @param v new value
     */
    public void setDate(Date v) 
    {

        if (!ObjectUtils.equals(this.date, v))
        {
            this.date = v;
            setModified(true);
        }


    }

    /**
     * Get the CoursId
     *
     * @return int
     */
    public int getCoursId()
    {
        return coursId;
    }


    /**
     * Set the value of CoursId
     *
     * @param v new value
     */
    public void setCoursId(int v) throws TorqueException
    {

        if (this.coursId != v)
        {
            this.coursId = v;
            setModified(true);
        }


        if (aCours != null && !(aCours.getCoursId() == v))
        {
            aCours = null;
        }

    }

    



    private Cours aCours;

    /**
     * Declares an association between this object and a Cours object
     *
     * @param v Cours
     * @throws TorqueException
     */
    public void setCours(Cours v) throws TorqueException
    {
        if (v == null)
        {
            setCoursId( 0);
        }
        else
        {
            setCoursId(v.getCoursId());
        }
        aCours = v;
    }


    /**
     * Returns the associated Cours object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated Cours object
     * @throws TorqueException
     */
    public Cours getCours()
        throws TorqueException
    {
        if (aCours == null && (this.coursId != 0))
        {
            aCours = CoursPeer.retrieveByPK(SimpleKey.keyFor(this.coursId));
        }
        return aCours;
    }

    /**
     * Return the associated Cours object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated Cours object
     * @throws TorqueException
     */
    public Cours getCours(Connection connection)
        throws TorqueException
    {
        if (aCours == null && (this.coursId != 0))
        {
            aCours = CoursPeer.retrieveByPK(SimpleKey.keyFor(this.coursId), connection);
        }
        return aCours;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setCoursKey(ObjectKey key) throws TorqueException
    {

        setCoursId(((NumberKey) key).intValue());
    }
   


    /**
     * Collection to store aggregation of collNotes
     */
    protected List collNotes;

    /**
     * Temporary storage of collNotes to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initNotes()
    {
        if (collNotes == null)
        {
            collNotes = new ArrayList();
        }
    }


    /**
     * Method called to associate a Note object to this object
     * through the Note foreign key attribute
     *
     * @param l Note
     * @throws TorqueException
     */
    public void addNote(Note l) throws TorqueException
    {
        getNotes().add(l);
        l.setControle((Controle) this);
    }

    /**
     * Method called to associate a Note object to this object
     * through the Note foreign key attribute using connection.
     *
     * @param l Note
     * @throws TorqueException
     */
    public void addNote(Note l, Connection con) throws TorqueException
    {
        getNotes(con).add(l);
        l.setControle((Controle) this);
    }

    /**
     * The criteria used to select the current contents of collNotes
     */
    private Criteria lastNotesCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getNotes(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List getNotes()
        throws TorqueException
    {
        if (collNotes == null)
        {
            collNotes = getNotes(new Criteria(10));
        }
        return collNotes;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Controle has previously
     * been saved, it will retrieve related Notes from storage.
     * If this Controle is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List getNotes(Criteria criteria) throws TorqueException
    {
        if (collNotes == null)
        {
            if (isNew())
            {
               collNotes = new ArrayList();
            }
            else
            {
                criteria.add(NotePeer.CONTROLE_ID, getControleId() );
                collNotes = NotePeer.doSelect(criteria);
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
                criteria.add(NotePeer.CONTROLE_ID, getControleId());
                if (!lastNotesCriteria.equals(criteria))
                {
                    collNotes = NotePeer.doSelect(criteria);
                }
            }
        }
        lastNotesCriteria = criteria;

        return collNotes;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getNotes(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getNotes(Connection con) throws TorqueException
    {
        if (collNotes == null)
        {
            collNotes = getNotes(new Criteria(10), con);
        }
        return collNotes;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Controle has previously
     * been saved, it will retrieve related Notes from storage.
     * If this Controle is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getNotes(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collNotes == null)
        {
            if (isNew())
            {
               collNotes = new ArrayList();
            }
            else
            {
                 criteria.add(NotePeer.CONTROLE_ID, getControleId());
                 collNotes = NotePeer.doSelect(criteria, con);
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
                 criteria.add(NotePeer.CONTROLE_ID, getControleId());
                 if (!lastNotesCriteria.equals(criteria))
                 {
                     collNotes = NotePeer.doSelect(criteria, con);
                 }
             }
         }
         lastNotesCriteria = criteria;

         return collNotes;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Controle is new, it will return
     * an empty collection; or if this Controle has previously
     * been saved, it will retrieve related Notes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Controle.
     */
    protected List getNotesJoinControle(Criteria criteria)
        throws TorqueException
    {
        if (collNotes == null)
        {
            if (isNew())
            {
               collNotes = new ArrayList();
            }
            else
            {
                criteria.add(NotePeer.CONTROLE_ID, getControleId());
                collNotes = NotePeer.doSelectJoinControle(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(NotePeer.CONTROLE_ID, getControleId());
            if (!lastNotesCriteria.equals(criteria))
            {
                collNotes = NotePeer.doSelectJoinControle(criteria);
            }
        }
        lastNotesCriteria = criteria;

        return collNotes;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Controle is new, it will return
     * an empty collection; or if this Controle has previously
     * been saved, it will retrieve related Notes from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Controle.
     */
    protected List getNotesJoinEtudiant(Criteria criteria)
        throws TorqueException
    {
        if (collNotes == null)
        {
            if (isNew())
            {
               collNotes = new ArrayList();
            }
            else
            {
                criteria.add(NotePeer.CONTROLE_ID, getControleId());
                collNotes = NotePeer.doSelectJoinEtudiant(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(NotePeer.CONTROLE_ID, getControleId());
            if (!lastNotesCriteria.equals(criteria))
            {
                collNotes = NotePeer.doSelectJoinEtudiant(criteria);
            }
        }
        lastNotesCriteria = criteria;

        return collNotes;
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
            fieldNames.add("ControleId");
            fieldNames.add("Coef");
            fieldNames.add("Date");
            fieldNames.add("CoursId");
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
        if (name.equals("ControleId"))
        {
            return new Integer(getControleId());
        }
        if (name.equals("Coef"))
        {
            return new Integer(getCoef());
        }
        if (name.equals("Date"))
        {
            return getDate();
        }
        if (name.equals("CoursId"))
        {
            return new Integer(getCoursId());
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
        if (name.equals("ControleId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setControleId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Coef"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCoef(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Date"))
        {
            // Object fields can be null
            if (value != null && ! Date.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDate((Date) value);
            return true;
        }
        if (name.equals("CoursId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCoursId(((Integer) value).intValue());
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
        if (name.equals(ControlePeer.CONTROLE_ID))
        {
            return new Integer(getControleId());
        }
        if (name.equals(ControlePeer.COEF))
        {
            return new Integer(getCoef());
        }
        if (name.equals(ControlePeer.DATE))
        {
            return getDate();
        }
        if (name.equals(ControlePeer.COURS_ID))
        {
            return new Integer(getCoursId());
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
      if (ControlePeer.CONTROLE_ID.equals(name))
        {
            return setByName("ControleId", value);
        }
      if (ControlePeer.COEF.equals(name))
        {
            return setByName("Coef", value);
        }
      if (ControlePeer.DATE.equals(name))
        {
            return setByName("Date", value);
        }
      if (ControlePeer.COURS_ID.equals(name))
        {
            return setByName("CoursId", value);
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
            return new Integer(getControleId());
        }
        if (pos == 1)
        {
            return new Integer(getCoef());
        }
        if (pos == 2)
        {
            return getDate();
        }
        if (pos == 3)
        {
            return new Integer(getCoursId());
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
            return setByName("ControleId", value);
        }
    if (position == 1)
        {
            return setByName("Coef", value);
        }
    if (position == 2)
        {
            return setByName("Date", value);
        }
    if (position == 3)
        {
            return setByName("CoursId", value);
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
        save(ControlePeer.DATABASE_NAME);
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
                    ControlePeer.doInsert((Controle) this, con);
                    setNew(false);
                }
                else
                {
                    ControlePeer.doUpdate((Controle) this, con);
                }
            }


            if (collNotes != null)
            {
                for (int i = 0; i < collNotes.size(); i++)
                {
                    ((Note) collNotes.get(i)).save(con);
                }
            }
            alreadyInSave = false;
        }
    }


    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key controleId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
        setControleId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
        setControleId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getControleId());
    }
 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public Controle copy() throws TorqueException
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
    public Controle copy(Connection con) throws TorqueException
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
    public Controle copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Controle(), deepcopy);
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
    public Controle copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Controle(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Controle copyInto(Controle copyObj) throws TorqueException
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
    protected Controle copyInto(Controle copyObj, Connection con) throws TorqueException
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
    protected Controle copyInto(Controle copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setControleId(controleId);
        copyObj.setCoef(coef);
        copyObj.setDate(date);
        copyObj.setCoursId(coursId);

        copyObj.setControleId( 0);

        if (deepcopy)
        {


        List vNotes = getNotes();
        if (vNotes != null)
        {
            for (int i = 0; i < vNotes.size(); i++)
            {
                Note obj = (Note) vNotes.get(i);
                copyObj.addNote(obj.copy());
            }
        }
        else
        {
            copyObj.collNotes = null;
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
    protected Controle copyInto(Controle copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setControleId(controleId);
        copyObj.setCoef(coef);
        copyObj.setDate(date);
        copyObj.setCoursId(coursId);

        copyObj.setControleId( 0);

        if (deepcopy)
        {


        List vNotes = getNotes(con);
        if (vNotes != null)
        {
            for (int i = 0; i < vNotes.size(); i++)
            {
                Note obj = (Note) vNotes.get(i);
                copyObj.addNote(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collNotes = null;
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
    public ControlePeer getPeer()
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
        return ControlePeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Controle:\n");
        str.append("ControleId = ")
           .append(getControleId())
           .append("\n");
        str.append("Coef = ")
           .append(getCoef())
           .append("\n");
        str.append("Date = ")
           .append(getDate())
           .append("\n");
        str.append("CoursId = ")
           .append(getCoursId())
           .append("\n");
        return(str.toString());
    }
}
