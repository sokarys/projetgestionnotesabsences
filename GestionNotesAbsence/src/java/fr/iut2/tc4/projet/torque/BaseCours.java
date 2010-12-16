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
 * Table des cours
 *
 * This class was autogenerated by Torque on:
 *
 * [Thu Dec 16 15:44:26 CET 2010]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Cours
 */
public abstract class BaseCours extends BaseObject
{
    /** Serial version */
    private static final long serialVersionUID = 1292510666562L;

    /** The Peer class */
    private static final CoursPeer peer =
        new CoursPeer();


    /** The value for the coursId field */
    private int coursId;

    /** The value for the matiereId field */
    private int matiereId;

    /** The value for the classeId field */
    private int classeId;


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



        // update associated Controle
        if (collControles != null)
        {
            for (int i = 0; i < collControles.size(); i++)
            {
                ((Controle) collControles.get(i))
                        .setCoursId(v);
            }
        }
    }

    /**
     * Get the MatiereId
     *
     * @return int
     */
    public int getMatiereId()
    {
        return matiereId;
    }


    /**
     * Set the value of MatiereId
     *
     * @param v new value
     */
    public void setMatiereId(int v) throws TorqueException
    {

        if (this.matiereId != v)
        {
            this.matiereId = v;
            setModified(true);
        }


        if (aMatiere != null && !(aMatiere.getMatiereId() == v))
        {
            aMatiere = null;
        }

    }

    /**
     * Get the ClasseId
     *
     * @return int
     */
    public int getClasseId()
    {
        return classeId;
    }


    /**
     * Set the value of ClasseId
     *
     * @param v new value
     */
    public void setClasseId(int v) throws TorqueException
    {

        if (this.classeId != v)
        {
            this.classeId = v;
            setModified(true);
        }


        if (aClasse != null && !(aClasse.getClasseId() == v))
        {
            aClasse = null;
        }

    }

    



    private Matiere aMatiere;

    /**
     * Declares an association between this object and a Matiere object
     *
     * @param v Matiere
     * @throws TorqueException
     */
    public void setMatiere(Matiere v) throws TorqueException
    {
        if (v == null)
        {
            setMatiereId( 0);
        }
        else
        {
            setMatiereId(v.getMatiereId());
        }
        aMatiere = v;
    }


    /**
     * Returns the associated Matiere object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated Matiere object
     * @throws TorqueException
     */
    public Matiere getMatiere()
        throws TorqueException
    {
        if (aMatiere == null && (this.matiereId != 0))
        {
            aMatiere = MatierePeer.retrieveByPK(SimpleKey.keyFor(this.matiereId));
        }
        return aMatiere;
    }

    /**
     * Return the associated Matiere object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated Matiere object
     * @throws TorqueException
     */
    public Matiere getMatiere(Connection connection)
        throws TorqueException
    {
        if (aMatiere == null && (this.matiereId != 0))
        {
            aMatiere = MatierePeer.retrieveByPK(SimpleKey.keyFor(this.matiereId), connection);
        }
        return aMatiere;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setMatiereKey(ObjectKey key) throws TorqueException
    {

        setMatiereId(((NumberKey) key).intValue());
    }




    private Classe aClasse;

    /**
     * Declares an association between this object and a Classe object
     *
     * @param v Classe
     * @throws TorqueException
     */
    public void setClasse(Classe v) throws TorqueException
    {
        if (v == null)
        {
            setClasseId( 0);
        }
        else
        {
            setClasseId(v.getClasseId());
        }
        aClasse = v;
    }


    /**
     * Returns the associated Classe object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated Classe object
     * @throws TorqueException
     */
    public Classe getClasse()
        throws TorqueException
    {
        if (aClasse == null && (this.classeId != 0))
        {
            aClasse = ClassePeer.retrieveByPK(SimpleKey.keyFor(this.classeId));
        }
        return aClasse;
    }

    /**
     * Return the associated Classe object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated Classe object
     * @throws TorqueException
     */
    public Classe getClasse(Connection connection)
        throws TorqueException
    {
        if (aClasse == null && (this.classeId != 0))
        {
            aClasse = ClassePeer.retrieveByPK(SimpleKey.keyFor(this.classeId), connection);
        }
        return aClasse;
    }

    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setClasseKey(ObjectKey key) throws TorqueException
    {

        setClasseId(((NumberKey) key).intValue());
    }
   


    /**
     * Collection to store aggregation of collControles
     */
    protected List collControles;

    /**
     * Temporary storage of collControles to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initControles()
    {
        if (collControles == null)
        {
            collControles = new ArrayList();
        }
    }


    /**
     * Method called to associate a Controle object to this object
     * through the Controle foreign key attribute
     *
     * @param l Controle
     * @throws TorqueException
     */
    public void addControle(Controle l) throws TorqueException
    {
        getControles().add(l);
        l.setCours((Cours) this);
    }

    /**
     * Method called to associate a Controle object to this object
     * through the Controle foreign key attribute using connection.
     *
     * @param l Controle
     * @throws TorqueException
     */
    public void addControle(Controle l, Connection con) throws TorqueException
    {
        getControles(con).add(l);
        l.setCours((Cours) this);
    }

    /**
     * The criteria used to select the current contents of collControles
     */
    private Criteria lastControlesCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getControles(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List getControles()
        throws TorqueException
    {
        if (collControles == null)
        {
            collControles = getControles(new Criteria(10));
        }
        return collControles;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Cours has previously
     * been saved, it will retrieve related Controles from storage.
     * If this Cours is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List getControles(Criteria criteria) throws TorqueException
    {
        if (collControles == null)
        {
            if (isNew())
            {
               collControles = new ArrayList();
            }
            else
            {
                criteria.add(ControlePeer.COURS_ID, getCoursId() );
                collControles = ControlePeer.doSelect(criteria);
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
                criteria.add(ControlePeer.COURS_ID, getCoursId());
                if (!lastControlesCriteria.equals(criteria))
                {
                    collControles = ControlePeer.doSelect(criteria);
                }
            }
        }
        lastControlesCriteria = criteria;

        return collControles;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getControles(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getControles(Connection con) throws TorqueException
    {
        if (collControles == null)
        {
            collControles = getControles(new Criteria(10), con);
        }
        return collControles;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Cours has previously
     * been saved, it will retrieve related Controles from storage.
     * If this Cours is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getControles(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collControles == null)
        {
            if (isNew())
            {
               collControles = new ArrayList();
            }
            else
            {
                 criteria.add(ControlePeer.COURS_ID, getCoursId());
                 collControles = ControlePeer.doSelect(criteria, con);
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
                 criteria.add(ControlePeer.COURS_ID, getCoursId());
                 if (!lastControlesCriteria.equals(criteria))
                 {
                     collControles = ControlePeer.doSelect(criteria, con);
                 }
             }
         }
         lastControlesCriteria = criteria;

         return collControles;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Cours is new, it will return
     * an empty collection; or if this Cours has previously
     * been saved, it will retrieve related Controles from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Cours.
     */
    protected List getControlesJoinCours(Criteria criteria)
        throws TorqueException
    {
        if (collControles == null)
        {
            if (isNew())
            {
               collControles = new ArrayList();
            }
            else
            {
                criteria.add(ControlePeer.COURS_ID, getCoursId());
                collControles = ControlePeer.doSelectJoinCours(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(ControlePeer.COURS_ID, getCoursId());
            if (!lastControlesCriteria.equals(criteria))
            {
                collControles = ControlePeer.doSelectJoinCours(criteria);
            }
        }
        lastControlesCriteria = criteria;

        return collControles;
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
            fieldNames.add("CoursId");
            fieldNames.add("MatiereId");
            fieldNames.add("ClasseId");
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
        if (name.equals("CoursId"))
        {
            return new Integer(getCoursId());
        }
        if (name.equals("MatiereId"))
        {
            return new Integer(getMatiereId());
        }
        if (name.equals("ClasseId"))
        {
            return new Integer(getClasseId());
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
        if (name.equals("CoursId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setCoursId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("MatiereId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMatiereId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ClasseId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setClasseId(((Integer) value).intValue());
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
        if (name.equals(CoursPeer.COURS_ID))
        {
            return new Integer(getCoursId());
        }
        if (name.equals(CoursPeer.MATIERE_ID))
        {
            return new Integer(getMatiereId());
        }
        if (name.equals(CoursPeer.CLASSE_ID))
        {
            return new Integer(getClasseId());
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
      if (CoursPeer.COURS_ID.equals(name))
        {
            return setByName("CoursId", value);
        }
      if (CoursPeer.MATIERE_ID.equals(name))
        {
            return setByName("MatiereId", value);
        }
      if (CoursPeer.CLASSE_ID.equals(name))
        {
            return setByName("ClasseId", value);
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
            return new Integer(getCoursId());
        }
        if (pos == 1)
        {
            return new Integer(getMatiereId());
        }
        if (pos == 2)
        {
            return new Integer(getClasseId());
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
            return setByName("CoursId", value);
        }
    if (position == 1)
        {
            return setByName("MatiereId", value);
        }
    if (position == 2)
        {
            return setByName("ClasseId", value);
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
        save(CoursPeer.DATABASE_NAME);
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
                    CoursPeer.doInsert((Cours) this, con);
                    setNew(false);
                }
                else
                {
                    CoursPeer.doUpdate((Cours) this, con);
                }
            }


            if (collControles != null)
            {
                for (int i = 0; i < collControles.size(); i++)
                {
                    ((Controle) collControles.get(i)).save(con);
                }
            }
            alreadyInSave = false;
        }
    }


    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key coursId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
        setCoursId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
        setCoursId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getCoursId());
    }
 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public Cours copy() throws TorqueException
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
    public Cours copy(Connection con) throws TorqueException
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
    public Cours copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Cours(), deepcopy);
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
    public Cours copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Cours(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Cours copyInto(Cours copyObj) throws TorqueException
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
    protected Cours copyInto(Cours copyObj, Connection con) throws TorqueException
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
    protected Cours copyInto(Cours copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setCoursId(coursId);
        copyObj.setMatiereId(matiereId);
        copyObj.setClasseId(classeId);

        copyObj.setCoursId( 0);

        if (deepcopy)
        {


        List vControles = getControles();
        if (vControles != null)
        {
            for (int i = 0; i < vControles.size(); i++)
            {
                Controle obj = (Controle) vControles.get(i);
                copyObj.addControle(obj.copy());
            }
        }
        else
        {
            copyObj.collControles = null;
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
    protected Cours copyInto(Cours copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setCoursId(coursId);
        copyObj.setMatiereId(matiereId);
        copyObj.setClasseId(classeId);

        copyObj.setCoursId( 0);

        if (deepcopy)
        {


        List vControles = getControles(con);
        if (vControles != null)
        {
            for (int i = 0; i < vControles.size(); i++)
            {
                Controle obj = (Controle) vControles.get(i);
                copyObj.addControle(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collControles = null;
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
    public CoursPeer getPeer()
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
        return CoursPeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Cours:\n");
        str.append("CoursId = ")
           .append(getCoursId())
           .append("\n");
        str.append("MatiereId = ")
           .append(getMatiereId())
           .append("\n");
        str.append("ClasseId = ")
           .append(getClasseId())
           .append("\n");
        return(str.toString());
    }
}