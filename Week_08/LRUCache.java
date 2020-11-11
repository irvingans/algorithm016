class LRUCache {
    private class DLinkedNode {
        private DLinkedNode prev; 
        private DLinkedNode next;
        private int val;
        private int key;

        public DLinkedNode(){
            //val = value;
        }
    }
        Map<Integer,DLinkedNode> lrucache;
        DLinkedNode head;
        DLinkedNode tail;
        int size;
        int cap;

    public LRUCache(int capacity) {
        lrucache = new HashMap<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
        size = 0;
        cap = capacity;
    }
    
    public int get(int key) {
        DLinkedNode node = lrucache.get(key);
        if(node != null){
            MoveToHead(node);
            return node.val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        
             DLinkedNode node = lrucache.get(key);
            if(node != null ) {
            node.val = value;
            MoveToHead(node);
            }else{
                if(size>= cap){
                DLinkedNode tail = RemoveTail();
            lrucache.remove(tail.key);
            size--;
                }

            DLinkedNode newnode = new DLinkedNode();
            newnode.key = key;
            newnode.val = value;
            AddToHead(newnode);
            lrucache.put(key,newnode);
            size++;
            }

            
        }
        

    private void AddToHead(DLinkedNode node){
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
        //size++;
    }

    private void MoveToHead(DLinkedNode node){
        RemoveNode(node);
        AddToHead(node);
    }

    private void RemoveNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkedNode RemoveTail(){
        DLinkedNode res = tail.prev;
        RemoveNode(res);
        return res;
    }


}

