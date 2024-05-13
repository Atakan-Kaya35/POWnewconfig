package org.example.powwww.entity.mobile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Animations extends Mobile{
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 850;
    private static final int PLANE_SIZE = 40;
    private static final int NUM_PLANES = 5;
    private final Random random = new Random();
    private final Point[] planePositions = new Point[NUM_PLANES];
    private final double[] angles = new double[NUM_PLANES];
    private final double SPEED = 2.0;
    private BufferedImage image;
    private double calibrationValue = 0.050;

    public Animations() {
        for (int i = 0; i < NUM_PLANES; i++) {
            planePositions[i] = new Point(random.nextInt(WIDTH - PLANE_SIZE), random.nextInt(HEIGHT - PLANE_SIZE));
            angles[i] = 2 * Math.PI * random.nextDouble(); // Random angle in radians
        }
        try {
            image = ImageIO.read(new File("powwww/src/main/resources/pnal.png")); // Load the image
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void movePlanes() {
        for (int i = 0; i < NUM_PLANES; i++) {
            int dx = (int) (Math.cos(angles[i]) * SPEED);
            int dy = (int) (Math.sin(angles[i]) * SPEED);
            planePositions[i].translate(dx, dy);

            // new random angle
            if (planePositions[i].x <= 0 || planePositions[i].x >= WIDTH - PLANE_SIZE ||
                    planePositions[i].y <= 0 || planePositions[i].y >= HEIGHT - PLANE_SIZE) {
                angles[i] = 2 * Math.PI * random.nextDouble();
            }
        }
    }

    public void draw(Graphics g, JComponent j) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < NUM_PLANES; i++) {
            double direction = angles[i];
            g2d.translate(planePositions[i].x + PLANE_SIZE / 2.0, planePositions[i].y + PLANE_SIZE / 2.0);
            g2d.rotate(direction + Math.PI / 2+calibrationValue);
            g2d.drawImage(image.getScaledInstance(PLANE_SIZE, PLANE_SIZE, Image.SCALE_SMOOTH), -PLANE_SIZE / 2, -PLANE_SIZE / 2, j);
            g2d.setTransform(new AffineTransform());
        }
    }



}
