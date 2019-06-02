package Models.File;

public class Line {
	private String[] content;
	private static int[] keyIndexes;

	public Line(String[] content) {
		super();
		this.content = content;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (checkEqualityWithIndexes(this, ((Line) obj))) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		int hashCode = 7;
		for (int index : keyIndexes) {
			hashCode *= 31 * this.content[index].hashCode();
		}
		return hashCode;
	}

	private boolean checkEqualityWithIndexes(Line line1, Line line2) {
		boolean equals = false;
		for (int index : keyIndexes) {
			equals = line1.content[index].equals(line2.content[index]);
			if (!equals)
				break;
		}
		return equals;
	}

	public String[] getContent() {
		return content;
	}

	public void setContent(String[] content) {
		this.content = content;
	}

	public static int[] getKeyIndexes() {
		return keyIndexes;
	}

	public static void setKeyIndexes(int[] keyIndexes) {
		Line.keyIndexes = keyIndexes;
	}

}
