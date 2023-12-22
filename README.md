# Instagram Clone with Java Swing

This project is a Java-based Instagram clone that replicates similar functionality to Instagram using the Swing framework for the graphical user interface (GUI). The data is stored in a database, and the project includes a server control page for establishing and terminating the database connectivity.

## Overview

The application aims to mimic the core features of Instagram such as:

- User Authentication and Registration
- Posting Images and Videos
- Following and Followers
- Like, Comment, and Share Posts
- Profile Management

## Features

- **User Authentication**: Allows users to sign up and log in securely.
- **Posting Media**: Enables users to upload images and videos with captions.
- **Social Interaction**: Facilitates following, liking, commenting, and sharing of posts.
- **Profile Management**: Provides options to edit profiles, change profile pictures, and view follower/following lists.

## Database Usage

The application utilizes a database to store user information, posts, comments, likes, and other related data. The database schema includes tables for users, posts, comments, likes, etc. The connectivity between the application and the database is managed through JDBC (Java Database Connectivity).

### Database Setup

1. Ensure a compatible SQL database (e.g., MySQL, PostgreSQL) is installed.
2. Run the SQL script provided (`database_setup.sql`) to create the necessary tables and relationships.
3. Update the database connection details in the Java code to match your database credentials.

## Server Control

The project includes a server control page to manage the connectivity between the application and the database.

### Starting the Server
1. Open the server control page (`ServerControl.java`).
2. Click on the "Start Server" button to initiate the connection with the database.

### Stopping the Server
1. To terminate the connection, click on the "Stop Server" button.

## Running the Application

1. Clone the repository: `git clone https://github.com/yourusername/instagram-clone.git`
2. Open the project in your Java IDE (e.g., IntelliJ, Eclipse).
3. Ensure the database connectivity details are correctly configured.
4. Run the main Java file to start the application.

## Contributing

Contributions are encouraged! If you have suggestions, bug fixes, or new feature ideas, please feel free to open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
