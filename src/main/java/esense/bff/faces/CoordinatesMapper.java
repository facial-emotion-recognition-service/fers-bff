package esense.bff.faces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoordinatesMapper {

	public List<Rectangle> toCoordinatesList(String input) {
		System.out.println("Start CoordinatesMapper.toCoordinatesList");
		System.out.println("input = " + input);
		if (input == null || input.length() < 3) {
			return new ArrayList<>();
		}
		String input2 = input.strip();
		System.out.println("input2 = " + input2);
		String str1 = input2.substring(1, input2.length() - 1);
		System.out.println("str1 = " + str1);
		List<String> coordinatesAsText = Arrays.asList(str1.split(","));
		System.out.println("coordinatesAsText = " + coordinatesAsText);
		List<List<Integer>> numbers = new ArrayList<>();
		for (String text : coordinatesAsText) {
			System.out.println("text = " + text);
			String str2 = text.substring(1, text.length() - 1);
			System.out.println("str2 = " + str2);
			List<String> coordinatesAsText2 = Arrays.asList(str2.split(","));
			System.out.println("coordinatesAsText2 = " + coordinatesAsText2);
			List<Integer> coordinatesAsIntegers = coordinatesAsText2.stream().map(s -> Integer.parseInt(s.strip()))
					.toList();
			System.out.println("coordinatesAsIntegers = " + coordinatesAsIntegers);
			numbers.add(coordinatesAsIntegers);
		}
		System.out.println("numbers = " + numbers);
		System.out.println("End CoordinatesMapper.toCoordinatesList");
		return numbers.stream().map(a -> toRectangle(a)).toList();
	}

	private Rectangle toRectangle(List<Integer> a) {
		return new Rectangle(a.get(0), a.get(1), a.get(2), a.get(3));
	}

}
