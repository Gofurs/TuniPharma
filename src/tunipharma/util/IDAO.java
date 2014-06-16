/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tunipharma.util;

/**
 *
 * @author Azza
 */
public interface IDAO<E,T> {
    
    public void create();
    public boolean insert(E obj);
    
    
    
}
