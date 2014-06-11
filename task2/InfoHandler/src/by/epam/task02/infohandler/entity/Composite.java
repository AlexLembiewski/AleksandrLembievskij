
package by.epam.task02.infohandler.entity;

import java.util.List;

/**
 *
 * @author Администратор
 * @param <T>
 */
public interface Composite<T> {
    
    public void add(T value);
    public T getChildElement(int index);
    public List getAllElements();
    public void remove(T value);

}
