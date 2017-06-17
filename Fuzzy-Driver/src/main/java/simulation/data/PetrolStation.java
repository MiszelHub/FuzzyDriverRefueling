package simulation.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by user on 03.06.2017.
 */
public class PetrolStation {
    @XmlElement
    private int position = 0;
    @XmlElement
    private float petrolPrice = 3.5f;

    public PetrolStation() {
    }

    public PetrolStation(int position, float petrolPrice) {
        this.position = position;
        this.petrolPrice = petrolPrice;
    }

    @XmlTransient
    public int getPosition() {
        return position;
    }

    @XmlTransient
    public float getPetrolPrice() {
        return petrolPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PetrolStation station = (PetrolStation) o;

        if (position != station.position) return false;
        return Float.compare(station.petrolPrice, petrolPrice) == 0;
    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + ( petrolPrice != +0.0f ? Float.floatToIntBits(petrolPrice) : 0 );
        return result;
    }

    @Override
    public String toString() {
        return "PetrolStation{" +
                "position=" + position +
                ", petrolPrice=" + petrolPrice +
                '}';
    }
}
