/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.core.lookup;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tina
 */
public class Lookup {
    
    Map<Class, Object> services = new HashMap<>() ; 
    PropertyChangeSupport pcs = new PropertyChangeSupport(this) ;
    List<LookupListener> listeners = new LinkedList<>();

    public <T> void register (Class<? super T> service, T instance){
        services.put(service, instance) ;
    }

    public void registremontre(LookupListener montre){
        listeners.add(montre);
    }
    
    public <T> T getService (Class<T> service){
        T instance = (T) services.get(service) ;
        return  instance ; 
    }
    
    private Lookup() {
    }
    
    public static Lookup getInstance() {
        return LookupHolder.INSTANCE;
    }
    
    private static class LookupHolder {

        private static final Lookup INSTANCE = new Lookup();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public void notifyMontre(){
        for (LookupListener ls : listeners){
            ls.notifyMontre();
        }
    }
}
