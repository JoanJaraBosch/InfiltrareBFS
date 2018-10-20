package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

import classes.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("maze.png"));
		} catch (IOException e) {
		}

		Scanner scaner = new Scanner(System.in);

		int dimX, dimY;

		dimX = img.getHeight();
		System.out.println(dimX + "\n");
		dimY = img.getWidth();
		System.out.println(dimY);
		int x, y;
		int[] initial = { 0, 1 }; // inicialitzem el cami inicial
		LinkedList<int[]> initialRoad = new LinkedList<int[]>();
		initialRoad.add(initial);
		Section initialSection = new Section(img, 0, 1, initialRoad);
		Section finalSection = new Section(img, 225, 225, null);
		float solution = 0;
		SearchWidth gps = new SearchWidth(dimX, dimY, img); // creem l'bjecete per a fer l'algorisme best first
		initialSection.setValorAcc(0);
		solution = gps.widthAlgorism(initialSection, finalSection); // cridem la funcio per a fer l'algorisme d'amplada
		gps.printResult(solution); // si te solucio la printara

		scaner.close();
	}

}
