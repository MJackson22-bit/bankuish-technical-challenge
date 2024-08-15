# bankuish-technical-challenge

A modern Android application built using Jetpack Compose that consumes the GitHub API to display repositories and their details. The app is architected using the MVVM pattern, with additional libraries like Koin, Ktor, and others to enhance functionality.

## Features

- **Two Screens:**
    - **Repositories List:** Displays a list of GitHub repositories.
 ![Screenshot_20240815_134335](https://github.com/user-attachments/assets/ef39352b-1811-41a1-bbc0-ef2f094ca337)

    - **Repository Details:** Shows detailed information about a selected repository.
 ![Screenshot_20240815_134440](https://github.com/user-attachments/assets/702923eb-854b-4e36-9347-9b4c4eb44bcf)


- **Technologies Used:**
    - **Jetpack Compose:** For building the UI in a declarative style.
    - **Koin:** For dependency injection.
    - **Ktor:** For network requests and handling the GitHub API.
    - **MVVM Architecture:** Separates data management from the UI.

- **Additional Implementations:**
    - **Shimmer Effect:** For a visually appealing loading screen.
    - **Swipe to Refresh:** Allows users to refresh the repository list with a swipe gesture.
    - **Pagination:** Efficiently loads repositories in batches as the user scrolls.
