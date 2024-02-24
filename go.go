package main

import (
	"fmt"
	"strings"
)

func convertNumbersToTargetLanguage(text string, toPersian bool) string {
	persianNumbers := map[rune]string{
		'۰': "0", '۱': "1", '۲': "2", '۳': "3", '۴': "4",
		'۵': "5", '۶': "6", '۷': "7", '۸': "8", '۹': "9",
	}
	arabicNumbers := map[rune]string{
		'٠': "0", '١': "1", '٢': "2", '٣': "3", '٤': "4",
		'٥': "5", '٦': "6", '٧': '7', '٨': "8", '٩': "9",
	}
	reversePersianNumbers := make(map[string]rune)
	for k, v := range persianNumbers {
		reversePersianNumbers[v] = k
	}

	var result strings.Builder
	for _, char := range text {
		if toPersian, ok := persianNumbers[char]; toPersian && ok {
			result.WriteRune(reversePersianNumbers[toPersian])
		} else if toEnglish, ok := arabicNumbers[char]; ok {
			result.WriteString(toEnglish)
		} else {
			result.WriteRune(char)
		}
	}
	return result.String()
}

func main() {
	testText := "This is a test: English 123, Persian ۱۲۳, Arabic ١٢٣."

	// Convert all numbers to English
	resultEnglish := convertNumbersToTargetLanguage(testText, false)
	fmt.Println(resultEnglish) // Output: "This is a test: English 123, Persian 123, Arabic 123."

	// Convert all numbers to Persian
	resultPersian := convertNumbersToTargetLanguage(testText, true)
	fmt.Println(resultPersian) // Output: "This is a test: English ۱۲۳, Persian ۱۲۳, Arabic ۱۲۳."
}
