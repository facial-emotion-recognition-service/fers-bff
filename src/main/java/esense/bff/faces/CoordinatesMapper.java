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
		String input3 = input2.substring(1, input2.length() - 1);
		System.out.println("input3 = " + input3);
		List<String> coordinatesAsText = Arrays.asList(input3.split("["));
		System.out.println("coordinatesAsText = " + coordinatesAsText);
		List<String> coordinatesAsText2 = coordinatesAsText.stream().map(s->s.substring(0, s.length()-1)).toList();
		System.out.println("coordinatesAsText2 = " + coordinatesAsText2);

		List<List<String>> coordinatesAsText3 = new ArrayList<>();
		for (String text : coordinatesAsText2) {
			System.out.println("text = " + text);
			List<String> a =Arrays.asList(text.split(","));
			System.out.println("a = " + a);
			coordinatesAsText3.add(a);
		}

		List<List<Integer>> numbers = new ArrayList<>();
		for (List<String> a : coordinatesAsText3) {
			System.out.println("a = " + a);
			List<Integer> b = a.stream().map(s->Integer.parseInt(s)).toList();
			System.out.println("b = " + b);
			numbers.add(b);
		}

		System.out.println("numbers = " + numbers);
		System.out.println("End CoordinatesMapper.toCoordinatesList");
		return numbers.stream().map(a -> toRectangle(a)).toList();
	}

	private Rectangle toRectangle(List<Integer> a) {
		return new Rectangle(a.get(0), a.get(1), a.get(2), a.get(3));
	}

}
