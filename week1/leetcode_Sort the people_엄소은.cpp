#include <map>

class Solution
{
  public:
    vector<string> sortPeople(vector<string> &names, vector<int> &heights)
    {
        map<int, string, greater<int>> m;
        int n = names.size();
        for (int i = 0; i < n; i++)
        {
            m[heights[i]] = names[i];
        }
        vector<string> sorted_names;
        for (const auto &entry : m)
        {
            sorted_names.push_back(entry.second);
        }
        return sorted_names;
    }
};