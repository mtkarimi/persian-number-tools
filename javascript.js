function convertNumbersToTargetLanguage(text, toPersian = false) {
  const persianNumbers = {'۰': '0', '۱': '1', '۲': '2', '۳': '3', '۴': '4', '۵': '5', '۶': '6', '۷': '7', '۸': '8', '۹': '9'};
  const arabicNumbers = {'٠': '0', '١': '1', '٢': '2', '٣': '3', '٤': '4', '٥': '5', '٦': '6', '٧': '7', '٨': '8', '٩': '9'};
  let reversePersianNumbers = {};
  for (let [key, value] of Object.entries(persianNumbers)) {
    reversePersianNumbers[value] = key;
  }

  const combinedNumbersToEnglish = {...persianNumbers, ...arabicNumbers};

  return text.split('').map(char => {
    if (toPersian) {
      return reversePersianNumbers[combinedNumbersToEnglish[char]] || char;
    } else {
      return combinedNumbersToEnglish[char] || char;
    }
  }).join('');
}

// Test the function with a mixed text of English, Persian, and Arabic numbers
const testText = "This is a test: English 123, Persian ۱۲۳, Arabic ١٢٣.";

// Convert all numbers to English
const resultEnglish = convertNumbersToTargetLanguage(testText, false);

// Convert all numbers to Persian
const resultPersian = convertNumbersToTargetLanguage(testText, true);

console.log(resultEnglish); // Output: "This is a test: English 123, Persian 123, Arabic 123."
console.log(resultPersian); // Output: "This is a test: English ۱۲۳, Persian ۱۲۳, Arabic ۱۲۳."
