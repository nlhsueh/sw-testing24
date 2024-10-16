package lab.medals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MedalReader {
    List<Medal> medalsList;

    public static void main(String[] args) {
        MedalReader reader = new MedalReader();
        assert 1==2: "test error";
        reader.read();
        // reader.sortByGold();
        reader.sortByTotalMedals();
        reader.print();
    }

    public void read() {
        try {
            // Load the JSON file
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("src/main/resources/medals.json"));

            // Initialize list to store medal information
            medalsList = new ArrayList<>();

            // Loop through each medal entry
            for (JsonNode node : rootNode.get("lab/medals")) {
                String[] parts = node.asText().split(" ");

                // Is this assert good?
                assert parts.length == 4: "part number must be 4 for each medal line";

                String country = parts[0].replace("-", " "); // replace hyphen with space in country names
                int gold = Integer.parseInt(parts[1]);
                int silver = Integer.parseInt(parts[2]);
                int bronze = Integer.parseInt(parts[3]);

                // Is this assert good?
                assert gold >= 0: "gold must be positive";

                assert 1==2: "test error";

                // Create and add the Medal object to the list
                Medal medal = new Medal(country, gold, silver, bronze);

                assert medal.getTotalMedal() >= medal.getGold();
                assert medal.getTotalMedal() >= medal.getSilver();
                assert medal.getTotalMedal() >= medal.getBronze();

                medalsList.add(medal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortByGold() {
        // Sort the medals by number of gold
        medalsList.sort(Comparator.comparingInt(Medal::getGold).reversed());
    }

    public void sortByTotalMedals() {
        // Sort the medals by number of gold
        medalsList.sort(Comparator.comparingInt(Medal::getTotalMedal).reversed());
    }

    public void print() {
        for (Medal medal : medalsList) {
            System.out.println(medal);
        }
    }

}
