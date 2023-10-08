import User from "@/models/user";
import { connectToDB } from "@/utils/database";

export const GET = async (req, { params }) => {
    try {
        await connectToDB();
        const user = await User.findOne({ username: params.id }).populate(
            "username"
        );

        return new Response(JSON.stringify(user), { status: 200 });
    } catch (error) {
        const err = {
            message: "Failed to get User",
            error,
        };
        return new Response(JSON.stringify(err), { status: 500 });
    }
};
export const PUT = async (req, { params }) => {
    try {
        await connectToDB();

        // Get the updated user info from the request body
        const updates = await req.json();

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
export const DELETE = async (req, { params }) => {
    try {
        await connectToDB();
        const user = await User.findOneAndDelete({ username: params.id });
        return new Response(`User ${params.id} was deleted`, { status: 200 });
    } catch (error) {
        const err = {
            message: "Failed to delete User",
            error,
        };
        return new Response(JSON.stringify(err), { status: 500 });
    }
};
