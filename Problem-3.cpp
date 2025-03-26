/*
TC : O (N)
SC : O(N)
*/
class Solution
{
public:
    vector<int> partitionLabels(string s)
    {
        if (s.size() == 0 || s.empty())
        {
            return {};
        }

        map<char, int> Hashmap;

        for (auto int i = 0; i < s.size(); i++)
        {
            Hashmap[s[i]] = i;
        }

        vector<int> res;
        int start = 0, end = Hashmap[s[0]];
        for (int i = 0; i < s.size(); i++)
        {
            if (i < end)
            {
                if (Hashmap[s[i]] > end)
                {
                    end = Hashmap[s[i]];
                }
                continue;
            }
            else
            {
                res.push_back(end - start + 1);
                start = end + 1;
                end = Hashmap[s[start]];
            }
        }

        return res;
    }
};