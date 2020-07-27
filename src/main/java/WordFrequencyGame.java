import java.util.*;

public class WordFrequencyGame {

    private static final String SPACE_PATTERN = "\\s+";
    private static final String CALCULATE_ERROR = "Calculate Error";
    private static final String DELIMITER = "\n";

    public String getResult(String sentence) {
            try {

                List<WordInfo> wordInfos = calculateWordFrequency(sentence);
                wordInfos.sort((firstWordInfo, secondWordInfo) -> secondWordInfo.getWordCount() - firstWordInfo.getWordCount());

                return generateWordFrequencyResult(wordInfos);
            } catch (Exception e) {
                return CALCULATE_ERROR;
            }
    }

    private List<WordInfo> calculateWordFrequency(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<WordInfo> wordInfos = new LinkedList<>();
        for (String uniqueWord : new HashSet<>(words)) {
            int count = (int) words.stream().filter(word -> word.equals(uniqueWord)).count();
            wordInfos.add(new WordInfo(uniqueWord, count));
        }
        return wordInfos;
    }

    private String generateWordFrequencyResult(List<WordInfo> wordInfos) {
        StringJoiner joiner = new StringJoiner(DELIMITER);
        for (WordInfo wordInfo : wordInfos) {
            String s = wordInfo.getValue() + " " + wordInfo.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }

}
