import java.util.HashMap;
import java.util.Map;

public class NumberConverter {

    public static String convertNumbersToTargetLanguage(String text, boolean toPersian) {
        Map<String, String> persianNumbers = new HashMap<>();
        persianNumbers.put("۰", "0");
        persianNumbers.put("۱", "1");
        persianNumbers.put("۲", "2");
        persianNumbers.put("۳", "3");
        persianNumbers.put("۴", "4");
        persianNumbers.put("۵", "5");
        persianNumbers.put("۶", "6");
        persianNumbers.put("۷", "7");
        persianNumbers.put("۸", "8");
        persianNumbers.put("۹", "9");

        Map<String, String> arabicNumbers = new HashMap<>();
        arabicNumbers.put("٠", "0");
        arabicNumbers.put("١", "1");
        arabicNumbers.put("٢", "2");
        arabicNumbers.put("٣", "3");
        arabicNumbers.put("٤", "4");
        arabicNumbers.put("٥", "5");
        arabicNumbers.put("٦", "6");
        arabicNumbers.put("٧", "7");
        arabicNumbers.put("٨", "8");
        arabicNumbers.put("٩", "9");

        Map<String, String> reversePersianNumbers = new HashMap<>();
        for (Map.Entry<String, String> entry : persianNumbers.entrySet()) {
            reversePersianNumbers.put(entry.getValue(), entry.getKey());
        }

        Map<String, String> combinedNumbersToEnglish = new HashMap<>();
        combinedNumbersToEnglish.putAll(persianNumbers);
        combinedNumbersToEnglish.putAll(arabicNumbers);

        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            String key = Character.toString(ch);
            if (toPersian) {
                result.append(reversePersianNumbers.getOrDefault(combinedNumbersToEnglish.getOrDefault(key, key), key));
            } else {
                result.append(combinedNumbersToEnglish.getOrDefault(key, key));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String testText = "This is a test: English 123, Persian ۱۲۳, Arabic ١٢٣.";

        // Convert all numbers to English
        String resultEnglish = convertNumbersToTargetLanguage(testText, false);

        // Convert all numbers to Persian
        String resultPersian = convertNumbersToTargetLanguage(testText, true);

        System.out.println(resultEnglish); // Output: "This is a test: English 123, Persian 123, Arabic 123."
        System.out.println(resultPersian); // Output: "This is a test: English ۱۲۳, Persian ۱۲۳, Arabic ۱۲۳."
    }
}
