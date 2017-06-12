package app;


import FuzzyLogic.*;
import FuzzyLogic.fuzzySet.FuzzySet;
import FuzzyLogic.membershipFunctions.TriangularMembershipFunction;
import org.apache.log4j.Logger;
import symulation.CarController;
import symulation.JourneySimulation;
import symulation.ai.CleverSiri;
import symulation.ai.Siri;
import symulation.generators.PetrolStationGenerator;
import symulation.ai.StupidSiri;
import symulation.data.Car;
import symulation.data.Road;
import symulation.exceptions.OutOfFuelException;

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
            ImplicationController implicationController = new ImplicationController(new XmlRuleSetParser(), "../resources/RuleSet.xml");
            ArrayList<FuzzySet> fuzzySets = new ArrayList<>();
            fuzzySets.add(new FuzzySet("Low", new TriangularMembershipFunction(2,6,8)));
            fuzzySets.add(new FuzzySet("Medium", new TriangularMembershipFunction(7,11,13)));
            fuzzySets.add(new FuzzySet("High", new TriangularMembershipFunction(12,16,18)));
            LinguisticVariable linguisticVariable = new LinguisticVariable("amountOfFuel",fuzzySets);

            Defuzyfier defuzyfier = new Defuzyfier(implicationController, linguisticVariable);

            ArrayList<LinguisticVariable> linguisticVariables = new ArrayList<>();
            //TODO: Wymyslić przedziały zbiorów rozmytych dla Trapeziodalneij i Trójkątnej funkcji przynaleznosci dla wszystkoich zmiennych :(

            Fuzzyfier<Float> fuzzyfier = new Fuzzyfier<>(linguisticVariables);
            Siri siri = new CleverSiri(implicationController, defuzyfier,fuzzyfier);
            CarController carController = new CarController(car, road, new StupidSiri());

            PetrolStationGenerator petrolStationGenerator = new PetrolStationGenerator(road);
            petrolStationGenerator.generateStationsOnTheRoad();


            JourneySimulation journeySimulation = new JourneySimulation(carController, road);


            logger.info("started simulation");
            journeySimulation.startSimulation();
        } catch (OutOfFuelException | LinguisticVariableNotFoundException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
