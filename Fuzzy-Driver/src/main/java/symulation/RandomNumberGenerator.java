package symulation;

/**
 * Created by user on 03.06.2017.
 */
public interface RandomNumberGenerator<T> {
    T generateNumberFromRange(T min, T max);
}
