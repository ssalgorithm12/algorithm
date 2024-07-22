#include <iostream>
#include <map>
#include <string>
using namespace std;

int main(int argc, char **argv)
{
    int test_case;
    int T;
    map<int, int> m = {{1, 31}, {2, 28}, {3, 31}, {4, 30},  {5, 31},  {6, 30},
                       {7, 31}, {8, 31}, {9, 30}, {10, 31}, {11, 30}, {12, 31}};

    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case)
    {
        string date;
        cin >> date;
        string year, month, day;
        year = date.substr(0, 4);
        month = date.substr(4, 2);
        day = date.substr(6, 2);

        int month_num = stoi(month);
        int day_num = stoi(day);

        if (month_num < 1 || month_num > 12 || day_num > m[month_num] || day_num < 1)
        {
            cout << "#" << test_case << " " << -1 << endl;
        }
        else
        {
            cout << "#" << test_case << " " << year << "/" << month << "/" << day << endl;
        }
    }
    return 0;
}