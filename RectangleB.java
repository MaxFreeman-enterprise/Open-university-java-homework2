/**The RectangleB class represents a 2D axis aligned integral rectangles.
* @author Max Freeman
*/ 
public class RectangleB
{
    
    private Point _pointSW;
    private Point _pointNE;
    private final int DEFAULT_VAL = 1;
    private final int DEFAULT_W_H = 0;
    
    
    //constructors//
    
    
    /**First constructor for objects of class RectangleB Constructs a new rectangle with the specified width,
    * height and it's south west corner is (0,0)
    * @param width - The rectangle width
    * @param height - The rectangle height
    */
    public RectangleB(int w, int h)
    {
        _pointSW = new Point(0,0);
        if(w<DEFAULT_W_H){
            w = DEFAULT_VAL;
        }    
        if (h<DEFAULT_W_H){
            h = DEFAULT_VAL;
        }
        
        
        int xNE = _pointSW.getX() + w;
        int yNE = _pointSW.getY() + h;
        
        _pointNE = new Point(xNE, yNE);
        
          
    }
        
    /**Second constructor for objects of class RectangleB Constructs a new rectangle with the specified vertices
    * @param p - south western vertex
    * @param w - rectangle width
    * @param h - rectangle height
    */ 
    public RectangleB(Point p, int w, int h) {
        
        _pointSW = new Point (p);
        
        if (w < DEFAULT_W_H)
            w = DEFAULT_VAL;
            
        if (h < DEFAULT_W_H)
            h = DEFAULT_VAL;
            
        _pointNE = new Point (p.getX() + w, p.getY() + h);
        
        
    }
    
    
    /**Third constructor for objects of class RectangleB Constructs a new rectangle with the specified vertices
    * @param sw - south western vertex
    * @param ne - north eastern vertex
    */
    
    public RectangleB(Point sw, Point ne){
    // sw - sout western vertex
    // new - north eastern vertex
    
    
        _pointNE = new Point(ne);
        _pointSW = new Point(sw);
        
    }
    
    /**Copy constructor for objects of class RectangleB Constructs a rectangle using another rectangle
    * @param r - The rectangle from which to construct the new object
    */
    public RectangleB(RectangleB r){
        _pointSW = new Point(r.getPointSW());
        _pointNE = new Point(r.getPointNE());
    }
    
    //get methods//
     
    
    //getWidth method//
     
    /**Returns the width of the rectangle
    * @return the width of the rectangle
    */
    public int getWidth()
    {
        return _pointNE.getX() - _pointSW.getX(); // the width of the rectangle
    }
    
    
    //getHeight method//
     
    /**Returns the height of the rectangle
    * @return the height of the rectangle
    */
    public int getHeight()
    {
        return _pointNE.getY() - _pointSW.getY();
    }
    
    
    /**getPointSW
    * Returns the South-West point of the rectangle
    * @return a copy of the s-w point of the rectangle 
    */
    public Point getPointSW()
    {
        return new Point(_pointSW);
    }
    
    
    /**getPointNE
    * Returns the North-East point of the rectangle
    * @return a copy of the n-e point of the rectangle
    */
    public Point getPointNE()
    {
        return new Point(_pointNE);
    }
    
    
    //getPerimeter method//
     
    /**getPerimeter
    * Calculates the perimeter of the rectangle
    * @return The perimeter of the rectangle.
    */
    public int getPerimeter()
    {
        return 2 * (this.getWidth() + this.getHeight());
    }
    
    
    //getArea method//
     
    /**getArea
    * Calculates the area of the rectangle
    * @return The area of the rectangle.
    */
    public int getArea()
    {
        return this.getWidth() * this.getHeight();
    }
    
    
    //getDiagonalLength method//
     
    /**Returns the length of the rectangle diagonal
    * @return the length of the diagonal of the Rectangle
    */
    public double getDiagonalLength()
    {
        return _pointSW.distance(_pointNE);
        
    }
    
    //set methods//
     
    /**setPointSW
    * Sets the South-West point of the rectangle. This change affects also the NE Point since 
    * the width and height of the rectangle should NOT change
    * @p - the new S-W point of the rectangle
    */
    public void setPointSW(Point p)
    {
        this._pointNE = new Point(p.getX() + this.getWidth(), p.getY() + 
        this.getHeight());
        
        this._pointSW = new Point(p);
    }
   
    
    //setWidth method//
     
    /**Sets the width of the rectangle
    * @param w - the width of the rectangle to set to
    */
    public void setWidth(int w)
    {
        this._pointNE.setX(this._pointSW.getX() + w);
    }
    
    
    //setHeight method//
     
    /**Sets the height of the rectangle
    * @param h - the height of the rectangle to set to
    */
    public void setHeight(int h)
    {
        this._pointNE.setY(this._pointSW.getY() + h);
    }
    
    
    //toString method//
     
    /**Returns a string representation of the rectangle
    * @override toString in class java.lang.Object
    * @return a string represent the rectangle For example: Width=4 Height=6 PointSW=(1,2)
    */
    public String toString()
    {
        return "Width=" + this.getWidth() + " Height=" + this.getHeight() + " PointSW=" + _pointSW.toString();
    }
    
    
    
    //move method//
     
    /**move
    * Move the rectangle by deltaX in x direction and deltaY in y direction
    * @param deltaX - translate the rectangle deltaX in the x direction.
    * @param deltaY - translate the rectangle deltaY in the y direction.
    */
    public void move(int deltaX, int deltaY)
    {
        this._pointSW.move(deltaX,deltaY);
        this._pointNE.move(deltaX,deltaY);
    }
    
    
    //equals method//
     
    /**Returns true iff the given rectangle is equal to this rectangle
    * @param other - the rectangle to check equality with
    * @return true iff other and this rectangle are equal
    */
    
    public boolean equals(RectangleB other)
    {
        return this._pointNE.equals(other.getPointNE()) &&
        this._pointSW.equals(other.getPointSW());
        
        
    }
    
    
    //isLarger method//
     
    /**Returns true if the current rectangle is larger than the parameter rectangle
    * @param other - another Rectangle to compare with
    * @return true - if the current Rectangle's area is larger than the other Rectangle which received as parameter, false - otherwise
    */
    public boolean isLarger(RectangleB other)
    {
        return this.getArea() > other.getArea();
    }
    
    
    //changeSides method//
     
    /**Changes the width to height and vice versa
    */
    public void changeSide()
    {
        _pointNE = new Point(this._pointSW.getX() + this.getHeight(),
        this._pointSW.getY() + this.getWidth());
    }
    
    
    //isIn method//
     
    /**Returns true if the current rectangle is in the parameter rectangle
    * @param r - another Rectangle to check with
    * @return true - if the current Rectangle's completely in the other Rectangle which received as parameter, false - otherwise
    */
    public boolean isIn (RectangleB r)
    {
        return !(this._pointSW.isLeft(r.getPointSW()) || this._pointSW.isUnder(r.getPointSW()) ||
        this.getPointNE().isRight(r.getPointNE()) || this.getPointNE().isAbove(r.getPointNE()));
        
        
    }
    
    
    //overlap method//
     
    /**Returns true if the current rectangle overlaps with the parameter rectangle
    * @param r - another Rectangle to check with
    * @return true - if the current Rectangle's overlaps with the other Rectangle which received
    * as parameter even by a single point, false - otherwise
    */
    public boolean overlap(RectangleB r){
        
        return !(r.getPointNE().isLeft(this._pointSW) || r.getPointNE().isUnder(this._pointSW) ||
        r.getPointSW().isRight(this.getPointNE()) || r.getPointSW().isAbove(this.getPointNE()));
        
        
    }
}
