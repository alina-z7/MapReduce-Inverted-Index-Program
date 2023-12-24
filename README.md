# MapReduce Inverted Index Program

The MapReduce Inverted Index Program is a distributed computing application designed to generate an inverted index from a collection of documents using the MapReduce paradigm.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Overview

The MapReduce Inverted Index Program processes text documents to create an inverted index, mapping each unique word found in the documents to the locations where it occurs. This index allows efficient search and retrieval of documents based on specific words, enabling faster information retrieval in large datasets.

## Features

- **Word Mapping:** Generates a mapping of words to the documents they appear in.
- **Scalability:** Utilizes Hadoop's distributed computing capabilities for scalability and efficient processing of large datasets.
- **Customizable:** Allows customization of input and output directories, providing flexibility for different datasets and environments.

## Prerequisites

Ensure the following prerequisites are met before using the MapReduce Inverted Index Program:

- Java Development Kit (JDK) installed
- Apache Hadoop configured and running
- Maven installed
- Text documents or datasets for indexing

## Installation

1. Clone or download this repository to your local machine.
2. Configure Hadoop to connect to your local environment or Hadoop cluster.
3. Set up the project in your preferred Java Integrated Development Environment (IDE).

## Usage

1. Prepare the text documents or datasets for indexing.
2. Update input and output paths in the code to point to your data directories.
3. Run the MapReduce job to generate the inverted index.
4. Access the output directory to view the generated inverted index.

## Project Structure

The project structure is organized as follows:

- `src/main/java`: Contains Java source code files.
  - `org.example`: Package containing MapReduce classes (`InvertedIndexMapper`, `InvertedIndexReducer`, `InvertedIndexDriver`).
- `pom.xml`: Maven project configuration file.

## License

This project is licensed under the [MIT License](LICENSE).
