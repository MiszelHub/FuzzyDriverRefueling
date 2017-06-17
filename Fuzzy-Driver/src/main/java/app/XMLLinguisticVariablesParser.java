package app;

import FuzzyLogic.LinguisticVariable;
import FuzzyLogic.RuleSet.RuleSet;
import simulation.data.LinguisticVariables;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by user on 17.06.2017.
 */
public class XMLLinguisticVariablesParser implements XmlFileParser<LinguisticVariables> {

    @Override
    public LinguisticVariables readFile(String fileName) throws JAXBException {
        File inputFile = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(LinguisticVariables.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (LinguisticVariables) jaxbUnmarshaller.unmarshal(inputFile);
    }
}
