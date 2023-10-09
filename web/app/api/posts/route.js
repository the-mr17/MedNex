import Post from "@/models/post";
import { connectToDB } from "@/utils/database";

// Get all posts
export const GET = async (request) => {
    try {
        await connectToDB();

        const posts = await Post.find(); //find all objects in the database as no parameters are passed to find()

        return new Response(JSON.stringify(posts), { status: 200 });
    } catch (error) {
        const err = {
            message: "Failed to get Posts",
            error,
        };
        return new Response(JSON.stringify(err), { status: 500 });
    }
};
