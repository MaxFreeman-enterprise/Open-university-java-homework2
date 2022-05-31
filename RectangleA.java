/**The RectangleA class represents a 2D axis aligned integral rectangles.
* @author Max Freeman
*/ 
public class RectangleA
{   
    //constants//
    private int _width;
    private int _height;
    private Point _pointSW;
    private final int DEFAULT_VAL = 1;
    private final int DEFAULT_W_H = 0;
    
    
    //constructors//
    
    /**
     * first constructor for objects of class RectangleA
     * Constructs a new rectangle with the specified width,height
     * and its south west corner is (0,0)
     * 
     */
    public RectangleA(int w, int h)
    {
        
        _pointSW = new Point (0,0);
        
        if(w>DEFAULT_W_H){
            _width = w;
        }
        
        else{
            _width = DEFAULT_VAL;
        }
        
        if(h>DEFAULT_W_H){
            _height = h;
        }
        
        else{
            _height = DEFAULT_VAL;
        }
    }
        
    /**
     * second constructor for objects of class RectangleA
     * Construct a new rectangle with the speficied width,height
     * and south west vertex
     * @param sw - south western vertex
     * @param w - rectangle width
     * @param h - rectangle height
     */
    public RectangleA(Point p, int w, int h) {
        
        this(w,h);
        this._pointSW = new Point(p);
        
    }
    
    
    /**
     * third constructor for objects of class RectangleA
     * Construct a new rectangle with the specified
     * sout west vertex and north east vertx
     */
    
    public RectangleA(Point sw, Point ne){
    // sw - sout western vertex
    // new - north eastern vertex
        _width = ne.getX() - sw.getX();
        _height = ne.getY() - sw.getY();
        _pointSW = new Point(sw);
        
    }
    
    /**
     * Copy constructor for objects of class RectangleA
     * Constructs a rectangle using another rectangle
     */
    public RectangleA(RectangleA r){
        _height = r._height;
        _width = r._width;
        _pointSW = new Point(r._pointSW);
    }
    
    //Methods//
    
    //Get width method//
    
    /**
     * returns the width of the rectangle
     * @return the width of the rectangle
     */
    public int getWidth()
    {
        return _width; // the width of the rectangle
    }
    
    //GetGeight method//
    
    /**
     * return the height of the rectangle
     * @return the height of the rectangle
     */
    public int getHeight()
    {
        return _height; // the height of the rectnagle
    }
    
    //GetPointSW method//
    
    /**
     * returns the South-West point of the rectangle
     * @return a copy of the s-w point of the rectangle
     */
    public Point getPointSW() // a copy of the s-w point of the rectnalge
    {
        return new Point(_pointSW);
    }
    
    //SetWidth method//
    
    /**
     * Sets the width of the rectangle
     * @param w - the width of the rectangle to set to
     */
    public void setWidth(int w)
    {
        if (w>DEFAULT_W_H)
        {
            _width = w; //w - the width of the rectangle to set to
        }
    }
    
    //SetHeight method//
    
    /**
     * sets the height of the rectangle
     * @param h - the height of the rectangle to set to
     */
    public void setHeight(int h)
    {
        if (h>DEFAULT_W_H)
        {
            _height = h; //@param h - the height of the rectangle ot set to
        }
    }
    
    //SetPointSW method//
    
    /**
     * Sets the Sout-West point of the rectangle
     * @param p - the S-W point of the rectangle to set to
     */
    public void setPointSW(Point p)
    {
        _pointSW = new Point (p);

        //_pointSW = new Point (_pointSW); // @param p - the S-W point of the rectangle
    }
    
    //toString method//
    
    /**
     * Returns a string representation of the rectangle
     * @return a string represent the rectangle
     */
    public String toString()
    // a string represent the rectangle for example: Width = 5 Height = 4, PointsSw(2,1)
    {
        
        return "Width=" + _width + " " + "Height=" + _height + " "
        + "PointSW=" + _pointSW.toString();
    
    }
    
    //GetPerimeter method//
    
    /**
     * Calculates the perimeter of the rectangle
     * @return The perimeter of the rectangle.
     */
    public int getPerimeter()
    {
        return (2*_height + 2*_width); // the perimeter of the rectnagle
    }
    
    //GetArea Method//
    
    /**
     * Calculates the area of the rectangle
     * @return The area of the rectangle.
     */
    public int getArea()
    {
        return (_height * _width); // the area of the rectangle
    }
    
    //Move method//
    
    /**
     * Move the rectangle by deltaX in x direction and deltaY in y direction
     * @param deltaY - translate the rectangle deltaY in the y direction.
     * @param deltaX - translate the rectangle deltaX in the x direction.
     */
    public void move(int deltaX, int deltaY)
    {
        _pointSW.move(deltaX, deltaY);
    }
    
    //Equals method//
    
    /**Returns true if the given rectangle is equal to this rectangle
    * @param other - the rectangle to check equality with
    * @return true if other and this rectangle are equal
    */
    public boolean equals(RectangleA other)
    {
        return _width == other.getWidth() && _height == other.getHeight() &&
        _pointSW.equals(other.getPointSW());
    }
    
    //GetDiagonallength method//
    
    /**Returns the length of the rectangle diagonal
    * @return the length of the diagonal of the Rectangle
    */
    public double getDiagonalLength()
    {
        
        
        return this._pointSW.distance(this.getPointNE()); 
        
    }
    
    //IsLarger method//
    
    
    /**Returns true if the current rectangle is larger than the parameter rectangle
    * @param other - another Rectangle to compare with
    * @return true - if the current Rectangle's area is larger than the other
    *  Rectangle which received as parameter, false - otherwise
    */
    public boolean isLarger(RectangleA other)
    {
        return getArea() > other.getArea();
    }
    
    //Get PointNE method//
    
    /**Returns the North-East point of the rectangle
    * @return a copy of the North-East point of the Rectangle
    */
    public Point getPointNE()
    {
        return new Point(this._pointSW.getX() + _width, this._pointSW.getY()
        + _height);
    }
    
    //ChangeSides method//
    
    /**
    * Changes the width to height and vice versa
    */
    public void changeSides()
    {
        int temp;
        temp = _width;
        _width = _height;
        _height = temp;
    }
    
    //IsIn method//
    
    /**
     * Return true if the current rectangle isin the 
     * parameter rectangle
     * @param r - another Rectangle to check with
     * @return true - if the current Rectangles isin
     * the other Rectangle
     * which received as parameter even by a single point,
     * false - otherwise
     */
    public boolean isIn (RectangleA r)
    {
        return !(this._pointSW.isLeft(r.getPointSW()) || this._pointSW.isUnder(r.getPointSW()) ||
        this.getPointNE().isRight(r.getPointNE()) || this.getPointNE().isAbove(r.getPointNE()));
        
        
    }
    
    
    //Overlap method//
    
    /**
     * Return true if the current rectangle overlaps with the 
     * parameter rectangle
     * @param r - another Rectangle to check with
     * @return true - if the current Rectangles overlaps with
     * the other Rectangle
     * which received as parameter even by a single point,
     * false- otherwise
     */
    public boolean overlap(RectangleA r){
        
        return !(r.getPointNE().isLeft(this._pointSW) || r.getPointNE().isUnder(this._pointSW) ||
        r.getPointSW().isRight(this.getPointNE()) || r.getPointSW().isAbove(this.getPointNE()));
        
        
    }
    
}
