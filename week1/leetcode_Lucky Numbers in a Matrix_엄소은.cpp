#include <iostream>
#include <set>
#include <vector>
using namespace std;

class Solution
{
  public:
    vector<int> luckyNumbers(vector<vector<int>> &matrix)
    {
        vector<int> min_row, max_col;
        int n = matrix.size();
        int m = matrix[0].size();

        for (int i = 0; i < n; ++i)
        {
            min_row.push_back(*min_element(matrix[i].begin(), matrix[i].end()));
        }
        for (int j = 0; j < m; ++j)
        {
            int maxVal = matrix[0][j];
            for (int i = 0; i < n; ++i)
            {
                if (matrix[i][j] > maxVal)
                {
                    maxVal = matrix[i][j];
                }
            }
            max_col.push_back(maxVal);
        }

        set<int> min_set(min_row.begin(), min_row.end());
        set<int> max_set(max_col.begin(), max_col.end());
        vector<int> result;
        for (int num : min_set)
        {
            if (max_set.find(num) != max_set.end())
            {
                result.push_back(num);
            }
        }
        return result;
    }
};