//
//public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//    ListNode f = l1;
//    ListNode s = l2;
//    ListNode ans = new ListNode();
//    ListNode dummyhead = ans;
//    int sum =0;
//    int carry = 0;
//    while(f!=null&&s!=null){
//        sum = f.val+s.val+carry;
//        carry=0;
//        if(sum>9){
//            dummyhead.next= new ListNode(sum%10);
//            dummyhead = dummyhead.next;
//            carry = sum/10;
//        }else
//        {
//            dummyhead.next = new ListNode(sum);
//            dummyhead = dummyhead.next;
//        }
//        f = f.next;
//        s = s.next;
//    }
//    while(f!=null){
//        sum = f.val+carry;
//        carry=0;
//        if(sum>9){
//            dummyhead.next= new ListNode(sum%10);
//            dummyhead = dummyhead.next;
//            carry = sum/10;
//        }else
//        {
//            dummyhead.next = new ListNode(sum);
//            dummyhead = dummyhead.next;
//        }
//        f = f.next;
//    }
//    while(s!=null){
//        sum = +s.val+carry;
//        carry=0;
//        if(sum>9){
//            dummyhead.next= new ListNode(sum%10);
//            dummyhead = dummyhead.next;
//            carry = sum/10;
//        }else
//        {
//            dummyhead.next = new ListNode(sum);
//            dummyhead = dummyhead.next;
//        }
//        s = s.next;
//    }
//    if(carry!=0){
//        dummyhead.next = new ListNode(carry);
//        dummyhead = dummyhead.next;
//    }
//    return ans.next;
//}
//public ListNode removeNthFromEnd(ListNode head, int n) {
//    ListNode temp = head;
//    int len = 0;
//    while(temp!=null){
//        temp = temp.next;
//        len++;
//    }
//    if(len<=1)return null;
//    len = len-n;
//    ListNode temp2 = head;
//    for(int i =1;i<len;i++){
//        temp2 = temp2.next;
//    }
//    if(len==0){
//        head = temp2.next;
//    }else if(temp2.next!=null&&temp2.next.next!=null){
//        temp2.next = temp2.next.next;
//    }else{
//        temp2.next=null;
//    }
//    return head;
//}
//public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//
//    ListNode ans = new ListNode();
//    ListNode temp = ans;
//    // System.out.println(temp);
//    while(list1!= null && list2!=null){
//
//        if(list1.val<=list2.val){
//            temp.next = list1;
//            list1 = list1.next;
//            temp = temp.next;
//            System.out.println(temp.val);
//        }else{
//            temp.next = list2;
//            list2 = list2.next;
//            temp = temp.next;
//        }
//    }
//    while(list1!=null){
//        temp.next=list1;
//        list1 = list1.next;
//        temp = temp.next;
//    }
//    while(list2!=null){
//        temp.next=list2;
//        list2 = list2.next;
//        temp = temp.next;
//    }
//    return ans.next;
//}
//public ListNode swapPairs(ListNode head) {
//    ListNode f = head;
//    if(head==null)return null;
//    if(head.next==null) return head;
//    ListNode s = f.next;
//    f.next = s.next;
//    s.next = f;
//    head = s;
//    s = f;
//    f = f.next;
//    // System.out.println(f.val);
//    // System.out.println(f.next.val);
//    while(f!=null&&s!=null){
//        if(f.next==null)break;
//        s.next = f.next;
//        f.next = f.next.next;
//        s.next.next = f;
//        s=f;
//        f = f.next;
//    }
//    return head;
//}
//public ListNode deleteDuplicates(ListNode node) {
//    if(node==null){
//        return node;
//    }
//    ListNode head = node;
//    while(node.next!=null){
//        if(node.val==node.next.val){
//            node.next = node.next.next;
//        }else{
//            node = node.next;
//        }
//    }
//    return head;
//}
//public boolean hasCycle(ListNode head) {
//    ListNode s = head;
//    ListNode f = head;
//    while(f!=null && f.next!=null){
//        s = s.next;
//        f = f.next.next;
//        if(s == f){
//            return true;
//        }
//    }
//    return false;
//}
//public ListNode detectCycle(ListNode head) {
//    boolean flag = false;
//    ListNode s = head;
//    ListNode f = head;
//    int len1=0;
//    while(f!=null && f.next!=null){
//        s = s.next;
//        f = f.next.next;
//        if(s == f){
//            flag = true;
//            break;
//        }
//        len1++;
//    }
//    if(flag){
//        s = s.next;
//        int len =1;
//        while(s!=f){
//            s = s.next;
//            len++;
//        }
//        ListNode first = head;
//        ListNode second = head;
//        while(len>0){
//            second = second.next;
//            len--;
//        }
//        while(first!=second){
//            first = first.next;
//            second = second.next;
//        }
//        return second;
//    }
//    return null;
//}