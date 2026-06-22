class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        # last positions
        last = {}
        for i,c in enumerate(s):
            last[c]=i
        # {c:i for i,c in enumerate(s)}
        # {'a': 8, 'b': 5, 'c': 7, 'd': 14, 'e': 15, 'f': 11, 'g': 13, 'h': 19, 'i': 22, 'j': 23, 'k': 20, 'l': 21}
        start = 0 #16
        end = 0 #23
        output = [] #9,7,8
        # end = 8
#          0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
        # "a b a b c b a c a d e  f   e  g  d  e h  i  j  h  k  l  i  j"
        #                                                             i
        for i,c in enumerate(s):
            end = max(end,last[c])
            if i == end:
                output.append(end-start+1)
                start = i+1
        return output 


#         3. Visualizing the Guarantee: "ababcc"
# Let's see why it's mathematically impossible for a letter to leak out, using the example s = "ababcc" where last = {'a': 2, 'b': 3, 'c': 5}.

# i = 0, c = 'a': last['a'] is 2. end becomes max(0, 2) = 2. The partition must go to at least index 2.

# i = 1, c = 'b': last['b'] is 3. end becomes max(2, 3) = 3. Because 'b' sneaked in, our boundary is forced to stretch further out to index 3.

# i = 2, c = 'a': last['a'] is 2. end becomes max(3, 2) = 3. No expansion needed.

# i = 3, c = 'b': last['b'] is 3. end becomes max(3, 3) = 3.

# At this exact moment, i == end (3 == 3).

# Why is this the perfect moment to snap the partition?
# Think about what it means when i finally catches up to end:

# We have successfully examined every single character from start to i.

# For every single one of those characters, we checked where its final duplicate lives.

# None of them had a final duplicate living anywhere past index i (otherwise, end would have been pushed past i, and i == end wouldn't be true).

# Because no character inside our current window has a twin waiting for it down the line, we can safely snap the partition shut knowing it is a completely isolated island. We log the size, reset start = i + 1, and begin building the next island.