# Data Structures and Algorithms (DSA) Project

## Project Overview

This is a multi-language Data Structures and Algorithms (DSA) learning project designed to master DSA concepts from beginner to advanced levels. The project follows a Behavior-Driven Development (BDD) approach where algorithm specifications are written in Gherkin (Cucumber) and shared across multiple language implementations.

The project structure separates specifications from implementations, allowing the same Cucumber feature files to drive implementations in different programming languages.

## Project Structure

```
.
├── AGENTS.md              # This file - guide for AI coding agents
├── cucumber-specs/        # Shared BDD specifications (Gherkin feature files)
│   ├── spec.toml          # Project context and generation instructions
│   ├── recursion.feature  # Recursion algorithm specifications
│   └── sorting.feature    # Sorting algorithm specifications
└── java-implementations/  # Java implementation of the specifications
    ├── pom.xml            # Maven build configuration
    ├── README.md          # Java project documentation
    ├── .gitignore         # Git ignore rules for Java/Maven
    └── src/test/java/com/dsa/
        ├── CucumberTestRunner.java   # JUnit test runner
        └── steps/
            ├── recursion/  # Recursion algorithm step definitions
            │   ├── RecursivelyCalculateTheSumOfNumbersSteps.java
            │   ├── RecursivelyCountTheNumberOfElementsInAListSteps.java
            │   └── RecursivelyFindTheLargestNumberSteps.java
            └── sorting/    # Sorting algorithm step definitions
                ├── SortACsvStringOfNumbersInNumericalOrderSteps.java
                └── SortACsvStringOfNumbersUsingQuickSortSteps.java
```

## Technology Stack

### Current Implementation
- **Language**: Java 17
- **Build Tool**: Maven 3.6+
- **BDD Framework**: Cucumber 7.15.0
- **Testing Framework**: JUnit 5.10.0 (Jupiter) + JUnit Platform Suite 1.10.0

### Feature Files Location
The Cucumber feature files are shared via a symbolic link:
- `java-implementations/src/test/resources/features` → `../../../../cucumber-specs`

This allows the Java project to load specifications from the shared `cucumber-specs` directory.

## Build and Test Commands

All commands should be run from the `java-implementations` directory:

```bash
cd java-implementations

# Compile the project
mvn clean compile

# Run all tests (Cucumber feature tests)
mvn test

# Package the project
mvn clean package

# Run tests with verbose output
mvn test -X
```

## Code Organization

### Package Structure
- `com.dsa` - Root package containing the test runner
- `com.dsa.steps.recursion` - Step definitions for recursion algorithms
- `com.dsa.steps.sorting` - Step definitions for sorting algorithms

### Naming Conventions
- Step definition classes follow the pattern: `{ScenarioName}Steps.java`
- Feature files use kebab-case: `{algorithm-category}.feature`
- Scenario names use descriptive sentences in Gherkin

### Test Runner Configuration
The `CucumberTestRunner.java` configures:
- Feature files location: `features` (classpath resource)
- Step definitions glue: `com.dsa.steps.sorting,com.dsa.steps.recursion`
- Output plugins: `pretty` console output + HTML report at `target/cucumber-report.html`

## Implemented Algorithms

### Sorting Algorithms
1. **Selection Sort** - Sorts a CSV string of integers using selection sort algorithm
2. **Quick Sort** - Sorts a list of integers using recursive quick sort with random pivot

### Recursion Algorithms
1. **Recursive Sum** - Calculates sum of numbers in an array using recursion
2. **Recursive Count** - Counts elements in an array using recursion
3. **Recursive Max** - Finds the largest number in an array using recursion

## Testing Strategy

The project uses Cucumber BDD for testing:

1. **Feature Files** define the expected behavior in Gherkin syntax
2. **Step Definitions** implement the actual algorithm logic
3. **Assertions** use Java's `assert` keyword for validation

### Adding New Algorithm Implementations

1. Create or update the appropriate `.feature` file in `cucumber-specs/`
2. Create a new step definition class in the appropriate `com.dsa.steps.{category}` package
3. Implement the `@Given`, `@When`, and `@Then` step methods
4. Run `mvn test` to verify the implementation passes the feature scenarios

## Code Style Guidelines

### Java Conventions
- **Source/Target**: Java 17
- **Encoding**: UTF-8
- **Language Features**: Use modern Java features like `var`, records, `RandomGenerator`, streams

### Example Step Definition Structure
```java
package com.dsa.steps.{category};

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Step definitions for scenario: {Scenario Description}
 */
public class {ScenarioName}Steps {
    
    private String inputData;
    private int result;
    
    @Given("a precondition {string}")
    public void a_precondition(String input) {
        this.inputData = input;
    }
    
    @When("the algorithm is applied")
    public void the_algorithm_is_applied() {
        this.result = algorithmImplementation(inputData);
    }
    
    @Then("the result should be {string}")
    public void the_result_should_be(String expected) {
        assert result == Integer.parseInt(expected);
    }
    
    private int algorithmImplementation(String input) {
        // Algorithm implementation here
        return 0;
    }
}
```

## Known Issues

The `pom.xml` currently uses deprecated Maven expressions:
- `${artifactId}` should be `${project.artifactId}`
- `${version}` should be `${project.version}`

These generate warnings but do not affect functionality.

## Future Enhancements

As mentioned in `spec.toml`, this project is intended to support multiple language implementations (e.g., Rust, Python, Go). Each implementation should:

1. Be placed in its own directory (e.g., `rust-implementations/`, `python-implementations/`)
2. Load feature files from the shared `cucumber-specs` directory
3. Implement the same step definitions in the target language

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## License

[To be added]
