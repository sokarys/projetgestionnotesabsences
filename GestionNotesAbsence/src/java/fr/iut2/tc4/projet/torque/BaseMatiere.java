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
 * Table des matieres
 *
 * This class was autogenerated by Torque on:
 *
 * [Sun Dec 19 12:20:45 CET 2010]
 *
 * You should not use this class directly.  It should not even be
 * extended all references should be to Matiere
 */
public abstract class BaseMatiere extends BaseObject
{
    /** Serial version */
    private static final long serialVersionUID = 1292757645631L;

    /** The Peer class */
    private static final MatierePeer peer =
        new MatierePeer();


    /** The value for the matiereId field */
    private int matiereId;

    /** The value for the nom field */
    private String nom;

    /** The value for the description field */
    private String description;

    /** The value for the prof field */
    private String prof;


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



        // update associated Cours
        if (collCourss != null)
        {
            for (int i = 0; i < collCourss.size(); i++)
            {
                ((Cours) collCourss.get(i))
                        .setMatiereId(v);
            }
        }
    }

    /**
     * Get the Nom
     *
     * @return String
     */
    public String getNom()
    {
        return nom;
    }


    /**
     * Set the value of Nom
     *
     * @param v new value
     */
    public void setNom(String v) 
    {

        if (!ObjectUtils.equals(this.nom, v))
        {
            this.nom = v;
            setModified(true);
        }


    }

    /**
     * Get the Description
     *
     * @return String
     */
    public String getDescription()
    {
        return description;
    }


    /**
     * Set the value of Description
     *
     * @param v new value
     */
    public void setDescription(String v) 
    {

        if (!ObjectUtils.equals(this.description, v))
        {
            this.description = v;
            setModified(true);
        }


    }

    /**
     * Get the Prof
     *
     * @return String
     */
    public String getProf()
    {
        return prof;
    }


    /**
     * Set the value of Prof
     *
     * @param v new value
     */
    public void setProf(String v) 
    {

        if (!ObjectUtils.equals(this.prof, v))
        {
            this.prof = v;
            setModified(true);
        }


    }

       


    /**
     * Collection to store aggregation of collCourss
     */
    protected List collCourss;

    /**
     * Temporary storage of collCourss to save a possible db hit in
     * the event objects are add to the collection, but the
     * complete collection is never requested.
     */
    protected void initCourss()
    {
        if (collCourss == null)
        {
            collCourss = new ArrayList();
        }
    }


    /**
     * Method called to associate a Cours object to this object
     * through the Cours foreign key attribute
     *
     * @param l Cours
     * @throws TorqueException
     */
    public void addCours(Cours l) throws TorqueException
    {
        getCourss().add(l);
        l.setMatiere((Matiere) this);
    }

    /**
     * Method called to associate a Cours object to this object
     * through the Cours foreign key attribute using connection.
     *
     * @param l Cours
     * @throws TorqueException
     */
    public void addCours(Cours l, Connection con) throws TorqueException
    {
        getCourss(con).add(l);
        l.setMatiere((Matiere) this);
    }

    /**
     * The criteria used to select the current contents of collCourss
     */
    private Criteria lastCourssCriteria = null;

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCourss(new Criteria())
     *
     * @return the collection of associated objects
     * @throws TorqueException
     */
    public List getCourss()
        throws TorqueException
    {
        if (collCourss == null)
        {
            collCourss = getCourss(new Criteria(10));
        }
        return collCourss;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Matiere has previously
     * been saved, it will retrieve related Courss from storage.
     * If this Matiere is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     *
     * @throws TorqueException
     */
    public List getCourss(Criteria criteria) throws TorqueException
    {
        if (collCourss == null)
        {
            if (isNew())
            {
               collCourss = new ArrayList();
            }
            else
            {
                criteria.add(CoursPeer.MATIERE_ID, getMatiereId() );
                collCourss = CoursPeer.doSelect(criteria);
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
                criteria.add(CoursPeer.MATIERE_ID, getMatiereId());
                if (!lastCourssCriteria.equals(criteria))
                {
                    collCourss = CoursPeer.doSelect(criteria);
                }
            }
        }
        lastCourssCriteria = criteria;

        return collCourss;
    }

    /**
     * If this collection has already been initialized, returns
     * the collection. Otherwise returns the results of
     * getCourss(new Criteria(),Connection)
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getCourss(Connection con) throws TorqueException
    {
        if (collCourss == null)
        {
            collCourss = getCourss(new Criteria(10), con);
        }
        return collCourss;
    }

    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Matiere has previously
     * been saved, it will retrieve related Courss from storage.
     * If this Matiere is new, it will return
     * an empty collection or the current collection, the criteria
     * is ignored on a new object.
     * This method takes in the Connection also as input so that
     * referenced objects can also be obtained using a Connection
     * that is taken as input
     */
    public List getCourss(Criteria criteria, Connection con)
            throws TorqueException
    {
        if (collCourss == null)
        {
            if (isNew())
            {
               collCourss = new ArrayList();
            }
            else
            {
                 criteria.add(CoursPeer.MATIERE_ID, getMatiereId());
                 collCourss = CoursPeer.doSelect(criteria, con);
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
                 criteria.add(CoursPeer.MATIERE_ID, getMatiereId());
                 if (!lastCourssCriteria.equals(criteria))
                 {
                     collCourss = CoursPeer.doSelect(criteria, con);
                 }
             }
         }
         lastCourssCriteria = criteria;

         return collCourss;
     }











    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Matiere is new, it will return
     * an empty collection; or if this Matiere has previously
     * been saved, it will retrieve related Courss from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Matiere.
     */
    protected List getCourssJoinMatiere(Criteria criteria)
        throws TorqueException
    {
        if (collCourss == null)
        {
            if (isNew())
            {
               collCourss = new ArrayList();
            }
            else
            {
                criteria.add(CoursPeer.MATIERE_ID, getMatiereId());
                collCourss = CoursPeer.doSelectJoinMatiere(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CoursPeer.MATIERE_ID, getMatiereId());
            if (!lastCourssCriteria.equals(criteria))
            {
                collCourss = CoursPeer.doSelectJoinMatiere(criteria);
            }
        }
        lastCourssCriteria = criteria;

        return collCourss;
    }









    /**
     * If this collection has already been initialized with
     * an identical criteria, it returns the collection.
     * Otherwise if this Matiere is new, it will return
     * an empty collection; or if this Matiere has previously
     * been saved, it will retrieve related Courss from storage.
     *
     * This method is protected by default in order to keep the public
     * api reasonable.  You can provide public methods for those you
     * actually need in Matiere.
     */
    protected List getCourssJoinClasse(Criteria criteria)
        throws TorqueException
    {
        if (collCourss == null)
        {
            if (isNew())
            {
               collCourss = new ArrayList();
            }
            else
            {
                criteria.add(CoursPeer.MATIERE_ID, getMatiereId());
                collCourss = CoursPeer.doSelectJoinClasse(criteria);
            }
        }
        else
        {
            // the following code is to determine if a new query is
            // called for.  If the criteria is the same as the last
            // one, just return the collection.
            criteria.add(CoursPeer.MATIERE_ID, getMatiereId());
            if (!lastCourssCriteria.equals(criteria))
            {
                collCourss = CoursPeer.doSelectJoinClasse(criteria);
            }
        }
        lastCourssCriteria = criteria;

        return collCourss;
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
            fieldNames.add("MatiereId");
            fieldNames.add("Nom");
            fieldNames.add("Description");
            fieldNames.add("Prof");
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
        if (name.equals("MatiereId"))
        {
            return new Integer(getMatiereId());
        }
        if (name.equals("Nom"))
        {
            return getNom();
        }
        if (name.equals("Description"))
        {
            return getDescription();
        }
        if (name.equals("Prof"))
        {
            return getProf();
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
        if (name.equals("MatiereId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMatiereId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Nom"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setNom((String) value);
            return true;
        }
        if (name.equals("Description"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setDescription((String) value);
            return true;
        }
        if (name.equals("Prof"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setProf((String) value);
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
        if (name.equals(MatierePeer.MATIERE_ID))
        {
            return new Integer(getMatiereId());
        }
        if (name.equals(MatierePeer.NOM))
        {
            return getNom();
        }
        if (name.equals(MatierePeer.DESCRIPTION))
        {
            return getDescription();
        }
        if (name.equals(MatierePeer.PROF))
        {
            return getProf();
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
      if (MatierePeer.MATIERE_ID.equals(name))
        {
            return setByName("MatiereId", value);
        }
      if (MatierePeer.NOM.equals(name))
        {
            return setByName("Nom", value);
        }
      if (MatierePeer.DESCRIPTION.equals(name))
        {
            return setByName("Description", value);
        }
      if (MatierePeer.PROF.equals(name))
        {
            return setByName("Prof", value);
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
            return new Integer(getMatiereId());
        }
        if (pos == 1)
        {
            return getNom();
        }
        if (pos == 2)
        {
            return getDescription();
        }
        if (pos == 3)
        {
            return getProf();
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
            return setByName("MatiereId", value);
        }
    if (position == 1)
        {
            return setByName("Nom", value);
        }
    if (position == 2)
        {
            return setByName("Description", value);
        }
    if (position == 3)
        {
            return setByName("Prof", value);
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
        save(MatierePeer.DATABASE_NAME);
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
                    MatierePeer.doInsert((Matiere) this, con);
                    setNew(false);
                }
                else
                {
                    MatierePeer.doUpdate((Matiere) this, con);
                }
            }


            if (collCourss != null)
            {
                for (int i = 0; i < collCourss.size(); i++)
                {
                    ((Cours) collCourss.get(i)).save(con);
                }
            }
            alreadyInSave = false;
        }
    }


    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key matiereId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        throws TorqueException
    {
        setMatiereId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) throws TorqueException
    {
        setMatiereId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getMatiereId());
    }
 

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public Matiere copy() throws TorqueException
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
    public Matiere copy(Connection con) throws TorqueException
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
    public Matiere copy(boolean deepcopy) throws TorqueException
    {
        return copyInto(new Matiere(), deepcopy);
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
    public Matiere copy(boolean deepcopy, Connection con) throws TorqueException
    {
        return copyInto(new Matiere(), deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    protected Matiere copyInto(Matiere copyObj) throws TorqueException
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
    protected Matiere copyInto(Matiere copyObj, Connection con) throws TorqueException
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
    protected Matiere copyInto(Matiere copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setMatiereId(matiereId);
        copyObj.setNom(nom);
        copyObj.setDescription(description);
        copyObj.setProf(prof);

        copyObj.setMatiereId( 0);

        if (deepcopy)
        {


        List vCourss = getCourss();
        if (vCourss != null)
        {
            for (int i = 0; i < vCourss.size(); i++)
            {
                Cours obj = (Cours) vCourss.get(i);
                copyObj.addCours(obj.copy());
            }
        }
        else
        {
            copyObj.collCourss = null;
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
    protected Matiere copyInto(Matiere copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setMatiereId(matiereId);
        copyObj.setNom(nom);
        copyObj.setDescription(description);
        copyObj.setProf(prof);

        copyObj.setMatiereId( 0);

        if (deepcopy)
        {


        List vCourss = getCourss(con);
        if (vCourss != null)
        {
            for (int i = 0; i < vCourss.size(); i++)
            {
                Cours obj = (Cours) vCourss.get(i);
                copyObj.addCours(obj.copy(con), con);
            }
        }
        else
        {
            copyObj.collCourss = null;
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
    public MatierePeer getPeer()
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
        return MatierePeer.getTableMap();
    }


    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Matiere:\n");
        str.append("MatiereId = ")
           .append(getMatiereId())
           .append("\n");
        str.append("Nom = ")
           .append(getNom())
           .append("\n");
        str.append("Description = ")
           .append(getDescription())
           .append("\n");
        str.append("Prof = ")
           .append(getProf())
           .append("\n");
        return(str.toString());
    }
}
