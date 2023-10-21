# MedNex

MedNex is a comprehensive healthcare application that simplifies the process of booking appointments with healthcare professionals and fosters a sense of community support among its users. This repository contains the source code and documentation for the MedNex app.

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Backend](#backend)
    - [Authentication](#authentication)
    - [Users](#users)
    - [Community Posts](#community-posts)
    - [Appointments (Self Checkups)](#appointments-self-checkups)
    - [Prescriptions](#prescriptions)
  
4. [API Testing](#api-testing)
5. [Android](#android)
    - [Community Features](#community-features)
    - [Authentication](#authentication)
    - [API Integration](#api-integration)
    - [Download the app](#download-the-app)
    - [Screenshots](#screenshots)

## Introduction

Welcome to MedNex! MedNex is a revolutionary healthcare application designed to make your healthcare journey more convenient, informative, and supportive. Whether you're looking to book appointments with healthcare professionals or seek support from a community of like-minded individuals, MedNex has got you covered.

## Features

MedNex offers a wide range of features to enhance your healthcare experience:

- **Appointment Booking**: Easily schedule appointments with healthcare professionals of various specialties.

- **Comprehensive Doctor Profiles**: Get detailed information about doctors, including their qualifications, specialties, and patient reviews.

- **Community Support**: Engage with a community of users who can provide support, share experiences, and seek advice on healthcare-related matters.

- **Personalized Health Information**: Access articles and health tips tailored to your needs.

- **Appointment Reminders**: Receive notifications to keep track of your appointments and reschedule when necessary.

- **Secure and Private**: MedNex employs strong security measures to protect your personal health information.

## Backend

The MedNex backend is built with Firebase for authentication and leverages Next.js for server-side rendering and MongoDB for data storage, offering a robust and secure platform for user management and data storage. Here's a breakdown of the key features and functionality:

### Authentication

MedNex uses Firebase Authentication for a safe and reliable user registration and login process. Firebase Authentication supports multiple authentication methods, such as email/password, phone number, and social logins.

### Users

The Users API provides essential CRUD (Create, Read, Update, Delete) operations for managing user accounts within MedNex. Users can register, update their profiles, and delete their accounts when necessary. This API is a fundamental component of our application.

### Community Posts

The Community Posts API enables users to create, read, update, and delete community posts. It's a space for users to share their experiences, ask for advice, and offer support to others within the MedNex community. Users can create and manage posts related to various health topics.

### Appointments (Self Checkups)

The Appointments API is at the core of MedNex's appointment booking system. Users can schedule appointments with healthcare professionals of different specialties. This API supports CRUD operations, allowing users to create new appointments, view upcoming appointments, update details, and cancel appointments when needed.

### Prescriptions

The Prescriptions API manages the storage and retrieval of prescriptions issued by healthcare professionals. Users can access their prescriptions through the MedNex app, making it easy to follow their healthcare provider's recommendations.

## API Testing

We provide a Postman collection for testing and interacting with our API. You can access the MedNex API Postman collection by clicking the link below:

[MedNex Postman Collection](https://www.postman.com/mednexteam/workspace/mednex/collection/30172391-21eeffb5-ca12-4f71-a92e-e6aefead9c05?action=share&creator=30172391)

This collection includes a set of pre-configured requests to help you understand and test the functionality of our API endpoints. You can use Postman to send requests, view responses, and explore the capabilities of the MedNex backend.

Please make sure you have the necessary environment variables and authentication credentials set up in Postman to interact with our API effectively.

## Android

The MedNex Android app is a key component of our healthcare platform, offering a mobile interface that combines healthcare services with a vibrant community.

### Community Features

Our Android app provides users with access to a thriving community of individuals who share experiences, offer support, and engage in discussions on various health-related topics. This community space is designed to create a sense of belonging and a source of valuable information and emotional support.

### Authentication

In the Android app, we have integrated authentication to ensure secure access to user accounts. Users can register, log in, and manage their profiles seamlessly, ensuring a personalized experience within the MedNex ecosystem.

### API Integration

The Android app seamlessly integrates with the backend APIs provided by MedNex, including user management, community posts, appointment scheduling (self checkups), and prescriptions. These APIs enhance the functionality and data exchange between the Android app and our backend, creating a comprehensive and feature-rich healthcare experience for our users.

### Screenshots

<img src="https://github.com/theMr17/MedNex/assets/84731134/2a210f06-8527-4ee2-82a0-99448c85c45c" width="300"/>
<img src="https://github.com/theMr17/MedNex/assets/84731134/2e1aab74-7e9c-4fe6-8177-1ef5f8d822e6" width="300"/>
<img src="https://github.com/theMr17/MedNex/assets/84731134/b8ee1562-8ae6-4d37-9e6b-ae43d3c86729" width="300"/>
<img src="https://github.com/theMr17/MedNex/assets/84731134/e7cb1022-13bf-4e2d-80b5-2d4e562ec4bc" width="300"/>
<img src="https://github.com/theMr17/MedNex/assets/84731134/2474b427-9351-47ff-a0c0-477197ac2331" width="300"/>

### Download the app

You can download the MedNex Android app directly from the following link:

[MedNex Android App (v1.0.0)](https://github.com/theMr17/MedNex/releases/download/v1.0.0/MedNex.apk)
