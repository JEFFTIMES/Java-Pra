package com.jefftimes;

import java.lang.reflect.Member;
import java.util.ArrayList;

class SocialNetwork {

    public class Member {
        private String name;

        // here is the recurse that the variable is declared within the class
        // has the data type of the class its own.
        // it is reasonable the list of the friends all are the same object with the member itself.
        private ArrayList<Member> friends;


        public Member(String name){
            this.name = name;
            this.friends = new ArrayList<>();

        }

        public void addFriend(Member friend){
            this.friends.add(friend);
        }

        public void deleteFriend(Member friend){
            this.friends.remove(friend);
        }

        public void iterFriends(){

            if(this.friends.isEmpty()){
                System.out.println("there is not any friend.");

            }else{
                for (Member f : this.friends) {
                    System.out.println("friend: " + f.name);
                }
            }

        }

        public void quit(){
            // here show the feature that the method of the inner could refer to an object of
            // its enclosing class
            members.remove(this);

            // the method of the inner class could call the method belong to the enclosing class
            //unenroll(this);

        }
    }

    private ArrayList<Member> members = new ArrayList<>();


    public Member enroll(String name){
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }

    public void unenroll(Member member){
        members.remove(member);
    }

    public void iterMembers(){
        for(Member m: members){
            System.out.println(m.name);
        }
    }
}
