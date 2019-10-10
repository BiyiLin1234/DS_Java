package DS_Java.lalala;

//用于leetcode测试
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
    }

    public ListNode(int[] arr) {
        if(arr == null || arr.length==0) {
            throw new IllegalArgumentException("arr can't be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        //这样构建完成后，this就是链表的头节点。
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while(cur!=null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}
