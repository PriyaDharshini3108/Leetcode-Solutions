class Solution {
    int max = 0;

    class ListNode {
        ListNode[] val = new ListNode[10];
    }

    ListNode parent = new ListNode();

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        for(int num : arr1){
            insert(String.valueOf(num));
        }

        for(int num : arr2){
            counter(String.valueOf(num));
        }

        return max;

    }

    private void insert(String number){
        ListNode node = parent;
        for(char ch : number.toCharArray()){
            int pos = ch - '0';
            if(node.val[pos] == null){
                node.val[pos] = new ListNode();
            }
            node = node.val[pos];
        }
    }

    private void counter(String number){
        ListNode node = parent;
        int count = 0;
        for(char ch : number.toCharArray()){
            int pos = ch - '0';
            if(node.val[pos] == null){
                return;
            }
            node = node.val[pos];
            count++;
            max = Math.max(max,count);
        }

    }

    
}