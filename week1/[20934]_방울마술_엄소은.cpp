#include <iostream>
#include <string>
using namespace std;

int main(int argc, char **argv)
{
    int test_case;
    int T;
    string magic;
    int k;
    string cups;
    int ans;

    cin >> T;

    for (test_case = 1; test_case <= T; ++test_case)
    {
        cin >> cups >> k;

        if (cups[2] == 'o' && k == 0)
        {
            ans = 2;
        }
        else if (cups[1] == 'o' && !(k & 1))
        {
            ans = 1;
        }
        else if (cups[1] != 'o' && (k & 1))
        {
            ans = 1;
        }
        else
        {
            ans = 0;
        }

        cout << "#" << test_case << " " << ans << endl;
    }
    return 0;
}
