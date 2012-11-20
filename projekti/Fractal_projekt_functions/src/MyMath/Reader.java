
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
     * @param point
     */
    public Reader(int point)
    {
        this.point = point;
    }
    /**
     * @return the point in which reader currently is.
     */
    public int getPoint()
    {
        return this.point;
    }
    /**
     * Sets new point value in to Reader.
     * @param point 
     */
    public void setPoint(int point)
    {
        this.point = point;
    }
}
