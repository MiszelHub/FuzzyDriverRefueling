package FuzzyLogic;

import javax.xml.bind.JAXBException;

/**
 * Created by user on 10.06.2017.
 */
public interface XmlFileParser<T> {
    T readFile(String fileName) throws JAXBException;
}
