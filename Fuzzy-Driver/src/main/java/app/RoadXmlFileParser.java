package app;

import simulation.data.LinguisticVariables;
import simulation.data.Road;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by user on 17.06.2017.
 */
public class RoadXmlFileParser implements XmlFileParser<Road> {
    @Override
    public Road readFile(String fileName) throws JAXBException {
        File inputFile = new File(fileName);
        JAXBContext jaxbContext = JAXBContext.newInstance(Road.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (Road) jaxbUnmarshaller.unmarshal(inputFile);
    }

    @Override
    public void writeFile(String filename, Road road) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Road.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //Marshal the employees list in console
        jaxbMarshaller.marshal(road, System.out);

        //Marshal the employees list in file
        jaxbMarshaller.marshal(road, new File(filename));
    }
}
