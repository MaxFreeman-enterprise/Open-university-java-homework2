
/**
 * Write a description of class Point here.
 *
 * @Max Freeman
 * @Data 27.11.2021
 * @version (a version number or a date)
 */
public class Point
{
    //declarations
    private int _x;
    private int _y;
    
    
    //constructors
    
    /**
     * Construct a point.
     * @param x The x coordinate
     * @param y The y coordinate
     */
    public Point(int x, int y)
    {
        
         _x = x;
         _y = y;

    }
    
    
    /**
     * Copy constructor for Point.
     * Construct a point with the same coordinates as other point.
     * @param other The point object from which to construct the new point
     */
    public Point(Point other)
    {
        _x = other.getX();
        _y = other.getY();
    }
    
    
    /**
     * Returns the x coordinate of the point.
     * @return The x coordinate of the point.
     */
    public int getX()
    {
        return _x;
    }
    
    
    /**
     * Returns the y coordinate of the point.
     * @return The y coordinate of the point.
     */
    public int getY()
    {
        return _y;
    }
    
    
    /**
     * Sets the x coordinate of the point.
     * @param x The new x coordinate
     */
    public void setX(int x)
    {
        _x = x;
        
    }
    
    
    /**
     * Sets the y coordinate of the point.
     * @param y The new y coordinate
     */
    public void setY(int y)
    {
        _y = y;
        
    }
    
    
    /**
     * Returns a string representation of this point.
     * @return String representation of this point
     */
    public String toString()
    {
        return "(" + _x + "," + _y + ")";
    }
    
    
    /**
     * check if this point equals other point.
     * @param other the point to be compared with this point
     * @return true of this point equals other point
     */
    public boolean equals(Point other)
    {
        return (other.getX()==_x && other.getY()==_y);
    }
    
    
    /**
     * check if this point is above other point.
     * @param other the point to be compared with this point
     * @return true if this point is above other point
     */
    public boolean isAbove(Point other)
    {
        return other.getY()<_y;
    }
    
    
    /**
     * Check if this point os under other point.
     * @param other The point to check if this point is under
     * @return true if this point is under other point
     */
    public boolean isUnder(Point other)
    {
        return other.isAbove(this);
    }
    
    
    /**
     * Check if this point is to the left of other point.
     * @param other the point to check if this point is left of
     * @return true if this point is to the left of other point
     */
    public boolean isLeft(Point other)
    {
        return _x<other.getX();
    }
    
    
    /**
     * check if this point is to the right of other point.
     * @param other the point to check if this point is right of
     * @return true if this point is to the right of other point
     */
    public boolean isRight(Point other)
    {
        return other.isLeft(this);
    }
    
    
    /**
     * Calculate the distance between this point and other point.
     * @param p the point to calculate the distance from
     * @return the distance between this and p points
     */
    public double distance(Point p)
    {
        return Math.sqrt(Math.pow((_x - p._x),2)+ Math.pow((_y - p._y),2));
    
    }
    
    
    /**
     * Moves the x coordinate by deltaX and the y coordinate by deltaY.
     * if movement moves the point outside first guardrant then the
     * point will remain at the same place and not move.
     * @param deltaX the amount to move in the x direction
     * @param deltaY the amount to move in the y direction
     */
    public void move(int deltaX, int deltaY)
    {
        _x += deltaX;
        _y += deltaY;
    }
    
    
}
