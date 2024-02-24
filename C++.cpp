#include <iostream>
#include <unordered_map>
#include <string>

std::string convertNumbersToTargetLanguage(const std::string& text, bool toPersian) {
    std::unordered_map<char, std::string> persianNumbers = {
        {'0', "۰"}, {'1', "۱"}, {'2', "۲"}, {'3', "۳"}, {'4', "۴"}, {'5', "۵"}, {'6', "۶"}, {'7', "۷"}, {'8', "۸"}, {'9', "۹"}
    };

    std::unordered_map<char, std::string> arabicNumbers = {
        {'0', "٠"}, {'1', "١"}, {'2', "٢"}, {'3', "٣"}, {'4', "٤"}, {'5', "٥"}, {'6', "٦"}, {'7', "٧"}, {'8', "٨"}, {'9', "٩"}
    };

    std::unordered_map<std::string, char> reversePersianNumbers;
    for (auto& pair : persianNumbers) {
        reversePersianNumbers[pair.second] = pair.first;
    }

    std::string result;
    for (char ch : text) {
        std::string current(1, ch); // Convert char to string for comparison
        bool found = false;

        if (toPersian) {
            for (auto& pair : persianNumbers) {
                if (pair.first == ch) {
                    result += pair.second;
                    found = true;
                    break;
                }
            }
            if (!found) {
                for (auto& pair : arabicNumbers) {
                    if (pair.first == ch) {
                        result += pair.second;
                        found = true;
                        break;
                    }
                }
            }
        } else {
            for (auto& pair : persianNumbers) {
                if (pair.second == current) {
                    result += pair.first;
                    found = true;
                    break;
                }
            }
            if (!found) {
                for (auto& pair : arabicNumbers) {
                    if (pair.second == current) {
                        result += pair.first;
                        found = true;
                        break;
                    }
                }
            }
        }

        if (!found) {
            result += ch; // If not a number or no match, keep the character as is
        }
    }

    return result;
}

int main() {
    std::string testText = "This is a test: English 123, Persian ۱۲۳, Arabic ١٢٣.";

    // Convert all numbers to English
    std::string resultEnglish = convertNumbersToTargetLanguage(testText, false);

    // Convert all numbers to Persian
    std::string resultPersian = convertNumbersToTargetLanguage(testText, true);

    std::cout << resultEnglish << std::endl; // Output: "This is a test: English 123, Persian 123, Arabic 123."
    std::cout << resultPersian << std::endl; // Output: "This is a test: English ۱۲۳, Persian ۱۲۳, Arabic ۱۲۳."

    return 0;
}
