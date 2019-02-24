import processing.core.PApplet;

import static processing.core.PApplet.abs;
import static processing.core.PApplet.cos;
import static processing.core.PApplet.pow;
import static processing.core.PApplet.sin;
import static processing.core.PConstants.PI;

public class SuperFormulaUtils
{
    private SuperFormulaUtils()
    {
    }

    public static float r(
            float theta,
            float m1,
            float m2,
            float a,
            float b,
            float n1,
            float n2,
            float n3
    )
    {
        float value1 = pow(abs(cos(m1 * theta / 4) / a), n2);
        float value2 = pow(abs(sin(m2 * theta / 4) / b), n3);
        return pow(value1 + value2, -1 / n1);
    }

    public static void drawShape(
            float x,
            float y,
            SuperFormulaShape shape,
            float rotation,
            PApplet p
    )
    {
        drawShape(
                x,
                y,
                shape.m1,
                shape.m2,
                shape.a,
                shape.b,
                shape.n1,
                shape.n2,
                shape.n3,
                rotation,
                p
        );
    }

    public static void drawShape(
            float x,
            float y,
            float m1,
            float m2,
            float a,
            float b,
            float n1,
            float n2,
            float n3,
            float rotation,
            PApplet p
    )
    {
        p.pushMatrix();
        p.translate(x, y);
        p.rotate(rotation);
        p.beginShape();
        for (float i = 0; i <= 2 * PI; i += 0.01)
        {
            float r = r(
                    i,
                    m1,
                    m2,
                    a,
                    b,
                    n1,
                    n2,
                    n3
            );
            float xCoordinate = r * 50 * cos(i);
            float yCoordinate = r * 50 * sin(i);
            p.vertex(xCoordinate, yCoordinate);
        }
        p.endShape();
        p.popMatrix();
    }
}
