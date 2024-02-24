def convert_numbers_to_target_language(text, to_persian=False):
    persian_numbers = {'۰': '0', '۱': '1', '۲': '2', '۳': '3', '۴': '4', '۵': '5', '۶': '6', '۷': '7', '۸': '8', '۹': '9'}
    arabic_numbers = {'٠': '0', '١': '1', '٢': '2', '٣': '3', '٤': '4', '٥': '5', '٦': '6', '٧': '7', '٨': '8', '٩': '9'}
    reverse_persian_numbers = {v: k for k, v in persian_numbers.items()}

    # Combine Persian and Arabic numbers mapping to English
    combined_numbers_to_english = {**persian_numbers, **arabic_numbers}

    if to_persian:
        # Convert all numbers to Persian
        return ''.join(reverse_persian_numbers.get(combined_numbers_to_english.get(char, char), char) for char in text)
    else:
        # Convert all numbers to English
        return ''.join(combined_numbers_to_english.get(char, char) for char in text)

# Test the function with a mixed text of English, Persian, and Arabic numbers
test_text = "This is a test: English 123, Persian ۱۲۳, Arabic ١٢٣."

# Convert all numbers to English
result_english = convert_numbers_to_target_language(test_text, to_persian=False)

# Convert all numbers to Persian
result_persian = convert_numbers_to_target_language(test_text, to_persian=True)

result_english, result_persian
