# Spring Book API

This simple Spring Boot project provides a basic API for performing CRUD (Create, Read, Update, Delete) operations on books and authors.

## Getting Started

To run the project on your local machine, follow the steps below.

### Prerequisites

- Java JDK 21
- Maven

### Installation

1. Navigate to the project directory:

    ```bash
    cd book-api-main
    ```

2. Build the project:

    ```bash
    mvn clean install
    ```

3. Run the application:

    ```bash
    java -jar target/database-0.0.1-SNAPSHOT.jar
    ```

The application will run by default at `http://localhost:8080`.

## API Endpoints

### List Books

**Endpoint:** `GET /books`

Lists all books.

### List Authors

**Endpoint:** `GET /authors`

Lists all authors.

### Book Details

**Endpoint:** `GET /books/{bookId}`

Gets details of a specific book.

### Author Details

**Endpoint:** `GET /authors/{authorId}`

Gets details of a specific author.

### Add New Book

**Endpoint:** `POST /books`

Adds a new book. The request body should contain book details.

### Add New Author

**Endpoint:** `POST /authors`

Adds a new author. The request body should contain author details.

### Update Book

**Endpoint:** `PUT /books/{bookId}`

Updates information for a specific book.

### Update Author

**Endpoint:** `PUT /authors/{authorId}`

Updates information for a specific author.

### Delete Book

**Endpoint:** `DELETE /books/{bookId}`

Deletes a specific book.

### Delete Author

**Endpoint:** `DELETE /authors/{authorId}`

Deletes a specific author.

## Contributing

1. Fork this repository and clone it to your workspace.
2. Add new features or fix bugs.
3. Commit your changes in a branch: `git commit -m 'Add new feature'`
4. Synchronize your branch with the main repository: `git push origin my-feature-branch`
5. Create a Pull Request.

