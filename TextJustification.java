import java.util.ArrayList;
import java.util.List;
public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder line = new StringBuilder();
            int numWords = last - index;
            int numSpaces = maxWidth - totalChars;
            if (last == words.length || numWords == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        line.append(" ");
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int spacesBetweenWords = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spacesBetweenWords + (i - index < extraSpaces ? 1 : 0)); j++) {
                            line.append(" ");
                        }
                    }
                }
            }
            result.add(line.toString());
            index = last;
        }

        return result;
    }
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        List<String> justifiedText = fullJustify(words, maxWidth);
        for (String line : justifiedText) {
            System.out.println('"' + line + '"');
        }
    }
}
