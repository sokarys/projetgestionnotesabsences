package fr.iut2.tc4.projet.torque.map;

import org.apache.torque.TorqueException;

/**
 * This is a Torque Generated class that is used to load all database map 
 * information at once.  This is useful because Torque's default behaviour
 * is to do a "lazy" load of mapping information, e.g. loading it only
 * when it is needed.<p>
 *
 * @see org.apache.torque.map.DatabaseMap#initialize() DatabaseMap.initialize() 
 */
public class GestionMapInit
{
    public static final void init()
        throws TorqueException
    {
        fr.iut2.tc4.projet.torque.EtudiantPeer.getMapBuilder();
        fr.iut2.tc4.projet.torque.AbsencePeer.getMapBuilder();
        fr.iut2.tc4.projet.torque.MatierePeer.getMapBuilder();
        fr.iut2.tc4.projet.torque.ClassePeer.getMapBuilder();
        fr.iut2.tc4.projet.torque.NotePeer.getMapBuilder();
        fr.iut2.tc4.projet.torque.ControlePeer.getMapBuilder();
    }
}
