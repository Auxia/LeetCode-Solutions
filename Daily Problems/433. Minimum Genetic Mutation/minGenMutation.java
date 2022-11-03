/* A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed to mutate from start to end. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank. */

class Solution{
    public int minMutation(String start, String end, String[] bank){
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if(!bankSet.contains(end)) return -1;
        char[] genes = new char[]{'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curr = queue.poll();
                if(curr.equals(end)) return level;
                char[] currArr = curr.toCharArray();
                for(int j = 0; j < currArr.length; j++){
                    char old = currArr[j];
                    for(char c : genes){
                        currArr[j] = c;
                        String next = new String(currArr);
                        if(bankSet.contains(next)){
                            queue.offer(next);
                            bankSet.remove(next);
                        }
                    }
                    currArr[j] = old;
                }
            }
            level++;
        }
        return -1;
    }
}