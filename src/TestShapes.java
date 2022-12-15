import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * FIRST, COMPLETE Shape interface
 * THEN, COMPLETE Rectangle, Square, and Circle classes
 * LASTLY, COMPLETE TestShapes class
 */

public class TestShapes {
    public static void main(String[] args) {

        /**
        This will be our actual program that we request some information from user to create 3 objects
        We will create 1 Rectangle, 1 Square and 1 Circle object

        Information to create objects will be as below
         -width of the rectangle = 5.5
         -height of the rectangle = 6
         -side of the square = 2.5
         -radius of the circle = 4

         Then print each object
         And print area and perimeters of each object
         Find and print the object which has the largest area

         EXPECTED OUTPUT:
         Circle{radius=4.0}
         Area of the Circle is = 50.24
         Perimeter of the Circle is = 25.12

         Rectangle{width=5.5, height=6.0}
         Area of the Rectangle is = 33.0
         Perimeter of the Rectangle is = 23.0

         Square{side=2.5}
         Area of the Square is = 6.25
         Perimeter of the Square is = 10.0

         Circle has the largest area as 50.24
         */



        Rectangle rectangle = new Rectangle(5.5, 6);
        Circle circle = new Circle();
        circle.setRadius(4);
        Square square = new Square();
        square.setSide(2.5);

        List<Shape> shapes = Arrays.asList(circle, square, rectangle);

        for (int i = 0; i < shapes.size(); i++) {
            Shape s = shapes.get(i);
            System.out.println(shapes.get(i));
            System.out.println("\nArea of the = " + s.getClass().getSimpleName() + " is " + s.getArea() + "\n");
            System.out.println("\nArea of the = " + s.getClass().getSimpleName() + " is " + s.getPerimeter() + "\n");
        }

        Shape s = shapes.stream().reduce(shapes.get(0), (first, next) -> getLargestArea(first, next)); // throwing into a pipeline [c1, r1, s1]

//        Shape s = shapes.get(0);
//        for(int i = 1; i < shapes.size(); i++){
//            s = getLargestArea(s, shapes.get(i));
//        }
       System.out.println(s.getClass().getSimpleName() + " has the largest area as " + s.getArea());
    }

    // helper method
    // if they happen to have the same area, return the first one
    public static Shape getLargestArea(Shape s1, Shape s2){
        if (s1.getArea() > s2.getArea()) return s1;
        else return s2;
    }
}
