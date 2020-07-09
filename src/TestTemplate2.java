import java.util.*;

/**
 * @author Sumit Deo
 */
public class TestTemplate2 {

    public static void main(String[] args) {
        int numToys = 6;
        int topToys = 2;
        List<String> toys = Arrays.asList("elmo", "elsa", "legos", "drone", "tablet", "warcraft");
        int numQuotes = 6;
        List<String> quotes = Arrays.asList("Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year",
                "Elsa and Elmo are the toys I'll be buying for my kids",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season");

        List<String> result = popularNToys(numToys, topToys, toys, numQuotes, quotes);

        for (String str : result) {
            System.out.print(str + " ");
        }

    }

    private static ArrayList<String> popularNToys(int numToys,
                                                  int topToys,
                                                  List<String> toys,
                                                  int numQuotes,
                                                  List<String> quotes) {

        HashMap<String, Integer> resultMap = new HashMap<>();
        HashMap<Integer, List<String>> quotesMap = new HashMap<>();

        for (int i = 0; i < numQuotes; i++) {
            List<String> listOfWords = Arrays.asList(quotes.get(i)
                    .toLowerCase()
                    .replaceAll("[^a-z']", " ")
                    .split(" "));
            quotesMap.put(i, listOfWords);
        }

        for (int i = 0; i < numToys; i++) {
            String toy = toys.get(i);
            for (int j = 0; j < numQuotes; j++) {
                if (quotesMap.get(j).contains(toy)) {
                    resultMap.put(toy, (resultMap.containsKey(toy) ? resultMap.get(toy) : 0) + 1);
                }
            }
        }

        ArrayList<String> result = new ArrayList<>();
        List<String> tempResult = new ArrayList<>();

        for (Map.Entry entry : resultMap.entrySet()) {
            tempResult.add(Integer.toString((Integer) entry.getValue()) + entry.getKey());
        }

        Collections.sort(tempResult, Collections.reverseOrder());

        for (int i = 0; i < topToys; i ++) {
            result.add(tempResult.get(i).substring(1));
        }

        return result;
    }

}
