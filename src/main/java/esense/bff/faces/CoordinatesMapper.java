package esense.bff.faces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoordinatesMapper {

	public List<List<Integer>> toCoordinatesList(String input) {
		String str1 = input.replace("[","").replace("]","");
		List<String> coordinatesAsText = Arrays.asList(str1.split(","));
		List<List<Integer>> result = new ArrayList<>();
		for (String text : coordinatesAsText) {
			String str2 = text.replace("[","").replace("]","");
			List<String> coordinatesAsText2 = Arrays.asList(str2.split(","));
			List<Integer> coordinatesAsIntegers = coordinatesAsText2.stream().map(s->Integer.parseInt(s)).toList();
			result.add(coordinatesAsIntegers);
		}
		return result;
	}

}
