package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Creates user objects
        User john = new User("url", "coolGuyJohn", "John", "Doe", "john@gmail.com");
        User mary = new User("url2", "maryMary", "Mary", "Bob", "mary@yahoo.com");
        User joe = new User("url", "JoeJo", "Joe", "Louis", "joe@hockey.com");

        ArrayList<User>userList = new ArrayList<>();
        userList.add(john);
        userList.add(mary);
        userList.add(joe);

        //Creates an list of posts to store each post object
        ArrayList<Post> postList = new ArrayList<>();
        //Creates post object without a url
        Post first = new Post(john, "My first post!");
        //Adds the post to the list
        postList.add(first);
        //Creates a post object with a url
        Post second = new Post(mary, "My second post", "www.awesome.com");
        postList.add(second);
        Post third = new Post (joe, "The third Post");
        postList.add(third);
        Post fourth = new Post(joe, "Another post", "www.google.com");
        postList.add(fourth);
        Post fifth = new Post(joe, "Joe posts a lot");
        postList.add(fifth);

        BlogMenu menu = new BlogMenu(userList, postList, john);


        String menuChoice = "";
        //this makes sure the program keeps running unless they select option 5
        //size()-1 sets the user to be the last user that posted
        while (!(menuChoice.equals("5"))){

            menuChoice = menu.printMenu();
            if (menuChoice.equals("1")){
                //Create a new User
                menu.createUser();

            }
            if (menuChoice.equals("2")){
                menu.becomeExistingUser();
                //become an existing user
            }

            if (menuChoice.equals("3")){
                //Create a post as the current user
                menu.createPost();

            }
            if (menuChoice.equals("4")){
                //Print all posts
                menu.printPosts();
            }
            if (menuChoice.equals("5")){
                //Print all users
                menu.printUsers();

            }
        }


    }
}
