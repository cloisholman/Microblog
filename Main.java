package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

//this prints the menu out. This gets the user input and makes sure it's a valid option
    public static String printMenu(User user){
        String menuChoice;
        System.out.println("");
        System.out.println("Main Menu");
        System.out.println("1) Create a new user");
        System.out.println("2) Create post as the current user");
        System.out.println("3) Print all posts");
        System.out.println("4) Print all users");
        System.out.println("You are currently user \"" + user.getUsername() + "\". What would like to do?");
        System.out.print("> ");

        Scanner keyboard = new Scanner (System.in);
        menuChoice = keyboard.nextLine();
        while (!(menuChoice.equals("1") || menuChoice.equals("2") || menuChoice.equals("3") || menuChoice.equals ("4")))
        {

            System.out.println("Please enter 1, 2, 3 or 4");
            System.out.println("");
            System.out.println("Main Menu");
            System.out.println("1) Create a new user");
            System.out.println("2) Create post as the current user");
            System.out.println("3) Print all posts");
            System.out.println("4) Print all users");
            System.out.println("You are currently user \"" + user.getUsername() + "\". What would like to do?");
            System.out.print("> ");

            menuChoice = keyboard.nextLine();
        }
        return menuChoice;

    }
    //this method creates a new user from user inputs and adds it to the user array list
    public static ArrayList<User> createUser (ArrayList<User> userList)
    {
        Scanner keyboard = new Scanner (System.in);
        String avatarUrl, username, firstName, lastName, email;
        System.out.println("Please enter your avatar url: ");
        avatarUrl = keyboard.nextLine();
        System.out.println("Please enter username: ");
        username = keyboard.nextLine();
        System.out.println("Please enter your first name: ");
        firstName = keyboard.nextLine();
        System.out.println("Please enter your last name: ");
        lastName = keyboard.nextLine();
        System.out.println("Please enter your email: ");
        email = keyboard.nextLine();
        User newUser = new User(avatarUrl, username, firstName, lastName, email);
        userList.add(newUser);

        return userList;
    }
    //this method creates a new post from user inputs and adds it to the post array list

    public static ArrayList<Post> createPost (ArrayList<Post> postList, User currentUser){
        Scanner keyboard = new Scanner (System.in);
        String content, url, lastPost, includeUrl;
        Post newPost;
        ArrayList<String> userPosts = new ArrayList<>();

        for(Post post: postList){
            if (post.getUser().equals(currentUser))
            {
                userPosts.add(post.getContent());
            }
        }
        if(userPosts.size() > 0){
            System.out.println(userPosts.get(userPosts.size()-1));
        }

        System.out.println("");
        System.out.println("Enter your post: ");
        content = keyboard.nextLine();
        System.out.println("Do you want to add a url to your post? Type 1 for Yes, 2 for No: ");
        includeUrl = keyboard.nextLine();
        while (!(includeUrl.equals("1") || includeUrl.equals("2")))
        {

            System.out.println("Please enter 1 for Yes, 2 for No: ");
            includeUrl = keyboard.nextLine();
        }
        if (includeUrl.equals("1"))
        {
            System.out.println("Enter the url: ");
            url = keyboard.nextLine();
            newPost = new Post(currentUser, content, url);
        }
        else
        {
            newPost = new Post(currentUser, content);
        }
        postList.add(newPost);

        return postList;
    }

    //Loops through the list of posts, pulling out each post
    //and storing it into a variable. Then prints the results
    //of the toString method.
    public static void printPosts(ArrayList<Post> postList)
    {
        for(Post post: postList){
            System.out.println(post.toString());
            System.out.println("");
        }
    }
    public static void printUsers(ArrayList<User> userList)
    {
        for (User user: userList)
        {
            System.out.println(user.toString());
            System.out.println("");
        }
    }

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


        String menuChoice = "";
        //this makes sure the program keeps running unless they select option 4
        //size()-1 sets the user to be the last user that posted
        while (!(menuChoice.equals("4"))){
            menuChoice = printMenu(userList.get(userList.size()-1));
            if (menuChoice.equals("1")){
                //Create a new User
                createUser(userList);

            }
            if (menuChoice.equals("2")){
                //Create a post as the current user
                createPost(postList, userList.get(userList.size()-1));

            }
            if (menuChoice.equals("3")){
                //Print all posts
                printPosts(postList);
            }
            if (menuChoice.equals("4")){
                //Print all users
                printUsers(userList);

            }
        }


    }
}
