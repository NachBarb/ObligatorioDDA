/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Martin
 */
public abstract class Observable {
    private HashSet<Observer> observers;

    public Observable() {
        observers = new HashSet();
    }
    
    public void addObserver(Observer obs) {
        observers.add(obs);
    }
    
    public void deleteObserver(Observer obs) {
        observers.remove(obs);
    }
    
    public void notifyObservers(Object event) {
        for (Iterator<Observer> iterator = observers.iterator(); iterator.hasNext();) {
            Observer o = iterator.next();
            o.update(this, event);
        }
    }
}
