package simulation.data;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by user on 17.06.2017.
 */
public class FuzzySetBoundaries {
    @XmlAttribute(name = "name")
    public String name;
    @XmlElement
    public float a;
    @XmlElement
    public float b;
    @XmlElement
    public float c;
    @XmlElement
    public float d;

    public FuzzySetBoundaries() {
    }

    public FuzzySetBoundaries(String name, float a, float b, float c, float d) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }



    @Override
    public String toString() {
        return "FuzzySetBoundaries{" +
                "name='" + name + '\'' +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }
}
