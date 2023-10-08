## API Reference

#### Get all items

-   Users

```http
  GET {base_url}/api/users
```

-   Posts

```http
  POST {base_url}/api/posts
```

#### Get Specific item

-   Users

```http
  GET {base_url}/api/users/[username]
```

-   posts

```http
  GET {base_url}/api/posts/[id]
```

#### Update and Delete items

-   Users

```http
  PUT {base_url}/api/users/[username]
```

```http
  DELETE {base_url}/api/users/[username]
```

-   posts

```http
  PUT {base_url}/api/posts/[id]
```

```http
  DELETE {base_url}/api/posts/[id]
```

_Provide the updates object in the body of the request.Updates only passed parameters, other parameters remain unchanged_

## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

`MONGODB_URI`

`FIREBASE_APIKEY`

`FIREBASE_AUTHDOMAIN`

`FIREBASE_PROJECTID`

`FIREBASE_STORAGEBUCKET`

`FIREBASE_MESSAGINGSENDERID`

`FIREBASE_APPID`

## Run Locally

Clone the project

```bash
  git clone https://github.com/theMr17/MedNex.git
```

Go to the project directory

```bash
  cd MedNex/web
```

Install packages

```bash
npm Install
```

Run Local Server

```bash
npm run dev
```

Open the link shown.
