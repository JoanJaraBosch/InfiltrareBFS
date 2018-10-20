package classes;

import java.awt.image.BufferedImage;
import java.util.*;

/**
 * @author Joan
 *
 */
public class Section {
	private int position_x, position_y;
	BufferedImage value;
	private float valueToOrder, valorAcc;
	private LinkedList<int[]> road = new LinkedList<int[]>();

	public Section(BufferedImage img, int position_x, int position_y, LinkedList<int[]> road, float valorHeuristic,
			float valorAccumulatiu) {
		this.value = img;
		this.position_x = position_x;
		this.position_y = position_y;
		this.road = road;
		this.valueToOrder = valorHeuristic;
		this.valorAcc = valorAccumulatiu;
	}

	public Section(BufferedImage img, int position_x, int position_y, LinkedList<int[]> road, float valorHeuristic) {
		this.value = img;
		this.position_x = position_x;
		this.position_y = position_y;
		this.road = road;
		this.valueToOrder = valorHeuristic;
	}

	public Section(BufferedImage img, int position_x, int position_y, LinkedList<int[]> road) {
		this.value = img;
		this.position_x = position_x;
		this.position_y = position_y;
		this.road = road;
	}

	public Section(BufferedImage img, int position_x, int position_y) {
		this.value = img;
		this.position_x = position_x;
		this.position_y = position_y;
	}

	public int getPosition_x() {
		return position_x;
	}

	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	public int getPosition_y() {
		return position_y;
	}

	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}

	public BufferedImage getValue() {
		return value;
	}

	public void setValue(BufferedImage value) {
		this.value = value;
	}

	public float getValueToOrder() {
		return valueToOrder;
	}

	public void setValueToOrder(float valueToOrder) {
		this.valueToOrder = valueToOrder;
	}

	public float getValorAcc() {
		return valorAcc;
	}

	public void setValorAcc(float valorAcc) {
		this.valorAcc = valorAcc;
	}

	public LinkedList<int[]> getRoad() {
		return road;
	}

	public void setRoad(LinkedList<int[]> road) {
		this.road = road;
	}

}
