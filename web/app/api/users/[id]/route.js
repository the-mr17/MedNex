import User from "@/models/user";
import { connectToDB } from "@/utils/database";

// Handle Get request for user with the username of the user passed into the params.id
// e.g.- {{base_url}}/api/users/12345  Method: GET
export const GET = async (req, { params }) => {
    try {
        await connectToDB();
        const user = await User.findOne({ username: params.id }).populate(
            "username"
        ); //find one object with the username parameter

        return new Response(JSON.stringify(user), { status: 200 });
    } catch (error) {
        const err = {
            message: "Failed to get User",
            error,
        };
        return new Response(JSON.stringify(err), { status: 500 });
    }
};

// Handle PUT request for user with the username of the user passed into the params.id
// e.g.- {{base_url}}/api/users/12345  Method: PUT
export const PUT = async (req, { params }) => {
    try {
        await connectToDB();

        // Get the updated user info from the request body
        const updates = await req.json();

        //get the user to be updated
        const user = await User.findOneAndUpdate(
            { username: params.id },
            updates,
            { new: true }
        );

        return new Response(JSON.stringify(user));
    } catch (error) {
        const err = {
            message: "Failed to update User",
            error,
        };
        return new Response(JSON.stringify(err), { status: 500 });
    }
};

// Handle DELETE request for user with the username of the user passed into the params
// e.g.- {{base_url}}/api/users/12345  Method: DELETE
export const DELETE = async (req, { params }) => {
    try {
        await connectToDB();

        // find the user by username and delete the user from database
        const user = await User.findOneAndDelete({ username: params.id });
        return new Response(`User ${params.id} was deleted`, { status: 200 });
    } catch (error) {
        const err = {
            message: "Failed to delete User", //generic error message if action fails;
            error,
        };
        return new Response(JSON.stringify(err), { status: 500 });
    }
};
