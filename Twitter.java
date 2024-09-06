class Twitter {
     class Node{
            int value;
            Node next;
            Node prev;

            Node(int val){
                this.value=val;
                this.next=null;
                this.prev=null;
            }
        }

    class Dll{
       
        Node head;
        Node tail;
        Dll(){
            head=new Node(-1);
            tail=new Node(-1);
            head.next=tail;
            tail.prev=head;
        }

        public void addNode(Node curr){
               Node temp=head.next;
               head.next=curr;
               curr.prev=head;
               curr.next=temp;
               temp.prev=curr;
        }

        public void deleteNode(Node curr){
            Node piche=curr.prev;
            Node aage=curr.next;
            piche.next=aage;
            aage.prev=piche;
        }
        public void delete(int val){
            Node temp=head.next;
            while(temp.next!=null){
                if(temp.value==val){
                     Node piche=temp.prev;
            Node aage=temp.next;
            piche.next=aage;
            aage.prev=piche;
            break;
                }
                temp=temp.next;
            }
            return;
        }

    }
    HashMap<Integer,Dll>followers;//Stores followers of a person
    HashMap<Integer,Dll>tweets;/*Stores post made by a person*/
    public Twitter() {
        followers=new HashMap<>();
        tweets=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Dll currList=tweets.getOrDefault(userId,new Dll());
        currList.addNode(new Node(tweetId));
        tweets.put(userId,currList);
    }
    
    public List<Integer> getNewsFeed(int userId) {
         
         if(!followers.containsKey(userId)){
             Dll currList=followers.getOrDefault(userId,new Dll());
             Node newone=new Node(userId);
            
        currList.addNode(newone);
        followers.put(userId,currList);
        }
        List<Integer>ret=new ArrayList<>();
        Dll followed=followers.get(userId);
        Node temp=followed.head.next;
        while(temp.next!=null){
            if(ret.size()==10)break;
            Dll currtweets=tweets.getOrDefault(temp.value,new Dll());
            Node tweet=currtweets.head.next;
            while(tweet.next!=null){
               if(!ret.contains(tweet.value)) ret.add(tweet.value);
               if(ret.size()==10)break;
                tweet=tweet.next;
            }
            temp=temp.next;
        }
        return ret;

    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)){
             Dll currList=followers.getOrDefault(followerId,new Dll());
             Node newone=new Node(followerId);
        currList.addNode(newone);
        followers.put(followerId,currList);
        }
        Dll currList=followers.get(followerId);
        Node newone=new Node(followeeId);
        currList.addNode(newone);
    
        followers.put(followerId,currList);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId))return;
        Dll currList=followers.get(followerId);
             currList.delete(followeeId);
             followers.put(followerId,currList);
        
        
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
