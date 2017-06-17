package app;

import FuzzyLogic.RuleSet.RuleSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by user on 10.06.2017.
 */
public class XmlRuleSetParser implements XmlFileParser<RuleSet> {

    @Override
    public RuleSet readFile(String fileName) throws JAXBException {
        File inputFile = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(RuleSet.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (RuleSet) jaxbUnmarshaller.unmarshal(inputFile);
    }

    @Override
    public void writeFile(String filename, RuleSet object) throws JAXBException {

    }
}
