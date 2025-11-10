def ASCIIWordSum(s, sumArr):
    word_sum = 0
    total = 0

    for ch in s:
        if ch == " ":
            total += word_sum
            sumArr.append(word_sum)
            word_sum = 0
            print(ch)
        else:
            word_sum += ord(ch)
            print(ch)

    # add final word
    total += word_sum
    sumArr.append(word_sum)

    return total



if __name__ == "__main__":
    sumArr = []
    strings = [
        "HOSEA", "JOEL", "AMOS", "OBADIAH", "JONAH", "MICAH",
        "NAHUM", "HABAKKUK", "ZEPHANIAH", "HAGGAI", "ZECHARIAH",
        "MALACHI", "ANNA", "WAHL"
    ]

    results = []
    for s in strings:
        results.append((s, ASCIIWordSum(s, sumArr)))

    for name, value in results:
        print(name, value)
