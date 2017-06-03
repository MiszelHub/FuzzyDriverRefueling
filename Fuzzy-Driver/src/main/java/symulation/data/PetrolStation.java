package symulation.data;

/**
 * Created by user on 03.06.2017.
 */
public class PetrolStation
{
    private int position = 0;
    private float petrolPrice = 3.5f;

    public PetrolStation(int position, float petrolPrice)
    {
        this.position = position;
        this.petrolPrice = petrolPrice;
    }

    public int getPosition()
    {
        return position;
    }

    public float getPetrolPrice()
    {
        return petrolPrice;
    }
}
