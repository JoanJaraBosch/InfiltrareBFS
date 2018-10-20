package classes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.*;

public class SearchWidth {
	private int x, y;
	BufferedImage gps;

	public SearchWidth(int x, int y, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.gps = img;
	}

	public float widthAlgorism(Section initialSection, Section finalSection) {
		Queue<Section> pendingToVerify = new LinkedList<Section>();
		pendingToVerify.add(initialSection);
		LinkedList<Section> treated = new LinkedList<Section>();
		float solution = 0;
		boolean found = false;

		while (!found && !pendingToVerify.isEmpty()) {
			Section currentlySection = pendingToVerify.remove();
			if ((currentlySection.getPosition_x() == finalSection.getPosition_x())
					&& (currentlySection.getPosition_y() == finalSection.getPosition_y())) {
				found = true;
				solution = currentlySection.getValueToOrder();
			} else {
				south(pendingToVerify, currentlySection, treated);
				east(pendingToVerify, currentlySection, treated);
				west(pendingToVerify, currentlySection, treated);
				north(pendingToVerify, currentlySection, treated);
			}
		}
		return solution;
	}

	public void printResult(float solution) {
		if (solution != 0)
			System.out.println("Sol: " + solution);
	}

	public void south(Queue<Section> toTreath, Section currently, LinkedList<Section> treatened) {
		int vX = currently.getPosition_x();
		int vY = currently.getPosition_y();

		if ((vX + 1) < x) {
			Color merda = new Color(gps.getRGB(vX + 1, vY));
			int red = merda.getRed();
			int blue = merda.getBlue();
			int green = merda.getGreen();

			if (red != 0 || blue != 0 || green != 0) {
				int[] aux = { vX + 1, vY };
				Section newSection = new Section(gps, vX + 1, vY);
				if (!isNodeTreated(newSection, treatened)) {
					float val = currently.getValueToOrder();
					if (red == 0 && blue == 255 && green == 0)
						val += 2;
					else if (red == 255 && blue == 0 && green == 0)
						val += 3;
					else
						val += 1;
					LinkedList<int[]> roadNew = (LinkedList<int[]>) currently.getRoad().clone();
					roadNew.add(aux);
					Section newSection2 = new Section(gps, vX + 1, vY, roadNew, val);
					toTreath.add(newSection2);
					treatened.add(newSection);
				}
			}
		}
	}

	public void east(Queue<Section> toTreath, Section currently, LinkedList<Section> treatened) {
		int vX = currently.getPosition_x();
		int vY = currently.getPosition_y();

		if ((vY + 1) < y) {
			Color merda = new Color(gps.getRGB(vX + 1, vY));
			int red = merda.getRed();
			int blue = merda.getBlue();
			int green = merda.getGreen();

			if (red != 0 || blue != 0 || green != 0) {
				int[] aux = { vX, vY + 1 };
				Section newSection = new Section(gps, vX, vY + 1);
				if (!isNodeTreated(newSection, treatened)) {
					float val = currently.getValueToOrder();
					if (red == 0 && blue == 255 && green == 0)
						val += 2;
					else if (red == 255 && blue == 0 && green == 0)
						val += 3;
					else
						val += 1;
					LinkedList<int[]> roadNew = (LinkedList<int[]>) currently.getRoad().clone();
					roadNew.add(aux);
					Section newSection2 = new Section(gps, vX, vY + 1, roadNew, val);
					toTreath.add(newSection2);
					treatened.add(newSection);
				}
			}
		}
	}

	public void west(Queue<Section> toTreath, Section currently, LinkedList<Section> treatened) {
		int vX = currently.getPosition_x();
		int vY = currently.getPosition_y();

		if ((vY - 1) >= 0) {
			Color merda = new Color(gps.getRGB(vX + 1, vY));
			int red = merda.getRed();
			int blue = merda.getBlue();
			int green = merda.getGreen();
			if (red != 0 || blue != 0 || green != 0) {
				int[] aux = { vX, vY - 1 };
				Section newSection = new Section(gps, vX, vY - 1);
				if (!isNodeTreated(newSection, treatened)) {
					float val = currently.getValueToOrder();
					if (red == 0 && blue == 255 && green == 0)
						val += 2;
					else if (red == 255 && blue == 0 && green == 0)
						val += 3;
					else
						val += 1;
					LinkedList<int[]> roadNew = (LinkedList<int[]>) currently.getRoad().clone();
					roadNew.add(aux);
					Section newSection2 = new Section(gps, vX, vY - 1, roadNew, val);
					toTreath.add(newSection2);
					treatened.add(newSection);
				}
			}
		}
	}

	public void north(Queue<Section> toTreath, Section currently, LinkedList<Section> treatened) {
		int vX = currently.getPosition_x();
		int vY = currently.getPosition_y();

		if ((vX - 1) >= 0) {
			Color merda = new Color(gps.getRGB(vX + 1, vY));
			int red = merda.getRed();
			int blue = merda.getBlue();
			int green = merda.getGreen();
			if (red != 0 || blue != 0 || green != 0) {
				int[] aux = { vX - 1, vY };
				Section newSection = new Section(gps, vX - 1, vY);
				if (!isNodeTreated(newSection, treatened)) {
					float val = currently.getValueToOrder();
					if (red == 0 && blue == 255 && green == 0)
						val += 2;
					else if (red == 255 && blue == 0 && green == 0)
						val += 3;
					else
						val += 1;
					LinkedList<int[]> roadNew = (LinkedList<int[]>) currently.getRoad().clone();
					roadNew.add(aux);
					Section newSection2 = new Section(gps, vX - 1, vY, roadNew, val);
					toTreath.add(newSection2);
					treatened.add(newSection);
				}
			}
		}
	}

	private boolean isNodeTreated(Section node, LinkedList<Section> treated) {
		for (Section actual : treated) {
			if (node.getPosition_x() == actual.getPosition_x() && node.getPosition_y() == actual.getPosition_y())
				return true;
		}
		return false;
	}
}
