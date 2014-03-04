package com.horstmann.corejava;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;
import com.horstmann.annotations.*;

/**
 * A bean to draw a bar chart.
 * @version 1.31 2007-10-03
 * @author Cay Horstmann
 */
public class ChartBean extends JComponent
{
    public enum Position { LEFT, CENTER, RIGHT };
    private double[] values = { 1, 2, 3 };
    private String title = "Title";
    private Position titlePosition = Position.CENTER;
    private boolean inverse;
    private Color color = Color.red;
    
    public ChartBean() {  }
  
   /**
    * Sets the title property.
    * @param t the new chart title.
    */
   @Property
   public void setTitle(String t)
   {
      title = t;
   }

   /**
    * Gets the title property.
    * @return the chart title.
    */
   public String getTitle()
   {
      return title;
   }

   /**
    * Sets the indexed values property.
    * @param v the values to display in the chart.
    */
   public void setValues(double[] v)
   {
      values = v;
   }

   /**
    * Gets the indexed values property.
    * @return the values to display in the chart.
    */
   public double[] getValues()
   {
      return values;
   }

   /**
    * Sets the indexed values property.
    * @param i the index of the value to set
    * @param value the new value for that index
    */
   @Property(editor = "DoubleArrayEditor")
   public void setValues(int i, double value)
   {
      if (0 <= i && i < values.length) values[i] = value;
   }

   /**
    * Gets the indexed values property.
    * @param i the index of the value to get
    * @return the value for that index
    */
   public double getValues(int i)
   {
      if (0 <= i && i < values.length) return values[i];
      return 0;
   }

   /**
    * Sets the inverse property.
    * @param b true if the display is inverted (white bars on colored background)
    */
   @Property(editor = "InverseEditor")
   public void setInverse(boolean b)
   {
      inverse = b;
   }

   /**
    * Gets the inverse property.
    * @return true if the display is inverted
    */
   public boolean isInverse()
   {
      return inverse;
   }

   /**
    * Sets the titlePosition property.
    * @param p LEFT, CENTER, or RIGHT
    */
   @Property(editor = "TitlePositionEditor")
   public void setTitlePosition(Position p)
   {
      titlePosition = p;
   }

   /**
    * Gets the titlePosition property.
    * @return LEFT, CENTER, or RIGHT
    */
   public Position getTitlePosition()
   {
      return titlePosition;
   }

   /**
    * Sets the graphColor property.
    * @param c the color to use for the graph
    */
   @Property
   public void setGraphColor(Color c)
   {
      color = c;
   }

   /**
    * Gets the graphColor property.
    * @param c the color to use for the graph
    */
   public Color getGraphColor()
   {
      return color;
   }

  
}
