import java.io.File;
import java.io.FileNotFoundException;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class SuperFormulaApplet extends PApplet
{
    JSONArray shapeArray;
    public String fileName;
    SuperFormulaShape currentShape;
    public SuperFormulaShape shape1;
    float rotation = 0;

    public static void main(String[] args)
    {
        PApplet.main(SuperFormulaApplet.class, args);
    }

    @Override
    public void settings()
    {
        size(800, 800);
    }

    @Override
    public void setup()
    {
        fileName = "shapes.json";
        File shapes = dataFile(fileName);
        if (shapes.exists())
            shapeArray = loadJSONArray(shapes);
        else
            shapeArray = new JSONArray();

        SuperFormulaShape customShape = new SuperFormulaShape((JSONObject) shapeArray.get(1));
        mousePressed();
        this.currentShape = shape1;
    }

    @Override
    public void draw()
    {
        background(255);
        currentShape.a = mouseX / 100.0f;
        currentShape.b = mouseY / 100.0f;
        SuperFormulaUtils.drawShape(width / 2.0f, height / 2.0f, currentShape, rotation, this);
        rotation += 0.01f;
    }

    @Override
    public void mousePressed()
    {
        shape1 = new SuperFormulaShape(
                random(30),
                random(30),
                random(30),
                random(30),
                random(30),
                random(30),
                random(30)
        );
        currentShape = shape1;
    }

    @Override
    public void keyPressed()
    {
        switch (key)
        {
            case 's':
                shapeArray.append(currentShape.toJsonObject());
                saveJSONArray(shapeArray, dataPath(fileName));
                println("Shape saved");
                break;
            case 'p':
                println(currentShape.m1);
                println(currentShape.m2);
                println(currentShape.a);
                println(currentShape.b);
                println(currentShape.n1);
                println(currentShape.n2);
                println(currentShape.n3);
                println();
                break;
        }
    }
}
