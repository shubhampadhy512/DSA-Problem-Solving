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
//public ListNode swapNodes(ListNode head, int k) {
//    ListNode temp = head;
//    int len=0;
//    while(temp!=null){
//        temp = temp.next;
//        len++;
//    }
//    if(len==1)return head;
//    ListNode s = head;
//    for(int i=1;i<k;i++){
//        s = s.next;
//    }
//    len = len - k;
//    System.out.println(s.val);
//    if(k<=len){
//        ListNode last = s;
//        for(int i=k;i<=len;i++){
//            last = last.next;
//        }
//        int temp2 = s.val;
//        s.val = last.val;
//        last.val = temp2;
//    }else{
//        ListNode last = head;
//        for(int i=0;i<len;i++){
//            last = last.next;
//        }
//        int temp2 = s.val;
//        s.val = last.val;
//        last.val = temp2;
//    }
//    // System.out.println(last.val);
//    return head;
//}
//public ListNode removeElements(ListNode head, int val) {
//    ListNode pre = head;
//    if(head==null)return head;
//    ListNode temp = pre.next;
//    while(temp!=null){
//        if(head==pre&&pre.val==val){
//            head=temp;
//            pre = head;
//        }else if(temp.val==val){
//            pre.next = temp.next;
//        }else{
//            pre = temp;
//        }
//        temp = temp.next;
//    }
//    if(pre==head&&pre.val==val)return null;
//    if(pre.val==val){
//        pre.next = temp;
//    }
//    return head;
//}
//public ListNode middleNode(ListNode head) {
//        ListNode temp = head;
//        int len=0;
//        while(temp!=null){
//            temp = temp.next;
//            len++;
//        }
//        ListNode midd = head;
//        for(int i = 0;i<len/2;i++){
//            midd = midd.next;
//        }
//        return midd;
//    }
//public void reorderList(ListNode head) {
//    ListNode temp = head;
//    int len=1;
//    while(temp.next!=null){
//        temp = temp.next;
//        len++;
//    }
//    if(len>2){
//        ListNode midd = head;
//        int i = 1;
//        while(i<=len/2){
//            midd = midd.next;
//            i++;
//        }
//        ListNode temp2 = head.next;
//        head.next = temp;
//        temp.next = temp2;
//        int n = len-i;
//        for(int j = 1 ; j<n;j++){
//            temp = midd;
//            for(int k = j; k<n;k++){
//                temp = temp.next;
//            }
//            System.out.println(temp.val);
//            ListNode dummy = temp2.next;
//            temp2.next = temp;
//            temp.next = dummy;
//            temp2 = dummy;
//        }
//        midd.next = null;
//    }
//}
//public ListNode deleteDuplicates(ListNode head) {
//    ListNode pre = head;
//    if(head==null||head.next==null)return head;
//    ListNode temp = head.next;
//    boolean flag = false;
//    while(temp.next!=null){
//        if(temp.val==temp.next.val){
//            temp.next= temp.next.next;
//            flag=true;
//        }
//        else if(head.val==temp.val){
//            head = temp.next;
//            pre = head;
//            temp = pre.next;
//            flag = false;
//            if(temp==null)break;
//        }
//        else if(flag){
//            pre.next=temp.next;
//            temp = temp.next;
//            flag = false;
//            if(temp.next!=null&&temp.val!=temp.next.val){
//                pre = temp;
//                temp = temp.next;
//            }
//        }else{
//            pre = temp;
//            temp = temp.next;
//            flag = false;
//        }
//    }
//    if(temp!=null){
//        if(head.val==temp.val)return null;
//    }
//    if(flag)pre.next=null;
//    return head;
//}
//public ListNode partition(ListNode head, int x) {
//        if(head==null||head.next==null)return head;
//        ListNode pre = null;
//        ListNode less = head;
//        while(less!=null){
//            if(less.val<x){
//                if(pre!=null){
//                    pre.next = less.next;
//                    less.next = head;
//                    head = less;
//                }else{
//                    pre = less;
//                }
//                break;
//            }
//            pre=less;
//            less = less.next;
//        }
//        if(less==null)return head;
//        while(pre.next!=null){
//            if(pre.next.val==less.next.val&&pre.next.val<x){
//                pre = pre.next;
//                less = less.next;
//                continue;
//            }
//            if(pre!=null&&pre.next.val<x){
//                ListNode dummy = pre.next;
//                pre.next = dummy.next;
//                dummy.next = less.next;
//                less.next = dummy;
//                less = dummy;
//                continue;
//            }
//            pre = pre.next;
//        }
//        return head;
//    }
//second method of found the middle of the linked List

// public ListNode middleNode(ListNode head) {
//        ListNode slow =head;
//        ListNode fast = head;
//
//        while(fast!=null && fast.next!=null){
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        return slow;
//    }
//public ListNode deleteMiddle(ListNode head) {
//        if(head.next==null)return null;
//        ListNode temp = head;
//        int len = 0;
//        while(temp!=null){
//            temp = temp.next;
//            len++;
//        }
//        temp = head;
//        for(int j = 1 ; j<len/2;j++){
//            temp = temp.next;
//        }
//        if(temp.next!=null)temp.next = temp.next.next;
//        else temp.next=null;
//        return head;
//    }
// Second method of 2095
//public ListNode deleteMiddle(ListNode head) {
//        if(head.next==null)return null;
//        ListNode slow = head;
//        ListNode fast = head.next;
//        ListNode pre = null;
//        while(slow!=null&&fast!=null){
//            pre = slow;
//            slow = slow.next;
//            if(fast.next==null)fast = fast.next;
//            else fast = fast.next.next;
//        }
//        pre.next = slow.next;
//        return head;
//public ListNode doubleIt(ListNode head) {
//        ListNode multi = head;
//        int len=1;
//        int carry = 0;
//        while(multi.next!=null){
//            multi = multi.next;
//            len++;
//        }
//        if(multi.val*2>9){
//            multi.val = (multi.val*2)%10;
//            carry = 1;
//        }else {
//            multi.val = multi.val*2;
//        }
//        ListNode dummy = head;
//        for(int i =1;i<len;i++){
//            while(dummy.next!=multi)dummy = dummy.next;
//            if(dummy.val*2+carry>9){
//                dummy.val = (dummy.val*2+carry)%10;
//                carry = 1;
//            }else{
//                dummy.val = dummy.val*2+carry;
//                carry = 0;
//            }
//            multi = dummy;
//            dummy=head;
//        }
//        if(carry==1){
//            dummy = new ListNode(1);
//            dummy.next = head;
//            head = dummy;
//        }
//        return head;
//    }
//public void deleteNode(ListNode node) {
//    node.val = node.next.val;
//    node.next = node.next.next;
//}
//it's not a optimal approach
//public ListNode reverseList(ListNode head) {
//        if(head==null||head.next==null)return head;
//        Stack<ListNode> stack = new Stack<>();
//        ListNode temp = head;
//        while(temp!=null){
//            stack.push(temp);
//            temp = temp.next;
//        }
//        head = stack.pop();
//        temp = head;
//        while(!stack.isEmpty()){
//            temp.next = stack.pop();
//            temp = temp.next;
//        }
//        temp.next = null;
//        return head;
//    }