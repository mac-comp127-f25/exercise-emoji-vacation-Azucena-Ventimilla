package emojivacation;

import edu.macalester.graphics.*;

import java.awt.Color;

@SuppressWarnings("WeakerAccess")  // This stops Java from giving you warnings about your code that are not helpful here
public class Emojis {
    private static final Color
        HEAD_COLOR = new Color(0xFFDE30), // fill in emoji head w/ color
        HEAD_OUTLINE_COLOR = new Color(0xAC9620), 
        MOUTH_COLOR = new Color(0xE45B5B), 
        EYE_COLOR = new Color(6969669),
        EYE_OUTLINE_COLOR = new Color(696969),
        EYE_MINI_COLOR = new Color(255,255,255),
        EYE_MINI_OUTLINE_COLOR = new Color(255,255,255);




    public static void main(String[] args) { // main method
        CanvasWindow canvas = new CanvasWindow("Emojis", 800, 600);

        GraphicsGroup littleSmiley = createSmileyFace(100);
        littleSmiley.setPosition(50, 400);
        canvas.add(littleSmiley);

        GraphicsGroup mediumSmiley = createSmileyFace(200);
        mediumSmiley.setPosition(150, 300);
        canvas.add(mediumSmiley);

        GraphicsGroup bigSmiley = createSmileyFace(300);
        bigSmiley.setPosition(350, 200);
        canvas.add(bigSmiley);
    }

    /**
     * Creates a smiley face emoji.
     *
     * @param size The overall width and height of the emoji.
     * @return A graphic that you can add to a window, or place inside some other graphics group.
     */
    public static GraphicsGroup createSmileyFace(double size) {
        GraphicsGroup group = new GraphicsGroup();

        group.add(createHead(size, size));
        
        // Mouth
        Arc mouth = createSmile(size * 0.6, size * 0.5);
        mouth.setCenter(size * 0.5, size * 0.75);
        group.add(mouth);

        // Eyes
        Ellipse eye1 = createEyes(size, size); 
        eye1.setCenter(size*0.3, size*0.3);
        group.add(eye1);

        Ellipse eye2 = createEyes(size, size); 
        eye2.setCenter(size*0.6, size*0.3);
        group.add(eye2);

      // Mini Eyes
        Ellipse mini_eye1 = createWhiteEyes(size, size);
        mini_eye1.setCenter(size*0.3, size*0.3);
        group.add(mini_eye1);

        Ellipse mini_eye2 = createWhiteEyes(size, size);
        mini_eye2.setCenter(size*0.6, size*0.3);
        group.add(mini_eye2);

        return group;
    }

    /**
     * Creates an empty emoji head. The head fits inside the box from (0,0)
     * to (width,height).
     */
    private static Ellipse createHead(double height, double width) {
        Ellipse head = new Ellipse(0, 0, width, height);
        head.setFillColor(HEAD_COLOR);
        head.setStrokeColor(HEAD_OUTLINE_COLOR);
        head.setStrokeWidth(2);
        return head;
    }

    /**
     * Creates a smile-shaped arc. The arc is measured relative to its “implied ellipse,” which is
     * the shape that would be formed if the arc were extend all the way around. The size of the
     * resulting arc will be smaller than the implied ellipse’s size.
     *
     * @param ellipseWidth  The width of the implied ellipse from which the smile’s arc is cut.
     * @param ellipseHeight The width of the implied ellipse from which the smile’s arc is cut.
     */
    private static Arc createSmile(double ellipseWidth, double ellipseHeight) {
        Arc mouth = new Arc(0, 0, ellipseWidth, ellipseHeight, 200, 140);
        mouth.setStrokeColor(MOUTH_COLOR);
        mouth.setStrokeWidth(4);
        return mouth;
    }

    private static Ellipse createEyes(double height, double width){
        Ellipse eye = new Ellipse(0.3, 0.3, 0.1*width, 0.1*height);
        eye.setFillColor(EYE_COLOR);
        eye.setStrokeColor(EYE_OUTLINE_COLOR);
        eye.setStrokeWidth(1);
        return eye;

    }
    private static Ellipse createWhiteEyes(double height, double width){
        Ellipse mini_eye = new Ellipse(0.3, 0.3, 0.03*width, 0.03*height);
        mini_eye.setFillColor(EYE_MINI_COLOR);
        mini_eye.setStrokeColor(EYE_MINI_OUTLINE_COLOR);
        mini_eye.setStrokeWidth(0.1);
        return mini_eye;
    }
}
