class Polygon {
	int[][] points;
	int[] borderColor; //RGB
	int[] fillColor;

	Polygon (int[][] points, int[] borderColor, int[] fillColor) {
		this.points = points;
		this.borderColor = borderColor;
		this.fillColor = fillColor;
	}

	void print() {
		System.out.println("Points:");
		for (int[] point : this.points) {
			System.out.printf("\t (%d, %d)\n", point[0], point[1]);
		}
		System.out.println("");
		
		System.out.printf(
			"border color:\n\tR: %d\n\tG: %d\n\tB: %d\n",
			this.borderColor[0],
			this.borderColor[1],
			this.borderColor[2]
		);
		System.out.printf(
			"fill color:\n\tR: %d\n\tG: %d\n\tB: %d\n",
			this.fillColor[0],
			this.fillColor[1],
			this.fillColor[2]
		);
	}

	public static void main(String[] args) {
		int[][] points = {
			{1, 2},
			{3, 4},
			{4, 2}
		};

		int[] border = { 10, 0, 0 };
		int[] fill = { 0, 0, 10 };

		Polygon poly = new Polygon(points, border, fill);

		poly.print();
	}
}
