# design-patterns
**Factory Pattern**

We can refer to constructors just like we refer to methods, by using
method references. For example:
```
Supplier<Shape> circleSupplier = Circle::new;
Circle circle = circleSupplier.get();
```
Using this technique, we could rewrite the previous code by creating a Map that maps a shape
name to its constructor:
```
final static Map<String, Supplier<Shape>> map = new HashMap<>();
  static {
    map.put("CIRCLE", Circle::new);
    map.put("RECTANGLE", Rectangle::new);
  }
```
We can now use this Map to instantiate different shapes, just as we did with the previous factory code:
```
public class ShapeFactory {

  final static Map<String, Supplier<Shape>> map = new HashMap<>();
  static {
    map.put("CIRCLE", Circle::new);
    map.put("RECTANGLE", Rectangle::new);
  }   
  public Shape getShape(String shapeType){
     Supplier<Shape> shape = map.get(shapeType.toUpperCase());
     if(shape != null) {
       return shape.get();
     }
     throw new IllegalArgumentException("No such shape " + shapeType.toUpperCase());
  }
}
```
Use the factory to get an object of concrete class using the lambda expression: FactoryPatternShapeDemo.java
```
public class FactoryPatternDemo {

   public static void main(String[] args) {

     Supplier<ShapeFactory> shapeFactory =  ShapeFactory::new;

  //call draw method of circle
     shapeFactory.get().getShape("circle").draw();

     //call draw method of Rectangle
     shapeFactory.get().getShape("rectangle").draw();      
   }
}
```
Output:
> Inside Circle::draw() method. \
> Inside Rectangle::draw() method.
> 