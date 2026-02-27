# DSA Algorithms - Java Implementations

This is a Java-based Maven project for implementing Data Structures and Algorithms (DSA) concepts. The project uses Cucumber BDD specifications to define algorithm behaviors and provides Java implementations.

## Project Overview

This project is part of a larger initiative to master DSA concepts from beginner to advanced levels. It implements various algorithms such as sorting, searching, and more, following behavior-driven development practices.

## Project Structure

```
dsa/
├── cucumber-specs/        # Shared Cucumber specifications (BDD feature files)
└── java-implementations/  # Java implementations of the algorithms (this project)
```

## Prerequisites

- Java 11 or higher
- Maven 3.6+

## Getting Started

### Build the Project

```bash
mvn clean compile
```

### Run Tests

```bash
mvn test
```

### Package the Project

```bash
mvn clean package
```

## Cucumber Integration

This project loads Cucumber specifications from the `cucumber-specs` directory and implements the step definitions. The specifications cover various algorithm categories:

- Sorting algorithms
- Searching algorithms
- And more...

## Future Enhancements

This project is designed to be part of a multi-language implementation strategy. Other language implementations (e.g., Rust) may be added alongside this Java project.

## License

[Add license information here]
