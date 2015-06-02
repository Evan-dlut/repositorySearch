package zhao.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Evan on 2015/5/31.
 */
public class ClassAndElement {

    private ClassMessage classMessage;
    private List<Element> elements = new LinkedList<Element>();

    public ClassMessage getClassMessage() {
        return classMessage;
    }

    public void setClassMessage(ClassMessage classMessage) {
        this.classMessage = classMessage;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public void addElement(Element element){
        elements.add(element);
    }
}
