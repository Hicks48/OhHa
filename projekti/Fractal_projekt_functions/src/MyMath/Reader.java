
package MyMath;

/**
 * Contains value point which tells which
 * point of the String should be read next.
 * @author Henri Korpela
 */
public class Reader {
    private int point;
    /**
     * Creates new reader and sets initial point value.
     * @param point starting point of reader.
     */
    public Reader(int point)
    {
        this.point = point;
    }
    /**
     * Return readers point.
     * @return the point in which reader currently is.
     */
    public int getPoint()
    {
        return this.point;
    }
    /**
     * Sets new point value in to Reader.
     * @param point new value for readers point.
     */
    public void setPoint(int point)
    {
        this.point = point;
    }
}
