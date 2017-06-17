package app;


import FuzzyLogic.*;
import FuzzyLogic.fuzzySet.FuzzySet;
import FuzzyLogic.membershipFunctions.TriangularMembershipFunction;
import org.apache.log4j.Logger;
import simulation.CarController;
import simulation.JourneySimulation;
import simulation.ai.CleverSiri;
import simulation.ai.Siri;
import simulation.data.LinguisticVariables;
import simulation.generators.PetrolStationGenerator;
import simulation.ai.StupidSiri;
import simulation.data.Car;
import simulation.data.Road;
import simulation.exceptions.OutOfFuelException;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {
        try {
            Car car = new Car();
            Road road = new Road();
            ImplicationController implicationController = new ImplicationController(new XmlRuleSetParser(), "C:\\Users\\user\\Desktop\\Repozytoria\\FuzzyDriverRefueling\\Fuzzy-Driver\\src\\main\\resources\\RuleSet.xml");
            ArrayList<FuzzySet> fuzzySets = new ArrayList<>();
            fuzzySets.add(new FuzzySet("Low", new TriangularMembershipFunction(2,6,8)));
            fuzzySets.add(new FuzzySet("Medium", new TriangularMembershipFunction(7,11,13)));
            fuzzySets.add(new FuzzySet("High", new TriangularMembershipFunction(12,16,18)));
            LinguisticVariable linguisticVariable = new LinguisticVariable("amountOfFuel",fuzzySets);

            Defuzyfier defuzyfier = new Defuzyfier(implicationController, linguisticVariable);


            XMLLinguisticVariablesParser parser = new XMLLinguisticVariablesParser();
            LinguisticVariables linguisticVariablesXML = parser
                    .readFile("C:\\Users\\user\\Desktop\\Repozytoria\\FuzzyDriverRefueling\\Fuzzy-Driver\\src\\main\\resources\\LinguisticVariablesTriangularMembershipFunction.xml");

            Mapper<LinguisticVariable> mapper = new LinguisticVariablesTriangularMapper(linguisticVariablesXML);

            ArrayList<LinguisticVariable> linguisticVariables = mapper.map();


            Fuzzyfier<Float> fuzzyfier = new Fuzzyfier<>(linguisticVariables);
            Siri siri = new CleverSiri(implicationController, defuzyfier,fuzzyfier);

            CarController carController = new CarController(car, road, siri);

            PetrolStationGenerator petrolStationGenerator = new PetrolStationGenerator(road);
            petrolStationGenerator.generateStationsOnTheRoad();


            JourneySimulation journeySimulation = new JourneySimulation(carController, road);


            logger.info("started simulation");
            journeySimulation.startSimulation();
        } catch (OutOfFuelException | LinguisticVariableNotFoundException | JAXBException e) {
            logger.error(e.getMessage());
        }
    }
}
