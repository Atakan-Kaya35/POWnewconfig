
package org.example.powwww.MapGridTaslak;
import org.example.powwww.grid.City;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;

public class GridFrame extends JFrame
{
    private final int EACH_SQUARE = 36;
    private final int FRAME_HEIGTH = EACH_SQUARE*20;
    private final int FRAME_WIDTH = EACH_SQUARE*30;
    private City city;

    private JPanel panel;
    private JComponent girdPanel;

    public GridFrame( City c)
    {
        this.city = c;
        panel = new JPanel();
        
        //panel.set
        panel.setLayout(new BorderLayout());
        girdPanel = createGridPanel();
        System.out.println("h");
        panel.add(girdPanel, BorderLayout.CENTER);
        add(panel);
        setSize(FRAME_WIDTH, FRAME_HEIGTH);
        setResizable(false);
        setVisible(true);
    }

    public JComponent createGridPanel()
    {
        JComponent panel = new GridPanel(this, city);
        return panel;
    }

    //Getter methods
    public int getWidth()
    {
        return FRAME_WIDTH;
    }
    public int getHeight()
    {
        return FRAME_HEIGTH;
    }
    public int getStartW()
    {
        return EACH_SQUARE;
    }
    public int getStartH()
    {
        return EACH_SQUARE;
    }
    public int getEachSquare()
    {
        return EACH_SQUARE;
    }
}
