import sys

sys.stdin = open("C:/Users/SSAFY/algorithm/week1/input.txt", "r")

T = int(input())


# T = int(input())
date_map = {
    1: 31,
    2: 28,
    3: 31,
    4: 30,
    5: 31,
    6: 30,
    7: 31,
    8: 31,
    9: 30,
    10: 31,
    11: 30,
    12: 31,
}

for test in range(1, T + 1):
    given_date = input()
    year, month, day = given_date[:4], given_date[4:6], given_date[6:]
    if (
        int(month) < 1
        or int(month) > 12
        or int(day) > date_map[int(month)]
        or int(day) < 1
    ):
        print(f"#{test}", -1)
    else:
        print(f"#{test} {year}/{month}/{day}")
