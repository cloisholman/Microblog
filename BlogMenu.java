package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class BlogMenu {

    private ArrayList<User> userList;
    private ArrayList<Post> postList;
    private User currentUser;
    private Scanner keyboard = new Scanner(System.in);

    public BlogMenu (ArrayList<User> userList, ArrayList<Post> postList, User user){
        this.userList = userList;
        this.postList = postList;
        this.currentUser = user;
    }

    //this prints the menu out. This gets the user input and makes sure it's a valid option
    public String printMenu(){
        String menuChoice;
        System.out.println("");
        System.out.println("Main Menu");
        System.out.println("1) Create a new user");
        System.out.println("2) Become an existing user");
        System.out.println("3) Create post as the current user");
        System.out.println("4) Print all posts");
        System.out.println("5) Print all users");
        System.out.println("You are currently user \"" + currentUser.getUsername() + "\". What would like to do?");
        System.out.print("> ");

        menuChoice = keyboard.nextLine();
        while (!(menuChoice.equals("1") || menuChoice.equals("2") || menuChoice.equals("3") || menuChoice.equals ("4") || menuChoice.equals("5")))
        {
            System.out.println("Please enter 1, 2, 3, 4 or 5");
            System.out.println("");
            System.out.println("Main Menu");
            System.out.println("1) Create a new user");
            System.out.println("2) Become an existing user");
            System.out.println("3) Create post as the current user");
            System.out.println("4) Print all posts");
            System.out.println("5) Print all users");
            System.out.println("You are currently user \"" + currentUser.getUsername() + "\". What would like to do?");
            System.out.print("> ");

            menuChoice = keyboard.nextLine();
        }
        return menuChoice;

    }
    //this method creates a new user from user inputs and adds it to the user array list
    //ArrayList is the data return type, createUser the method name
    //.add will add new elements to the array list
    public ArrayList<User> createUser ()
    {
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
    public void becomeExistingUser(){
        String username;
        boolean noMatch = true;
        System.out.println("List of current users: ");
        for (User user: userList)
        {
            System.out.println(user.getUsername());
        }
        System.out.println("Enter the username of the user you want to become");
        username = keyboard.nextLine();

        while(noMatch){
            for (User user: userList)
            {
                if (user.getUsername().equals(username))
                {
                 this.currentUser = user;
                 noMatch = false;
                }
            }
            if (noMatch){
                System.out.println("Please enter an existing username");
                System.out.println("List of current users: ");
                for (User user: userList)
                {
                    System.out.println(user.getUsername());
                }
                System.out.println("Enter the username of the user you want to become");
                username = keyboard.nextLine();
            }
        }
    }
    //this method I named createPost creates a new post from user inputs and adds it to the post array list

    public ArrayList<Post> createPost (){
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
    // I applied for... array list I named userList based on provided example of for...postList
    public void printPosts()
    {
        for(Post post: postList){
            System.out.println(post.toString());
            System.out.println("");
        }
    }
    public void printUsers()
    {
        for (User user: userList)
        {
            System.out.println(user.toString());
            System.out.println("");
        }
    }
}
