
package org.example.powwww.MapGridTaslak;
import org.example.powwww.grid.City;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;

public class GridFrame extends JFrame
{
    public static final int EACH_SQUARE = 36;
    private final int FRAME_HEIGTH = EACH_SQUARE*20+ EACH_SQUARE*2;
    private final int FRAME_WIDTH = EACH_SQUARE*30+ EACH_SQUARE*2;
    private City city;

    private JPanel panel;
    private JComponent gridPanel;

    public GridFrame( City c)
    {
        this.city = c;
        panel = new JPanel();
        
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BorderLayout());
        gridPanel = createGridPanel();
        panel.add(gridPanel, BorderLayout.CENTER);
        add(panel);
        setSize(FRAME_WIDTH, FRAME_HEIGTH + EACH_SQUARE);
        setResizable(false);
        setVisible(true);
    }

    public JComponent createGridPanel()
    {
        JComponent panel = new GridPanel(this, city);
        return panel;
    }

    public JPanel getPanel() {
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

    public void showTime(int tick) {
    }
}
