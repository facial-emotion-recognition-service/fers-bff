package esense.bff.faces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoordinatesMapper {

	public List<Rectangle> toCoordinatesList(String input) {
		String str1 = input.replace("[", "").replace("]", "");
		List<String> coordinatesAsText = Arrays.asList(str1.split(","));
		List<List<Integer>> numbers = new ArrayList<>();
		for (String text : coordinatesAsText) {
			String str2 = text.replace("[", "").replace("]", "");
			List<String> coordinatesAsText2 = Arrays.asList(str2.split(","));
			List<Integer> coordinatesAsIntegers = coordinatesAsText2.stream().map(s -> Integer.parseInt(s.strip()))
					.toList();
			numbers.add(coordinatesAsIntegers);
		}
		return numbers.stream().map(a -> toRectangle(a)).toList();
	}

	private Rectangle toRectangle(List<Integer> a) {
		return new Rectangle(a.get(0), a.get(1), a.get(2), a.get(3));
	}

}
